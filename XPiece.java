package TicTacToe;

import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.layout.Pane;

public class XPiece implements Pieces{
	private Pane _gamePane;
	private Line _verticalLine;
	private Line _horizontalLine;

	public XPiece(Pane gamePane, double x, double y) {
		_gamePane = gamePane;
		int startX1 = (int) x + 50;
		int startY1 = (int) y + 25;
		int endX1 = startX1;
		int endY1 = startY1 + 50;
		_verticalLine = new Line(startX1, startY1, endX1, endY1);
		_verticalLine.setFill(Color.BLACK);
		_verticalLine.setScaleX(4);
		_verticalLine.setRotate(45);
		int startX2 = (int) x + 25;
		int startY2 = (int) y + 50;
		int endX2 = startX2 + 50;
		int endY2 = startY2;
		_horizontalLine = new Line(startX2, startY2, endX2, endY2);
		_horizontalLine.setFill(Color.BLACK);
		_horizontalLine.setScaleY(4);
		_horizontalLine.setRotate(45);
		_gamePane.getChildren().addAll(_verticalLine, _horizontalLine);
		
	}
	

	@Override
	public void remove() {
		_gamePane.getChildren().removeAll(_verticalLine, _horizontalLine);
	}
}
