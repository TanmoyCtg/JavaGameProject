# JavaGameProject
I built this project for my school project. It's a Shooting game. 
Me and My friend built this project. In future, we try our best to make this for Android application.

In this project we create 7 classes. classes name
<ol>
  <li>Game.java</li>
  <li>ShotEntity.java</li>
  <li>AlienEntity.java</li>
  <li>ShipEntity.java</li>
  <li>Entity.java</li>
  <li>Sprite.java</li>
  <li>SpriteStore.java</li>
</ol>
<h1>Game.java</h1> </br>
Inside this class we also use another private class<br/>
KeyInputHandler which extends KeyAdapter class

1. main() live here.

2. Game class extends Canvas class

3. Game() - constructor

Module 
<ol>
    startGame()<br>
    initEntities()<br>
    updateLogic()<br>
    removeEntity()<br>
    notifyDeath()<br>
    notifyWin()<br>
    notifyAlienKilled()<br>
    tryToFire()<br>
    gameLoop()
</ol>
Inside KeyInputHandler class we use module:
<ol>
  <li>keyPressed()</li>
  <li>keyReleased()</li>
  <li>keyTyped()</li>
 </ol>
<h3>Game class variable</h3>
<ul>
  <li> - BufferStrategy strategy</li>
  <li> - boolena gameRuning </li>
  <li> - ArrayList entities - list of all entities </li>
  
  <li>- ArrayList removeList - we need to remove list of entities from game loop</li>
  <li>- Entity ship - Entity class represent the player- ship means actually player who fires or kill the alien</li>
  <li>- double moveSpeed - ship move (pix/sec) </li>
  
  <li> - long lastFire </li>
  <li>- long firingInterval - interval which is milisec players shot.</li>
  <li>-int alienCount - after shot how many alien left we need to count </li>
  
  
  <li>- String message - display a message to player press the key.</li>
  <li>- boolean waitingForKeyPress - </li>
  <li> - boolean leftPressed - it can be true or false </li>
  
  <li> - boolean rightPressed - false </li>
  <li> - boolean firePressed - when player starts firing.</li>
  <li> - boolean logicRequiredThisLoop</li>
  
</ul>

<h2> Public Game() constructor </h2>
<strong>How we make Game constructor</strong>
<article>
  <p> 
    we create frame to contain our game. How? Using JFrame. We import javax.swing.JFrame. Then we give a title our Frame. JFrame()
    constructor takes our string frame title. We need to hold the content of the frame and we need resolution of the game. That's why
    we need JPanel. JPanel provide that for us. We need to import javax.swing.JPanel we declared panel object and then set our frame         width and height. That's why we need to use <b>setPreferredSize(width, height)</b>. we make our setLayout(null).
   
    Next we setup our canvas size and put it into content of the frame.
    we setBounds(x,y,width,height) 
    add this to the panel. always use add() else nothing happened.
    Now we need to make our window visible. That's why we need to use container object again
    container.pack()
    <b>what .pack() do</b>
    <strong>Pack is calling setSize.Pack() function gives the charge of frame layout manager to set frame size.pack() pack the components closely together.</strong>
    setVisible () - function takes a boolean argument.if it's true then window is visible.
  
  </p>

</article>





