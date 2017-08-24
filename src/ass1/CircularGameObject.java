/**
 * 
 */
package ass1;

import java.lang.reflect.Array;

import com.jogamp.opengl.GL2;

/**
 * @author z5020285 Pratulya Kashyap
 *
 */
public class CircularGameObject extends GameObject {

	/**
	 * @param parent
	 */
	private double radius;
	private double[] myFillColour;
	private double[] myLineColour;

	// Create a CircularGameObject with centre 0,0 and radius 1
	public CircularGameObject(GameObject parent, double[] fillColour, double[] lineColour) {
		super(parent);

		this.radius = 1;
		this.myFillColour = fillColour;
		this.myLineColour = lineColour;
	}

	// Create a CircularGameObject with centre 0,0 and a given radius
	public CircularGameObject(GameObject parent, double radius, double[] fillColour, double[] lineColour) {
		super(parent);

		this.radius = radius;
		this.myFillColour = fillColour;
		this.myLineColour = lineColour;
	}

	public double getRadius() {
		return radius;
	}

	public void setRadius(double radius) {
		this.radius = radius;
	}

	public double[] getMyFillColour() {
		return myFillColour;
	}

	public void setMyFillColour(double[] myFillColour) {
		this.myFillColour = myFillColour;
	}

	public double[] getMyLineColour() {
		return myLineColour;
	}

	public void setMyLineColour(double[] myLineColour) {
		this.myLineColour = myLineColour;
	}

	/**
	 * : Draw the CIRCLE
	 * 
	 * if the fill colour is non-null, fill the polygon with this colour if the
	 * line colour is non-null, draw the outline with this colour
	 * 
	 * @see ass1.GameObject#drawSelf(javax.media.opengl.GL2)
	 */
	@Override
	public void drawSelf(GL2 gl) {

		if (this.myFillColour != null) {
			gl.glPolygonMode(GL2.GL_FRONT_AND_BACK, GL2.GL_FILL);
			gl.glColor4d(this.myFillColour[0], this.myFillColour[1], this.myFillColour[2], this.myFillColour[3]);
			gl.glBegin(GL2.GL_POLYGON);
			for (int i = 0; i < Array.getLength(this.myPoints) - 1; i++) {
				gl.glVertex2d(this.myPoints.get(i)[0], this.myPoints.get(i)[1]);
			}
		}

		if (this.myLineColour != null) {
			gl.glPolygonMode(GL2.GL_FRONT_AND_BACK, GL2.GL_LINE);
			gl.glColor4d(this.myFillColour[0], this.myFillColour[1], this.myFillColour[2], this.myFillColour[3]);
			gl.glBegin(GL2.GL_POLYGON);
			for (int i = 0; i < Array.getLength(this.myPoints) - 1; i++) {
				gl.glVertex2d(this.myPoints.get(i)[0], this.myPoints.get(i)[1]);
			}
		}
	}
}
