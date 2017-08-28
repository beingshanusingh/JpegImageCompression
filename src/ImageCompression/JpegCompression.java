package ImageCompression;
import java.awt.image.RenderedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import javax.imageio.*;
import javax.imageio.stream.ImageOutputStream;
import javax.imageio.stream.MemoryCacheImageOutputStream;


public class JpegCompression {

	public static void main(String[] args) {
		
		File originalImage= new File("C:\\Users\\Shanu Singh\\Desktop\\elonmusk.jpg");
		File compressedImage = new File("C:\\\\Users\\\\Shanu Singh\\\\Desktop\\\\Newelonmusk.jpg ");
		 try {
			 compressJPEGimage(originalImage, compressedImage, 0.25f);
			 System.out.println("Done");
		 }
		 catch(IOException e) {
			 
		 }

	}

	public static void compressJPEGimage(File originalImage, File compressedImage, float compressionQuality ) throws IOException{
		RenderedImage image= ImageIO.read(originalImage);
		
		ImageWriter jpegWriter = ImageIO.getImageWritersByFormatName("jpg").next();
		
		ImageWriteParam jpegWriteParam = jpegWriter.getDefaultWriteParam();
		
		jpegWriteParam.setCompressionMode(ImageWriteParam.MODE_EXPLICIT);
		
		jpegWriteParam.setCompressionQuality(compressionQuality);
		
		try(ImageOutputStream output = ImageIO.createImageOutputStream(compressedImage)){
			
			jpegWriter.setOutput(output);
			
			IIOImage outputImage = new IIOImage(image, null, null);
			
			jpegWriter.write(null, outputImage, jpegWriteParam);
			
		}
		jpegWriter.dispose();
		
		
	}
	
	
}
