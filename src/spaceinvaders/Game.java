package spaceinvaders;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.BufferStrategy;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
public class Game extends Canvas{
    /** The stragey that allows us to use accelerate page flipping */
    private BufferStrategy strategy;
    /** True if the game is currently "running", i.e. the game loop is looping */
    private boolean gameRunning = true;
    /** The list of all the entities that exist in our game */
    private ArrayList entities = new ArrayList();
    /** The list of entities that need to be removed from the game this loop */
    private ArrayList removeList = new ArrayList();
    /** The entity representing the player */
    private Entity ship;
    /** The speed at which the player's ship should move (pixels/sec) */
    private double moveSpeed = 300;
    /** The time at which last fired a shot */
    private long lastFire = 0;
    /** The interval between our players shot (ms) */
    private long firingInterval = 500;
    /** The number of aliens left on the screen */
    private int alienCount;

    /** The message to display which waiting for a key press */
    private String message = "";
    /** True if we're holding up game play until a key has been pressed */
    private boolean waitingForKeyPress = true;
    /** True if the left cursor key is currently pressed */
    private boolean leftPressed = false;
    /** True if the right cursor key is currently pressed */
    private boolean rightPressed = false;
    /** True if we are firing */
    private boolean firePressed = false;
    /** True if game logic needs to be applied this loop, normally as a result of a game event */
    private boolean logicRequiredThisLoop = false;

    /**
     * Construct our game and set it running.
     */
    public Game() {
        // create a frame to contain our game
        JFrame container = new JFrame("Space Invaders 101");

        // get hold the content of the frame and set up the resolution of the game
        JPanel panel = (JPanel) container.getContentPane();
        panel.setPreferredSize(new Dimension(800,600));
        panel.setLayout(null);

        // setup our canvas size and put it into the content of the frame
        setBounds(0,0,800,600);
        panel.add(this);

        // Tell AWT not to bother repainting our canvas since we're
        // going to do that our self in accelerated mode
        setIgnoreRepaint(true);

        // finally make the window visible
        container.pack();
        container.setResizable(false);
        container.setVisible(true);

        // add a listener to respond to the user closing the window. If they
        // do we'd like to exit the game
        container.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });

        // add a key input system (defined below) to our canvas
        // so we can respond to key pressed
        addKeyListener(new KeyInputHandler());

        // request the focus so key events come to us
        requestFocus();

        // create the buffering strategy which will allow AWT
        // to manage our accelerated graphics
        createBufferStrategy(2);
        strategy = getBufferStrategy();

        // initialise the entities in our game so there's something
        // to see at startup
        initEntities();
    } // Game constructor end here

    /**
     * Start a fresh game, this should clear out any old data and
     * create a new set.
     */
    private void startGame() {
        // clear out any existing entities and intialise a new set
        entities.clear();
        initEntities();

        // blank out any keyboard settings we might currently have
        leftPressed = false;
        rightPressed = false;
        firePressed = false;
    }
    private void initEntities(){
        // create the player ship and place it in the center of the screen
       // ship = new ShipEntity();
        entities.add(ship);
        // create a block of aliens(5 rows,by 12 aliens, spaced evenly)
        alienCount =  0;
        for (int row=0;row<5;row++ ){
            for(int x = 0;x<12;x++){
                //Entity alien = new AlienEntity();
                //entities.add(alien);
                alienCount++;
            }
        }

    }
//
    public void updateLogic(){
      logicRequiredThisLoop=true;
    }
    // Remove an entity from the game.
    public void removeEntity(Entity entity){
        removeList.add(entity);
    }

    // notify the player died
    public void notifyDeath(){
        message = "Oh no! They got you, try again?";
        waitingForKeyPress = true;
    }
    // Notification that the player has won since all the aliens
    public void notifyWin(){
        message = "Well done! You win!";
        waitingForKeyPress = true;
    }
    // Notification that an alien has been killed
    public void notifyAlienKilled(){
        //reduce the alien count, if there are none left, player won
        alienCount--;
        if (alienCount == 0){
            notifyWin();
        }
        // if there are aliens like little
        //we increase aliens speed
        for (int i=0; i<entities.size();i++){
            Entity entity = (Entity) entities.get(i);
            if (entity instanceof AlienEntity){
                //speed up by 2%
                entity.setHorizontalMovement(entity.getHorizontalMovement() * 1.02);
            }
        }
    }
    /**
     * Attempt to fire a shot from the player. Its called "try"
     * since we must first check that the player can fire at this
     * point, i.e. has he/she waited long enough between shots
     */
    public void tryToFire(){
        //check that we have waiting long enough to fire
        if (System.currentTimeMillis() - lastFire < firingInterval){
            return;
        }
        // if player waited long, creat the shot entity and record the time
        lastFire = System.currentTimeMillis();
        ShotEntity shot = new ShotEntity(this,"sprites/shot.gif",ship.getX()+10,ship.getY()=30);
        entities.add(shot);
    }
    /**
     * The main game loop. This loop is running during all game
     * play as is responsible for the following activities:
     * <p>
     * - Working out the speed of the game loop to update moves
     * - Moving the game entities
     * - Drawing the screen contents (entities, text)
     * - Updating game events
     * - Checking Input
     * <p>
     */
    public void gameLoop(){
        long lastLoopTime =System.currentTimeMillis();
        // keep looping round untill the game ends
        while(gameRunning){

        }
    }

    /*
    * KeyInputHandler class is a private class. We create this class to handle the keyboard input.
    * left, right,shoot when game is on.
    * start button can be anything
    * This class is inner class of Game class
    * */
    private class KeyInputHandler extends KeyAdapter{
        private int pressCount = 1;
        /*
        * KeyTyped() comes in
        * */
        public void KeyPressed(KeyEvent e){
            if (waitingForKeyPress){
                return;
            }
            if (e.getKeyCode() == KeyEvent.VK_LEFT){
                leftPressed = true;
            }
            if (e.getKeyCode() == KeyEvent.VK_RIGHT){
                rightPressed = true;
            }
            if (e.getKeyCode() == KeyEvent.VK_SPACE){
                firePressed = true;
            }
        }

        public void keyReleased(KeyEvent e){
            if(waitingForKeyPress){return;}
            if (e.getKeyCode() == KeyEvent.VK_LEFT){
                leftPressed = false;
            }
            if (e.getKeyCode() == KeyEvent.VK_RIGHT){
                rightPressed = false;
            }
            if (e.getKeyCode() == KeyEvent.VK_SPACE){
                firePressed = false;
            }
        }
        public void keyTyped(KeyEvent e){
            // if we're waiting for a "any key" type then

            if (waitingForKeyPress){
                if (pressCount == 1){
                    waitingForKeyPress = false;
                    startGame();
                    pressCount = 0;
                }
                else {
                    pressCount++;
                }
            }
            if(e.getKeyChar() == 27){
                System.exit(0);
            }
        }
    }

    public static void main(String argv[]) {
        Game g =new Game();

        // Start the main game loop, note: this method will not
        // return until the game has finished running. Hence we are
        // using the actual main thread to run the game.
        //g.gameLoop();
    }
}

