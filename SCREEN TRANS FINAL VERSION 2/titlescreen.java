import greenfoot.*;

/**
 * Write a description of class Letter here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class titlescreen extends Actor
{
    GreenfootImage imgSelected;
    GreenfootImage imgNormal;
    GreenfootImage imgQuestion;
    boolean letterSelected=false;
    public titlescreen (){
        imgNormal= new GreenfootImage("Titlescreen(press anywhere to start).png");
        imgSelected= new GreenfootImage("Selection.png");
        setImage(imgNormal);
    }
     public titlescreen (String L){
        imgNormal= new GreenfootImage("Titlescreen(press anywhere to start).png");
        imgNormal.drawString(L,imgNormal.getWidth()/4,imgNormal.getHeight()/2);
        imgSelected= new GreenfootImage("Selection.png");
        imgSelected.drawString(L,imgSelected.getWidth()/2,imgSelected.getHeight()/2);
        setImage(imgNormal);
    }
    /**
     * Act - do whatever the Letter wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
   
    public void act() 
    {
        // Add your action code here.
        if (Greenfoot.mouseClicked(this)){
            if (letterSelected){
                setImage(imgNormal);
                letterSelected=false;
            }
            else {
                setImage(imgSelected);
                letterSelected=true;     
            }
        }
    }    
}
