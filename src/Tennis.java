import javafx.animation.AnimationTimer;
import javafx.application.*;
import javafx.stage.*;
import javafx.scene.*;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;

public class Tennis extends Application{
		//variables here

		TennisCourt tennisCourt;
		TennisPlayer player1, player2;
		GraphicsContext gc;
		public static void main (String [] args)
		{
			launch(args);
		}

		@Override public void start(Stage primaryStage) throws Exception
		{
			int SceneW = 1000;
			int SceneH = 1000;

			Group root = new Group();
			tennisCourt = new TennisCourt();
			player1 = new TennisPlayer (475,50);
			player2 = new TennisPlayer (475,900);
			
			Canvas canvas = new Canvas(SceneW, SceneH);
			gc = canvas.getGraphicsContext2D();
			
			AnimationTimer aTimer = new AnimationTimer(){
				@Override
				public void handle(long arg0) {
					draw();
				}
			};
			aTimer.start();
			root.getChildren().addAll(canvas);
			Scene scene = new Scene(root, SceneW, SceneH);
			primaryStage.setScene(scene);
			primaryStage.setTitle("Tennis Court");
			primaryStage.show();
		}
		
		public void draw()
		{
			gc.setFill(Color.WHITE);
			gc.setStroke(Color.BLACK);
			gc.fillRect(0, 0, gc.getCanvas().getWidth(), gc.getCanvas().getHeight());
			
			gc.setFill(Color.FORESTGREEN);
			gc.fillRect(200, 100, 600, 800);
			
			gc.setFill(Color.DARKTURQUOISE);
			gc.fillOval(player1.x, player1.y, 50, 50);
			gc.fillOval(player2.x, player2.y, 50, 50);
			
			gc.setStroke(Color.WHITE);
			gc.setLineWidth(4);
			
			gc.strokeLine(500, 300, 500, 700);
			for(int i = 0; i < 2; i++)
			{	
				gc.strokeLine(275+450*(i), 100, 275+450*(i), 900);
			}
			
			for(int i = 0; i < 3; i++)
			{	
				int lineStart = 0;
				int lineEnd = 0;
				
				if(i == 1)
				{
					lineStart = 200;
					lineEnd = 800;
					gc.setStroke(Color.BLACK);
					gc.setLineWidth(8);
				}
				else
				{
					lineStart = 275;
					lineEnd = 725;
					gc.setLineWidth(4);
				}
				gc.strokeLine(lineStart, 100+200*(i+1), lineEnd, 100+200*(i+1));
				gc.setStroke(Color.WHITE);
			}
			
			for(int i = 0; i < 2; i++)
			{	
				gc.strokeLine(500, 100+790*i, 500, 110+790*i);
			}
		}
}
	