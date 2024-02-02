package model;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import org.json.simple.DeserializationException;

import org.json.simple.JsonArray;
import org.json.simple.JsonObject;
import org.json.simple.Jsoner;

import utils.Level;

public class SysData  implements  java.io.Serializable{ 

	private static SysData sys = null;
	private ArrayList<Game> allgames;
	private ArrayList<Question> allQuestions;

	public static SysData getInstance()
	{
		if(sys == null)
			sys = new SysData();
		return sys;
	}

	private SysData() {
		
		allgames=new ArrayList<Game>();
		allQuestions=new ArrayList<Question>();
	}
	
	
	//this is same as Write Game data Func , cause when we add game here , we will make sure to update
	//serializable file in the controller which mean this game will be saved in the file
	public String InitializeGame(Game g)
	{
		if(allgames.add(g)) {
			return "Starting New Game";
			
		}
		else
		{
			return "Cannot add the game!";
		}
	}
	
	//get all questions from json file
	public ArrayList<Question> loadQ(String path)
	{
		allQuestions.clear();
		try (FileReader reader = new FileReader(new File(path))) {
    		JsonObject doc = (JsonObject) Jsoner.deserialize(reader);
    		JsonArray cus1 = (JsonArray) doc.get("questions");
    		Iterator<Object> iterator = cus1.iterator();
    		while (iterator.hasNext()) {
    			JsonObject obj = (JsonObject) iterator.next();
    			String q_content=(obj.get("content").toString());
    			// Assuming EnumType is the type of your enum
    			Level level = Level.valueOf(obj.get("level").toString());
    			String q_answ1=(obj.get("answ1").toString());
    			String q_answ2=(obj.get("answ2").toString());
    			String q_answ3=(obj.get("answ3").toString());
    			String q_answ4=(obj.get("answ4").toString());
    			Integer right_answ =Integer.valueOf(obj.get("right").toString());
    			Question q1=new Question(q_content,level,q_answ1,q_answ2,q_answ3,q_answ4,right_answ);
    			allQuestions.add(q1);
    			return allQuestions;
    		}
    		
			System.out.println(" data imported successfully!"); 
				
    	} catch (IOException | DeserializationException e) {
    		e.printStackTrace();
    	}
		return allQuestions;
		
	}
	
	
	
	// write new question into json file
	public void writeQuestionToJson(Question question, String outputPath) {
		JsonArray questionsArray = new JsonArray();


		JsonObject questionObject = new JsonObject();
		questionObject.put("content", question.getQuestionContent());
		questionObject.put("level", question.getLevel().toString());
		questionObject.put("answ1", question.getAnswer1());
		questionObject.put("answ2", question.getAnswer2());
		questionObject.put("answ3", question.getAnswer3());
		questionObject.put("answ4", question.getAnswer4());
		questionObject.put("right", question.getCorrectAnswerNumber());

		questionsArray.add(questionObject);


		JsonObject doc = new JsonObject();
		doc.put("questions", questionsArray);
		add_new_q(question);

		try (FileWriter writer = new FileWriter(outputPath)) {
			writer.write(doc.toJson());
			System.out.println("Data exported successfully!");
		} catch (IOException e) {
			e.printStackTrace();
		}
    }
	
	
	// remove question with specific content	
	public void removeQuestion(String path, String questionContent) {
	    try (FileReader reader = new FileReader(new File(path))) {
	        JsonObject doc = (JsonObject) Jsoner.deserialize(reader);
	        JsonArray cus1 = (JsonArray) doc.get("questions");
	        Iterator<Object> iterator = cus1.iterator();
	        int indexToRemove = -1;

	        for (int i = 0; i < cus1.size(); i++) {
	        	JsonObject jsonObject = (JsonObject) cus1.get(i);
	            String currentQuestionContent = (String) jsonObject.get("Content");

	            if (currentQuestionContent.equals(questionContent)) {
	                indexToRemove = i;
	                break;
	            }
	        }

	        if (indexToRemove != -1) {
	            // Remove the question
	            cus1.remove(indexToRemove);
	            for (Question i :allQuestions)
	            {
	            	if(i.getQuestionContent().equals(questionContent)) {
	            		remove_q(i);
	            	}
	            }

	            // Save the updated data back to the JSON file
	            try (FileWriter fileWriter = new FileWriter(path)) {
	                fileWriter.write(doc.toString());
	            }

	            System.out.println("Question with content '" + questionContent + "' removed successfully!");
	        } else {
	            System.out.println("Question with content '" + questionContent + "' not found.");
	        }

	    } catch ( Exception e) {
	        e.printStackTrace();
	    }
	    }
	

	//this will include updating answers(from the instance)
	public void updateQ(Question q,String previusContent,String path)
	{
		
		removeQuestion(path,previusContent);
		writeQuestionToJson(q,path);
		
	}
	public String add_new_q(Question q)
	{
		if(!allQuestions.add(q))
		{
			return "cannot add";
		}
		else
		{
			return "added succesfully";
		}
	}
	public String remove_q(Question q)
	{
		if(!allQuestions.remove(q))
		{
			return "cannot remove";
		}
		else
		{
			return "removed ";
		}
	}
	
	
	
	
	
	
	
    // same as loadData (we will make sure this data are saved in serializable file(functions are in main class )
	public ArrayList<Game> getAllgames() {
		return allgames;
	}

	public void setAllgames(ArrayList<Game> allgames) {
		this.allgames = allgames;
	}

	public ArrayList<Question> getAllQuestions() {
		return allQuestions;
	}

	public void setAllQuestions(ArrayList<Question> allQuestions) {
		this.allQuestions = allQuestions;
	}
	
	public Question popQuestion(Level level)
	{
		ArrayList<Question> ar=new ArrayList<Question>();
		for (Question a:allQuestions)
		{
			if(a.getLevel().equals(level))
			{
				ar.add(a);
				
			}
		}
		Random random = new Random();
        int index=random.nextInt(ar.size());
        return ar.get(index);
		
	}
	

	

}
