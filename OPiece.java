package TicTacToe;

import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.layout.Pane;

public class OPiece implements Pieces {
	private Pane _gamePane;
	private Circle _firstCircle;
	private Circle _secondCircle;
	
	
	public OPiece(Pane gamePane, double x, double y) {
		_gamePane = gamePane;
		_firstCircle = new Circle(x, y, Constants.OUTERCIRCLE_RAD);
		_firstCircle.setFill(Color.BLACK);
		_secondCircle = new Circle(x, y, Constants.INNERCIRCLE_RAD);
		_secondCircle.setFill(Color.WHITE);
		_gamePane.getChildren().addAll(_firstCircle, _secondCircle);
		
	}


	@Override
	public void remove() {
		_gamePane.getChildren().removeAll(_firstCircle, _secondCircle);


	}

}
