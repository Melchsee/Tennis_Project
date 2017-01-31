import java.util.HashMap;
import java.util.Timer;
import java.util.TimerTask;

import javafx.animation.AnimationTimer;
import javafx.application.*;
import javafx.stage.*;
import javafx.scene.*;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Label;
import javafx.scene.input.KeyCode;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

public class Tennis extends Application{
		//variables here

		int speed = 5;
		double angle2 = -Math.PI/8;
		double angle1 = -Math.PI/8;
		double ballangle = Math.PI/2;
		double ballspeed = 6;
		double storedballposx = 420;
		double storedballposy = 90;
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
			player1 = new TennisPlayer(475, 50);
			player2 = new TennisPlayer(475, 900);
			ball = new TennisBall(420, 90);
			
			Canvas canvas = new Canvas(SceneW, SceneH);
			gc = canvas.getGraphicsContext2D();
		
			ball.lastHit = 0;
			Label score = new Label();
			score.setFont(new Font("Arial", 64));
			
			root.getChildren().addAll(canvas, score);
		
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
					score.setText("Top:" + player1.score + " - " + "Bot:" + player2.score);
					
					ball.x += Math.cos(ballangle) * ballspeed;
					ball.y += Math.sin(ballangle) * ballspeed;
					
					
					if(keysPressed.getOrDefault(KeyCode.A, false))
					{			
						player2.x = Math.max(player2.x-speed, 0);
					}
					if(keysPressed.getOrDefault(KeyCode.S, false))
					{			
						player2.y = Math.min(player2.y+speed, 950);
					}
					if(keysPressed.getOrDefault(KeyCode.D, false))
					{			
						player2.x =  Math.min(player2.x+speed, 950);
					}
					if(keysPressed.getOrDefault(KeyCode.W, false))
					{			
						player2.y =  Math.max(player2.y-speed, 500);
					}
					
					if(keysPressed.getOrDefault(KeyCode.SPACE, false))
					{			
						AnimationTimer aTimer = new AnimationTimer(){
							private boolean max = false;
							
							@Override
							public void handle(long arg0) {
								if(max)
								{
									angle2 -= Math.PI / 180;
									if(angle2 <= -Math.PI / 8)
									{
										this.stop();
									}
								}
								else
								{
									angle2 += Math.PI / 180;
									if(angle2 >= Math.PI / 8)
									{
										max = true;
									}
								}
								
							}							
						};
						aTimer.start();
					}
					if(ball.lastHit == 0)
					{
						ballspeed = 0;
					}
					
					if(Math.sqrt(Math.pow((ball.x + 10) - (player2.x + 60 + 10 * (Math.cos(angle2))), 2) + Math.pow((ball.y + 10) - (player2.y + 25 + 10 * (Math.sin(angle2))), 2)) < 10)
					{
						if(ball.lastHit == 0 || ball.lastHit == 1)
						{
							ball.lastHit = 2;
							ballangle = angle2 - Math.PI/2;
							storedballposx = ball.x;
							storedballposy = ball.y;
							ballspeed = 6;
						}
					}
					else if(Math.sqrt(Math.pow((ball.x + 10) - (player2.x + 60 + 15 * (Math.cos(angle2))), 2) + Math.pow((ball.y + 10) - (player2.y + 25 + 15 * (Math.sin(angle2))), 2)) < 10)
					{
						if(ball.lastHit == 0 || ball.lastHit == 1)
						{
							ball.lastHit = 2;
							ballangle = angle2 - Math.PI/2;
							storedballposx = ball.x;
							storedballposy = ball.y;
							ballspeed = 6;
						}
					}
					else if(Math.sqrt(Math.pow((ball.x + 10) - (player2.x + 60 + 20 * (Math.cos(angle2))), 2) + Math.pow((ball.y + 10) - (player2.y + 25 + 20 * (Math.sin(angle2))), 2)) < 10)
					{
						if(ball.lastHit == 0 || ball.lastHit == 1)
						{
							ball.lastHit = 2;
							ballangle = angle2 - Math.PI/2;
							storedballposx = ball.x;
							storedballposy = ball.y;
							ballspeed = 6;
						}
					}
					else if(Math.sqrt(Math.pow((ball.x + 10) - (player2.x + 60 + 25 * (Math.cos(angle2))), 2) + Math.pow((ball.y + 10) - (player2.y + 25 + 25 * (Math.sin(angle2))), 2)) < 10)
					{
						if(ball.lastHit == 0 || ball.lastHit == 1)
						{
							ball.lastHit = 2;
							ballangle = angle2 - Math.PI/2;
							storedballposx = ball.x;
							storedballposy = ball.y;
							ballspeed = 6;
						}
					}
					else if(Math.sqrt(Math.pow((ball.x + 10) - (player2.x + 60 + 30 * (Math.cos(angle2))), 2) + Math.pow((ball.y + 10) - (player2.y + 25 + 30 * (Math.sin(angle2))), 2)) < 10)
					{
						if(ball.lastHit == 0 || ball.lastHit == 1)
						{
							ball.lastHit = 2;
							ballangle = angle2 - Math.PI/2;
							storedballposx = ball.x;
							storedballposy = ball.y;
							ballspeed = 6;
						}
					}
					else if(Math.sqrt(Math.pow((ball.x + 10) - (player2.x + 60 + 35 * (Math.cos(angle2))), 2) + Math.pow((ball.y + 10) - (player2.y + 25 + 35 * (Math.sin(angle2))), 2)) < 10)
					{
						if(ball.lastHit == 0 || ball.lastHit == 1)
						{
							ball.lastHit = 2;
							ballangle = angle2 - Math.PI/2;
							storedballposx = ball.x;
							storedballposy = ball.y;
							ballspeed = 6;
						}
					}
					else if(Math.sqrt(Math.pow((ball.x + 10) - (player2.x + 60 + 40 * (Math.cos(angle2))), 2) + Math.pow((ball.y + 10) - (player2.y + 25 + 40 * (Math.sin(angle2))), 2)) < 10)
					{
						if(ball.lastHit == 0 || ball.lastHit == 1)
						{
							ball.lastHit = 2;
							ballangle = angle2 - Math.PI/2;
							storedballposx = ball.x;
							storedballposy = ball.y;
							ballspeed = 6;
						}
					}
					
