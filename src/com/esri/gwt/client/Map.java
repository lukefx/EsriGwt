package com.esri.gwt.client;

import java.util.ArrayList;
import java.util.List;

import com.esri.gwt.client.geometry.Extent;
import com.esri.gwt.client.geometry.Point;
import com.esri.gwt.client.geometry.SpatialReference;
import com.esri.gwt.client.graphic.Graphic;
import com.esri.gwt.client.layers.Layer;
import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.dom.client.Element;

/**
 * Basic Map class with all the navigation functionalities.
 * @author lsimone
 *
 */
public abstract class Map {

	private JavaScriptObject map;
	private List<Layer> layers;
	private List<Graphic> graphicLayers;
	
	public Map(Element element) {
		layers = new ArrayList<Layer>();
		graphicLayers = new ArrayList<Graphic>();
		this.map = _newInstance(element, null);
	}
	
	public Map(Element element, Extent extent) {
		layers = new ArrayList<Layer>();
		graphicLayers = new ArrayList<Graphic>();
		this.map = _newInstance(element, extent.getExtent());
	}
	
	public JavaScriptObject getMap() {
		return this.map;
	}

	public void addLayer(Layer layer) {
		_addLayer(this.map, layer.getLayer(), 0);
		layers.add(layer);
	}

	public void addLayer(Layer layer, int index) {
		_addLayer(this.map, layer.getLayer(), index);
		layers.add(layer);
	}

	public Layer getLayer(int id) {
		return layers.get(id);
	}

	public List<Layer> getLayers() {
		return this.layers;
	}
	
	public void removeLayer(Layer layer) {
		_removeLayer(this.map, layer.getLayer());
		layers.remove(layer);
	}
	
	public void reorderLayer(Layer layer, int index) {
		_reorderLayer(this.map, layer.getLayer(), index);
	}
	
	public int getLevel() {
		return _getLevel(this.map);
	}

	public Extent getExtent() {
		return new Extent(_getExtent(this.map));
	}

	public void panLeft() {
		_panLeft(this.map);
	}

	public void panRight() {
		_panRight(this.map);
	}
	
	public void panUp() {
		_panUp(this.map);
	}

	public void panDown() {
		_panDown(this.map);
	}
	
	public void removeAllLayers() {
		_removeAllLayers(this.map);
	}
	
	public String[] getLayerIds() {
		return _layerIds(this.map).toString().trim().split(",");
	}

	public void reposition() {
		_reposition(this.map);
	}
	
	public void resize() {
		_resize(this.map);
	}
	
	public void setExtent(Extent extent) {
		// default fit = false
		_setExtent(this.map, extent.getExtent(), false);
	}
	
	public void setExtent(Extent extent, boolean fit) {
		_setExtent(this.map, extent.getExtent(), fit);
	}
	
	public SpatialReference getSpatialReference() {
		return _getSpatialReference(this.map);
	}
	
	public void setLevel(int level) {
		_setLevel(this.map, level);
	}
	
	/**
	 * A standard CSS cursor value. 
	 * Some common values include "default", "pointer", "crosshair", "text", "help", and "wait".
	 * @param cursor
	 */
	public void setMapCursor(String cursor) {
		_setMapCursor(this.map, cursor);
	}
	
	/**
	 * Converts a single screen point or an array of screen points to map coordinates.
	 * @param screenPoint
	 * @return
	 */
	public Point toMap(Point screenPoint) {
		return _toMap(this.map, screenPoint);
	}

	/**
	 * Converts a single map point or an array of map points to screen coordinates.
	 * @param mapPoint
	 * @return
	 */
	public Point toScreen(Point mapPoint) {
		return _toScreen(this.map, mapPoint);
	}
	
	/**
	 * Provides access to the Map's GraphicsLayer.
	 * @return
	 */
	public List<Graphic> getGraphics() {
		return graphicLayers;
	}	
	
	/* JSNI Methods */

	private native JavaScriptObject _newInstance(Element mapDomElement, JavaScriptObject extent) /*-{
		
		$wnd.console.log(mapDomElement);
		var map = new $wnd.esri.Map(mapDomElement);
		return map;
		// return (ex != null) ? new $wnd.esri.Map(mapDomElement, { extent: ex }) : new $wnd.esri.Map(mapDomElement);
	}-*/;

	private native void _addLayer(JavaScriptObject map, JavaScriptObject layer, int index) /*-{
		//TODO layers index
		map.addLayer(layer);
	}-*/;

	private native JavaScriptObject _getExtent(JavaScriptObject map) /*-{
		return map.extent;
	}-*/;

	private native void _panLeft(JavaScriptObject map) /*-{
		map.panLeft();
	}-*/;

	private native void _panRight(JavaScriptObject map) /*-{
		map.panRight();
	}-*/;

	private native void _panUp(JavaScriptObject map) /*-{
		map.panUp();
	}-*/;
	
	private native void _panDown(JavaScriptObject map) /*-{
		map.panDown();
	}-*/;
	
	private native JavaScriptObject _layerIds(JavaScriptObject map) /*-{
		return map.layerIds;
	}-*/;

	private native int _getLevel(JavaScriptObject map) /*-{
		return map.getLevel();
	}-*/;

	private native void _removeAllLayers(JavaScriptObject map) /*-{
		return map.removeAllLayers();
	}-*/;

	private native void _removeLayer(JavaScriptObject map, JavaScriptObject layer) /*-{
		map.removeLayer(layer);
	}-*/;

	private native void _reorderLayer(JavaScriptObject map, JavaScriptObject layer, int index) /*-{
		map.reorderLayer(layer, index);
	}-*/;	
	
	private native void _reposition(JavaScriptObject map) /*-{
		map.reposition();
	}-*/;

	private native void _resize(JavaScriptObject map) /*-{
		map.resize();
	}-*/;		

	private native void _setExtent(JavaScriptObject map, JavaScriptObject extent, boolean fit) /*-{
		map.setExtent(extent, fit);
	}-*/;	
	
	private native void _setLevel(JavaScriptObject map, int level) /*-{
		map.setLevel(level);
	}-*/;

	private native void _setMapCursor(JavaScriptObject map, String cursor) /*-{
		map.setMapCursor(cursor);
	}-*/;

	private native Point _toMap(JavaScriptObject map, JavaScriptObject screenPoint) /*-{
		return map.toMap(screenPoint);
	}-*/;

	private native Point _toScreen(JavaScriptObject map, JavaScriptObject mapPoint) /*-{
		return map.toScreen(mapPoint);
	}-*/;

	private native SpatialReference _getSpatialReference(JavaScriptObject map) /*-{
		return map.spatialReference;
	}-*/;
	
}
