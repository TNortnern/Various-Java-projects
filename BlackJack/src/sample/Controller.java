package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;

import java.util.ArrayList;
import java.util.Scanner;

public class Controller {
    @FXML
    private TextField playerScore;
    @FXML
    private TextField cpuScore;
    @FXML
    private Button hitButton;
    @FXML
    private Button standButton;
    @FXML
    private HBox userCards;
    @FXML
    private HBox cpuCards;
    @FXML
    private Button shuffleButton;
    @FXML
    private Label roundMessage;
    @FXML
    private Button playAgainButton;
    @FXML
    private TextField userPointCount;
    @FXML
    private TextField cpuPointCount;

    private int playerRounds = 0;
    private int cpuRounds = 0;

    private ArrayList<String> cpuHand = new ArrayList();
    private ArrayList<String> userHand = new ArrayList();

    private Deck deck = new Deck();
    private Deck playerDeck = new Deck();
    private Deck cpuDeck = new Deck();


    private boolean roundOver = false;
    private boolean cpuStanding = false;
    public void startGame(ActionEvent actionEvent) {
        System.out.println("BlackJack");
        shuffleButton.setDisable(true);
        playAgainButton.setVisible(false);
        hitButton.setDisable(false);
        standButton.setDisable(false);
        deck.createDeck();
        deck.shuffle();
            playerDeck.draw(deck);
            playerDeck.draw(deck);

            cpuDeck.draw(deck);
            cpuDeck.draw(deck);
        userHand.add(playerDeck.getCard(0).toString().replaceAll("\\s+","") + ".png");
        userHand.add(playerDeck.getCard(1).toString().replaceAll("\\s+","") + ".png");
        for(int i = 0; i < userHand.size(); i++){
            System.out.println(userHand.get(i));
            ImageView userImgs = new ImageView(new Image(getClass().getResource("images/"+userHand.get(i)).toString(), true));
            userImgs.setFitWidth(35);
            userImgs.setFitHeight(70);
            userCards.getChildren().add(userImgs);
        }

            cpuHand.add(cpuDeck.getCard(0).toString().replaceAll("\\s+","") + ".png");
            cpuHand.add(cpuDeck.getCard(1).toString().replaceAll("\\s+","") + ".png");
            ImageView cpuImg = new ImageView(new Image(getClass().getResource("images/"+cpuHand.get(0)).toString(), true));
            cpuImg.setFitWidth(35);
            cpuImg.setFitHeight(70);
            ImageView hidden = new ImageView(new Image(getClass().getResource("images/b1fv.png").toString(), true));
            hidden.setFitWidth(35);
            hidden.setFitHeight(70);
            cpuCards.getChildren().addAll(cpuImg, hidden);

            System.out.println("Your hand: ");
            System.out.println(playerDeck.toString());
            System.out.println("Your hand is: " + playerDeck.cardsValue());
            System.out.println("Dealerhand is " + cpuDeck.cardsValue());
            System.out.println("Deal: " + cpuDeck.toString());



        check();
            playerScore.setText(String.valueOf(playerDeck.cardsValue()));

            check();





        }


    public void hit(ActionEvent actionEvent) {

        if(roundOver == false) {
            String img = deck.getCard(0).toString().replaceAll("\\s+","") + ".png";
            userHand.add(img);
            ImageView userImg = new ImageView(new Image(getClass().getResource("images/"+img).toString(), true));
            userImg.setFitWidth(35);
            userImg.setFitHeight(70);
            userCards.getChildren().add(userImg);
            playerDeck.draw(deck);


                playerScore.setText(String.valueOf(playerDeck.cardsValue()));
                check();



        }
        check();
    }



