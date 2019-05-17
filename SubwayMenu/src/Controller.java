import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.text.*;
import javafx.scene.image.*;
import javafx.stage.*;
import java.util.*;
import javafx.geometry.Pos;

public class Controller {
    static String breadType, cheeseType, meatType, sauceType, order;
    static double total = 0;
    static ArrayList<String> veggies = new ArrayList<>(), seasoning = new ArrayList<>();
    
    @FXML
    TextField sizeSelected;
    @FXML
    TextField breadSelected;
    @FXML
    TextField meatSelected;
    @FXML
    TextField cheeseSelected;
    @FXML
    TextField veggiesSelected;
    @FXML
    TextField sauceSelected;
    @FXML
    TextField seasoningSelected;
    @FXML
    TextField Ticket;
    @FXML
    TextField MeatTicket;
    @FXML
    TextField CheeseTicket;
    @FXML
    TextField VeggieTicket;
    @FXML
    TextField SauceTicket;
    @FXML
    TextField SeasoningTicket;
    @FXML
    TextField Price;
    
    public static void tutorial() {
        Stage popupwindow = new Stage();
        popupwindow.initModality(Modality.APPLICATION_MODAL);
        popupwindow.setTitle("Please Watch And Learn!");
        
        VBox pain = new VBox();
        pain.setAlignment(Pos.CENTER);
        pain.setSpacing(50);
        Text helpText = new Text("Select your options for your sandwich.\nClick \"none\" on options you don't want.");
        helpText.setFont(Font.font("Times New Roman", FontWeight.BOLD, 20));
        
        ImageView clip = new ImageView("imgs/tutorial.gif");
        clip.setFitHeight(600);
        clip.setFitWidth(600);
        
        Button agree = new Button("OK");

        agree.setOnAction(e -> {
            popupwindow.close();
        });
        
        pain.getChildren().addAll(helpText, clip, agree);
        
        Scene scene1= new Scene(pain, 700, 800);
        popupwindow.setScene(scene1);
        popupwindow.showAndWait();
    }
    
    public void displaySize(javafx.event.ActionEvent actionEvent) {
        if(sizeSelected.getText().equals("")){
            addSize();
        } else {
           Alert alreadySelected = new Alert(Alert.AlertType.WARNING, "Do you want to change your size?", ButtonType.YES, ButtonType.NO);

           Optional<ButtonType> result = alreadySelected.showAndWait();
           
           ButtonType button = result.orElse(ButtonType.NO);

           if (button == ButtonType.YES) {
              addSize();
           } else {
               System.out.println("canceled");
           }
       }
    }
    
    public void addSize() {
        ChoiceBox<String> size = new ChoiceBox();
        size.getItems().addAll("S", "M", "L", "XL", "XXL");
        
        if (sizeSelected.getText() != null && !sizeSelected.getText().equals("")) {
            size.setValue(sizeSelected.getText());
        } else {
            size.setValue("S");
        }
        
        VBox sizeBox = new VBox(10);
        
        Stage popupwindow = new Stage();
        popupwindow.initModality(Modality.APPLICATION_MODAL);
        popupwindow.setTitle("Select your size");
        
        Text sizeTitle = new Text("Select your size");
        Button sizeDone = new Button("Done");

        sizeDone.setOnAction(e -> {
            sizeSelected.setText(size.getValue());
            getPrice();
            
            popupwindow.close();
        });
        
        sizeBox.getChildren().addAll(sizeTitle, size, sizeDone);
        
        Scene scene1= new Scene(sizeBox, 300, 250);
        popupwindow.setScene(scene1);
        popupwindow.showAndWait();
    }

    public void displayBread(javafx.event.ActionEvent actionEvent) {
        if(breadSelected.getText().equals("")){
            addBread();
        } else {
           Alert alreadySelected = new Alert(Alert.AlertType.WARNING, "Do you want to change your bread?", ButtonType.YES, ButtonType.NO);

           Optional<ButtonType> result = alreadySelected.showAndWait();
           ButtonType button = result.orElse(ButtonType.NO);

           if (button == ButtonType.YES) {
              addBread();
           } else {
               System.out.println("canceled");
           }
       }
    }
    
