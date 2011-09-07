package com.esri.gwt.client.layers;

import com.google.gwt.core.client.JavaScriptObject;

public class ArcGISDynamicMapServiceLayer extends Layer {
	
	public ArcGISDynamicMapServiceLayer(String uri) {
		super(_newInstance(uri));
	}
	
	public ArcGISDynamicMapServiceLayer(String id, String uri) {
		super(_newInstance(id, uri));
	}
	
	/* JSNI */
	
	private native static JavaScriptObject _newInstance(String uri) /*-{
		return new $wnd.esri.layers.ArcGISDynamicMapServiceLayer(uri);
	}-*/;
	
	private native static JavaScriptObject _newInstance(String idLayer, String uri) /*-{
		return new $wnd.esri.layers.ArcGISDynamicMapServiceLayer(uri, { id: idLayer });
	}-*/;
	
}
