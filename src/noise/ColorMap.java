package noise;

import java.awt.Color;

public class ColorMap {
	private Color[] colors;
	private enum Type{Scale, Map, Def};
	private Type type;
	public ColorMap(Color[] pointColors){
		type = Type.Def;
	}
	public ColorMap(double[] points, Color[] pointColors){
		type = Type.Map;
	}
	public ColorMap(Color c0, Color c1){
		type = Type.Scale;
		colors = new Color[2];
		colors[0] = c0;
		colors[1] = c1;
	}
	public Color getColor(double loc){
		loc = capD(loc);
		switch(type){
		case Def:
			return colors[(loc != 1) ? (int) (loc * colors.length) : colors.length - 1];
		case Map:
			return null;
		case Scale:
			double n, p;
			int[] c = new int[3];
			Color color = new Color(0);
			
			n = loc * colors[0].getRed();
			p = (1 - loc) * colors[1].getRed();
			c[0] = capI((int) (n + p));
			
			n = loc * colors[0].getGreen();
			p = (1 - loc) * colors[1].getGreen();
			c[1] = capI((int) (n + p));
			
			n = loc * colors[0].getBlue();
			p = (1 - loc) * colors[1].getBlue();
			c[2] = capI((int) (n + p));
			return new Color(c[0], c[1], c[2]);
		default:
			return Color.black;
		}
	}
	private double capD(double x){
		return (x < 0) ? 0 : (x > 1) ? 1 : x;
	}
	private int capI(int x){
		return (x < 0) ? 0 : (x > 255) ? 255 : x;
	}
}
