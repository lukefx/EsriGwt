package com.esri.gwt.client.event;

import java.util.HashMap;
import java.util.Map;

import com.esri.gwt.client.geometry.Point;
import com.google.gwt.core.client.JavaScriptObject;

public abstract class MapPanHandler {

	private Map<String, JavaScriptObject> callbacks;

	public MapPanHandler() {
		callbacks = new HashMap<String, JavaScriptObject>();
		callbacks.put("onPan", _attachPanEvent(this));
		callbacks.put("onPanStart", _attachPanStartEvent(this));
		callbacks.put("onPanEnd", _attachPanStopEvent(this));
	}

	public JavaScriptObject getCallback(String event) {
		return this.callbacks.get(event);
	}

	public Map<String, JavaScriptObject> getCallbacks() {
		return callbacks;
	}

	public abstract void handlePanEvent(Point event);
	public abstract void handleStartPanEvent(Point event);
	public abstract void handleEndPanEvent(Point event);

	private native JavaScriptObject _attachPanEvent(MapPanHandler mapEventHandler) /*-{
		callback = function(event) {
			mapEventHandler.@com.esri.gwt.client.event.MapPanHandler::handlePanEvent(Lcom/esri/gwt/client/geometry/Point;)(event);
		}
		return callback;
	}-*/;

	private native JavaScriptObject _attachPanStartEvent(MapPanHandler mapEventHandler) /*-{
		callback = function(event) {
			mapEventHandler.@com.esri.gwt.client.event.MapPanHandler::handleStartPanEvent(Lcom/esri/gwt/client/geometry/Point;)(event);
		}
		return callback;
	}-*/;

	private native JavaScriptObject _attachPanStopEvent(MapPanHandler mapEventHandler) /*-{
		callback = function(event) {
			mapEventHandler.@com.esri.gwt.client.event.MapPanHandler::handleEndPanEvent(Lcom/esri/gwt/client/geometry/Point;)(event);
		}
		return callback;
	}-*/;

}
