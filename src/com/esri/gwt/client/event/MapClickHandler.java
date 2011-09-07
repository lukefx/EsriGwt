package com.esri.gwt.client.event;

import com.esri.gwt.client.type.Event;
import com.google.gwt.core.client.JavaScriptObject;

public abstract class MapClickHandler {

	private final JavaScriptObject callback;
	
	public MapClickHandler() {
		this.callback = _initInstance(this);
	}

    public JavaScriptObject getCallback() {
        return this.callback;
    }
	
	public abstract void onClick(Event event);

	private native JavaScriptObject _initInstance(MapClickHandler mapEventHandler) /*-{
        clickCallback = function(event) {
            mapEventHandler.@com.esri.gwt.client.event.MapClickHandler::onClick(Lcom/esri/gwt/client/type/Event;)(event);
        }
        return clickCallback;
	}-*/;
	
}
