package unittests;

import org.junit.Test;
import renderer.ImageWriter;

import java.awt.*;

public class ImageWriterTest {
    @Test
    /**
     * crate image with grid line by yellow stripes, the test run over the pixels in the file and write the color to every pixel.
     */
    public void imageWriterTest() {
        ImageWriter gridPicture = new ImageWriter("gridPicture", 1000, 1600, 500, 800);
        for (int i = 0; i < gridPicture.getNy(); i++) {
            for (int j = 0; j < gridPicture.getNx(); j++) {
                if (i % 50 == 0 || j % 50 == 0) {//if the correct pixel is divide by 50 paint it yellow to crate a grid
                    gridPicture.writePixel(j, i, Color.YELLOW);
                } else gridPicture.writePixel(j, i, Color.CYAN); //the background of the rest picture is blue
            }
        }
        gridPicture.writeToImage();

    }


}
