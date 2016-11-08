import java.util.HashMap;

import javafx.animation.AnimationTimer;
import javafx.application.*;
import javafx.stage.*;
import javafx.scene.*;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.KeyCode;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;

public class Tennis extends Application{
		//variables here

		int speed = 8;
		int angle2 = 0;
		TennisCourt tennisCourt;
		TennisPlayer player1, player2;
		TennisBall ball;
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
			player1 = new TennisPlayer(475,50);
			player2 = new TennisPlayer(475,900);
			ball = new TennisBall(490, 750);
			
			Canvas canvas = new Canvas(SceneW, SceneH);
			gc = canvas.getGraphicsContext2D();
				
			root.getChildren().addAll(canvas);
		
			HashMap<KeyCode, Boolean> keysPressed  = new HashMap<>();
			Scene scene = new Scene(root, SceneW, SceneH);

			
			scene.setOnKeyPressed(event -> {
				keysPressed.put(event.getCode(), true);
			});

			scene.setOnKeyReleased(event -> {
				keysPressed.put(event.getCode(), false);
			});
			
			
			AnimationTimer aTimer = new AnimationTimer(){
				@Override
				public void handle(long arg0) {
					draw();
				
					if(keysPressed.getOrDefault(KeyCode.A, false))
					{			
						player2.x = player2.x-speed;
					}
					if(keysPressed.getOrDefault(KeyCode.S, false))
					{			
						player2.y = player2.y+speed;
					}
					if(keysPressed.getOrDefault(KeyCode.D, false))
					{			
						player2.x = player2.x+speed;
					}
					if(keysPressed.getOrDefault(KeyCode.W, false))
					{			
						player2.y = player2.y-speed;
					}
					if(keysPressed.getOrDefault(KeyCode.SPACE, false))
					{			
						//angle1
					}
					if(keysPressed.getOrDefault(KeyCode.LEFT, false))
					{			
						player1.x = player1.x-speed;
					}
					if(keysPressed.getOrDefault(KeyCode.DOWN, false))
					{			
						player1.y = player1.y+speed;
					}
					if(keysPressed.getOrDefault(KeyCode.RIGHT, false))
					{			
						player1.x = player1.x+speed;
					}
					if(keysPressed.getOrDefault(KeyCode.UP, false))
					{			
						player1.y = player1.y-speed;
					}
					if(keysPressed.getOrDefault(KeyCode.CONTROL, false))
					{			
						angle2 = 30;
					}
					if(keysPressed.getOrDefault(KeyCode.ENTER, false))
					{			
						player1 = new TennisPlayer(475,50);
						player2 = new TennisPlayer(475,900);
					}
				}
			};
			aTimer.start();
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
			gc.fillRect(player1.x-(50-30*(Math.sin(angle2))),  player1.y+(Math.sin(angle2)*20), 50, 20);
			gc.fillOval(player2.x, player2.y, 50, 50);
			gc.fillRect(player2.x+50,  player2.y, 50, 20);
			
			gc.setFill(Color.GREENYELLOW);
			gc.fillOval(ball.x, ball.y, 20, 20);
			
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
	