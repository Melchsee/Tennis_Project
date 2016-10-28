import javafx.scene.layout.StackPane;
import javafx.scene.paint.*;
import javafx.scene.shape.*;

public class TennisCourt extends StackPane{

		public TennisCourt()
		{
			int tennisCourtWidth = (int) 600;
			int tennisCourtHeight = (int) 900;
		
			Rectangle r = new Rectangle();
			r.setX((1000-tennisCourtWidth)/2);
			r.setY((1000-tennisCourtHeight)/2);
			r.setWidth(tennisCourtWidth);
			r.setHeight(tennisCourtHeight);
			r.setFill(Color.WHITE);
			r.setStroke(Color.BLACK);
			r.setStrokeWidth(5);
			
			Line horLines[] = new Line[3]; 
			for(int i = 0; i < horLines.length; i++)
			{
				horLines[i] = new Line();
				horLines[i].setStartX(300*(i+1));
				horLines[i].setStartY(200);
				horLines[i].setEndX(300*(i+1));
				horLines[i].setEndY(800);
			}
			this.getChildren().addAll(r);
			this.getChildren().addAll(horLines);
		}
}
	