    public void addBread() {
        HBox breadToggleButtons = new HBox(5);
        
        VBox breadBox = new VBox(10);
        
        Stage popupwindow = new Stage();
        popupwindow.initModality(Modality.APPLICATION_MODAL);
        popupwindow.setTitle("Select your bread");
        
        Text breadText = new Text("Select your bread type");
        
        ToggleGroup breadToggle = new ToggleGroup();
        
        RadioButton white = new RadioButton("White");
        white.setToggleGroup(breadToggle);
        RadioButton wheat = new RadioButton("Wheat");
        wheat.setToggleGroup(breadToggle);
        RadioButton toasted = new RadioButton("Toasted");
        toasted.setToggleGroup(breadToggle);
        
        breadToggleButtons.getChildren().addAll(white,wheat,toasted);
        
        if (breadType == null) {
            white.setSelected(true);
        } else {
             if (breadType == "White") {
                 white.setSelected(true);
             } else if (breadType == "Wheat") {
                 wheat.setSelected(true);
             } else if (breadType == "Toasted") {
                 toasted.setSelected(true);
             }
        }
        
        Button breadDone = new Button("Done");

        breadDone.setOnAction(e -> {
            RadioButton temp = (RadioButton)breadToggle.getSelectedToggle();
            breadType = temp.getText();
            breadSelected.setText(breadType);
            getPrice();
            
            popupwindow.close();
        });
        
        breadBox.getChildren().addAll(breadText, breadToggleButtons, breadDone);
        
        Scene scene1 = new Scene(breadBox, 300, 250);
        popupwindow.setScene(scene1);
        popupwindow.showAndWait();
    }

    public void displayMeat(javafx.event.ActionEvent actionEvent) {
        if(meatSelected.getText().equals("")){
            addMeat();
        } else {
           Alert alreadySelected = new Alert(Alert.AlertType.WARNING, "Do you want to change your meat?", ButtonType.YES, ButtonType.NO);

           Optional<ButtonType> result = alreadySelected.showAndWait();
           ButtonType button = result.orElse(ButtonType.NO);

           if (button == ButtonType.YES) {
              addMeat();
           } else {
               System.out.println("canceled");
           }
       }
    }
    
    public void addMeat() {
        HBox meatToggleButtons = new HBox(5);
        
        VBox meatBox = new VBox(10);
        
        Stage popupwindow=new Stage();
        popupwindow.initModality(Modality.APPLICATION_MODAL);
        popupwindow.setTitle("Select your meat");
        
        Text meatText = new Text("Select your meat type");
        
        ToggleGroup meatToggle = new ToggleGroup();
        
        RadioButton none = new RadioButton("None");
        none.setToggleGroup(meatToggle);
        RadioButton chicken = new RadioButton("Chicken");
        chicken.setToggleGroup(meatToggle);
        RadioButton bologna = new RadioButton("Bologna");
        bologna.setToggleGroup(meatToggle);
        RadioButton ham = new RadioButton("Ham");
        ham.setToggleGroup(meatToggle);
        RadioButton turkey = new RadioButton("Turkey");
        turkey.setToggleGroup(meatToggle);
        
        meatToggleButtons.getChildren().addAll(none, chicken, bologna, ham, turkey);
        
        if (meatSelected.getText().equals("") || meatSelected.getText().equals("None")) {
            none.setSelected(true);
        } else {
            if (meatSelected.getText().equals("Chicken")) {
                chicken.setSelected(true);
            } else if (meatSelected.getText().equals("Bologna")) {
                bologna.setSelected(true);
            } else if (meatSelected.getText().equals("Ham")) {
                ham.setSelected(true);
            } else if (meatSelected.getText().equals("Turkey")) {
                turkey.setSelected(true);
            }
        }
        
        Button meatDone = new Button("Done");

        meatDone.setOnAction(e -> {
            RadioButton temp = (RadioButton)meatToggle.getSelectedToggle();
            meatType = temp.getText();
            meatSelected.setText(meatType);
            getPrice();
            
            popupwindow.close();
        });
        
        meatBox.getChildren().addAll(meatText, meatToggleButtons, meatDone);
        
        Scene scene1= new Scene(meatBox, 300, 250);
        popupwindow.setScene(scene1);
        popupwindow.showAndWait();
    }

    public void displaycheese(javafx.event.ActionEvent actionEvent) {
        if(cheeseSelected.getText().equals("")){
            addCheese();
        } else {
           Alert alreadySelected = new Alert(Alert.AlertType.WARNING, "Do you want to change your cheese?", ButtonType.YES, ButtonType.NO);

           Optional<ButtonType> result = alreadySelected.showAndWait();
           ButtonType button = result.orElse(ButtonType.NO);

           if (button == ButtonType.YES) {
              addCheese();
           } else {
               System.out.println("canceled");
           }
       }
    }
    
