package com.esri.gwt.client;

import java.util.Iterator;

import com.esri.gwt.client.widget.MapWidget;
import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.Element;
import com.google.gwt.user.client.ui.SimplePanel;
import com.google.gwt.user.client.ui.Widget;

/**
 * MapPanel is a SimplePanel with inside a Map.
 * @author lsimone
 *
 */
public class MapPanel extends SimplePanel {

	private MapWidget map;
	private static int id = 1;
	
	public MapPanel() {
		super();
		super.getElement().setId("map_" + id++);
		super.getElement().setClassName("map");
		setSize("100%", "100%");
		
		GWT.log("panel id: " + this.getElement().getId(), null);
		GWT.log("super id: " + super.getElement().getId(), null);

		initMap(super.getElement());
		
	}
	
	/**
	 * Initialize the Map inside the panel.
	 * Extent the class and override this method to add custom initialization to the map.
	 */
	private void initMap(Element el) {
		this.map = new MapWidget(el);
	}
	
	public MapWidget getMapWidget() {
		return this.map;
	}
	
	@Override
	protected void onLoad() {
		super.onLoad();
		// initMap(super.getElement());
		// this.map.resize();
		this.map.reposition();
	}

	@Override
	public boolean remove(Widget child) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Iterator<Widget> iterator() {
		// TODO Auto-generated method stub
		return null;
	}
	
}
