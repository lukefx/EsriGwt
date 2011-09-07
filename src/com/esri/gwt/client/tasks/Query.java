package com.esri.gwt.client.tasks;

import com.esri.gwt.client.geometry.Geometry;
import com.google.gwt.core.client.JavaScriptObject;

public class Query {
	
	private JavaScriptObject query;
	
	public Query() {
		this.query = _newInstance();
	}

	public JavaScriptObject getQuery() {
		return this.query;
	}
	
	public void setGeometry(Geometry geometry) {
		_setGeometry(this.query, geometry);
	}	
	
	/* JSNI */
	
	private native JavaScriptObject _newInstance() /*-{
		return new $wnd.esri.tasks.Query();
	}-*/;
	
	private native void _setGeometry(JavaScriptObject query, Geometry geometry) /*-{ 
		query.geometry = geometry;
	}-*/;
	
}
