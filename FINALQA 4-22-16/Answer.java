import greenfoot.*;

/**
 * Write a description of class Answer here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Answer extends Actor
{
    String ans;
    boolean isCorrect=false;
    int ansNum;

     public Answer(String txt){
        
      ans=txt;
      
      // First we create an image that will hold our largest answer, so that we can 
      // align all the text to the left.  
      GreenfootImage imgTxt= new GreenfootImage(300,30);
      // if we include "java.awt." in the next line, we don't have to import the class
      //See http://www.greenfoot.org/topics/187
      imgTxt.setColor(java.awt.Color.white);
      
      imgTxt.setFont(new java.awt.Font("Helvetica", java.awt.Font.PLAIN, 14));
      imgTxt.drawString(ans,1,15);
     
      //TextImage t=new TextImage(ans);
      setImage(imgTxt);   
        
    }  
    public Answer(String txt, int num, boolean correct){
          
        
    }
    /**
     * Act - do whatever the Answer wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        // Add your action code here.
        if (Greenfoot.mouseClicked(this)){
           if (isCorrect) {
               message("That's right.  Good Job");
            }
            else {
               message("Sorry, incorrect.  You need to study more");
            }
            // This could also be put in the message method, after the message is displayed
            // and disappears. Which makes more sense?
            ((Blackboard) getWorld()).loadQ();// curLine maintained in Blackboard
         } 
    }
    public void setCorrect(){
     isCorrect=true;
    }
    public int slen(){
        return ans.length();
    }
    
    public void message(String s) {
         Message m = new Message(s);
         getWorld().addObject(m,347,240);
        }
}
