package com.esri.gwt.client.graphic;

import com.esri.gwt.client.geometry.Geometry;
import com.esri.gwt.client.infotemplate.InfoTemplate;
import com.esri.gwt.client.symbol.Symbol;
import com.esri.gwt.client.type.Map;
import com.google.gwt.core.client.JavaScriptObject;

/**
 * A Graphic can contain geometry, a symbol, attributes, or an infoTemplate. 
 * A Graphic is displayed in the GraphicsLayer. The GraphicsLayer allows you to listen for events on Graphics. 
 * @author lsimone
 *
 */
public class Graphic {

	private JavaScriptObject graphic;
	
	public Graphic(Geometry geometry) {
		this.graphic = _newInstance(geometry);
	}

	public Graphic(Geometry geometry, Symbol symbol) {
		this.graphic = _newInstance(geometry);
	}
	
	private Graphic(JavaScriptObject graphic) {
		this.graphic = graphic;
	}
	
	public static Graphic createInstance(JavaScriptObject graphic) {
		return new Graphic(graphic);
	}
	
	public Map<JavaScriptObject> getAttributes() {
		return _getAttributes(this.graphic);
	}
	
	public Geometry getGeometry() {
		return _getGeometry(this.graphic);
	}
	
	public InfoTemplate getInfoTemplate() {
		return InfoTemplate.createInstance(_getInfoTemplate(this.graphic));
	}
	
	public void setInfoTemplate(InfoTemplate infoTemplate) {
		_setInfoTemplate(this.graphic, infoTemplate.getInfoTemplate());
	}
	
	/* JSNI */
	
	private final native JavaScriptObject _newInstance(Geometry geometry) /*-{
		return new $wnd.esri.Graphic(geometry);
	}-*/;
	
	private final native Map<JavaScriptObject> _getAttributes(JavaScriptObject graphic) /*-{ 
		return graphic.attributes; 
	}-*/;
	
	private final native Geometry _getGeometry(JavaScriptObject graphic) /*-{ 
		return graphic.geometry;
	}-*/;
	
	private final native JavaScriptObject _getInfoTemplate(JavaScriptObject graphic) /*-{
		return graphic.infoTemplate;
	}-*/;
	
	private final native void _setInfoTemplate(JavaScriptObject graphic, JavaScriptObject infoTemplate) /*-{
		graphic.setInfoTemplate(infoTemplate);
	}-*/;
	
	
	
}