    // Check to see who won
    public void check(){
        userPointCount.setText(String.valueOf(playerRounds));
        cpuPointCount.setText(String.valueOf(cpuRounds));
        // checks to see if round is over
        if(roundOver == true){
            playAgainButton.setVisible(true);
            hitButton.setDisable(true);
            standButton.setDisable(true);
            cpuScore.setText(String.valueOf(cpuDeck.cardsValue()));
            // display cpu's items
            cpuCards.getChildren().clear();
            for(int i = 0; i < cpuHand.size(); i++){
                System.out.println(cpuHand.get(i));
                ImageView cpuImgs = new ImageView(new Image(getClass().getResource("images/"+cpuHand.get(i)).toString(), true));
                cpuImgs.setFitWidth(35);
                cpuImgs.setFitHeight(70);
                cpuCards.getChildren().add(cpuImgs);
            }
        }else {
            // unanimously win round if either player hits 21
            if (playerDeck.cardsValue() == 21) {
                roundOver = true;
                playerRounds++;
                System.out.println("You win!");
                roundMessage.setText("21! You win this round!");


            } else if (cpuDeck.cardsValue() == 21) {
                roundOver = true;
                cpuRounds++;
                roundMessage.setText("21! CPU wins this round!");


            } else if (cpuDeck.cardsValue() > 21) {
                roundOver = true;
                roundMessage.setText("CPU busts, You win!");

                playerRounds++;
            }
            else if (playerDeck.cardsValue() > 21) {
                roundOver = true;
                cpuRounds++;
                roundMessage.setText("You bust, CPU wins!");

            } else {
                if (cpuStanding == true) {
                    roundOver = true;
                    if (playerDeck.cardsValue() == 21 && cpuDeck.cardsValue() == 21) {
                        System.out.println("Push!");
                        roundMessage.setText("PUSH!");

                    }  else if (cpuDeck.cardsValue() > playerDeck.cardsValue() && cpuDeck.cardsValue() <= 20) {
                        System.out.println("CPU Wins!");
                        roundMessage.setText("CPU wins this round!");

                        cpuRounds++;
                    } else if (playerDeck.cardsValue() > cpuDeck.cardsValue() && playerDeck.cardsValue() <= 20) {
                        System.out.println("You win!");
                        roundMessage.setText("You win this round!");

                        playerRounds++;
                    } else if (playerDeck.cardsValue() == cpuDeck.cardsValue()) {
                        System.out.println("Push!");
                        roundMessage.setText("PUSH!");

                    }
                } // end of cpustanding if
            } // end of game logic else
        } // end of roundOver else
    } // end of check

    // Computer's turn
    public void cpu() {
        double percentage = 0;
        ImageView hidden = new ImageView(new Image(getClass().getResource("images/b1fv.png").toString(), true));
        hidden.setFitWidth(35);
        hidden.setFitHeight(70);
        check();
        if (roundOver == false) {

            while (cpuDeck.cardsValue() < 21) {
                if (cpuDeck.cardsValue() <= 11) {
                    cpuHand.add(deck.getCard(0).toString().replaceAll("\\s+","") + ".png");
                    cpuCards.getChildren().add(hidden);
                    cpuDeck.draw(deck);

                    check();
                } else if (cpuDeck.cardsValue() > 11 && cpuDeck.cardsValue() < 18) {
                    percentage = Math.random() * 49 + 1;
                    System.out.println(percentage);
                    if (percentage > 15) {
                        cpuHand.add(deck.getCard(0).toString().replaceAll("\\s+","") + ".png");
                        cpuCards.getChildren().add(hidden);
                        cpuDeck.draw(deck);

                        check();
                        break;
                    }
                } else if (cpuDeck.cardsValue() >= 18) {
                    cpuStanding = true;
                    break;
                }


            }

        } // end of if

        cpuStanding = true;

        check();

    } // end of cpu

    // if user clicks stand
    public void stand(ActionEvent actionEvent) {
        cpu();
        }

        // reset everything
    public void playAgain(ActionEvent actionEvent) {
        playerScore.setText("");
        cpuScore.setText("");
        roundMessage.setText("");
        userCards.getChildren().clear();
        cpuCards.getChildren().clear();
        userHand.clear();
        cpuHand.clear();
        playerDeck.clearDeck();
        cpuDeck.clearDeck();
        roundOver = false;
        cpuStanding = false;
        shuffleButton.setDisable(false);
        playAgainButton.setVisible(false);
    }
}







