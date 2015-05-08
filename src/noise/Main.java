package noise;

import java.awt.Color;
import java.util.Random;


public class Main {
	private static Random random = new Random();
	public static void main(String[] args) {
		//double[][] noiseA = Noise.noise(2000, 10);
		//double[][] noiseB = Noise.noise(64, 32);
		//double[][] noiseC = Noise.smooth(noiseA, noiseB, 200);
		//ImageWriter.greyWriteImage(noiseB);
		//ColorMap map = new ColorMap(Color.yellow, new Color(117, 63, 9));
		OpenSimplexNoise noise = new OpenSimplexNoise();
		double size = 1000, feature = 64;
		double[][] nn = new double[(int) size][(int) size];
		for(int x = 0; x < size; x++){
			for(int y = 0; y < size; y++){
				double n = noise.eval(x / feature, y / feature, 0.5);
				double d = Math.abs(n - 0.5) / 4;
				double o = (random.nextDouble() * d * 2) - d;
				n += (n + o > 1) ? 0 : (n - o < 0) ? 0 : o;
				n = (n == 1) ? n - o : (n == 0) ? n + o : n;
				nn[x][y] = (n > 1) ? 1 - o : (n < 0) ? 0 + o : n;
			}
		}
		ImageWriter.greyWriteImage(nn);
		System.out.println("finished!");
	}

}