    public void addCheese() {
        HBox cheeseToggleButtons = new HBox(5);
        
        VBox cheeseBox = new VBox(10);
        
        Stage popupwindow=new Stage();
        popupwindow.initModality(Modality.APPLICATION_MODAL);
        popupwindow.setTitle("Select your cheese");
        
        Text cheeseText = new Text("Select your cheese type");
        
        ToggleGroup cheeseToggle = new ToggleGroup();
        
        RadioButton none = new RadioButton("None");
        none.setToggleGroup(cheeseToggle);
        RadioButton American = new RadioButton("American");
        American.setToggleGroup(cheeseToggle);
        RadioButton spicy = new RadioButton("Spicy");
        spicy.setToggleGroup(cheeseToggle);
        RadioButton BBQ = new RadioButton("BBQ");
        BBQ.setToggleGroup(cheeseToggle);
        RadioButton pepper_jack = new RadioButton("Pepper Jack");
        pepper_jack.setToggleGroup(cheeseToggle);
        
        cheeseToggleButtons.getChildren().addAll(none, American, spicy, BBQ, pepper_jack);
        
        if (cheeseSelected.getText().equals("") || cheeseSelected.getText().equals("None")) {
             none.setSelected(true);
        } else {
            if (cheeseSelected.getText().equals("American")) {
                 American.setSelected(true);
             } else if (cheeseSelected.getText().equals("Spicy")) {
                 spicy.setSelected(true);
             } else if (cheeseSelected.getText().equals("BBQ")) {
                 BBQ.setSelected(true);
             } else if (cheeseSelected.getText().equals("Pepper Jack")) {
                 pepper_jack.setSelected(true);
             }
        }
        
        Button cheeseDone = new Button("Done");

        cheeseDone.setOnAction( e-> {
            RadioButton temp = (RadioButton)cheeseToggle.getSelectedToggle();
            cheeseType = temp.getText();
            cheeseSelected.setText(cheeseType);
            getPrice();
            
            popupwindow.close();
        });
        
        cheeseBox.getChildren().addAll(cheeseText, cheeseToggleButtons, cheeseDone);
        
        Scene scene1= new Scene(cheeseBox, 300, 250);
        popupwindow.setScene(scene1);
        popupwindow.showAndWait();
    }

    public void displayVeggies(ActionEvent actionEvent){
        if(veggiesSelected.getText().equals("")){
            addVeggies();
        } else {
           Alert alreadySelected = new Alert(Alert.AlertType.WARNING, "Do you want to change your veggies?", ButtonType.YES, ButtonType.NO);

           Optional<ButtonType> result = alreadySelected.showAndWait();
           ButtonType button = result.orElse(ButtonType.NO);

           if (button == ButtonType.YES) {
              addVeggies();
           } else {
               System.out.println("canceled");
           }
       }
    }

    public void addVeggies(){
        Stage popupwindow = new Stage();
        popupwindow.initModality(Modality.APPLICATION_MODAL);
        popupwindow.setTitle("Select your veggies");
        
        VBox veggieHolder = new VBox(5);
        
        Label v1Label = new Label("Veggie1");
        Label v2Label = new Label("Veggie2");
        Label v3Label = new Label("Veggie3");
        
        ChoiceBox<String> veggie1 = new ChoiceBox<>();
        ChoiceBox<String> veggie2 = new ChoiceBox<>();
        ChoiceBox<String> veggie3 = new ChoiceBox<>();

        VBox main = new VBox(5);

        for(int i = 0; i < 3; i++ ){
            veggies.add("None");
        }
        
        veggie1.getItems().addAll( "None","Lettuce", "Tomatoes", "Broccoli", "Onions");
        veggie2.getItems().addAll( "None","Lettuce", "Tomatoes", "Broccoli", "Onions");
        veggie3.getItems().addAll( "None","Lettuce", "Tomatoes", "Broccoli", "Onions");
        
        veggie1.setValue(veggies.get(0));
        veggie2.setValue(veggies.get(1));
        veggie3.setValue(veggies.get(2));
        
        veggieHolder.getChildren().addAll(new Label("Choose up to 3 vegetable types"),v1Label, veggie1);
        
        if (veggies.get(1).toString() != "None") {
            veggieHolder.getChildren().addAll(v2Label, veggie2, v3Label, veggie3);
        } else if (veggies.get(0).toString() != "None") {
            veggieHolder.getChildren().addAll(v2Label, veggie2);
            
            veggie2.setOnAction(e -> {
                checkVeggies(veggie1.getValue(), veggie2.getValue(), veggie3.getValue());
                addVeggies();
                
                popupwindow.close();
            });
        } else {
            veggie1.setOnAction(e -> {
                checkVeggies(veggie1.getValue(), veggie2.getValue(), veggie3.getValue());
                addVeggies();
                
                popupwindow.close();
            });
        }

        Button veggieDone = new Button("Done");
        
        veggieDone.setOnAction(e -> {
            checkVeggies(veggie1.getValue(), veggie2.getValue(), veggie3.getValue());
            
            veggiesSelected.setText("");
            
            for(int i = 0; i < veggies.size(); i++) {
                //System.out.println("Veggies: " + veggies.get(i));
                veggiesSelected.appendText(veggies.get(i) + " ");
            }
            
            getPrice();
            
            popupwindow.close();
        });
        
        main.getChildren().addAll(veggieHolder, veggieDone);

        Scene scene1= new Scene(main, 300, 250);
        popupwindow.setScene(scene1);
        popupwindow.showAndWait();
    }
    
