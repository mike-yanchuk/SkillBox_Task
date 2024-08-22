import org.imgscalr.Scalr;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;

public class ImageResizer implements Runnable{

    private File[] files;
    private int newWidth;
    private String dstFolder;
    private long start;
    private int i;
    public ImageResizer(File[] files, int newWidth, String dstFolder, long start, int i) {
        this.files = files;
        this.newWidth = newWidth;
        this.dstFolder = dstFolder;
        this.start = start;
        this.i = i;
    }

    @Override
    public void run() {
        try {
            for (File file : files) {
                BufferedImage image = ImageIO.read(file);
                if (image == null) {
                    continue;
                }
                int newHeight = (int) Math.round(image.getHeight() / (image.getWidth() / (double) newWidth));
                BufferedImage newImage = resize(image, newWidth, newHeight);
                File newFile = new File(dstFolder + "/" + file.getName());
                ImageIO.write(newImage, "jpg", newFile);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("Finish " + (i + 1)  + " " + (System.currentTimeMillis() - start) + " ms");
    }

    public static BufferedImage resize(BufferedImage src, int targetWidth, int targetHeight){
        return Scalr.resize(src, Scalr.Method.QUALITY, targetWidth, targetHeight);
    }
}
