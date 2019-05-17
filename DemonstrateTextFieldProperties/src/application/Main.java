package application;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;


public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
			//Parent Pane
			BorderPane root = new BorderPane();
			//Set Hbox fot the top textField
			HBox top = new HBox(20);
			//Parent HBox for radiobuttons and colsetter textField
			HBox bottom = new HBox(10);
			// HBox for radio Buttons
			HBox buttons = new HBox(10);
			//HBox for column setting text field
			HBox colSets = new HBox(5);
			// Text field that will be adjusted
			TextField midText = new TextField();
			// Column setting text field
			TextField brText = new TextField();
			// Making column big enough to align the default text
			midText.setPrefColumnCount(15);
			// just initializing the text box
			midText.setText("Set this text to something");
			brText.setPrefColumnCount(2);
			brText.setText(Integer.toString(midText.getPrefColumnCount()));
			// Creation of buttons
			RadioButton center = new RadioButton();
			RadioButton left = new RadioButton();
			RadioButton right = new RadioButton();
			ToggleGroup toggleAlign = new ToggleGroup();
			// Assigning all buttons to the same togglegroup
			center.setToggleGroup(toggleAlign);
			left.setToggleGroup(toggleAlign);
			right.setToggleGroup(toggleAlign);
			// add label and textfield to top HBox
			top.getChildren().addAll(new Label("Text Field"), midText);
			// add buttons to bottom HBox
			buttons.getChildren().addAll(new Label("Left"),left,new Label("Center"),center,new Label("Right"),right);
			// adding column setting textbox to bottom HBox
			colSets.getChildren().addAll(new Label("Column Size"), brText);
			bottom.getChildren().addAll(buttons,colSets);
			// VBox to keep the Hbox's directly vertical of each other
			VBox v = new VBox(10);
			v.getChildren().addAll(top, bottom);
			// Adding everything to the parent
			root.setCenter(v);
			// When left is clicked
			left.setOnAction(e ->{
				midText.setAlignment(Pos.CENTER_LEFT);
			});
			// When center is clicked
			center.setOnAction(e ->{
				midText.setAlignment(Pos.CENTER);
			});
			// When right is clicked
			right.setOnAction(e ->{
				midText.setAlignment(Pos.CENTER_RIGHT);
			});
			// When the value is typed and entered in the column setting textbox
			brText.setOnAction( e ->{
				midText.setPrefColumnCount(Integer.parseInt(brText.getText()));
			});


			Scene scene = new Scene(root,350,75);
			primaryStage.setTitle("Exercise16_6");
			primaryStage.setScene(scene);
			primaryStage.show();


	}

	public static void main(String[] args) {
		launch(args);
	}
}
