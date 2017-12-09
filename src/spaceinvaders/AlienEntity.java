package spaceinvaders;
// it's a game entity alien entity
// it's a enemy of our game.
public class AlienEntity extends Entity{
    // alien speed - this is for alien moves horizontally
    private double moveSpeed = 75;
    // our Game class where entity exists
    private Game game;
    // this create a new alien entity
    //@param game create this entity
    //@param ref the sprite which is diplayed in the screen
    //@param x - horizontal
    //@param y - vertical
    public AlienEntity(Game game, String ref, int x, int y){
        super (ref,x,y);
        this.game = game;
        dx= - moveSpeed;
    }
    /**
     * aliens moved based on time elapsed
     * @param delta the time that has elapsed since last move
     *
     */
    public void move(long delta){
        // if we have reached the left hand side of the screen
        // and moving right, then we need to request a logic update

        if ((dx < 0 ) && (x < 10)){
            game.updateLogic();
        }
        // and if we reach the right screen and we need to left then dx positive
        // we need logic update also
        if ((dx > 0) && (x > 750)){
            game.updateLogic();
        }
        // proceed with normal move
        super.move(delta);
    }
    public void doLogic(){
        // swap over horizontal movement and move down the screen a bit
        dx = -dx;
        y += 10;
        // if alien reached the bottom of the screen then the player dies
        if (y > 570){ game.notifyDeath();}
    }
    //@param other means other entity
    public void collidedWith(Entity other){
        // collisions with aliens are handled elsewhere
    }









































}
