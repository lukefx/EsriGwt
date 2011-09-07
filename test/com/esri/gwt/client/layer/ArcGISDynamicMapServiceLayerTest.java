package com.esri.gwt.client.layer;

import com.esri.gwt.client.layers.ArcGISDynamicMapServiceLayer;
import com.esri.gwt.client.widget.MapWidget;
import com.google.gwt.junit.client.GWTTestCase;
import com.google.gwt.user.client.DOM;

public class ArcGISDynamicMapServiceLayerTest extends GWTTestCase {
	
	@Override
	public String getModuleName() {
		return "com.esri.gwt.esrigwtweb";
	}
	
	public void testLayer() {
		
		MapWidget map = new MapWidget(DOM.createDiv());
		
		ArcGISDynamicMapServiceLayer layer = new ArcGISDynamicMapServiceLayer("http://10.1.75.107/ArcGIS/rest/services/lugano/MapServer");
		assertNotNull(layer);
		map.addLayer(layer);
		
		layer = new ArcGISDynamicMapServiceLayer("Lugano", "http://10.1.75.107/ArcGIS/rest/services/lugano/MapServer");
		assertEquals(layer.getId(), "Lugano");
		
	}
	
}
