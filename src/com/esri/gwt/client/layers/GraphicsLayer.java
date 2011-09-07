package com.esri.gwt.client.layers;

import com.google.gwt.core.client.JavaScriptObject;

/**
 *  A layer that contains one or more Graphic features. 
 *  Each map contains a GraphicsLayer by default, accessible using the Map.Graphics property. 
 *  Beginning with v1.4, you can create your own graphics layers and add them to the map. 
 *  Graphics layers can be reordered within the group of graphics layers. 
 *  However, the graphics layer in Map.Graphics is always on top. 
 *  Also, all graphics layers are always on top of TiledMapServiceLayers and DynamicMapServiceLayers. 
 * @author lsimone
 *
 */
public class GraphicsLayer extends Layer {

	public GraphicsLayer() {
		super(_newInstance());
	}
	
	private native static JavaScriptObject _newInstance() /*-{
		return new $wnd.esri.layers.GraphicsLayer();
	}-*/;

}
