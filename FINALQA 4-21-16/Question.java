import greenfoot.*;

/**
 * Write a description of class Text here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Question extends Actor
{
    // instance variables 
    // See https://docs.oracle.com/javase/tutorial/java/javaOO/classvars.html
    // for a discussion of instance variables and class variables
    
    String question;
    Answer[] ans = new Answer[5];
    int correctAnswer;
    private boolean addAns=true;
    
    
     public Question(String q){
       question=q;
       stringToImage(q);
    }
    public Question(String q, 
                    String a0,String a1,String a2,String a3, 
                    int correctA){
      
      // Create an image using the text for this question
      question=q;
      stringToImage(q);
      // First we create an image that will hold our largest question, so that we can 
      // align all the text to the left.  
      
      
      // Create each answer using a constructor that accepts a string representing the ans.
      //World w=getWorld();
      
      ans[0]=new Answer(a0);
      ans[1]=new Answer(a1);
      ans[2]=new Answer(a2);
      ans[3]=new Answer(a3);
      
      // CorrectAnswer points to the element in the array that is the right answer.  
      // By convention, the constructor sets the boolean isCorrect to false.
      
      ans[correctAnswer].setCorrect();  // set this ans to correct
       
      
    }  
    
      
    
    
       /**
     * Act - do whatever the Text wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    
    public void act() 
    {
        // Add your action code here.
        if (addAns){
         addAnswers();
         addAns=false;
        }
       //  Greenfoot.stop();
    } 
    
    public void addAnswers(){
       int xStart=350; //top left corner of where to start answers
       int yStart=200; // y location for starting answers
       getWorld().addObject(ans[0],xStart,yStart);
       getWorld().addObject(ans[1],xStart,yStart+20);
       getWorld().addObject(ans[2],xStart,yStart+40);
       getWorld().addObject(ans[3],xStart,yStart+60);
    }


    // We use this code in each of our constructors, so create a single method
    // to create a background image from the question string
    // Once created, we set the question object's image to this string image
    public void stringToImage(String s){
        
    GreenfootImage imgTxt= new GreenfootImage(600,30);
      // if we include "java.awt." in the next line, we don't have to import the class
      //See http://www.greenfoot.org/topics/187
      imgTxt.setColor(java.awt.Color.white);
      
      imgTxt.setFont(new java.awt.Font("Helvetica", java.awt.Font.PLAIN, 14));
      // Draw the text into the image that we are creating for the question object
      imgTxt.drawString(s,1,15);
     
      //TextImage t=new TextImage(ans);
      setImage(imgTxt);      
        
    }
    


  
}
