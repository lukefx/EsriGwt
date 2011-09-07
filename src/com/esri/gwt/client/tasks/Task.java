package com.esri.gwt.client.tasks;

import com.google.gwt.core.client.JavaScriptObject;

public abstract class Task {

	private JavaScriptObject task;

	public String getUrl() {
		return _getUrl(this.task);
	}

	public JavaScriptObject getTask() {
		return this.task;
	}
	
	public void setTask(JavaScriptObject task) {
		this.task = task;
	}
	
	/* JSNI */
	
	private native String _getUrl(JavaScriptObject task) /*-{
		return task.url;
	}-*/;
	
}
