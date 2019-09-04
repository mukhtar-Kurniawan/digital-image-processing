import java.io.File;
import java.io.IOException;
import java.awt.image.BufferedImage;
import java.awt.Color;
import javax.imageio.ImageIO;

public class image_negative{
  public static void main(String args[])throws IOException{
    BufferedImage img = null;
    File f = null;
   
    //read image, in this case, 
    //you put that in the same directory
    try{
      f = new File("flower.jpeg");
      img = ImageIO.read(f);
    }catch(IOException e){
      System.out.println(e);
    }
   
    //get image width and height
    int width = img.getWidth();
    int height = img.getHeight();

    //convert to negative
    
    for(int i=0; i<width; i++){
      for(int j=0; j<height; j++){
   
         int pixel[] = img.getRaster().getPixel(i, j, new int[3]);
         //get the gamma corrected value
         int r = 255 - pixel[0];
         int g = 255 - pixel[1];
         int b = 255 - pixel[2];
   
         Color color = new Color(r, g, b);
   
         int rgb = color.getRGB();
   
         img.setRGB(i, j, rgb);
      }
    }

    //write image
    try{
      f = new File("negative.jpg");
      ImageIO.write(img, "jpg", f);
    }catch(IOException e){
      System.out.println(e);
    }
  }
}