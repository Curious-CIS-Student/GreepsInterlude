import greenfoot.*;  // (World, Actor, GreenfootImage, and Greenfoot)

/**
 * A Greep is an alien creature that likes to collect tomatoes.
 * 
 * @author (your name here)
 * @version 0.1
 */
public class Greep extends Creature
{
    // Remember: you cannot extend the Greep's memory. So:
    // no additional fields (other than final fields) allowed in this class!
    
    /**
     * Default constructor for testing purposes.
     */
    public Greep()
    {
        this(null);
    }

    
    /**
     * Create a Greep with its home space ship.
     */
    public Greep(Ship ship)
    {
        super(ship);
    }
    

    /**
     * Do what a greep's gotta do.
     */
     public void act()
    {
        super.act();   // do not delete! leave as first statement in act().
        if (carryingTomato()) {
            setFlag(2, false); // We're not looking for a tomato anymore.
            if (atShip()) {
                dropTomato();
            }
            else { // Carrying tomato and not at ship.
                moveHome();
            }
        }
        else {
            if (atShip()) {
                setFlag(1, false); // We no longer need to tell others about the tomato pile we found.
            }
            // We're heading back home because we found a tomato. It doesn't matter
            //  whether we're near another tomato or not. We need to let everyone know
            //  about the tomato we found.
            if (getFlag(1)) {
                moveHome();
            }
            else if (nearTomato())
            {
                if (getFlag(2)) { // Following a trail.
                    if(randomChance(5)) {
                        move();
                    }
                }
                else { // We stumbled upon a tomato. Take the news to the ship!
                    setFlag(1, true);
                }
            }
            else { // Not near a tomato pile.
                if (seePaint("purple")) {
                    setFlag(2, true);
                    turnHome();
                    turn(180);
                }
                if (atWater() || atWorldEdge()) {
                    turn(45);
                }
                move();
                checkFood();
            }
        }
    }

    /**
     * Private method to move home. If we run into a wall, then we will turn aside.
     *  Otherwise, we will turn towards the ship.
     */
    private void moveHome() {
        if (atWater() || atWorldEdge()) {
            turn(45);
            move();
        }
        else { // No obstacles present.
            if (getFlag(1)) {
                spit("purple");
            }
            move();
            turnHome();
        }
    }
    
    /**
     * Private method to check if there is a tomato where we are.
     */
    private boolean nearTomato() {
        // check whether there's a tomato pile here
        TomatoPile tomatoes = (TomatoPile) getOneIntersectingObject(TomatoPile.class);
        if (tomatoes != null) {
            return true;
        }
        return false;
    }
    
    /**
     * Is there any food here where we are? If so, try to load some!
     */
    public void checkFood()
    {
        if (nearTomato()) {
            loadTomato();
            // Note: this attempts to load a tomato onto *another* Greep. It won't
            // do anything if we are alone here.
        }
    }


    /**
     * This method specifies the name of the author (for display on the result board).
     */
    public static String getAuthorName()
    {
        return "Isaac Blasiman";  // write your name here!
    }


    /**
     * This method specifies the image we want displayed at any time. (No need 
     * to change this for the competition.)
     */
    public String getCurrentImage()
    {
        if (carryingTomato())
            return "greep-with-food.png";
        else
            return "greep.png";
    }
}