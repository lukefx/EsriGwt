package com.esri.gwt.client.geometry;

import com.google.gwt.core.client.JavaScriptObject;

/**
 *  A location defined by an X- and Y- coordinate. It can be map units or screen units.
 * @author lsimone
 *
 */
public class Point extends JavaScriptObject implements Geometry {

	protected Point () {  }
			
	public final native float getX() /*-{ return this.x; }-*/;
	public final native void setX(float x) /*-{ this.x = x; }-*/;
	public final native float getY() /*-{ return this.y; }-*/;
	public final native void setY(float y) /*-{ this.y = y; }-*/;
	
	public final native Point getOffset(float dx, float dy) /*-{ return this.offset(dx, dy) }-*/;
	public final native Point update(float dx, float dy) /*-{ return this.update(dx, dy) }-*/;

}
