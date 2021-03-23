//Name: Renata Auchynnikava 
//Email: renataau02@gmail.com
//Position application: Software Engineer Intern

//Note to run: Please read the "Download JavaFX read" on this repository on how to implement JavaFX

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class Ford_SE_Internship extends Application {
	// creating variables
	Button btn = new Button("Submit");
	GridPane grid = new GridPane();
	HBox hbBtn = new HBox(10);
	Label inputLabel = new Label("Enter a whole number");
	Label resultLabel = new Label("Result");
	Scene scene = new Scene(grid, 300, 275);
	Label resultText = new Label();
	TextField userInput = new TextField();
	String uiString = userInput.getText();
	int inputNum;

	public static void main(String[] args) {
		Application.launch(args);
	}
	public void start(Stage primaryStage) {
		//Title and window setup
		primaryStage.setTitle("Mustang Bronco GUI");
		primaryStage.setWidth(400);
		primaryStage.setHeight(400);

		// adding components to display
		grid.add(inputLabel, 0, 1);
		grid.add(userInput, 1, 1);
		grid.add(resultLabel, 0, 2);
		grid.add(resultText, 1, 2);
		grid.add(btn, 1, 4);
		grid.setAlignment(Pos.CENTER);
		grid.setHgap(10);
		grid.setVgap(10);
		grid.setPadding(new Insets(25, 25, 25, 25));
		
		//creating button handling
		btn.setOnAction(new ButtonHandler());

		primaryStage.setScene(scene);
		primaryStage.show();
	}
	private class ButtonHandler implements EventHandler<ActionEvent> {
		@Override
		public void handle(ActionEvent primaryStage) {
			//testing whether or not a valid input is given
			try {
				String text = userInput.getText();
				inputNum = Integer.parseInt(text);
				calculateMB(inputNum);
			}
			catch(Exception e)
			{
				resultText.setText("Enter a valid input");
			}
		}
	}
	public void calculateMB(int inputNum) {
		//internal logic
		String output = "";
		if (inputNum % 3 == 0) {
			output += "Mustang";
		}
		if (inputNum % 5 == 0) {
			output += "Bronco";
		}
		if (output == "") {
			output = Integer.toString(inputNum);
		}
		resultText.setText(output);
	}
}
