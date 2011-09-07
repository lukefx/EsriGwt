package com.esri.gwt.client.layer;

import com.esri.gwt.client.MapPanel;
import com.esri.gwt.client.widget.MapWidget;
import com.google.gwt.junit.client.GWTTestCase;
import com.google.gwt.user.client.DOM;
import com.google.gwt.user.client.ui.RootPanel;

public class MapTest extends GWTTestCase {

	@Override
	public String getModuleName() {
		return "com.esri.gwt.esrigwtweb";
	}

	public void testMapPanel() {
		
		MapPanel panel = new MapPanel();
		RootPanel.get().add(panel);
		
		assertNotNull(panel.getMapWidget());
		assertNotNull(panel.getElement().getId());
		
	}
	
	public void testMapInit() {
		
		MapWidget map = new MapWidget(DOM.createDiv());
		assertNotNull(map);
		assertNotNull(map.getMap());
		
	}

}
