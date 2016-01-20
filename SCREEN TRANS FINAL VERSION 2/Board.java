import greenfoot.*;

/**
 * Write a description of class Board here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Board extends World
{
    /**
     * Constructor for objects of class Board.
     * 
     */
    public Board()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(238, 386, 1); 
        prepare();
    }
    private void prepare()
    {
        titlescreen t1 = new titlescreen();
        addObject(t1, 125, 183);
    }
}
