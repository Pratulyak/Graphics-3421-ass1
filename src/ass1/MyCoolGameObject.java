package ass1;

import java.util.Arrays;

public class MyCoolGameObject extends GameObject {

	public MyCoolGameObject() {
		super(GameObject.ROOT);
		
		double points[][] = { { 0, 0 }, { 1, 1 }, { 0, 1 }, { -1, 1 }, { -1, -1 }, { 1, -1 } };
		double lineColour[] = { 1, 1, 1, 1 };
		double fillColour[] = { 0, 1, 0, 0 };
		double fillColourB[] = { 1, 0, 0, 0 };
		double lineColourC[] = { 1, 0.2, 1, 0 };
		
		PolygonalGameObject a = new PolygonalGameObject(GameObject.ROOT, Arrays.asList(points), fillColour, lineColour);
		CircularGameObject b = new CircularGameObject(GameObject.ROOT, 1, fillColourB, lineColour);
		LineGameObject c = new LineGameObject(GameObject.ROOT, 1, 1, 1, 2, lineColourC);
		LineGameObject d = new LineGameObject(GameObject.ROOT, 1, -1, 1, -2, lineColourC);

		a.setScale(0.25);
			
		b.setScale(0.125);
		b.setParent(a);

	
		c.setScale(0.25);
		c.setParent(a);

		
		d.setScale(0.25);
		d.setParent(a);

	}

}
