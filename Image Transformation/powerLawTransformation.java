import java.io.File;
import java.io.IOException;
import java.awt.image.BufferedImage;
import java.awt.Color;
import javax.imageio.ImageIO;

public class powerLawTransformation{
  public static void main(String args[])throws IOException{
    BufferedImage img = null;
    File f = null;

    //you can setting the value of c and gamma
    float c=50;
    double gamma=0.6;

    //read image, in this case, 
    //you put that in the same directory
    try{
      f = new File("desktop.jpg");
      img = ImageIO.read(f);
    }catch(IOException e){
      System.out.println(e);
    }
    
    //get image width and height
    int width = img.getWidth();
    int height = img.getHeight();
    
    //convert to gamma transformation
    for(int i=0; i<width; i++){
      for(int j=0; j<height; j++){
   
         int pixel[] = img.getRaster().getPixel(i, j, new int[3]);
         //get the gamma corrected value
         int k = (int) (c*(Math.pow((double)pixel[0]/(double)255, gamma)));
   
         Color color = new Color(k, k, k);
   
         int rgb = color.getRGB();
   
         img.setRGB(i, j, rgb);
      }
    }
    
    //write image
    try{
      f = new File("gamma.jpg");
      ImageIO.write(img, "jpg", f);
    }catch(IOException e){
      System.out.println(e);
    }
  }
}


