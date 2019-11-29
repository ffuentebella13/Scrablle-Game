package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.control.Button;
import java.awt.*;
import java.util.Arrays;
import javafx.scene.control.Label;

import javax.swing.*;

public class Controller {
    @FXML
    TextField A,B,C,D,E,F,G,H,I,J,K,L,M,N,O,P,Q,R,S,T,U,V,W,X,Y,Z; // letter bag
    @FXML
    TextField s_words; // input type for the words
    @FXML
    Label s_found,score; // score

    int ctr = 0;//ctr for the looping of found fords

    int scoring = 0 , errorCount = 0,totalWords; // initialize counters

    String allWords, letterReamining,words; // variables for found words

    int letterCount; // letter bags
    int vowelCount = 0;
    int countNumberOfWords;

    //new game
    @FXML
    private void newGame(ActionEvent event) {
        JOptionPane.showMessageDialog(null, "New Game has begun!", "New Game!", JOptionPane.INFORMATION_MESSAGE);
        allWords = null;
        scoring = 0;
        countNumberOfWords = 0;
        totalWords = 0;
        errorCount = 0;
        score.setText(String.valueOf(scoring)); // clear
        s_words.setText(""); // clear
        s_found.setText("");// clear



        A.setText(String.valueOf(9)); //innitiate again if new game is pressed
        B.setText(String.valueOf(2)); //innitiate again if new game is pressed
        C.setText(String.valueOf(2)); //innitiate again if new game is pressed
        D.setText(String.valueOf(4)); //innitiate again if new game is pressed
        E.setText(String.valueOf(12)); //innitiate again if new game is pressed
        F.setText(String.valueOf(4)); //innitiate again if new game is pressed
        G.setText(String.valueOf(3)); //innitiate again if new game is pressed
        H.setText(String.valueOf(4)); //innitiate again if new game is pressed
        I.setText(String.valueOf(4)); //innitiate again if new game is pressed
        J.setText(String.valueOf(1)); //innitiate again if new game is pressed
        K.setText(String.valueOf(1)); //innitiate again if new game is pressed
        L.setText(String.valueOf(4)); //innitiate again if new game is pressed
        M.setText(String.valueOf(2)); //innitiate again if new game is pressed
        N.setText(String.valueOf(6)); //innitiate again if new game is pressed
        O.setText(String.valueOf(8)); //innitiate again if new game is pressed
        P.setText(String.valueOf(2)); //innitiate again if new game is pressed
        Q.setText(String.valueOf(1)); //innitiate again if new game is pressed
        R.setText(String.valueOf(6)); //innitiate again if new game is pressed
        S.setText(String.valueOf(4)); //innitiate again if new game is pressed
        T.setText(String.valueOf(6)); //innitiate again if new game is pressed
        U.setText(String.valueOf(2)); //innitiate again if new game is pressed
        V.setText(String.valueOf(2)); //innitiate again if new game is pressed
        W.setText(String.valueOf(1)); //innitiate again if new game is pressed
        X.setText(String.valueOf(1)); //innitiate again if new game is pressed
        Y.setText(String.valueOf(2)); //innitiate again if new game is pressed
        Z.setText(String.valueOf(1)); //innitiate again if new game is pressed

        new Controller();
    }
    //Exit game
    @FXML
    private void quit(ActionEvent event) {

        JOptionPane.showMessageDialog(null, "Game has Ended!\n\n Your Score is: "+scoring, "Quit", JOptionPane.INFORMATION_MESSAGE);
        System.exit(0);
    }


    //button clicker
    @FXML
    private void letter(ActionEvent event) {
        Button button = (Button)(event.getSource()) ;
        String buttonValue = button.getText(); // get the button value
        s_words.setText( s_words.getText() + buttonValue   ); // display the click letters in input type
        //checking if there are still vowels

    }

