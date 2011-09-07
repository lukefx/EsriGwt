package com.esri.gwt.client.layers;

import com.google.gwt.core.client.JavaScriptObject;

public class ArcGISTiledMapServiceLayer extends Layer {

	public ArcGISTiledMapServiceLayer(String uri) {
		super(_newInstance(uri));
	}

	private native static JavaScriptObject _newInstance(String uri) /*-{
		return new $wnd.esri.layers.ArcGISTiledMapServiceLayer(uri);
	}-*/;
	
}
