package com.esri.gwt.client.type;

import java.util.Iterator;

import com.google.gwt.core.client.JavaScriptObject;

public class List<E extends JavaScriptObject> extends JavaScriptObject {

	protected List() {  }
	public final native int length() /*-{ return this.length; }-*/;
	public final native E get(int i) /*-{ return this[i]; }-*/;
	
	public final Iterator<E> iterator() {
		// TODO Auto-generated method stub
		return null;
	}

}
