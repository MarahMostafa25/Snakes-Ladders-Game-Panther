package model;
import java.util.ArrayList;
import java.util.List;

public class Question implements  java.io.Serializable{
	private static int questionNumber=1;
	private int number;
	private String questionContent;
	private int level;
    private ArrayList<String> answers;
	private int correctAnswerNumber;
	
	public Question(String questionContent, int level, int correctAnswerNumber) {
		
		this.number=questionNumber++;
		this.questionContent = questionContent;
		if(level >3|| level<1){
            throw new IllegalArgumentException("Easy 1 , Medium 2 , Hard 3 ");
		}
		else {
			this.level = level;
		}
        this.answers = new ArrayList<String>();
        if (correctAnswerNumber < 0 || correctAnswerNumber >= answers.size()) {
            throw new IllegalArgumentException("Invalid Index number like this");
        } else {
            this.correctAnswerNumber = correctAnswerNumber;
        }
	}

	public static int getQuestionNumber() {
		return questionNumber;
	}

	public static void setQuestionNumber(int questionNumber) {
		Question.questionNumber = questionNumber;
	}

	public String getQuestionContent() {
		return questionContent;
	}

	public void setQuestionContent(String questionContent) {
		this.questionContent = questionContent;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public List<String> getAnswers() {
		return answers;
	}

	public void setAnswers(ArrayList<String> answers) {
		this.answers = answers;
	}

	public int getCorrectAnswerNumber() {
		return correctAnswerNumber;
	}

	public void setCorrectAnswerNumber(int correctAnswerNumber) {
		   if (correctAnswerNumber < 0 || correctAnswerNumber >= answers.size()) {
	        	
	            throw new IllegalArgumentException("Invalid Index number like this");
	        } else {
	            this.correctAnswerNumber = correctAnswerNumber;
	        }
	}

	@Override
	public String toString() {
		return "Question [questionContent=" + questionContent + ", level=" + level + ", answers=" + answers
				+ ", correctAnswerNumber=" + correctAnswerNumber + "]";
	}
	

}