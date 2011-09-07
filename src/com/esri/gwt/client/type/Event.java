package com.esri.gwt.client.type;

import com.esri.gwt.client.geometry.Point;
import com.google.gwt.core.client.JavaScriptObject;

public class Event extends JavaScriptObject {

	protected Event() {  }
	
	public final native Point getMapPoint() /*-{ return this.mapPoint }-*/;
	
}
