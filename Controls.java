package TicTacToe;

import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.application.Platform;
import javafx.scene.control.Button;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;


public class Controls {
	private BorderPane _controlPane;
	private Button _quitButton;
	private Button _clearButton;
	private PaneOrganizer _controlsListener;
	private Label _label;

	public Controls(PaneOrganizer paneOrg) {
		_controlPane = new BorderPane();
		_controlPane.setPrefSize(Constants.CONTROLPANE_WIDTH, Constants.CONTROLPANE_HEIGHT);
		_controlPane.setStyle("-fx-background-color: BLACK;");
		this.setUpButtons();
		this.setUpRightSidePanel();
		_controlsListener = paneOrg;
	}
	
	public BorderPane getControlPane() {
		return _controlPane;
	}
	
	public void setUpRightSidePanel() {
		VBox rightPanel = new VBox(5);
		rightPanel.setPrefSize(Constants.BPANEL_WIDTH, Constants.BPANEL_HEIGHT);
		_label = new Label("Click on the grid \nto begin the game!");
		_label.setAlignment(Pos.TOP_CENTER);
		_label.setStyle("-fx-font: 15 futura; -fx-base: #0033CC;");
		
		Label playerLabel = new Label("Player1: O \nPlayer2: X");
		playerLabel.setAlignment(Pos.BOTTOM_CENTER);
		playerLabel.setStyle("-fx-font: 19 futura; -fx-base: #0033CC;");

		rightPanel.getChildren().addAll(_label, playerLabel);
		_controlPane.setRight(rightPanel);
		rightPanel.setAlignment(Pos.CENTER);
	}
	public void setUpButtons() {
		VBox buttonPanel = new VBox(5);
		ButtonHandler buttonHandler = new ButtonHandler();
		buttonPanel.setPrefSize(Constants.BPANEL_WIDTH, Constants.BPANEL_HEIGHT);
		_clearButton = new Button("Clear");
		_clearButton.setOnAction(buttonHandler);
		_clearButton.setAlignment(Pos.TOP_CENTER);
		_clearButton.setStyle("-fx-font: 17 futura; -fx-base: #FF6633;");		
		_quitButton = new Button("Quit");
		_quitButton.setOnAction(buttonHandler);
		_quitButton.setAlignment(Pos.BOTTOM_CENTER);
		_quitButton.setStyle("-fx-font: 17 futura; -fx-base: #FF6633;");
		buttonPanel.getChildren().addAll(_clearButton, _quitButton);
		_controlPane.setLeft(buttonPanel);
		buttonPanel.setAlignment(Pos.CENTER);
	}
	
	public void changeLabelStartGame() {
		_label.setText("Click on the grid \nto begin the game!");
	}
	
	public void changeLabelMidGame() {
		_label.setText("Try to outsmart \nyour opponent!");
	}
	
	private class ButtonHandler implements EventHandler<ActionEvent>{
		
		public void handle(ActionEvent e) {
			if (e.getSource() == _clearButton){
				_controlsListener.tellGameToClear();
			} else if (e.getSource() == _quitButton) {
				Platform.exit();
			}
			e.consume();
		}	
	}
	
}
