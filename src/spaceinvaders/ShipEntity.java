package spaceinvaders;

// the entity represents the players ship
public class ShipEntity extends Entity {
    // the game in which the ship exists
    private Game game;

    public ShipEntity(Game game,String ref,int x, int y){
        super (ref,x,y);
        this.game = game;
    }
    public void move(long delta){
        if ((dx < 0) && (x < 10)){
            return;
        }
        if ((dx > 0) && (x > 755)){
            return;
        }
        super.move(delta);
    }
    public void collidedWith(Entity other){
        if (other instanceof  AlienEntity){
            game.notifyDeath();
        }
    }
}
