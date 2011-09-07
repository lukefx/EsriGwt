package com.esri.gwt.client.widget;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.DOM;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.SimplePanel;
import com.google.gwt.user.client.ui.ToggleButton;

/**
 * Toolbar that supports basic navigation such as pan and zoom. 
 * @author lsimone
 *
 */
public class Toolbar extends SimplePanel {

	private JavaScriptObject toolbar;
	private JavaScriptObject map;
	private HorizontalPanel panel;
	
	private static int id = 1;

	public Toolbar(final MapWidget mapWidget) {
		
		super(DOM.createDiv());
		super.getElement().setId("toolbar-" + (id++));
		this.map = mapWidget.getMap();

		panel = new HorizontalPanel();
		
		final ToggleButton zoomIn = new ToggleButton("Zoom In");
		final ToggleButton zoomOut = new ToggleButton("Zoom Out");
		
		zoomIn.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				ToggleButton bt = (ToggleButton) event.getSource();
				if (bt.isDown()) {
					zoomOut.setDown(false);
					activateZoomIn(toolbar);
				}
				else {
					cleanState();
				}
			}
		});		
		
		zoomOut.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				ToggleButton bt = (ToggleButton) event.getSource();
				if (bt.isDown()) {
					zoomIn.setDown(false);
					activateZoomOut(toolbar);
				}
				else {
					cleanState();
				}
			}
		});
		
		Button fullExtent = new Button("Full Extent", new ClickHandler() {
			public void onClick(ClickEvent event) {
				fullExtent(toolbar);
			}
		});

		Button prevExtent = new Button("Prev Extent", new ClickHandler() {
			public void onClick(ClickEvent event) {
				prevExtent(toolbar);
			}
		});
		
		Button nextExtent = new Button("Next Extent", new ClickHandler() {
			public void onClick(ClickEvent event) {
				nextExtent(toolbar);
			}
		});
		
		Button pan = new Button("Pan", new ClickHandler() {
			public void onClick(ClickEvent event) {
				activatePan(toolbar);
			}
		});
		
		panel.add(zoomIn);
		panel.add(zoomOut);
		panel.add(fullExtent);
		panel.add(prevExtent);
		panel.add(nextExtent);
		panel.add(pan);
		
		this.add(panel);
		
	}

	private void cleanState() {
		
		for(int i=0;i<1;i++) {
			((ToggleButton) panel.getWidget(i)).setDown(false);
		}
		
		deactivateAll(this.toolbar);
		
	}
	
	@Override
	protected void onLoad() {
		super.onLoad();
		this.toolbar = _initToolbar(this.map);
	}
	
	/* JSNI */

	private final native JavaScriptObject _initToolbar(JavaScriptObject map) /*-{
		return new $wnd.esri.toolbars.Navigation(map);
	}-*/;
	
	private final native void activateZoomIn(JavaScriptObject toolbar) /*-{
		toolbar.activate($wnd.esri.toolbars.Navigation.ZOOM_IN);
	}-*/;
	
	private final native void activateZoomOut(JavaScriptObject toolbar) /*-{
		toolbar.activate($wnd.esri.toolbars.Navigation.ZOOM_OUT);
	}-*/;
	
	private final native void fullExtent(JavaScriptObject toolbar) /*-{
		toolbar.zoomToFullExtent();
	}-*/;

	private final native void prevExtent(JavaScriptObject toolbar) /*-{
		toolbar.zoomToPrevExtent();
	}-*/;
	
	private final native void nextExtent(JavaScriptObject toolbar) /*-{
		toolbar.zoomToNextExtent();
	}-*/;
	
	private final native void activatePan(JavaScriptObject toolbar) /*-{
		toolbar.activate($wnd.esri.toolbars.Navigation.PAN);
	}-*/;
	
	private final native void deactivateAll(JavaScriptObject toolbar) /*-{
		toolbar.deactivate();
	}-*/;
	
}
