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
		int size = 128, feature = 128;
		double[][] n1 = Noise.turb(size, 24);
		ImageWriter.greyWriteImage(n1);
		System.out.println("finished!");
	}

}
