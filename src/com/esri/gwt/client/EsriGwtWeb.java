package com.esri.gwt.client;

import com.esri.gwt.client.event.MapClickHandler;
import com.esri.gwt.client.geometry.Point;
import com.esri.gwt.client.graphic.Graphic;
import com.esri.gwt.client.layers.ArcGISDynamicMapServiceLayer;
import com.esri.gwt.client.layers.ArcGISImageServiceLayer;
import com.esri.gwt.client.layers.ImageServiceParameters;
import com.esri.gwt.client.layers.Layer;
import com.esri.gwt.client.tasks.Query;
import com.esri.gwt.client.tasks.QueryTask;
import com.esri.gwt.client.tasks.callback.QueryCallback;
import com.esri.gwt.client.tasks.result.FeatureSet;
import com.esri.gwt.client.type.Event;
import com.esri.gwt.client.widget.MapWidget;
import com.esri.gwt.client.widget.TestPanel;
import com.esri.gwt.client.widget.Toolbar;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.CheckBox;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.VerticalPanel;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class EsriGwtWeb implements EntryPoint {

	private MapWidget map;

	/**
	 * This is the entry point method.
	 */
	public void onModuleLoad() {
		
		VerticalPanel mainPanel = new VerticalPanel();
		
		MapPanel mapPanel = new MapPanel();
		this.map = mapPanel.getMapWidget();
		
		final Layer lugano = new ArcGISDynamicMapServiceLayer("http://10.1.75.111:8399/arcgis/rest/services/Lugano/MapServer");
		lugano.setId("Lugano");
		map.addLayer(lugano);

		// ortofoto
		ImageServiceParameters isp = new ImageServiceParameters();
		isp.setFormat(ImageServiceParameters.PNG8);
		isp.setBandIds(0, 1, 2);
		
		final ArcGISImageServiceLayer ortofoto = new ArcGISImageServiceLayer("http://10.1.75.111:8399/arcgis/rest/services/Ortofoto/ImageServer", isp);
		ortofoto.setId("Ortofoto");
		ortofoto.setCompressionQuality(20);
		map.addLayer(ortofoto);
		
		map.addClickHandler(new MapClickHandler() {
			@Override
			public void onClick(Event event) {
				Point p = event.getMapPoint();
				RootPanel.get().add(new HTML("x: " + p.getX() + ", y: " + p.getY()));
				
				QueryTask task = new QueryTask("http://10.1.75.111:8399/arcgis/rest/services/Lugano/MapServer/1");
				Query query = new Query();
				query.setGeometry(event.getMapPoint());
				
				task.execute(query, new QueryCallback() {
					
					@Override
					public void onSuccess(FeatureSet featureSet) {
						RootPanel.get().add(new HTML(featureSet.getFeatures().get(0).getAttributes().get("KEYGIS")));	
					}
					
					@Override
					public void onFailure(Throwable caught) {
						GWT.log("Error on query: ", caught);
					}
				});
				
			}
		});

		for(Graphic g : map.getGraphics()) {
			GWT.log("graphic: " + g, null);
		}
		
		Toolbar toolbar = new Toolbar(mapPanel.getMapWidget());

		mainPanel.add(toolbar);
		mainPanel.add(mapPanel);
		// main.add(new TestPanel());
		
		// Initial TOC -> export to a Widget
		for(final Layer layer : map.getLayers()) {
			CheckBox checkbox = new CheckBox(layer.getId());
			checkbox.setValue(layer.isVisible());
			checkbox.addClickHandler(new ClickHandler() {
				@Override
				public void onClick(ClickEvent event) {
					boolean state = ((CheckBox) event.getSource()).getValue();
					layer.setVisible(state);
				}
			});
			RootPanel.get().add(checkbox);
		}
		
		RootPanel.get().add(mainPanel);
		
		// locateme();
		map.reposition();
		
		Button addSymbol = new Button("Add Symbol");
		addSymbol.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				// map.graphics.add(new esri.Graphic(geometry, symbol));
				// map.getGraphics().add(new Graphic());				
			}
		});
		
		RootPanel.get().add(addSymbol);
		
	}

	private static native final void log(JavaScriptObject js) /*-{
		$wnd.console.log(js);
	}-*/;
		
	private static native final void locateme() /*-{
		if ($wnd.navigator.geolocation != null) {
			$wnd.navigator.geolocation.getCurrentPosition(function(position) {
				$wnd.console.log(position.coords.latitude);
				$wnd.console.log(position.coords.longitude);
			});
		}
	}-*/;
	
}
