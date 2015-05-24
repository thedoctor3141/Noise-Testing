package noise;

import java.util.Random;

public class Noise {

	private static Random random = new Random();
	private static OpenSimplexNoise noise = new OpenSimplexNoise();
	public static double[][] turb(int size, double feature)
	{
		double[][] nn = new double[size][size];
		for(int x = 0; x < size; x++){
			for(int y = 0; y < size; y++){
				nn[x][y] = noise.eval(x / feature, y / feature);
			}
		}
		return nn;
	}
	
}
