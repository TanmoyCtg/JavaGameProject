package spaceinvaders;

import java.awt.image.BufferedImage;
import java.util.HashMap;

public class SpriteStore {
    private static SpriteStore single = new SpriteStore();
    public static SpriteStore get(){
        return single;
    }
    private HashMap sprites = new HashMap();
    public Sprite getSprite (String ref){
        if (sprites.get(ref) != null){
            return (Sprite) sprites.get(ref);
        }
        // otherwise , go away - grab from resource loader
        BufferedImage sourceImage = null;
        try{
            
        }

    }
}
