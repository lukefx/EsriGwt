package com.esri.gwt.client.tasks.callback;

import com.esri.gwt.client.tasks.result.IdentifyResult;

public abstract class IdentifyCallback {

	public abstract void onSuccess(IdentifyResult results);
	public abstract void onFailure(Throwable caught);
	
}
