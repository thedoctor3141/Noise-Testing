package noise;

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
		double[][] n1 = Noise.turb(1000, 5, 0.001, 2);
		ImageWriter.greyWriteImage(n1);
		System.out.println("finished!");
	}

}