    private void checkVeggies(String veggie1, String veggie2, String veggie3) {
        veggies.clear();
            
        if (veggies.size() < 3) {
            if (veggie1 != "None") {
                veggies.add(veggie1);
            }
            
            if (!veggie2.equals("None")) {
                veggies.add(veggie2);
            }
            
            if (!veggie3.equals("None")) {
                veggies.add(veggie3);
            }
        }
        
        if (veggies.size() == 0) {
            veggies.add("None");
        }
    }
    
    public void displaySauce(javafx.event.ActionEvent actionEvent) {
        if(sauceSelected.getText().equals("")){
            addSauce();
        } else {
           Alert alreadySelected = new Alert(Alert.AlertType.WARNING, "Do you want to change your sauce?", ButtonType.YES, ButtonType.NO);

           Optional<ButtonType> result = alreadySelected.showAndWait();
           ButtonType button = result.orElse(ButtonType.NO);

           if (button == ButtonType.YES) {
              addSauce();
           } else {
               System.out.println("canceled");
           }
       }
    }
    
    public void addSauce() {
        HBox sauceToggleButtons = new HBox(5);
        
        VBox sauceBox = new VBox(10);
        
        Stage popupwindow = new Stage();
        popupwindow.initModality(Modality.APPLICATION_MODAL);
        popupwindow.setTitle("Select your sauce");
        
        Text sauceText = new Text("Select your sauce type");
        
        ToggleGroup sauceToggle = new ToggleGroup();
        
        RadioButton none = new RadioButton("None");
        none.setToggleGroup(sauceToggle);
        RadioButton tomato = new RadioButton("Tomato");
        tomato.setToggleGroup(sauceToggle);
        RadioButton garlic = new RadioButton("Garlic");
        garlic.setToggleGroup(sauceToggle);
        RadioButton hot = new RadioButton("Hot");
        hot.setToggleGroup(sauceToggle);
        
        sauceToggleButtons.getChildren().addAll(none, tomato, garlic, hot);
        
        Button sauceDone = new Button("Done");
        
        sauceDone.setOnAction(e -> {
            RadioButton temp = (RadioButton)sauceToggle.getSelectedToggle();
            sauceType = temp.getText();
            sauceSelected.setText(sauceType);
            getPrice();
            
            popupwindow.close();
        });
        
        if (sauceSelected.getText().equals("") || sauceSelected.getText().equals("None")) {
            none.setSelected(true);
        } else {
            if (sauceSelected.getText().equals("Tomato")) {
                 tomato.setSelected(true);
             } else if (sauceSelected.getText().equals("Garlic")) {
                 garlic.setSelected(true);
             } else if (sauceSelected.getText().equals("Hot")) {
                 hot.setSelected(true);
             }
        }
        
        sauceBox.getChildren().addAll(sauceText, sauceToggleButtons, sauceDone);
        
        Scene scene1= new Scene(sauceBox, 300, 250);
        popupwindow.setScene(scene1);
        popupwindow.showAndWait();
    }

    public void displaySeasoning(ActionEvent actionEvent){
        if(seasoningSelected.getText().equals("")){
            addSeasoning();
        } else{
            Alert alreadySelected = new Alert(Alert.AlertType.WARNING, "Do you want to change your seasoning?", ButtonType.YES, ButtonType.NO);

            Optional<ButtonType> result = alreadySelected.showAndWait();
            ButtonType button = result.orElse(ButtonType.NO);

            if (button == ButtonType.YES) {
                addSeasoning();
            } else {
                System.out.println("canceled");
            }
        }
    }

