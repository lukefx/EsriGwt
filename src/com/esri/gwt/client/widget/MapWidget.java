package com.esri.gwt.client.widget;

import com.esri.gwt.client.Map;
import com.esri.gwt.client.event.HasMapClickHandlers;
import com.esri.gwt.client.event.HasMapExtentHandlers;
import com.esri.gwt.client.event.HasMapPanHandlers;
import com.esri.gwt.client.event.MapClickHandler;
import com.esri.gwt.client.event.MapExtentHandler;
import com.esri.gwt.client.event.MapPanHandler;
import com.esri.gwt.client.geometry.Extent;
import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.dom.client.Element;

/**
 * Main map widget. It handle all the events of the map.
 * @author lsimone
 *
 */
public class MapWidget extends Map implements HasMapClickHandlers, HasMapPanHandlers, HasMapExtentHandlers {

	public MapWidget(Element element) {
		super(element);
	}

	public MapWidget(Element element, Extent extent) {
		super(element, extent);
	}

	public void addClickHandler(MapClickHandler handler) {
		_addClickListener(this.getMap(), handler.getCallback());
	}
    
	public void addPanHandler(MapPanHandler handler) {
		for(String event : handler.getCallbacks().keySet()) {
			_addPanListener(this.getMap(), event, handler.getCallback(event));
		}
	}

	public void addExtentHandler(MapExtentHandler handler) {
		_addExtentHandler(this.getMap(), handler.getCallback());
	}
	
	/* JSNI Methods */
	private native void _addClickListener(JavaScriptObject map, JavaScriptObject clickCallback) /*-{
    	$wnd.dojo.connect(map, "onClick", clickCallback);
	}-*/;
	
    private native void _addPanListener(JavaScriptObject map, String event, JavaScriptObject panCallback) /*-{
		$wnd.dojo.connect(map, event, panCallback);
	}-*/;

	private native void _addExtentHandler(JavaScriptObject map, JavaScriptObject extentCallback) /*-{
		$wnd.dojo.connect(map, "onExtentChange", extentCallback);
	}-*/;
    
}
