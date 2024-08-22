import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.image.BufferedImageOp;
import java.io.File;

public class Main {

    private static int newWidth = 300;

    public static void main(String[] args) {

        String srcFolder = "C:/Users/User1/Desktop/картинки";
        String dstFolder = "C:/Users/User1/Desktop/парсинг";

        File srcDir = new File(srcFolder);
        long start = System.currentTimeMillis();

        File[] files = srcDir.listFiles();
        int countCores = Runtime.getRuntime().availableProcessors();
        System.out.println("Количество доступных ядер: " + countCores);
        int part = files.length / countCores;

        for (int i = 0; i < countCores; i++) {
            int integer = i == countCores - 1 ? files.length - (part * i) : part;
            File[] filesNew = new File[integer];
            System.arraycopy(files, part * i, filesNew, 0, integer);
            ImageResizer resizer = new ImageResizer(filesNew, newWidth, dstFolder, start, i);
            new Thread(resizer).start();
        }

    }

}