package model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Random;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

import org.json.simple.DeserializationException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.JsonArray;
import org.json.simple.JsonObject;
import org.json.simple.Jsoner;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import controller.Main;
import utils.Level;

public class SysData  implements  java.io.Serializable{ 

	private static SysData sys = null;
	private ArrayList<Game> allgames;
	private HashSet<Question> allQuestions;

	public static SysData getInstance()
	{
		if(sys == null)
			sys = new SysData();
		return sys;
	}

	private SysData() {
		
		allgames=new ArrayList<Game>();
		allQuestions=new HashSet<Question>();
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
	public void loadQ(String path) {
		allQuestions.clear();
	    try (FileReader reader = new FileReader(new File(path))) {
	        JsonObject doc = (JsonObject) Jsoner.deserialize(reader);
	        JsonArray cus1 = (JsonArray) doc.get("questions");
	        Iterator<Object> iterator = cus1.iterator();
	        while (iterator.hasNext()) {
	            JsonObject obj = (JsonObject) iterator.next();
	            String q_content = (obj.get("content").toString());
	            // Assuming EnumType is the type of your enum
	            Level level = Level.valueOf(obj.get("level").toString());
	            String q_answ1 = (obj.get("answ1").toString());
	            String q_answ2 = (obj.get("answ2").toString());
	            String q_answ3 = (obj.get("answ3").toString());
	            String q_answ4 = (obj.get("answ4").toString());
	            Integer right_answ = Integer.valueOf(obj.get("right").toString());
	            Question q1 = new Question(q_content, level, q_answ1, q_answ2, q_answ3, q_answ4, right_answ);
	            allQuestions.add(q1);
	        }

	        System.out.println("Data imported successfully!");
	    } catch (IOException | DeserializationException e) {
	        e.printStackTrace();
	    }
	    
	}

	
	
	public void writeQuestionToJson(Question q, String outputPath) throws IOException {
	    File file = new File("Questions.json");

	    JSONArray quesArray = new JSONArray();

	    // Check if the file exists
	    if (file.exists() && file.length() > 0) {
	        JSONParser parser = new JSONParser();
	        try (FileInputStream fis = new FileInputStream(file);
	             BufferedReader reader = new BufferedReader(new InputStreamReader(fis))) {

	            Object obj = parser.parse(reader);
	            JSONObject jo = (JSONObject) obj;
	            quesArray = (JSONArray) jo.get("questions");
	        } catch (ParseException e) {
	            e.printStackTrace();
	        }
	    }

	    // Add the new question to the array
	    JSONObject questionObject = new JSONObject();
	    questionObject.put("content", q.getQuestionContent());
	    questionObject.put("level", q.getLevel().toString());
	    questionObject.put("answ1", q.getAnswer1());
	    questionObject.put("answ2", q.getAnswer2());
	    questionObject.put("answ3", q.getAnswer3());
	    questionObject.put("answ4", q.getAnswer4());
	    questionObject.put("right", q.getCorrectAnswerNumber());
	    quesArray.add(questionObject);

	    // Write the updated array to the file
	    JSONObject jsonObject = new JSONObject();
	    jsonObject.put("questions", quesArray);

	    try (FileWriter writer = new FileWriter(outputPath)) {
	        writer.write(jsonObject.toJSONString());
	        System.out.println("Data exported successfully!");
	    } catch (IOException e) {
	        e.printStackTrace();
	    } finally {
	        SysData.getInstance().loadQ("Questions.json");
	    }
	}

	
	
	
	//remove from json method (Json contains the questions)
		public void RemoveFromJson(Question question) throws IOException, ParseException {
			JSONParser parser = new JSONParser();
			FileInputStream fis = new FileInputStream("Questions.json");
			BufferedReader reader = new BufferedReader(new InputStreamReader(fis));
			Object obje = parser.parse(reader);
			JSONObject jo = (JSONObject) obje;
			JSONArray quesArray = (JSONArray) jo.get("questions");
			Iterator<JSONObject> QuestionIter = quesArray.iterator();
		
			while(QuestionIter.hasNext()) {
				JSONObject jo2 = QuestionIter.next();
				String questionText = (String) jo2.get("content");
				if(questionText!=null && questionText.equals(question.getQuestionContent())) {
					QuestionIter.remove();
				}


			}
			JSONObject jsonObject2 = new JSONObject();
			jsonObject2.put("questions", quesArray);
			try {
				FileWriter file = new FileWriter("Questions.json");
				file.write(jsonObject2.toJSONString());
				file.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally {
				SysData.getInstance().loadQ("Questions.json");
			}
			
		}
		

	

	//this will include updating answers(from the instance)
	public void updateQ(Question q,String previusContent,String path) throws IOException, ParseException
	{
		Question q4=new Question(previusContent);
		SysData.getInstance().RemoveFromJson(q4);
		SysData.getInstance().writeQuestionToJson(q,path);
		
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

	public HashSet<Question> getAllQuestions() {
		return allQuestions;
	}

	public void setAllQuestions(HashSet<Question> allQuestions) {
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
