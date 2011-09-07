package com.esri.gwt.client.tasks;

import com.esri.gwt.client.tasks.callback.QueryCallback;
import com.google.gwt.core.client.JavaScriptObject;

public class QueryTask extends Task {
	
	public QueryTask(String url) {
		this.setTask(_newInstance(url));
	}

	public void execute(Query query, QueryCallback callback) {
		_execute(this.getTask(), query.getQuery(), callback);
	}
	
	private native JavaScriptObject _newInstance(String url) /*-{
		return new $wnd.esri.tasks.QueryTask(url);
	}-*/;
	
	private native void _execute(JavaScriptObject task, JavaScriptObject query, QueryCallback taskCallback) /*-{		

		task.execute(query, 
			function(featureSet) {
				taskCallback.@com.esri.gwt.client.tasks.callback.QueryCallback::onSuccess(Lcom/esri/gwt/client/tasks/result/FeatureSet;)(featureSet);
			},
			function(error) {
				taskCallback.@com.esri.gwt.client.tasks.callback.QueryCallback::onFailure(Ljava/lang/Throwable;)(error);
			}
		);

	}-*/;
	
}
