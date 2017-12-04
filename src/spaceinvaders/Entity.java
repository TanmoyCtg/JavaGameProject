package spaceinvaders;

import java.awt.*;

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
    /*
    * set the vertical speed of this entity
    * The vertical speed of this entity (pixels/ sec
    * */
    public void setVerticalMovement(double dy){
        this.dy = dy;
    }
/*
* Get the horizontal speed of this entity
* return horizontal speed dx of this entity(pixels/sec)
* */
    public double getHorizontalMovement(){
        return dx;
    }
    /*
    * Get the vertical speed of this entity
    * return dy vertical entity(pixels/sec)
    * */
    public double getVerticalMovement(){
        return dy;
    }
    public void draw(Graphics g){
        sprite.draw(g,(int) x,(int) y);
    }












}
