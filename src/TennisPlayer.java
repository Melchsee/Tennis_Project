import javafx.scene.paint.*;
import javafx.scene.shape.*;

public class TennisPlayer extends Circle{
	
	public TennisPlayer(int x, int y)
	{
		setCenterX(x);
		setCenterY(y);
		setRadius(50);
		setFill(Color.WHITE);
		setStroke(Color.BLACK);
		setStrokeWidth(5);
	
	}

}