    public void addSeasoning(){
        Stage popupwindow=new Stage();
        popupwindow.initModality(Modality.APPLICATION_MODAL);
        popupwindow.setTitle("Select your seasoning");
        
        VBox seasonHolder = new VBox(5);
        
        Label v1Label = new Label("season1");
        Label v2Label = new Label("season2");

        ChoiceBox<String> season1 = new ChoiceBox<>();
        ChoiceBox<String> season2 = new ChoiceBox<>();

        VBox main = new VBox(5);
        
        for(int i = 0; i < 2; i++ ){
            seasoning.add("None");
        }

        season1.getItems().addAll("None", "Salt", "Pepper", "Oil", "Vinegar");
        season2.getItems().addAll("None", "Salt", "Pepper", "Oil", "Vinegar");
        
        season1.setValue(seasoning.get(0));
        season2.setValue(seasoning.get(1));

        seasonHolder.getChildren().addAll(new Label("Choose your seasoning"),v1Label, season1, v2Label, season2);

        Button seasonDone = new Button("Done");
        
        seasonDone.setOnAction(e-> {
            seasoning.clear();
            
            if (seasoning.size() < 3) {
                if (season1.getValue() != "None") {
                    seasoning.add(season1.getValue());
                }
                
                if (!season2.getValue().equals("None")) {
                    seasoning.add(season2.getValue());
                }
                
                if (seasoning.size() == 0) {
                    seasoning.add("None");
                }
            }

            seasoningSelected.clear();
            
            for (int i = 0; i < seasoning.size(); i++) {
                //if (seasoning.get(i).toString() != "None" && i != 0) {
                    seasoningSelected.appendText(seasoning.get(i).toString() + " ");
                //}
            }
            
            getPrice();
            
            popupwindow.close();
        });
        
        main.getChildren().addAll(seasonHolder, seasonDone);

        Scene scene1= new Scene(main, 300, 250);
        popupwindow.setScene(scene1);
        popupwindow.showAndWait();
    }
    
    public void getPrice() {
        if (sizeSelected.getText().equals("") == false && breadSelected.getText().equals("") == false && meatSelected.getText().equals("") == false && cheeseSelected.getText().equals("") == false && veggiesSelected.getText().equals("") == false && sauceSelected.getText().equals("") == false && seasoningSelected.getText().equals("") == false) {
            setPrice();
            
            order = "You ordered a " + sizeSelected.getText() + " " + breadSelected.getText() + " sub.";
            Ticket.setText(order);
            
            order = "Meat: " + meatSelected.getText();
            MeatTicket.setText(order);
            
            order = "Cheese: " + cheeseSelected.getText();
            CheeseTicket.setText(order);
            
            
            if (veggiesSelected.getText().equals("None") == false) {
                order = "Veggies: " + veggies.get(0);
                
                for (int i = 1; i < veggies.size(); i++) {
                    if (order.contains(veggies.get(i))) {
                        order = order.replace(veggies.get(i), "extra " + veggies.get(i));
                    } else {
                        if (veggies.get(i) != "None") {
                            order += ", " + veggies.get(i);
                        }
                    }
                }
            } else {
                order = "Veggies: " + veggiesSelected.getText();
            }
            
            VeggieTicket.setText(order);
            
            order = "Sauce: " + sauceSelected.getText();
            SauceTicket.setText(order);
            
            if (seasoningSelected.getText().equals("None ") == false) {
                order = "Seasoning: " + seasoning.get(0);
                
                for (int i = 1; i < seasoning.size(); i++) {
                    if (order.contains(seasoning.get(i))) {
                        order = order.replace(seasoning.get(i), "extra " + seasoning.get(i));
                    } else {
                        if (seasoning.get(i) != "None") {
                            order += ", " + seasoning.get(i);
                        }
                    }
                }       
            } else {
                order = "Seasoning: " + seasoningSelected.getText();
            }
            
            SeasoningTicket.setText(order);
        }
    }
    
    public void setPrice() {
        if (sizeSelected.getText().equals("S")) {
            total = 1.99;
        } else if (sizeSelected.getText().equals("M")) {
            total = 2.99;
        } else if (sizeSelected.getText().equals("L")) {
            total = 4.99;
        } else if (sizeSelected.getText().equals("XL")) {
            total = 6.99;
        } else if (sizeSelected.getText().equals("XXL")) {
            total = 8.99;
        }
        
        Price.setText("Total: $" + total);
    }
}