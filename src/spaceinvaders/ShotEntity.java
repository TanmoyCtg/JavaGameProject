package spaceinvaders;
// this entity fired the aliens
// this is a player ship and its shoots the fire.
public class ShotEntity extends Entity {
    // vertical speed player moves the ship
    private double moveSpeed = -300;
    private Game game;
    private boolean used = false;

    /**
     * Create a new shot from the player
     *
     * @param game   The game in which the shot has been created
     * @param sprite The sprite representing this shot
     * @param x      The initial x location of the shot
     * @param y      The initial y location of the shot
     */

    public ShotEntity(Game game, String sprite, int x, int y) {
        super(sprite, x, y);
        this.game = game;
        dy = moveSpeed;

    }

    // shot move based on time elapsed
    // delta the time that elapsed since last move
    public void move(long delta) {
        //proceed with normal curve
        super.move(delta);
        // if shoot off the screen, remove ourselfs
        if (y < -100) {
            game.removeEntity(this);
        }
    }

    /**
     * Notification that this shot has collided with another
     * entity
     *
     * @parma other The other entity with which we've collided
     */
    public void collidedWith(Entity other) {
        // prevents double kills, if we've already hit something
        // don't collide
        if (used) {
            return;
        }
        // hit alien,kill it
        if (other instanceof AlienEntity) {
            game.removeEntity(this);
            game.removeEntity(other);
            // notify the game that the alien has been killed
            game.notifyAlienKilled();
            used = true;
        }
    }
}


