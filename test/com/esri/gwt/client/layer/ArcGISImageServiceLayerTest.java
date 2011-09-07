package com.esri.gwt.client.layer;

import com.esri.gwt.client.layers.ArcGISImageServiceLayer;
import com.esri.gwt.client.layers.ImageServiceParameters;
import com.google.gwt.junit.client.GWTTestCase;

public class ArcGISImageServiceLayerTest extends GWTTestCase {

	@Override
	public String getModuleName() {
		return "com.esri.gwt.EsriGwtWeb";
	}

	public void testLayer() {
		
		ImageServiceParameters isp = new ImageServiceParameters();
		isp.setFormat(ImageServiceParameters.PNG8);
		isp.setInterpolation(ImageServiceParameters.INTERPOLATION_BILINEAR);
		isp.setBandIds(0, 1, 2);
		
		ArcGISImageServiceLayer ortofoto = new ArcGISImageServiceLayer("http://10.1.75.107/ArcGIS/rest/services/Ortofoto/ImageServer", isp);
		ortofoto.getBandCount();
		ortofoto.getBandIds();
		ortofoto.setBandIds(1, 2, 3);
		ortofoto.setCompressionQuality(50); // A value from 0 to 100. 100 is best quality but largest in file size.
		int quality = ortofoto.getCompressionQuality();
		assertNotNull(quality);
		
		//ortofoto.setDisableClientCaching(false);
		//ortofoto.setInterpolation(ImageServiceParameters.INTERPOLATION_BILINEAR);
		
	}
	
}