					if(keysPressed.getOrDefault(KeyCode.LEFT, false))
					{			
						player1.x = Math.max(player1.x-speed, 0);
					}
					if(keysPressed.getOrDefault(KeyCode.DOWN, false))
					{			
						player1.y = Math.min(player1.y+speed, 450);
					}
					if(keysPressed.getOrDefault(KeyCode.RIGHT, false))
					{			
						player1.x =  Math.min(player1.x+speed, 950);
					}
					if(keysPressed.getOrDefault(KeyCode.UP, false))
					{			
						player1.y =  Math.max(player1.y-speed, 0);
					}
					if(keysPressed.getOrDefault(KeyCode.ENTER, false))
					{			
						AnimationTimer aTimer = new AnimationTimer(){
							private boolean max = false;
							
							@Override
							public void handle(long arg0) {
								if(max)
								{
									
									angle1 -= Math.PI / 180;
									if(angle1 <= -Math.PI / 8)
									{
										this.stop();
									}
								}
								else
								{
									angle1 += Math.PI / 180;
									if(angle1 >= Math.PI / 8)
									{
										max = true;
									}
								}
							}
						};
						aTimer.start();
					}
					if(Math.sqrt(Math.pow((ball.x + 10) - (player1.x - 10 - 10 * (Math.cos(angle1))), 2) + Math.pow((ball.y + 10) - (player1.y + 25 - 10 * (Math.sin(angle1))), 2)) < 10)
					{
						if(ball.lastHit == 0 || ball.lastHit == 2)
						{
							ball.lastHit = 1;
							ballangle = angle1 + Math.PI/2;
							storedballposx = ball.x;
							storedballposy = ball.y;
							ballspeed = 6;
						}
					}
					else if(Math.sqrt(Math.pow((ball.x + 10) - (player1.x - 10 - 15 * (Math.cos(angle1))), 2) + Math.pow((ball.y + 10) - (player1.y + 25 - 15 * (Math.sin(angle1))), 2)) < 10)
					{
						if(ball.lastHit == 0 || ball.lastHit == 2)
						{
							ball.lastHit = 1;
							ballangle = angle1 + Math.PI/2;
							storedballposx = ball.x;
							storedballposy = ball.y;
							ballspeed = 6;
						}
					}
					else if(Math.sqrt(Math.pow((ball.x + 10) - (player1.x - 10 - 20 * (Math.cos(angle1))), 2) + Math.pow((ball.y + 10) - (player1.y + 25 - 20 * (Math.sin(angle1))), 2)) < 10)
					{
						if(ball.lastHit == 0 || ball.lastHit == 2)
						{
							ball.lastHit = 1;
							ballangle = angle1 + Math.PI/2;
							storedballposx = ball.x;
							storedballposy = ball.y;
							ballspeed = 6;
						}
					}
					else if(Math.sqrt(Math.pow((ball.x + 10) - (player1.x - 10 - 25 * (Math.cos(angle1))), 2) + Math.pow((ball.y + 10) - (player1.y + 25 - 25 * (Math.sin(angle1))), 2)) < 10)
					{
						if(ball.lastHit == 0 || ball.lastHit == 2)
						{
							ball.lastHit = 1;
							ballangle = angle1 + Math.PI/2;
							storedballposx = ball.x;
							storedballposy = ball.y;
							ballspeed = 6;
						}
					}
					else if(Math.sqrt(Math.pow((ball.x + 10) - (player1.x - 10 - 30 * (Math.cos(angle1))), 2) + Math.pow((ball.y + 10) - (player1.y + 25 - 30 * (Math.sin(angle1))), 2)) < 10)
					{
						if(ball.lastHit == 0 || ball.lastHit == 2)
						{
							ball.lastHit = 1;
							ballangle = angle1 + Math.PI/2;
							storedballposx = ball.x;
							storedballposy = ball.y;
							ballspeed = 6;
						}
					}
					else if(Math.sqrt(Math.pow((ball.x + 10) - (player1.x - 10 - 35 * (Math.cos(angle1))), 2) + Math.pow((ball.y + 10) - (player1.y + 25 - 35 * (Math.sin(angle1))), 2)) < 10)
					{
						if(ball.lastHit == 0 || ball.lastHit == 2)
						{
							ball.lastHit = 1;
							ballangle = angle1 + Math.PI/2;
							storedballposx = ball.x;
							storedballposy = ball.y;
							ballspeed = 6;
						}
					}
					else if(Math.sqrt(Math.pow((ball.x + 10) - (player1.x - 10 - 40 * (Math.cos(angle1))), 2) + Math.pow((ball.y + 10) - (player1.y + 25 - 40 * (Math.sin(angle1))), 2)) < 10)
					{
						if(ball.lastHit == 0 || ball.lastHit == 2)
						{
							ball.lastHit = 1;
							ballangle = angle1 + Math.PI/2;
							storedballposx = ball.x;
							storedballposy = ball.y;
							ballspeed = 6;
						}
					}
					
