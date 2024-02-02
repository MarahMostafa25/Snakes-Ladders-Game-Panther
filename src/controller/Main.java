package controller;
	
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.ObjectInputStream;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import model.SysData;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;

public class Main extends Application {
	public static SysData res;
	@Override
	public void start(Stage primaryStage) {
		try {
			/*MediaPlayer media=new MediaPlayer(new Media(getClass().getResource("/Images/audioo.mp3").toString()));
			media.setCycleCount(MediaPlayer.INDEFINITE);
			media.play();
			primaryStage.setOnCloseRequest(windowEvent->
			{
				media.stop();
			});*/
			Parent root = FXMLLoader.load(getClass().getResource("/view/MainPage.fxml"));
			Scene scene = new Scene(root);
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	
	public static void main(String[] args) {
		deSerialize();
		if(res==null)
		{
			serialize();
		}
		launch(args);
		System.out.print(SysData.getInstance().getAllQuestions());
	}
	
	public static void serialize()
	{
		try {
	         FileOutputStream fileOut =new FileOutputStream("games.ser");
	         ObjectOutputStream out = new ObjectOutputStream(fileOut);
	         res=SysData.getInstance();
	         out.writeObject(res);
	         out.close();
	         fileOut.close();
	         System.out.printf("Serialized data is saved in games.ser");
	      } 
		catch (EOFException ignoredFirstTime)
		{
			
		}
		catch (IOException i) {
	         i.printStackTrace();
	        
	      }
	}
	
	public static void deSerialize()
	{
		 try {
	         FileInputStream fileIn = new FileInputStream("games.ser");
	         ObjectInputStream in = new ObjectInputStream(fileIn);
	         res= (SysData) in.readObject();
	         in.close();
	         fileIn.close();
	         System.out.printf(" successfully deSerialized the data");
	      } catch (IOException i) {
	         i.printStackTrace();
	         return;
	      } catch (ClassNotFoundException c) {
	         System.out.println("class not found");
	         c.printStackTrace();
	         return;
	      }
	}
	public static void update()
	{
		try {
	         FileOutputStream fileOut =new FileOutputStream("games.ser");
	         ObjectOutputStream out = new ObjectOutputStream(fileOut);
	         out.writeObject(Main.res);
	         out.close();
	         fileOut.close();
	        
	      } catch (IOException i) {
	         i.printStackTrace();
	        
	      }
	}
}
