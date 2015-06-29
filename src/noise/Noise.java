package noise;

import java.util.Random;

public class Noise {

	private static Random random = new Random();
	private static OpenSimplexNoise simplex = new OpenSimplexNoise();
	public static double[][] turb(int size, int octaves, double startFrequence, double persistence)
	{
		double amplitude = 1, frequence = startFrequence, noise = 0, normalizeFactor = 0;;
		double[][] nn = new double[size][size];
		for(int x = 0; x < size; x++){
			for(int y = 0; y < size; y++){
				
				amplitude = 10000;
				noise = 0;
				normalizeFactor = 0;
				frequence = startFrequence;
				for(int i = 0; i <= octaves; i++){
					normalizeFactor += amplitude;
					noise += amplitude * simplex.eval((x) / frequence / size, (y) / frequence / size);
					amplitude *= persistence;
					frequence *= 2;
				}
				double n = noise / normalizeFactor;
				nn[x][y] = n;
			}
		}
		return nn;
	}
}
