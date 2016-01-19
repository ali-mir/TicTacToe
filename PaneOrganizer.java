package TicTacToe;

import javafx.scene.layout.BorderPane;

public class PaneOrganizer {
	private BorderPane _root;
	private Game _game;
	private Controls _controls;
	
	public PaneOrganizer(){
		_root = new BorderPane();
		_controls = new Controls(this);
		_root.setBottom(_controls.getControlPane());
		_game = new Game(this);
		_root.setTop(_game.getGamePane());
	}
	
	public BorderPane getRoot() {
		return _root;
	}
	
	public void tellGameToClear() {
		_game.clear();
	}
	
	public void changeTextStartGame() {
		_controls.changeLabelStartGame();
	}
	public void changeTextMidGame() {
		_controls.changeLabelMidGame();
	}
	
}
