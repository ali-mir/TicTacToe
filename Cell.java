package TicTacToe;

import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class Cell {
	private Pane _gamePane;
	private Rectangle _cell;
	private boolean _isFull;

	public Cell(Pane gamePane, int x, int y) {
		_gamePane = gamePane;
		_isFull = false;
		_cell = new Rectangle(x, y, Constants.CELL_SIZE, Constants.CELL_SIZE);
		_cell.setFill(Color.WHITE);
		_gamePane.getChildren().add(_cell);
		
	}
	
	public Rectangle getRect(){
		return _cell;
	}
	
	public void isFull() {
		_isFull = true;
	}
	
	public void isEmpty() {
		_isFull = false;
	}
	
	public boolean getIsFull() {
		return _isFull;
	}
	
}
