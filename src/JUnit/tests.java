package JUnit;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;


import java.io.IOException;
import java.util.ArrayList;

import org.json.simple.parser.ParseException;
import org.junit.Test;

import model.Question;
import model.SysData;
import utils.Level;

public class tests {
	
	
	//This test checks if the load is correct.
	 @Test
	    public void testload() throws IOException, ParseException {

	        SysData.getInstance().loadQ("Question.json");
	        System.out.print(SysData.getInstance().getAllQuestions());

	        assertTrue(SysData.getInstance().getAllQuestions() != null);
	    }
	// we checked before that loadQ is working well (which is used in writeQuestionToJson method)
		// so this test is only for writing.
	@Test
    public void testAddingNewQuestion() throws IOException, ParseException {

    	Level qlevel=Level.Medium;
        Question question = new Question("A software component is an architectural entity that.",qlevel, "encapsulates a subset of the system�s functionality and/or data", "restricts access to that subset via an explicitly defined interface", "has explicitly defined dependencies on its required execution context", "all the answers are correct",4); 
        SysData.getInstance().writeQuestionToJson(question,"Questions.json");
        System.out.print(SysData.getInstance().getAllQuestions());

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
  //This Test checks if all the questions in our JSON questions file have 4 answers.
  	@Test
  	public void answersNumOfQuestionsTest(){
  		for (Question q : SysData.getInstance().getAllQuestions()) {
  			int expectedResult = 4 ;
  		 ArrayList<String> actualResult = new ArrayList<String>();
  		 actualResult.add(q.getAnswer1());
  		actualResult.add(q.getAnswer2());
  		actualResult.add(q.getAnswer3());
  		actualResult.add(q.getAnswer4());
  			assertEquals(expectedResult, actualResult.size());
  		}
  	}
  //This Test checks if  the update did work
  	@Test
  	public void updateQuestionsTest() throws IOException, ParseException{
  		 
  		 Level qlevel = Level.Medium;
  		 Question question_updated = new Question("A software component is an architectural entity that.",qlevel, "encapsulates a subset of the system�s functionality and/or data", "restricts access to that subset via an explicitly defined interface", "has explicitly defined dependencies on its required execution context", "all the answers are correct",1); 
  		 SysData.getInstance().updateQ(question_updated,"A software component is an architectural entity that.","Questions.json");
  		 
  		ArrayList<Question> qq=new ArrayList<Question>(SysData.getInstance().getAllQuestions());
  		for (Question q: qq)
  		{
  			if(q.getQuestionContent().equals(question_updated.getQuestionContent()))
  			{
  		  		assertEquals(q.getCorrectAnswerNumber(),1);

  			}
  		}	
  	}
}

	 

