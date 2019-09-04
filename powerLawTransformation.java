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
    float c=100;
    double gamma=1;

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
    
    //convert to gamma transformation
    for(int i=0; i<width; i++){
      for(int j=0; j<height; j++){
   
         int pixel[] = img.getRaster().getPixel(i, j, new int[3]);
         //get the gamma corrected value
         int r = (int) (c*(Math.pow((double)pixel[0]/(double)255, gamma)));
         int g = (int) (c*(Math.pow((double)pixel[1]/(double)255, gamma)));
         int b = (int) (c*(Math.pow((double)pixel[2]/(double)255, gamma)));
   
         Color color = new Color(r, g, b);
   
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


