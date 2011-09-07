package com.esri.gwt.client.geometry;

import com.google.gwt.core.client.JavaScriptObject;

public class SpatialReference extends JavaScriptObject {

	protected SpatialReference() { } 
	
	public final native int getWkid() /*-{ return this.wkid }-*/;
	
	public static final native SpatialReference create(int wkid) /*-{
		return new $wnd.esri.SpatialReference({wkid:wkid});
	}-*/;
	
}
