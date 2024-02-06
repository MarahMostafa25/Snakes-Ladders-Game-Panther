package JUnit;

import static org.junit.Assert.assertTrue;

import java.io.IOException;

import org.json.simple.parser.ParseException;
import org.junit.Test;

import model.Question;
import model.SysData;
import utils.Level;

public class tests {
    @Test
    public void testAddingNewQuestion() throws IOException, ParseException {

    	Level qlevel=Level.Medium;
        Question question = new Question("A software component is an architectural entity that.",qlevel, "encapsulates a subset of the system�s functionality and/or data", "restricts access to that subset via an explicitly defined interface", "has explicitly defined dependencies on its required execution context", "all the answers are correct",4); 
        SysData.getInstance().writeQuestionToJson(question,"Questions.json");
        System.out.print(SysData.getInstance().getAllQuestions());

        assertTrue(SysData.getInstance().getAllQuestions().contains(question));
 

    }
    @Test
    public void testAddingSecondQuestion() throws IOException, ParseException {

    	Level qlevel=Level.Medium;
        Question question = new Question("A  component is an architectural entity that 7.",qlevel, "encapsulates a subset of the system�s functionality and/or data", "restricts access to that subset via an explicitly defined interface", "has explicitly defined dependencies on its required execution context", "all the answers are correct",4); 
        SysData.getInstance().writeQuestionToJson(question,"Questions.json");
        assertTrue(SysData.getInstance().getAllQuestions().contains(question));
 

    }
    
  //remove a question from sysData and checks if it actually has been removed from the class
    @Test
    public void testRemovingQuestion() throws IOException, ParseException{
    	String content="A software component is an architectural entity that.";
    	Question tryQuestion=new Question(content);
        SysData.getInstance().RemoveFromJson(tryQuestion);
        SysData.getInstance().loadQ("Questions.json");
        assertTrue(!SysData.getInstance().getAllQuestions().contains(tryQuestion));


    }
    
  
  
    
      
	 
}

	 

