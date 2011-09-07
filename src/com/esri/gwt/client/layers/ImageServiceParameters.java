package com.esri.gwt.client.layers;

import com.google.gwt.core.client.JavaScriptObject;

public class ImageServiceParameters {

	private JavaScriptObject config;
	
	public final static String PNG8 = "png8";
	public final static String PNG24 = "png24";
	public final static String JPG = "jpg";
	public final static String BMP = "bmp";
	public final static String GIF = "gif";
	
	public final static String INTERPOLATION_BILINEAR = "INTERPOLATION_BILINEAR";
	public final static String INTERPOLATION_CUBICCONVOLUTION = "INTERPOLATION_CUBICCONVOLUTION";
	public final static String INTERPOLATION_MAJORITY = "INTERPOLATION_MAJORITY";
	public final static String INTERPOLATION_NEARESTNEIGHBOR = "INTERPOLATION_NEARESTNEIGHBOR";

	public ImageServiceParameters() {
		config = _newInstance();
	}
	
	public JavaScriptObject getImageServiceParameters() {
		return this.config;
	}
	
	/**
	 * <p>Map image format.</p>
	 * Known values: png8 | png24 | jpg | bmp | gif
	 * <p><b>Default value</b>: png8</p> 
	 * @param format
	 */
	public void setFormat(String format) {
		_format(this.config, format);
	}
	
	/**
	 * Array of current band selections.
	 * @param R
	 * @param G
	 * @param B
	 */
	public void setBandIds(int i, int j, int k) {
		_bandIds(this.config, i, j, k);
	}
	
	/**
	 * Current interpolation method. 
	 * The interpolation method affects how the raster dataset is transformed when it undergoes warping or when it changes coordinate space.
	 * @param interpolationBilinear
	 */
	public void setInterpolation(String interpolation) {
		_interpolation(this.config, interpolation);
	}	
	
	/* JSNI */
	
	private native final JavaScriptObject _newInstance() /*-{
		return new $wnd.esri.layers.ImageServiceParameters();
	}-*/;
	
	private native final JavaScriptObject _format(JavaScriptObject config, String format) /*-{
		config.format = format;
	}-*/;

	private native final JavaScriptObject _bandIds(JavaScriptObject config, int i, int j, int k) /*-{
		config.bandIds = [i, j, k];
	}-*/;

	private native final JavaScriptObject _interpolation(JavaScriptObject config, String interpolation) /*-{
		config.interpolation = interpolation;
	}-*/;
	
}
