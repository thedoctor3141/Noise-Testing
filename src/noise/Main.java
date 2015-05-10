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
		int size = 128, feature = 64;
		double[][] n1 = Noise.noise(size, 8);
		double[][] n2 = Noise.noise(size, 4);
		double[][] n3 = Noise.noise(size, 16);
		double[][] n4 = Noise.noise(size, 32);
		n1 = Noise.smooth(n1, n2, size);
		n2 = Noise.smooth(n3, n4, size);
		n3 = Noise.smooth(n1, n2, size);
		ImageWriter.greyWriteImage(n3);
		System.out.println("finished!");
	}

}
