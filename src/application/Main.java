package application;
	
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;

public class Main extends Application {
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
		launch(args);
	}
}
