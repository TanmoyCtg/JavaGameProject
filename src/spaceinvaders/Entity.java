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
/*
* we Draw this entity to the graphics context provided
* @param g is Graphics class object. g object draw the sprite
* */
   public void doLogic(){

   }
   /*
   * Get the x location of this entity
   * return x - int
   * */
   public int getX(){return (int) x;}

   public int getY() {return (int) y;}

    /**
     * Check if this entity collised with another.
     *
     * @param other The other entity to check collision against
     * @return True if the entities collide with each other
     */
    public boolean collidesWith(Entity other){
        me.setBounds((int) x, (int) y, sprite.getWidth(),sprite.getHeight());
        him.setBounds((int) other.x, (int) other.y,other.sprite.getWidth(),other.sprite.getHeight());
        return me.intersects(him);
    }

/**
 * Notification that this entity collided with another.
 *
 * @param other The entity with which this entity collided.
 */
// abstract methos
    public abstract void collidedWith(Entity other);

}
