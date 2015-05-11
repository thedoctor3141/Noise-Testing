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
	public static double[][] noise(int size, int steps) {
		double[][] noise = new double[size][size];
		double[][][] pointSet = pointSet(steps, size);
		int sx = 0, sy = 0, sx2 = 0, sy2 = 0, stepSize = size / steps;
		double[][] points = new double[4][3];
		for(int x = 0; x < size; x++){
			for(int y = 0; y < size; y++){
				sx = x / stepSize;
				sy = y / stepSize;
				sx2 = sx + 1;
				sy2 = sy + 1;
				for(int i = 0; i < 4; i++){
					for(int d = 0; d < 3; d++){
						switch(i){
						case 0:
							points[i][d] = pointSet[sx][sy][d];
							break;
						case 1:
							points[i][d] = pointSet[sx2][sy][d];
							break;
						case 2:
							points[i][d] = pointSet[sx][sy2][d];
							break;
						case 3:
							points[i][d] = pointSet[sx2][sy2][d];
							break;
						}
					}
				}
				noise[x][y] = noise(x, y, points, stepSize);
			}
		}
		return noise;
	}
	private static double[][][] pointSet(int steps, int size){
		int step = size / steps;
		double[][][] points = new double[steps+2][steps+2][3];
		double px = 0, py = 0;
		for(int x = 0; x < steps+2; x++){
			for(int y = 0; y < steps+2; y++){
				px = random.nextInt(step) + (x * step) ;
				py = random.nextInt(step) + (y * step) ;
				points[x][y][0] = px;
				points[x][y][1] = py;
				points[x][y][2] = random.nextDouble();
			}
		}
		return points;
	}
	public static double noise(int nx, int ny, double[][] points, int stepSize){
		double[] dists = new double[4];
		double dist = 0;
		double stepDist = 0;
		int sx = 0, sy = 0;
		double total = 0;
		double avgWeight = 0;
		for(int i = 0; i < 4; i++){
			dist = (Math.sqrt(sq(points[i][1] - ny) + sq(points[i][0] - nx)) + stepDist) * points[i][2] / stepSize;
			total += dist;
		}
		avgWeight = random.nextDouble() * total;
		for(int i = 0; i < 4; i++){
			if(avgWeight < dists[i]){
				avgWeight = points[i][2] - 0.9;
				break;
			}
		}
		return avgWeight;
	}
	private static double sq(double d){
		return d * d;
	}
	public static double[][] smooth(double[][] a, double[][] b, int size){
		double[][] c = new double[size][size];
		for(int x = 0; x < size; x++){
			for(int y = 0; y < size; y++){
				c[x][y] = (a[x][y] + b[x][y]) / 2;
			}
		}
		return c;
	}
}
