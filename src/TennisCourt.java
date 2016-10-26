import javafx.scene.paint.*;
import javafx.scene.shape.*;

public class TennisCourt extends Rectangle{

		public TennisCourt()
		{
			int tennisCourtWidth = (int) 600;
			int tennisCourtHeight = (int) 900;
		
			setX((1000-tennisCourtWidth)/2);
			setY((1000-tennisCourtHeight)/2);
			setWidth(tennisCourtWidth);
			setHeight(tennisCourtHeight);
			setFill(Color.WHITE);
			setStroke(Color.BLACK);
			setStrokeWidth(5);
			
			Line horLines[] = new Line[3]; 
			for(int i = 0; i < horLines.length; i++)
			{
				horLines[i] = new Line();
				horLines[i].setStartX(300*(i+1));
				horLines[i].setStartY(200);
				horLines[i].setEndX(300*(i+1));
				horLines[i].setEndY(800);
			}
		
		}
}
	

