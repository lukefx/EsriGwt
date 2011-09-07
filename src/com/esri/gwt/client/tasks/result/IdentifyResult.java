package com.esri.gwt.client.tasks.result;

import com.esri.gwt.client.graphic.Graphic;

public class IdentifyResult extends Result {
	
	protected IdentifyResult() {  }
	
	public final native String getDisplayName() /*-{ return this.displayName;	}-*/;
	public final native float getLayerId() /*-{ return this.layerId }-*/;
	public final native float getLayerName() /*-{ return this.layerName }-*/;
	public final native Graphic getFeature() /*-{ return this.feature }-*/;
	
}
