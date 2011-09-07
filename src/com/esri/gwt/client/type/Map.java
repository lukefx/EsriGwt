package com.esri.gwt.client.type;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.core.client.JsArrayString;

public class Map<E extends JavaScriptObject> extends JavaScriptObject {

	protected Map() {  }
	public final native int length() /*-{ return this.length; }-*/;
	public final native String get(String i) /*-{ return this[i]; }-*/;
	
	private final native JsArrayString _keySet() /*-{
		var array = new Array();
		var i = 0;
		for (var key in this) {
			array[i++] = key;
		}
		return array;
	}-*/;

	public final String[] keySet() {
		return ArrayHelper.toArray(_keySet());
	}
	
}