					if(keysPressed.getOrDefault(KeyCode.CONTROL, false))
					{			
						player1 = new TennisPlayer(475,50);
						player2 = new TennisPlayer(475,900);
						ball = new TennisBall(420,90);
						ballangle = Math.PI/2;
						ballspeed = 6;
						player1.score = 0;
						player2.score = 0;
						ball.lastHit = 0;
					}
					
					if(Math.sqrt(Math.pow((ball.y-storedballposy), 2) + Math.pow((ball.x-storedballposx), 2)) > 525)
					{
						if(ball.lastHit == 1)
						{
							if((ball.x<200 || ball.x>800 || ball.y<550 || ball.y>900))
							{
								if(Math.sqrt(Math.pow((ball.y-storedballposy), 2) + Math.pow((ball.x-storedballposx), 2)) > 750)
								{
									player1.score += 1;		
									ball.lastHit = 0;
								}
								else
								{
									player2.score += 1;
									ball.lastHit = 0;
								}
								
								player1.x = 475;
								player1.y = 50;
								player2.x = 475;
								player2.y = 900;
								if((player1.score + player2.score)%2 == 0)
								{
									ball = new TennisBall(420, 90);
									ballangle = Math.PI/2;
								}
								else
								{
									ball = new TennisBall(560, 890);
									ballangle = -Math.PI/2;
								}
							}
						}
						
						if(ball.lastHit == 2)
						{
							if(ball.x<200 || ball.x>800 || ball.y<100 || ball.y>550)
							{
								if(Math.sqrt(Math.pow((ball.y-storedballposy), 2) + Math.pow((ball.x-storedballposx), 2)) > 750)
								{
									player2.score += 1;		
									ball.lastHit = 0;
								}
								else
								{
									player1.score += 1;
									ball.lastHit = 0;
								}
								
								player1.x = 475;
								player1.y = 50;
								player2.x = 475;
								player2.y = 900;
								if((player1.score + player2.score)%2 == 0)
								{
									ball = new TennisBall(420, 90);
									ballangle = Math.PI/2;
								}
								else
								{
									ball = new TennisBall(560, 890);
									ballangle = -Math.PI/2;
								}							}
						}
					}
					if(player1.score >= 10)
					{
						score.setText(player1.score + "-" + player2.score + ": Top wins!!! \n Press ctrl to restart!");
					}
					if(player2.score >= 10)
					{
						score.setText(player1.score + "-" + player2.score + ": Bottom wins!!! \n Press ctrl to restart!");
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
			gc.setStroke(Color.DARKTURQUOISE);
			gc.setLineWidth(20); //sets width of racket
			gc.strokeLine(player1.x - 10, player1.y + 25, player1.x - 10 - 50*Math.cos(angle1), player1.y + 25 + 50*Math.sin(angle1));//line for racket
			gc.fillOval(player2.x, player2.y, 50, 50);
			gc.setLineWidth(20); //sets width of racket
			gc.strokeLine(player2.x + 60, player2.y + 25, player2.x + 60 + 50*Math.cos(angle2), player2.y + 25 - 50*Math.sin(angle2));//line for racket
			
			
			gc.setFill(Color.GREENYELLOW);
			gc.fillOval(ball.x, ball.y, 20, 20);
			
			gc.setStroke(Color.WHITE);
			gc.setLineWidth(4);
			
			gc.strokeLine(500, 300, 500, 700);
			for(int i = 0; i < 2; i++)
			{	
				gc.strokeLine(275 + 450 * i, 100, 275 + 450 * i, 900);
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
				gc.strokeLine(lineStart, 100+200*(i + 1), lineEnd, 100 + 200 * (i + 1));
				gc.setStroke(Color.WHITE);
			}
			
			for(int i = 0; i < 2; i++)
			{	
				gc.strokeLine(500, 100 + 790 * i, 500, 110 + 790 * i);
			}
		}
}
	