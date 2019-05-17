package application;

import java.text.DecimalFormat;
import java.util.Scanner;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		// Parent of all of the layout
		BorderPane root = new BorderPane();

		// aligning each table layout horizontally
		HBox tableLayout = new HBox(5);

		//parent for table
		BorderPane table = new BorderPane();

		// makes loan textfield to take input
		TextField loan = new TextField();
		loan.setPrefColumnCount(8);
		HBox loanBox = new HBox(new Label("Loan Amount"), loan);
		loanBox.setSpacing(15);

		// makes number of years textfield to take input
		TextField years = new TextField();
		years.setPrefColumnCount(2);
		HBox yearBox = new HBox(new Label("Number of Years:"), years);
		yearBox.setSpacing(15);

		// Parsing inputted years value from string to int
		years.setOnAction(e -> {

			Integer.parseInt(years.getText());

		});
		// Button that will display the table
		Button tableShow = new Button("Show Table");
		// Parent for the two textfields and button
		HBox entryHolder = new HBox(10);
		entryHolder.getChildren().addAll(loanBox, yearBox, tableShow);

		// Creation of columns in the table
		VBox interestBox = new VBox(5);
		VBox monthlyBox = new VBox(5);
		VBox totalBox = new VBox(5);

		// When Show Table button is clicked
		tableShow.setOnAction(e -> {
			// Column Title creation
			Text interestText = new Text("Interest Rate");
			Text montlyText = new Text("Montly Payment");
			Text totalText = new Text("Total Amount");
			interestBox.getChildren().add(interestText);
			monthlyBox.getChildren().add(montlyText);
			totalBox.getChildren().add(totalText);
			// Defining interest rate as i and incrementing by .125
			// This also handles creating the data in each column
			for (double i = 5; i <= 8; i += .125) {
				Text interestRate = new Text();
				Text monthlyPay = new Text();
				Text totalPay = new Text();
				// Interest Rate Data
				interestRate.setText(Double.toString(i));

				// Monthly Pay Data
				monthlyPay.setText(Double.toString(
						Double.parseDouble(new DecimalFormat("0.00").format(Double.parseDouble(loan.getText()) * i/1200 / (1 - 1 / Math.pow(1 + i/1200, Integer.parseInt(years.getText()) * 12))))

						));

				// Total Pay Data
				totalPay.setText(Double.toString(
						Double.parseDouble(new DecimalFormat("0.00").format(Double.parseDouble(monthlyPay.getText()) * Integer.parseInt(years.getText()) * 12))

				));

				// Adding the three columns of the table
				interestBox.getChildren().add(interestRate);
				monthlyBox.getChildren().add(monthlyPay);
				totalBox.getChildren().add(totalPay);
			}

		});
		// Parent for table items
		tableLayout.getChildren().addAll(interestBox, monthlyBox, totalBox);

		// Parent for the table
		table.setCenter(tableLayout);

		// Connects the textfield/button with the table
		VBox connector = new VBox(5);
		connector.getChildren().addAll(entryHolder, table);
		root.setTop(connector);


		Scene scene = new Scene(root, 450, 600);
		primaryStage.setScene(scene);
		primaryStage.show();

	}

	public static void main(String[] args) {
		launch(args);
	}
}
