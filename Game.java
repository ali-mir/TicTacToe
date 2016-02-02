package TicTacToe;

import javafx.scene.layout.Pane;
import java.util.Arrays;
import javafx.scene.input.MouseEvent;
import javafx.event.EventHandler;



public class Game {
	private Pane _gamePane;
	private Cell[][] _cellArray;
	private Pieces[][] _pieceArray;
	private PaneOrganizer _gameListener;
	

	public Game(PaneOrganizer paneOrg) {
		_gamePane = new Pane();
		_gamePane.setPrefSize(Constants.GAMEPANE_WIDTH, Constants.GAMEPANE_HEIGHT);
		this.setUpCells();
		this.setUpLines();
		_pieceArray = new Pieces[3][3];
		_gamePane.addEventHandler(MouseEvent.ANY, new MouseHandler());
		_gameListener = paneOrg;
		
	}
	
	public Pane getGamePane() {
		return _gamePane;
	}
	
	private void setUpLines() {
		Lines lines = new Lines(_gamePane);
		lines.createVerticalLines(100, 25);
		lines.createHorizontalLines(25, 100);
	}
	
	
	private void setUpCells() { // REDO
		_cellArray = new Cell[3][3];
		int x = 0;
		int y = 0;
		for (int i = 0; i< 3; i++){
			for (int j = 0; j<3; j++) {
				Cell cell = new Cell(_gamePane, x, y);
				_cellArray[i][j] = cell;
				x = x + 100;
			}
			x = 0;
			y = y + 100;
		}
	}
	
	public void clear () {
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				if (_cellArray[i][j].getIsFull()) {
				_pieceArray[i][j].remove();
				_pieceArray[i][j] = null;
				_cellArray[i][j].isEmpty();
				}
			}
		}
		_gameListener.changeTextStartGame();
		
	}
	
	public void checkForGameOver() {
	
	}
	
	
	private class MouseHandler implements EventHandler<MouseEvent> {
		boolean _whichPiece = true;
		
		public void handle(MouseEvent e) {
			if (e.getEventType() == MouseEvent.MOUSE_CLICKED){
				double xClick = e.getX();
				double yClick = e.getY();
				for (int i = 0; i < 3; i++) {
					for (int j = 0; j < 3; j++) {
						if (_cellArray[i][j].getRect().contains(xClick, yClick)
								&& !_cellArray[i][j].getIsFull()) {
							System.out.println("You have selected cell " + (i + 1) + "," + (j + 1));
							_gameListener.changeTextMidGame();
							if (_whichPiece) {
								double circleX = _cellArray[i][j].getRect().getX() + 50;
								double circleY = _cellArray[i][j].getRect().getY() + 50;
								OPiece opiece = new OPiece(_gamePane, circleX,
										circleY);
								_pieceArray[i][j] = opiece;
								_cellArray[i][j].isFull();
								_whichPiece = false;
							} else {
								double lineX = _cellArray[i][j].getRect().getX();
								double lineY = _cellArray[i][j].getRect().getY();
								XPiece xpiece = new XPiece(_gamePane, lineX,
										lineY);
								_pieceArray[i][j] = xpiece;
								_cellArray[i][j].isFull();
								_whichPiece = true;
							}
						}
						
					}
					
				}
				
			}

		}
		
	}
}
