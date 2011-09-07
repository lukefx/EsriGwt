package com.esri.gwt.client.layers;

import com.esri.gwt.client.type.ArrayHelper;
import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.core.client.JsArrayNumber;

public class ArcGISImageServiceLayer extends Layer {
	
	public ArcGISImageServiceLayer(String uri) {
		super(_newInstance(uri));		
	}

	public ArcGISImageServiceLayer(String uri, ImageServiceParameters params) {
		super(_newInstance(uri, params.getImageServiceParameters()));		
	}

	public void setClientCaching(boolean caching) {
		_disableClientCaching(this.getLayer(), caching);
	}
	
	public double getBandCount() {
		return _bandCount(this.getLayer());
	}
	
	public double[] getBandIds() {
		return ArrayHelper.toArray(_bandIds(this.getLayer()));
	}
	
	public void setBandIds(int i, int j, int k) {
		_bandIds(this.getLayer(), i, j, k);
	}
	
	public int getCompressionQuality() {
		return _compressionQuality(this.getLayer());
	}
	
	public void setCompressionQuality(int quality) {
		_setCompressionQuality(this.getLayer(), quality);
	}
	
	/* JSNI */
	
	private native static JavaScriptObject _newInstance(String uri, JavaScriptObject params) /*-{
		return new $wnd.esri.layers.ArcGISImageServiceLayer(uri, { imageServiceParameters: params });
	}-*/;
	
	private native static JavaScriptObject _newInstance(String uri) /*-{
		return new $wnd.esri.layers.ArcGISImageServiceLayer(uri);
	}-*/;

	private native static void _disableClientCaching(JavaScriptObject layer, boolean caching) /*-{
		layer.disableClientCaching = caching;
	}-*/;
	
	private native static double _bandCount(JavaScriptObject layer) /*-{
		return layer.bandCount;
	}-*/;
	
	private native static JsArrayNumber _bandIds(JavaScriptObject layer) /*-{
		return layer.bandIds;
	}-*/;
	
	private native final void _bandIds(JavaScriptObject layer, int i, int j, int k) /*-{
		layer.bandIds = [i, j, k];
	}-*/;
	
	private native final int _compressionQuality(JavaScriptObject layer) /*-{
		return layer.compressionQuality;
	}-*/;
	
	private native final void _setCompressionQuality(JavaScriptObject layer, int quality) /*-{
		layer.setCompressionQuality(quality);
	}-*/;
	
}
