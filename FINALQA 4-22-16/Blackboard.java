import greenfoot.*;
import java.awt.Font;
import java.awt.Color;
import java.util.ArrayList;
import java.io.*;
/**
 * Write a description of class Blackboard here.
 * 
 * @author (Mr. Kaehms) 
 * @version (Rev 0.0 alpha)
 * 
 */
public class Blackboard extends World
{

    private String fileName = "greefoot-sample-questions.txt";
    public ArrayList<String> lines;
    public int maxLines;//=4;
    public int lineno=0;
    
    
    /**
     * Constructor for objects of class Blackboard.
     * 
     */
    public Blackboard()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(700, 467, 1); 
        
        try {
          lines = loadFile(fileName);
          maxLines=lines.size();
        }
        catch (IOException ioe){
            System.out.println("error");
        }
        
        prepare();
    }

    /**
     * Prepare the world for the start of the program. That is: create the initial
     * objects and add them to the world.
     */
    private void prepare()
    {
        Question question = new Question("1) What does promulgate mean? ", "A) to proclaim or make known", "B) eagerness or speed", "C) whiny or complaining", "D) great fire", 2);
        addObject(question, 382, 146);
      
    }
    
   /**
    * Load a csv (comma separated variable) file into an array list. Each line will 
    * be treated as a question as follow:
    * col1=question, col1=ans0, col2=ans1, col3=ans2, col4=ans3, col5=correctAns's index
    */
    private ArrayList<String> loadFile(String filename) throws IOException {
        ArrayList<String> lines = new ArrayList<String>();
        
        // Allow loading from JAR files
        
        // "filename" has to reference a file in the project directory used to
        // create the jar file.
        
        ClassLoader classLoader = getClass().getClassLoader();
        InputStream is = classLoader.getResourceAsStream(filename);
        if (is == null) {
            throw new IOException("No such file: " + filename);
        }
        BufferedReader reader = new BufferedReader(
                                new InputStreamReader(is));
        String line = reader.readLine();
        while (line != null) {
            
            // Note that we are ignoring lines that start with "#". This way we
            // can add comments to our data file.
            if (!line.equals("") && !line.startsWith("#")) {
                lines.add(line);
            }
            line = reader.readLine();
        }
        reader.close();
        return lines;
    }

   /**
    * Selects one line from the arraylist based on current lineno. Parses it and
    * creates a question object, and hence the list of related answer objects
    */ 
    public void loadQ(){
          
          String l=lines.get(lineno) ;
          String[] qAndA = l.split(",");
          
          removeObjects( getObjects(Question.class));
          removeObjects( getObjects(Answer.class));
          
          Question q = new Question(qAndA[0],// The question
                                    qAndA[1],qAndA[2],qAndA[3],qAndA[4],//answers
                                    Integer.parseInt(qAndA[5]));//correct answer. Must be converted from string 
          addObject(q, 382, 146);
          lineno++;
          if (lineno> lines.size()-1){
              lineno=0;
            }
          /*
          showText("Q:"+ fixedLengthString(qAndA[0],30), 200,80);
          showText(fixedLengthString("a) "+ qAndA[1],30), 200,120);
          showText(fixedLengthString("b) "+qAndA[2],30), 200,135);
          showText(fixedLengthString("c) "+qAndA[3],30), 200,150);
          showText(fixedLengthString("d) "+qAndA[4],30), 200,165);
          */
          //showText("b)"+qAndA[2], 100,140);
          //showText("c)"+qAndA[3], 100,155);
          //showText("c)"+qAndA[4], 100,175);
        }
        
   public int getMaxLines(){
       return maxLines;
    }
}
