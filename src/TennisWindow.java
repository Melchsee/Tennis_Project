import java.util.Arrays;

import javafx.application.*;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.stage.*;
import javafx.scene.*;
import javafx.scene.control.Button;
import javafx.scene.paint.*;
import javafx.scene.shape.*;

public class TennisWindow extends Application{
		//variables here

		public static void main (String [] args)
		{
			launch(args);
		}

		@Override public void start(Stage primaryStage) throws Exception
		{
			int SceneW = 1000;
			int SceneH = 1000;
			int tennisCourtWidth = (int) 800;
			int tennisCourtHeight = (int) 400;
		
			Rectangle tennisCourt = new Rectangle();
			tennisCourt.setX(100);
			tennisCourt.setY(300);
			tennisCourt.setWidth(tennisCourtWidth);
			tennisCourt.setHeight(tennisCourtHeight);
			tennisCourt.setFill(Color.WHITE);
			tennisCourt.setStroke(Color.BLACK);
			tennisCourt.setStrokeWidth(5);
			
		
			Line horLine = new Line();
			horLine.setStartX(100);
			horLine.setStartY(500);
			horLine.setEndX(900);
			horLine.setEndY(500);
			
			Line vertLine = new Line();
			vertLine.setStartX(500);
			vertLine.setStartY(300);
			vertLine.setEndX(500);
			vertLine.setEndY(700);
			
			Group root = new Group();
			root.getChildren().addAll(tennisCourt, horLine, vertLine);
			Scene scene = new Scene(root, SceneW, SceneH);
			primaryStage.setScene(scene);
			primaryStage.setTitle("Tennis Court");
			primaryStage.show();
		}
}
	

