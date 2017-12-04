package spaceinvaders;

import java.awt.Rectangle;

public abstract class Entity {
    protected  double x;
    protected double y;
    protected Sprite sprite;
    protected double dx;
    protected double dy;
    private Rectangle me = new Rectangle();
    private Rectangle him = new Rectangle();

    public Entity(String ref,int x,int y){
        this.sprite = SpriteStore.get().getSprite(ref);
        this.x = x;
        this.y = y;
    }
    public void move(long delta){
        x+=(delta * dx) /1000;
        y += (delta * dy) /1000;
    }

    public void setHorizontalMovement(double dx){
        this.dx = dx;
    }















}
