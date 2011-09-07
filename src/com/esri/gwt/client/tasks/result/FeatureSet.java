package com.esri.gwt.client.tasks.result;

import java.util.ArrayList;
import java.util.List;

import com.esri.gwt.client.geometry.SpatialReference;
import com.esri.gwt.client.graphic.Graphic;
import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.core.client.JsArray;

public class FeatureSet extends Result {

	protected FeatureSet() {  }

	// private final native JavaScriptObject getInstance() /*-{ return this; }-*/;
	public final native String getDisplayFieldName() /*-{ return this.displayFieldName; }-*/;
	public final native Object getFieldAliases() /*-{ return this.fieldAliases }-*/;
	public final native String getGeometryType() /*-{ return this.geometryType; }-*/;
	public final native SpatialReference getSpatialReference() /*-{ return this.spatialReference; }-*/;
	private final native JsArray<JavaScriptObject> _getFeatures() /*-{ return this.features; }-*/;

	public final List<Graphic> getFeatures() {
		List<Graphic> graphics = new ArrayList<Graphic>();
		JsArray<JavaScriptObject> array = _getFeatures();
		for (int i = 0; i < array.length(); i++) {
			graphics.add(Graphic.createInstance(array.get(i)));
		}
		return graphics;
	}

}
