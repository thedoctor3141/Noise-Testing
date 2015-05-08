package noise;
import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class ImageWriter {
    //just convinence methods for debug

    public static void greyWriteImage(double[][] data){
        //this takes and array of doubles between 0 and 1 and generates a grey scale image from them

        BufferedImage image = new BufferedImage(data.length,data[0].length, BufferedImage.TYPE_INT_RGB);

        for (int y = 0; y < data[0].length; y++)
        {
          for (int x = 0; x < data.length; x++)
          {
        	  data[x][y] = cap(data[x][y]);
              Color col=new Color((float)data[x][y],(float)data[x][y],(float)data[x][y]); 
            image.setRGB(x, y, col.getRGB());
          }
        }

        try {
            // retrieve image
            File outputfile = new File("noise.png");
            outputfile.createNewFile();

            ImageIO.write(image, "png", outputfile);
        } catch (IOException e) {
            //o no!
        }
    }
    public static void colorWriteImage(double[][] data, ColorMap map){
        //this takes and array of doubles between 0 and 1 and generates a grey scale image from them

        BufferedImage image = new BufferedImage(data.length,data[0].length, BufferedImage.TYPE_INT_RGB);

        for (int y = 0; y < data[0].length; y++)
        {
          for (int x = 0; x < data.length; x++)
          {
        	  data[x][y] = cap(data[x][y]);
              Color col= map.getColor(data[x][y]);
            image.setRGB(x, y, col.getRGB());
          }
        }

        try {
            // retrieve image
            File outputfile = new File("noise.png");
            outputfile.createNewFile();

            ImageIO.write(image, "png", outputfile);
        } catch (IOException e) {
            //o no!
        }
    }
    public static void colorWriteImage(double[][] data, Color color){
        //this takes and array of doubles between 0 and 1 and generates a grey scale image from them

        BufferedImage image = new BufferedImage(data.length,data[0].length, BufferedImage.TYPE_INT_RGB);

        for (int y = 0; y < data[0].length; y++)
        {
          for (int x = 0; x < data.length; x++)
          {
            data[x][y] = cap(data[x][y]);
              Color col=new Color(0f, 0f, (float) data[x][y]); 
            image.setRGB(x, y, col.getRGB());
          }
        }

        try {
            // retrieve image
            File outputfile = new File("noise.png");
            outputfile.createNewFile();

            ImageIO.write(image, "png", outputfile);
        } catch (IOException e) {
            //o no!
        }
    }
    private static double cap(double x){
    	return (x < 0) ? 0 : (x > 1) ? 1 : x;
    }
}