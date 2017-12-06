package spaceinvaders;
import java.awt.GraphicsConfiguration;
import java.awt.GraphicsEnvironment;
import java.awt.Transparency;
import java.awt.image.BufferedImage;
import java.util.HashMap;
import java.net.URL;
import java.lang.String;
import java.awt.Image;
import java.io.IOException;
import javax.imageio.ImageIO;

//import static com.sun.tools.internal.ws.wsdl.parser.Util.fail;

public class SpriteStore {
    private static SpriteStore single = new SpriteStore();
    public static SpriteStore get(){
        return single;
    }
    private HashMap sprites = new HashMap();

    public Sprite getSprite (String ref) {
        if (sprites.get(ref) != null) {
            return (Sprite) sprites.get(ref);
        }
        // otherwise , go away - grab from resource loader
        BufferedImage sourceImage = null;
        try {

            URL url = this.getClass().getClassLoader().getResource(ref);
            if (url == null) {
                fail("can't find ref: " + ref);
            }
            // use ImageIO to read the image in
            sourceImage = ImageIO.read(url);

        } catch (IOException e) {
            fail("Failed to load: " + ref);

        }
        // create an accelerated image of the right size to store our sprite in
        GraphicsConfiguration gc = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice().getDefaultConfiguration();
        Image image = gc.createCompatibleImage(sourceImage.getWidth(), sourceImage.getHeight(), Transparency.BITMASK);

        // draw our source image into the accelerated image
        image.getGraphics().drawImage(sourceImage,0,0,null);
        // create a sprite, add it the cache then return it
        Sprite sprite = new Sprite(image);
        sprites.put(ref,sprite);
        return sprite;
    }
        // handle resource loading failure
        // message to display on failure
        private void fail(String message){
            // dump the message and exit the game
            System.err.println(message);
            System.exit(0);
        }
}
