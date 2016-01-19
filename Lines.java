package TicTacToe;

import javafx.scene.shape.Line;
import javafx.scene.paint.Color;
import javafx.scene.layout.Pane;

public class Lines {
	private Pane _gamePane;
	
	public Lines(Pane gamePane){
		_gamePane = gamePane;
		
	}
	
	public void createVerticalLines(int x, int y) {
		int startX1 = x;
		int startY1 = y;
		int endX1 = x;
		int endY1 = y + 250;
		Line line1 = new Line(startX1, startY1, endX1, endY1);
		line1.setFill(Color.BLACK);
		line1.setScaleX(2);
		int startX2 = startX1 + 100;
		int startY2 = y;
		int endX2 = endX1 + 100;
		int endY2 = y + 250;
		Line line2 = new Line(startX2, startY2, endX2, endY2);
		line2.setScaleX(2);
		_gamePane.getChildren().addAll(line1, line2);	
	}
	
	public void createHorizontalLines(int x, int y) {
		int startX1 = x;
		int startY1 = y;
		int endX1 = x + 250;
		int endY1 = y;
		Line line1 = new Line(startX1, startY1, endX1, endY1);
		line1.setFill(Color.BLACK);
		line1.setScaleY(2);
		int startX2 = startX1;
		int startY2 = y + 100;
		int endX2 = endX1;
		int endY2 = y + 100;
		Line line2 = new Line(startX2, startY2, endX2, endY2);
		line2.setScaleY(2);
		_gamePane.getChildren().addAll(line1, line2);	
	}
}