    @FXML
    private void submit(ActionEvent event) {

        words = s_words.getText();//get the words from inout type
        ctr++;//increment ctr
        char letter;//storing of letters

        Model wordsAdded = new Model(words,ctr);//constructor in model

        String [] finalResult = wordsAdded.getFoundWords(); // stor everything in array


        int wordsLength = s_words.getText().length();//get length

        for (int i = 0; i < wordsLength; i++) {
            letter = s_words.getText().charAt(i);//checking each letter
            if (letter == 'a' || letter == 'e' || letter == 'i' || letter == 'o' || letter == 'u' || letter == 'A' || letter == 'E' || letter == 'I' || letter == 'O' || letter == 'U') {
                //Increments the vowel counter
                vowelCount++;//increment if there is vowel
            }

        }

        if(wordsLength>1 && wordsLength<=8 &&  vowelCount >0) {//looping only if words is more than 1 char and less than 9 letters
            for (int i = 0; i < wordsLength; i++) {//loop for check all the letter in the formed words
                letter = s_words.getText().charAt(i);//checking each letter

                //filter letter bag
                if (letter == 'A' || letter == 'a') {
                    letterCount = Integer.parseInt(A.getText());//get value of letter

                    Model letterBag = new Model(letterCount,vowelCount); //pass letter count to constructor

                    letterReamining = letterBag.getResult(); // get the result of letter decrement from model

                    if (Integer.parseInt(letterReamining) <0) { // error count
                        errorCount++;
                        s_words.setText("");
                        JOptionPane.showMessageDialog(null, "Sorry you dont have ' " + letter + " ' Left!", "Sorry!", JOptionPane.INFORMATION_MESSAGE);
                    } else {
                        A.setText(String.valueOf(letterReamining)); // it passed the condition
                    }
                } else if (letter == 'B' || letter == 'b') {

                    letterCount = Integer.parseInt(B.getText());//get value of letter

                    Model letterBag = new Model(letterCount,vowelCount); //pass letter count to constructor

                    letterReamining = letterBag.getResult(); // get the result of letter decrement from model

                    if (Integer.parseInt(letterReamining) <0) { // error count
                        errorCount++;
                        s_words.setText("");
                        JOptionPane.showMessageDialog(null, "Sorry you dont have ' " + letter + " ' Left!", "Sorry!", JOptionPane.INFORMATION_MESSAGE);
                    } else {
                        B.setText(String.valueOf(letterReamining)); // it passed the condition
                    }
                }
                else if (letter == 'C' || letter == 'c') {
                    letterCount = Integer.parseInt(C.getText());//get value of letter
                    Model letterBag = new Model(letterCount,vowelCount); //pass letter count to constructor

                    letterReamining = letterBag.getResult(); // get the result of letter decrement from model

                    if (Integer.parseInt(letterReamining) <0) { // error count
                        errorCount++;
                        s_words.setText("");
                        JOptionPane.showMessageDialog(null, "Sorry you dont have ' " + letter + " ' Left!", "Sorry!", JOptionPane.INFORMATION_MESSAGE);
                    } else {
                        C.setText(String.valueOf(letterReamining)); // it passed the condition
                    }
                }
                else if (letter == 'D' || letter == 'd') {

                    letterCount = Integer.parseInt(D.getText());//get value of letter
                    Model letterBag = new Model(letterCount,vowelCount); //pass letter count to constructor

                    letterReamining = letterBag.getResult(); // get the result of letter decrement from model

                    if (Integer.parseInt(letterReamining) <0) { // error count
                        errorCount++;
                        s_words.setText("");
                        JOptionPane.showMessageDialog(null, "Sorry you dont have ' " + letter + " ' Left!", "Sorry!", JOptionPane.INFORMATION_MESSAGE);
                    } else {
                        D.setText(String.valueOf(letterReamining)); // it passed the condition
                    }
                }
                //LETTER E
                else if (letter == 'E' || letter == 'e') {

                    letterCount = Integer.parseInt(E.getText());//get value of letter
                    Model letterBag = new Model(letterCount,vowelCount); //pass letter count to constructor
                    letterReamining = letterBag.getResult(); // get the result of letter decrement from model

                    if (Integer.parseInt(letterReamining) <0) { // error count
                        errorCount++;
                        s_words.setText("");
                        JOptionPane.showMessageDialog(null, "Sorry you dont have ' " + letter + " ' Left!", "Sorry!", JOptionPane.INFORMATION_MESSAGE);
                    } else {
                        E.setText(String.valueOf(letterReamining)); // it passed the condition
                    }
                }
                //LETTER F
                else if (letter == 'F' || letter == 'f') {

                    letterCount = Integer.parseInt(F.getText());//get value of letter
                    Model letterBag = new Model(letterCount,vowelCount); //pass letter count to constructor

                    letterReamining = letterBag.getResult(); // get the result of letter decrement from model

                    if (Integer.parseInt(letterReamining) <0) { // error count
                        errorCount++;
                        s_words.setText("");
                        JOptionPane.showMessageDialog(null, "Sorry you dont have ' " + letter + " ' Left!", "Sorry!", JOptionPane.INFORMATION_MESSAGE);
                    } else {
                        F.setText(String.valueOf(letterReamining)); // it passed the condition
                    }
                }
                //LETTER G
                else if (letter == 'G' || letter == 'g') {

                    letterCount = Integer.parseInt(G.getText());//get value of letter
                    Model letterBag = new Model(letterCount,vowelCount); //pass letter count to constructor

                    letterReamining = letterBag.getResult(); // get the result of letter decrement from model

                    if (Integer.parseInt(letterReamining) <0) { // error count
                        errorCount++;
                        s_words.setText("");
                        JOptionPane.showMessageDialog(null, "Sorry you dont have ' " + letter + " ' Left!", "Sorry!", JOptionPane.INFORMATION_MESSAGE);
                    } else {
                        G.setText(String.valueOf(letterReamining)); // it passed the condition
                    }
                }
                //LETTER H
                else if (letter == 'H' || letter == 'h') {

                    letterCount = Integer.parseInt(H.getText());//get value of letter
                    Model letterBag = new Model(letterCount,vowelCount); //pass letter count to constructor

                    letterReamining = letterBag.getResult(); // get the result of letter decrement from model

                    if (Integer.parseInt(letterReamining) <0) { // error count
                        errorCount++;
                        s_words.setText("");
                        JOptionPane.showMessageDialog(null, "Sorry you dont have ' " + letter + " ' Left!", "Sorry!", JOptionPane.INFORMATION_MESSAGE);
                    } else {
                        H.setText(String.valueOf(letterReamining)); // it passed the condition
                    }
                }
                //LETTER I
                else if (letter == 'I' || letter == 'i') {
                    letterCount = Integer.parseInt(I.getText());//get value of letter
                    Model letterBag = new Model(letterCount,vowelCount); //pass letter count to constructor
                    letterReamining = letterBag.getResult(); // get the result of letter decrement from model

                    if (Integer.parseInt(letterReamining) <0) { // error count
                        errorCount++;
                        s_words.setText("");
                        JOptionPane.showMessageDialog(null, "Sorry you dont have ' " + letter + " ' Left!", "Sorry!", JOptionPane.INFORMATION_MESSAGE);
                    } else {
                        I.setText(String.valueOf(letterReamining)); // it passed the condition
                    }
                }

                //SECOND ROW

                //LETTER J
                else if (letter == 'J' || letter == 'j') {
                    letterCount = Integer.parseInt(J.getText());//get value of letter
                    Model letterBag = new Model(letterCount,vowelCount); //pass letter count to constructor

                    letterReamining = letterBag.getResult(); // get the result of letter decrement from model

                    if (Integer.parseInt(letterReamining) <0) { // error count
                        errorCount++;
                        s_words.setText("");
                        JOptionPane.showMessageDialog(null, "Sorry you dont have ' " + letter + " ' Left!", "Sorry!", JOptionPane.INFORMATION_MESSAGE);
                    } else {
                        J.setText(String.valueOf(letterReamining)); // it passed the condition
                    }
                }
                //LETTER K
                else if (letter == 'K' || letter == 'k') {
                    letterCount = Integer.parseInt(K.getText());//get value of letter
                    Model letterBag = new Model(letterCount,vowelCount); //pass letter count to constructor

                    letterReamining = letterBag.getResult(); // get the result of letter decrement from model

                    if (Integer.parseInt(letterReamining) <0) { // error count
                        errorCount++;
                        s_words.setText("");
                        JOptionPane.showMessageDialog(null, "Sorry you dont have ' " + letter + " ' Left!", "Sorry!", JOptionPane.INFORMATION_MESSAGE);
                    } else {
                        K.setText(String.valueOf(letterReamining)); // it passed the condition
                    }
                }
                //LETTER L
                else if (letter == 'L' || letter == 'l') {
                    letterCount = Integer.parseInt(L.getText());//get value of letter
                    Model letterBag = new Model(letterCount,vowelCount); //pass letter count to constructor

                    letterReamining = letterBag.getResult(); // get the result of letter decrement from model

                    if (Integer.parseInt(letterReamining) <0) { // error count
                        errorCount++;
                        s_words.setText("");
                        JOptionPane.showMessageDialog(null, "Sorry you dont have ' " + letter + " ' Left!", "Sorry!", JOptionPane.INFORMATION_MESSAGE);
                    } else {
                        L.setText(String.valueOf(letterReamining)); // it passed the condition
                    }
                }
                //LETTER M
                else if (letter == 'M' || letter == 'm') {
                    letterCount = Integer.parseInt(M.getText());//get value of letter
                    Model letterBag = new Model(letterCount,vowelCount); //pass letter count to constructor

                    letterReamining = letterBag.getResult(); // get the result of letter decrement from model

                    if (Integer.parseInt(letterReamining) <0) { // error count
                        errorCount++;
                        s_words.setText("");
                        JOptionPane.showMessageDialog(null, "Sorry you dont have ' " + letter + " ' Left!", "Sorry!", JOptionPane.INFORMATION_MESSAGE);
                    } else {
                        M.setText(String.valueOf(letterReamining)); // it passed the condition
                    }
                }
                //LETTER N
                else if (letter == 'N' || letter == 'n') {
                    letterCount = Integer.parseInt(N.getText());//get value of letter
                    Model letterBag = new Model(letterCount,vowelCount); //pass letter count to constructor

                    letterReamining = letterBag.getResult(); // get the result of letter decrement from model

                    if (Integer.parseInt(letterReamining) <0) { // error count
                        errorCount++;
                        s_words.setText("");
                        JOptionPane.showMessageDialog(null, "Sorry you dont have ' " + letter + " ' Left!", "Sorry!", JOptionPane.INFORMATION_MESSAGE);
                    } else {
                        N.setText(String.valueOf(letterReamining)); // it passed the condition
                    }
                }
                //LETTER O
                else if (letter == 'O' || letter == 'o') {
                    letterCount = Integer.parseInt(O.getText());//get value of letter
                    Model letterBag = new Model(letterCount,vowelCount); //pass letter count to constructor
                    letterReamining = letterBag.getResult(); // get the result of letter decrement from model

                    if (Integer.parseInt(letterReamining) <0) { // error count
                        errorCount++;
                        s_words.setText("");
                        JOptionPane.showMessageDialog(null, "Sorry you dont have ' " + letter + " ' Left!", "Sorry!", JOptionPane.INFORMATION_MESSAGE);
                    } else {
                        O.setText(String.valueOf(letterReamining)); // it passed the condition
                    }
                }
                //LETTER P
                else if (letter == 'P' || letter == 'p') {
                    letterCount = Integer.parseInt(P.getText());//get value of letter
                    Model letterBag = new Model(letterCount,vowelCount); //pass letter count to constructor

                    letterReamining = letterBag.getResult(); // get the result of letter decrement from model

                    if (Integer.parseInt(letterReamining) <0) { // error count
                        errorCount++;
                        s_words.setText("");
                        JOptionPane.showMessageDialog(null, "Sorry you dont have ' " + letter + " ' Left!", "Sorry!", JOptionPane.INFORMATION_MESSAGE);
                    } else {
                        P.setText(String.valueOf(letterReamining)); // it passed the condition
                    }
                }
                //LETTER Q
                else if (letter == 'Q' || letter == 'q') {
                    letterCount = Integer.parseInt(Q.getText());//get value of letter
                    Model letterBag = new Model(letterCount,vowelCount); //pass letter count to constructor

                    letterReamining = letterBag.getResult(); // get the result of letter decrement from model

                    if (Integer.parseInt(letterReamining) <0) { // error count
                        errorCount++;
                        s_words.setText("");
                        JOptionPane.showMessageDialog(null, "Sorry you dont have ' " + letter + " ' Left!", "Sorry!", JOptionPane.INFORMATION_MESSAGE);
                    } else {
                        Q.setText(String.valueOf(letterReamining)); // it passed the condition
                    }
                }
                //LETTER R
                else if (letter == 'R' || letter == 'r') {
                    letterCount = Integer.parseInt(R.getText());//get value of letter
                    Model letterBag = new Model(letterCount,vowelCount); //pass letter count to constructor

                    letterReamining = letterBag.getResult(); // get the result of letter decrement from model

                    if (Integer.parseInt(letterReamining) <0) { // error count
                        errorCount++;
                        s_words.setText("");
                        JOptionPane.showMessageDialog(null, "Sorry you dont have ' " + letter + " ' Left!", "Sorry!", JOptionPane.INFORMATION_MESSAGE);
                    } else {
                        R.setText(String.valueOf(letterReamining)); // it passed the condition
                    }
                }
                //third Row
                //LETTER S
                else if (letter == 'S' || letter == 's') {
                    letterCount = Integer.parseInt(S.getText());//get value of letter
                    Model letterBag = new Model(letterCount,vowelCount); //pass letter count to constructor

                    letterReamining = letterBag.getResult(); // get the result of letter decrement from model

                    if (Integer.parseInt(letterReamining) <0) { // error count
                        errorCount++;
                        s_words.setText("");
                        JOptionPane.showMessageDialog(null, "Sorry you dont have ' " + letter + " ' Left!", "Sorry!", JOptionPane.INFORMATION_MESSAGE);
                    } else {
                        S.setText(String.valueOf(letterReamining)); // it passed the condition
                    }
                }
                //LETTER T
                else if (letter == 'T' || letter == 't') {
                    letterCount = Integer.parseInt(T.getText());//get value of letter
                    Model letterBag = new Model(letterCount,vowelCount); //pass letter count to constructor

                    letterReamining = letterBag.getResult(); // get the result of letter decrement from model

                    if (Integer.parseInt(letterReamining) <0) { // error count
                        errorCount++;
                        s_words.setText("");
                        JOptionPane.showMessageDialog(null, "Sorry you dont have ' " + letter + " ' Left!", "Sorry!", JOptionPane.INFORMATION_MESSAGE);
                    } else {
                        T.setText(String.valueOf(letterReamining)); // it passed the condition
                    }
                }
                //LETTER U
                else if (letter == 'U' || letter == 'u') {
                    letterCount = Integer.parseInt(U.getText());//get value of letter
                    Model letterBag = new Model(letterCount,vowelCount); //pass letter count to constructor
                    letterReamining = letterBag.getResult(); // get the result of letter decrement from model

                    if (Integer.parseInt(letterReamining) <0) { // error count
                        errorCount++;
                        s_words.setText("");
                        JOptionPane.showMessageDialog(null, "Sorry you dont have ' " + letter + " ' Left!", "Sorry!", JOptionPane.INFORMATION_MESSAGE);
                    } else {
                        U.setText(String.valueOf(letterReamining)); // it passed the condition
                    }
                }
                //LETTER V
                else if (letter == 'V' || letter == 'v') {
                    letterCount = Integer.parseInt(V.getText());//get value of letter
                    Model letterBag = new Model(letterCount,vowelCount); //pass letter count to constructor

                    letterReamining = letterBag.getResult(); // get the result of letter decrement from model

                    if (Integer.parseInt(letterReamining) <0) { // error count
                        errorCount++;
                        s_words.setText("");
                        JOptionPane.showMessageDialog(null, "Sorry you dont have ' " + letter + " ' Left!", "Sorry!", JOptionPane.INFORMATION_MESSAGE);
                    } else {
                        V.setText(String.valueOf(letterReamining)); // it passed the condition
                    }
                }
                //LETTER W
                else if (letter == 'W' || letter == 'w') {
                    letterCount = Integer.parseInt(W.getText());//get value of letter
                    Model letterBag = new Model(letterCount,vowelCount); //pass letter count to constructor

                    letterReamining = letterBag.getResult(); // get the result of letter decrement from model

                    if (Integer.parseInt(letterReamining) <0) { // error count
                        errorCount++;
                        s_words.setText("");
                        JOptionPane.showMessageDialog(null, "Sorry you dont have ' " + letter + " ' Left!", "Sorry!", JOptionPane.INFORMATION_MESSAGE);
                    } else {
                        W.setText(String.valueOf(letterReamining)); // it passed the condition
                    }
                }
                //LETTER X
                else if (letter == 'X' || letter == 'x') {
                    letterCount = Integer.parseInt(X.getText());//get value of letter
                    Model letterBag = new Model(letterCount,vowelCount); //pass letter count to constructor

                    letterReamining = letterBag.getResult(); // get the result of letter decrement from model

                    if (Integer.parseInt(letterReamining) <0) { // error count
                        errorCount++;
                        s_words.setText("");
                        JOptionPane.showMessageDialog(null, "Sorry you dont have ' " + letter + " ' Left!", "Sorry!", JOptionPane.INFORMATION_MESSAGE);
                    } else {
                        X.setText(String.valueOf(letterReamining)); // it passed the condition
                    }
                }
                //LETTER k
                else if (letter == 'Y' || letter == 'y') {
                    letterCount = Integer.parseInt(Y.getText());//get value of letter
                    Model letterBag = new Model(letterCount,vowelCount); //pass letter count to constructor

                    letterReamining = letterBag.getResult(); // get the result of letter decrement from model

                    if (Integer.parseInt(letterReamining) <0) { // error count
                        errorCount++;
                        s_words.setText("");
                        JOptionPane.showMessageDialog(null, "Sorry you dont have ' " + letter + " ' Left!", "Sorry!", JOptionPane.INFORMATION_MESSAGE);
                    } else {
                        Y.setText(String.valueOf(letterReamining)); // it passed the condition
                    }
                }
                //LETTER k
                else if (letter == 'Z' || letter == 'z') {
                    letterCount = Integer.parseInt(Z.getText());//get value of letter
                    Model letterBag = new Model(letterCount,vowelCount); //pass letter count to constructor

                    letterReamining = letterBag.getResult(); // get the result of letter decrement from model

                    if (Integer.parseInt(letterReamining) <0) { // error count
                        errorCount++;
                        s_words.setText("");
                        JOptionPane.showMessageDialog(null, "Sorry you dont have ' " + letter + " ' Left!", "Sorry!", JOptionPane.INFORMATION_MESSAGE);
                    } else {
                        Z.setText(String.valueOf(letterReamining)); // it passed the condition
                    }
                }

            }
        }
        else {
            errorCount++;
            JOptionPane.showMessageDialog(null, "Please make sure the word is more than 2 letters to 8 letters", "Invalid word!", JOptionPane.INFORMATION_MESSAGE);
        }

        //Displaying the result
        for (String finalResults: finalResult)
        {
            if(finalResults != null && finalResults.length() > 0) {//checking the length

                if(errorCount<=0 && vowelCount>0){ // counting the errors for scoring

                    if(allWords == null) //checking if found words is the first one
                    {
                        allWords = finalResults.toUpperCase();//storing to store words  convert uppercase
                        countNumberOfWords++;
                        totalWords++;
                       // scoring++; // increment score
                    }
                    else{
                        allWords = allWords.toUpperCase() + " , " + finalResults.toUpperCase(); // storing to store words and convert to uppercase
                        countNumberOfWords = 0;
                        totalWords++;
                    }

                    Model scroingModel = new Model(countNumberOfWords, allWords,totalWords); //pass letter count to constructor
                    String scores= scroingModel.getScore();

                    score.setText(String.valueOf(scores)); // it passed the condition

                   // score.setText(String.valueOf(scoring));//display scores
                    errorCount = 0;
                    s_found.setText(allWords); // display found words


                }
                //if there are errors do add words
                else{

                    if(vowelCount<=0){
                        JOptionPane.showMessageDialog(null, "You need to have atleast 1 vowel in order to form a word!", "Sorry!", JOptionPane.INFORMATION_MESSAGE);
                       // s_words.setText(""); // clear input field
                    }
                    else {
                        JOptionPane.showMessageDialog(null, "Unable to add in found words!", "Sorry!", JOptionPane.INFORMATION_MESSAGE);
                       // s_words.setText(""); // clear input field
                    }

                }
                if(Integer.parseInt(A.getText()) == 0 && Integer.parseInt(E.getText()) == 0 && Integer.parseInt(I.getText()) == 0 && Integer.parseInt(O.getText()) == 0 && Integer.parseInt(U.getText()) == 0){
                    JOptionPane.showMessageDialog(null, "Game Over!\nYou dont have vowels left!", "Game Over!", JOptionPane.INFORMATION_MESSAGE);
                    newGame(event);
                }

            }



        }
        vowelCount = 0;//reset vowel count
        errorCount = 0;//reset
        s_words.setText(""); // clear input field


    }



    @FXML
    private void initialize() {
        System.out.println("Started");

    }
}
