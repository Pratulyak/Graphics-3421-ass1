package ass1;

import java.util.ArrayList;
import java.util.List;

import com.jogamp.opengl.GL2;

public class LineGameObject extends GameObject {
	private List<double[]> myPoints;
	private double[] lineColour;

	// Create a LineGameObject from (0,0) to (1,0)
	public LineGameObject(GameObject parent, double[] lineColour) {
		super(parent);

		double[] point = new double[2];
		point[0] = 0;
		point[1] = 0.0;
		double[] point2 = new double[2];
		point2[0] = 1.0;
		point2[1] = 0.0;
		this.myPoints = new ArrayList<double[]>();
		this.myPoints.add(point);
		this.myPoints.add(point2);

		this.lineColour = lineColour;
	}

	// Create a LineGameObject from (x1,y1) to (x2,y2)
	public LineGameObject(GameObject parent, double x1, double y1, double x2, double y2, double[] lineColour) {
		super(parent);
		System.out.println("x1= "+x1+" x2= " + x2 +" y2= " +y1+" y2 ="+y2);
		double[] point = new double[2];
		point[0] = x1; 
		point[1] = y1;
		double[] point2 = new double[2];
		point2[0] = x2;
		point2[1] = y2;
		this.myPoints = new ArrayList<double[]>();
		this.myPoints.add(point);
		this.myPoints.add(point2);

		this.lineColour = lineColour;
	}

	public List<double[]> getMyPoints() {
		return myPoints;
	}

	public void setMyPoints(List<double[]> myPoints) {
		this.myPoints = myPoints;
	}

	public double[] getLineColour() {
		return lineColour;
	}

	public void setLineColour(double[] lineColour) {
		this.lineColour = lineColour;
	}

	/**
	 * TODO: Draw the polygon
	 * 
	 * if the fill colour is non-null, fill the polygon with this colour if the
	 * line colour is non-null, draw the outline with this colour
	 * 
	 * @see ass1.GameObject#drawSelf(javax.media.opengl.GL2)
	 */
	@Override
	public void drawSelf(GL2 gl) {
		if (this.lineColour != null) {
			gl.glPolygonMode(GL2.GL_FRONT_AND_BACK, GL2.GL_LINE);
			gl.glColor4d(this.lineColour[0], this.lineColour[1], this.lineColour[2], this.lineColour[3]);
			gl.glBegin(GL2.GL_LINES);
			for (int i = 0; i < this.myPoints.size(); i++) {
				gl.glVertex2d(this.myPoints.get(i)[0], this.myPoints.get(i)[1]);
			}
			gl.glEnd();
		}
		gl.glPolygonMode(GL2.GL_FRONT_AND_BACK, GL2.GL_FILL);
	}

}
