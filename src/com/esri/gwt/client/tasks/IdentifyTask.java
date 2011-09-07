package com.esri.gwt.client.tasks;

import com.esri.gwt.client.tasks.callback.IdentifyCallback;
import com.google.gwt.core.client.JavaScriptObject;

public class IdentifyTask extends Task {

	public IdentifyTask(String url) {
		this.setTask(_newInstance(url));
	}
	
	public void execute(IdentifyParameters identifyParams, IdentifyCallback callback) {
		_execute(this.getTask(), identifyParams.getIdentifyParameters(), callback);
	}

	/* JSNI */
	
	private native JavaScriptObject _newInstance(String url) /*-{
		return new $wnd.esri.tasks.IdentifyTask(url);
	}-*/;
	
	private native void _execute(JavaScriptObject task, JavaScriptObject identifyParams, IdentifyCallback taskCallback) /*-{		

		task.execute(identifyParams, function(identifyResults) {
			taskCallback.@com.esri.gwt.client.tasks.callback.IdentifyCallback::onSuccess(Lcom/esri/gwt/client/tasks/result/IdentifyResult;)(identifyResults);
		});

	}-*/;
	
}
