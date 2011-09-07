# Esri GWT

GWT wrapper for ESRI JS API

````java
public class EsriGwtWeb implements EntryPoint {
	
	private MapWidget map;
	
	public void onModuleLoad() {
		
		Button panLeft = new Button("Pan Left");
		panLeft.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				map.panLeft();
			}
		});
		
		RootPanel.get().add(panLeft);

		Button panRight = new Button("Pan Left");
		panRight.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				map.panRight();
			}
		});
		
		RootPanel.get().add(panRight);
		
		map = new MapWidget("mapDiv");
		map.addLayer(new ArcGISTiledMapServiceLayer("http://server.arcgisonline.com/ArcGIS/rest/services/ESRI_Imagery_World_2D/MapServer"));
		
		map.addClickHandler(new MapClickHandler() {
			public void handleClickEvent(Point event) {

				QueryTask task = new QueryTask("http://sampleserver1.arcgisonline.com/ArcGIS/rest/services/Demographics/ESRI_Census_USA/MapServer/5");
				Query query = new Query();
				query.setGeometry(event.getMapPoint());

				task.execute(query, new QueryCallback() {
					
					@Override
					public void onSuccess(FeatureSet featureSet) {
						RootPanel.get("keygis").clear();						
						RootPanel.get("keygis").add(new HTML(featureSet.getFeatures().get(0).getAttributes().get("STATE_NAME")));
					}
					
					@Override
					public void onFailure(Throwable caught) {
						GWT.log("Error on Query!", caught);
					}
				});
			}
		});
		
		map.addExtentHandler(new MapExtentHandler() {
			@Override
			public void onExtentChange(Extent extent, Point point, boolean levelChange, LOD lod) {
				GWT.log("Extent changed " + extent , null);
			}
		});
		
		map.addPanHandler(new MapPanHandler() {
			public void handlePanEvent(Point event) {
				GWT.log("You pan my map!", null);
			}

			public void handleStartPanEvent(Point event) {
				GWT.log("You start the pan on my map!", null);				
			}

			public void handleEndPanEvent(Point event) {
				GWT.log("You stop the pan on my map!", null);				
			}
		});
		
	}
} 
````
