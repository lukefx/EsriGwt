package com.esri.gwt.client.geometry;

import com.google.gwt.core.client.JavaScriptObject;

/**
 * The minimum and maximum X- and Y- coordinates of a bounding box.
 * @author lsimone
 *
 */
public class Extent {
	
	private JavaScriptObject extent;
	
	public Extent(JavaScriptObject extent) { 
		this.extent = extent;
	}
	
	/**
	 * Creates a new Extent object. The coordinates represent the lower left and upper right corners of the bounding box. 
	 * A spatial reference is also required.
	 * @param xmin Bottom-left X-coordinate of an extent envelope. 
	 * @param ymin Bottom-left Y-coordinate of an extent envelope. 
	 * @param xmax Top-right X-coordinate of an extent envelope. 
	 * @param ymax Top-right Y-coordinate of an extent envelope. 
	 * @param spatialRefence Spatial reference of the geometry. 
	 */
	public Extent(double xmin, double ymin, double xmax, double ymax, SpatialReference spatialRefence) {
		this.extent = _newInstance(xmin, ymin, xmax, ymax, spatialRefence);
	}
	
	public JavaScriptObject getExtent() {
		return this.extent;
	}
	
	public float getXMax() {
		return _getXMax(extent);
	}

	public float getXMin() {
		return _getXMin(extent);
	}
	
	public float getYMax() {
		return _getYMax(extent);
	}
	
	public float getYMin() {
		return _getYMin(extent);
	}
	
	public String toString() {
		return "[" + getXMin() + "," + getYMin() + ";" + getXMax() + "," + getYMax() + "]";
	}
	
	private native JavaScriptObject _newInstance(double xmin, double ymin, double xmax, double ymax, SpatialReference ref) /*-{
		return new $wnd.esri.geometry.Extent(xmin, ymin, xmax, ymax, ref);
	}-*/;
	
	private final native float _getXMax(JavaScriptObject extent) /*-{
		return extent.xmax;
	}-*/;

	private final native float _getXMin(JavaScriptObject extent) /*-{
		return extent.xmin;
	}-*/;

	private final native float _getYMax(JavaScriptObject extent) /*-{
		return extent.ymax;
	}-*/;

	private final native float _getYMin(JavaScriptObject extent) /*-{
		return extent.ymin;
	}-*/;
	
	private final native String _getType() /*-{
		return this.type;
	}-*/;
	
}
