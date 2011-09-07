package com.esri.gwt.client.event;

import com.esri.gwt.client.geometry.Extent;
import com.esri.gwt.client.geometry.Point;
import com.esri.gwt.client.layers.LOD;
import com.google.gwt.core.client.JavaScriptObject;

public abstract class MapExtentHandler {

	private final JavaScriptObject callback;
	
	public MapExtentHandler() {
		this.callback = _initInstance(this);
	}
	
	public JavaScriptObject getCallback() {
		return this.callback;
	}
	
	public abstract void onExtentChange(Extent extent, Point point, boolean levelChange, LOD lod);
	
	public void _onExtentChange(JavaScriptObject extent, Point point, boolean levelChange, LOD lod) {
		this.onExtentChange(new Extent(extent), point, levelChange, lod);
	}
	
	private native JavaScriptObject _initInstance(MapExtentHandler mapEventHandler) /*-{
	    extentCallback = function(extent, delta, outLevelChange, outLod){
	        mapEventHandler.@com.esri.gwt.client.event.MapExtentHandler::_onExtentChange(Lcom/google/gwt/core/client/JavaScriptObject;Lcom/esri/gwt/client/geometry/Point;ZLcom/esri/gwt/client/layers/LOD;)(extent, delta, outLevelChange, outLod);
	    }
	    return extentCallback;
	}-*/;
	
}
