import javafx.application.*;
import javafx.stage.*;
import javafx.scene.*;

public class Tennis extends Application{
		//variables here

		public static void main (String [] args)
		{
			launch(args);
		}

		@Override public void start(Stage primaryStage) throws Exception
		{
			int SceneW = 1000;
			int SceneH = 1000;

			Group root = new Group();
			root.getChildren().addAll(new TennisCourt(), new TennisPlayer(500,100), new TennisPlayer(500,900));
			Scene scene = new Scene(root, SceneW, SceneH);
			primaryStage.setScene(scene);
			primaryStage.setTitle("Tennis Court");
			primaryStage.show();
		}
}
	