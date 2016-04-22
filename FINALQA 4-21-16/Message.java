import greenfoot.*;

/**
 * Write a description of class Message here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Message extends Actor
{
     GreenfootImage imgMessage= new GreenfootImage(400,40);
    /**
     * Act - do whatever the Message wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public Message() {
        
    
      // if we include "java.awt." in the next line, we don't have to import the class
      //See http://www.greenfoot.org/topics/187
      imgMessage.setColor(java.awt.Color.red);
      imgMessage.fill();
      imgMessage.setColor(java.awt.Color.white);
      imgMessage.setFont(new java.awt.Font("Helvetica", java.awt.Font.PLAIN, 14));
      imgMessage.drawString("Sorry, incorrect answer.",20,20);
      imgMessage.setTransparency(200);
      
     // imgTxt.setFont(new java.awt.Font("Helvetica", java.awt.Font.PLAIN, 14));
      // Draw the text into the image that we are creating for the question object
     // imgTxt.drawString(s,1,15);
     
      //TextImage t=new TextImage(ans);
     setImage(imgMessage);      
        
    }
    public void act() 
    {
        // Add your action code here.
        imgMessage.setTransparency(imgMessage.getTransparency()-1);
        if (imgMessage.getTransparency()<20){
            getWorld().removeObject(this);
        }
    }    
}
