package com.esri.gwt.client.infotemplate;

import com.google.gwt.core.client.JavaScriptObject;

public class InfoTemplate {

	private JavaScriptObject infoTemplate;
	
	/**
	 * Creates a new empty InfoTemplate object.
	 */
	public InfoTemplate() {
		this.infoTemplate = _newInstance();
	}
	
	private InfoTemplate(JavaScriptObject infoTemplate) {
		this.infoTemplate = infoTemplate;
	}
	
	public static InfoTemplate createInstance(JavaScriptObject infoTemplate) {
		return new InfoTemplate(infoTemplate);
	}
	
	public JavaScriptObject getInfoTemplate() {
		return this.infoTemplate;
	}
	
	public String getTitle() {
		return _getTitle(this.infoTemplate);
	}
	
	public void setTitle(String title) {
		_setTitle(this.infoTemplate, title);
	}
	
	/* JSNI */
	
	private final native JavaScriptObject _newInstance() /*-{
		return new $wnd.esri.InfoTemplate();
	}-*/;
	
	private final native String _getTitle(JavaScriptObject infoTemplate) /*-{
		return infoTemplate.title;
	}-*/;

	private final native void _setTitle(JavaScriptObject infoTemplate, String title) /*-{
		infoTemplate.setTitle(title);
	}-*/;
	
}
