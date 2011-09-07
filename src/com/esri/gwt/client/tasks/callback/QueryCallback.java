package com.esri.gwt.client.tasks.callback;

import com.esri.gwt.client.tasks.result.FeatureSet;

public interface QueryCallback {

	public void onSuccess(FeatureSet featureSet);
	public void onFailure(Throwable caught);
	
}
