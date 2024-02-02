package JUnit;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import org.junit.Test;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.Game;
import model.Question;
import model.SysData;
import utils.Level;

public class tests {
	//create a new question and write it to json and check if it has been added to sysData
    @Test
    public void testAddingNewQuestion() throws IOException {

    	Level qlevel=Level.Medium;
        Question question = new Question("A software component is an architectural entity that.",qlevel, "encapsulates a subset of the system’s functionality and/or data", "restricts access to that subset via an explicitly defined interface", "has explicitly defined dependencies on its required execution context", "all the answers are correct",4); 
        SysData.getInstance().writeQuestionToJson(question,"Questions.json");
        assertTrue(SysData.getInstance().getAllQuestions().contains(question));

 

    }
    @Test
    public void testloadingallQuestion() throws IOException {
    	System.out.print(SysData.getInstance().loadQ("Questions.json"));

        assertTrue(SysData.getInstance().loadQ("Questions.json") != null);

 

    }

	 
}

	 

