package com.esri.gwt.client.tasks;

import com.esri.gwt.client.layers.LayerOption;
import com.google.gwt.core.client.JavaScriptObject;

public class IdentifyParameters {
	
	private JavaScriptObject params;
	
	public IdentifyParameters() {
		this.params = _newInstance();
	}
	
	public JavaScriptObject getIdentifyParameters() {
		return this.params;
	}
	
	public float getDPI() {
		return _dpi(this.params);
	}
	
	public float getTolerance() {
		return _getTolerance(this.params);
	}

	public void setTolerance(float tolerance) {
		_setTolerance(this.params, tolerance);
	}
	
	public void returnGeometry(boolean geometry) {
		_setReturnGeometry(this.params, geometry);
	}
	
	public void setLayerIds(int[] layers) {
		_layerIds(this.params, layers);
	}
	
	public void setLayerOption(LayerOption layerOption) {
		_layerOption(this.params, layerOption.toString());
	}	
	
	/* JSNI */

	private native JavaScriptObject _newInstance() /*-{
		return new $wnd.esri.tasks.IdentifyParameters();
	}-*/;
	
	private native float _dpi(JavaScriptObject params) /*-{
		return params.dpi;
	}-*/;
	
	private native float _getTolerance(JavaScriptObject params) /*-{
		return params.tolerance;
	}-*/;

	private native void _setTolerance(JavaScriptObject params, float tolerance) /*-{
		params.tolerance = tolerance;
	}-*/;
	
	private native void _setReturnGeometry(JavaScriptObject params, boolean geometry) /*-{
		params.returnGeometry = geometry;
	}-*/;
	
	private native void _layerIds(JavaScriptObject params, int[] layers) /*-{
		$wnd.console.log(layers);
		params.layerIds = layers;
	}-*/;
	
	private native void _layerOption(JavaScriptObject params, String layerOption) /*-{
		params.layerOption = layerOption;
	}-*/;
	
}
