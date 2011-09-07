package com.esri.gwt.client.symbol;

import com.esri.gwt.client.graphic.Color;

public abstract class Symbol {

	public Color color;
	public String type;
		
	public void setColor(Color color) {
		this.color = color;
	}
	
	public Color getColor() {
		return this.color;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	
}
