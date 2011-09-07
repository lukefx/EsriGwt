package com.esri.gwt.client.layers;

import com.google.gwt.core.client.JavaScriptObject;

public abstract class Layer {
	
	private JavaScriptObject layer;
	
	public Layer(JavaScriptObject jso) {
		this.layer = jso;
	}
	
	public JavaScriptObject getLayer() {
		return layer;
	}
	
	public String getId() {
		return _getId(layer);
	}
	
	public void setId(String id) {
		_setId(layer, id);
	}
	
	public Boolean isVisible() {
		return _visible(layer);
	}
	
	public void setVisible(boolean visible) {
		_setVisible(layer, visible);
	}
	
	public Boolean isLoaded() {
		return _loaded(layer);
	}
	
	/* JSNI */
	
	private final native boolean _loaded(JavaScriptObject layer) /*-{
		return layer.loaded;
	}-*/;
	
	private final native String _getId(JavaScriptObject layer) /*-{
		return layer.id;
	}-*/;

	private final native void _setId(JavaScriptObject layer, String id) /*-{
		layer.id = id;
	}-*/;
	
	private final native boolean _visible(JavaScriptObject layer) /*-{
		return layer.visible;
	}-*/;
	
	private final native void _setVisible(JavaScriptObject layer, boolean visible) /*-{
		visible ? layer.show() : layer.hide();
	}-*/;
	
}
