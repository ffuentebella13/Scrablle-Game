package sample;

import javax.swing.*;
import java.awt.*;

public class Model {
    private String words, found, result,allWords;
    String addWords[]=new String[100];//declaration and instantiation
    int ctr,countWords;
    int countLetters;
    private int letterCount;
    int countNumberOfWords;
    int vowelCount;
    int totalWords;

    public Model(String words, String found) {
        this.words = words;
        this.found = found;

        process();

    }

    public Model(String words, int ctr) {
        this.words = words;
        this.ctr = ctr;
    }

    public Model(int letterCount,int errorCount) {
        this.letterCount = letterCount;
        this. vowelCount =   errorCount;
        countLetter();
    }

    public Model(int countNumberOfWords, String allWords,int totalWords) {
        this.allWords = allWords;
        this.countNumberOfWords = countNumberOfWords;
        this.totalWords = totalWords;

       Score();
    }

    public void Score() {
        if(countNumberOfWords == 1){

            countLetters = allWords.length();
        }
       else{
            totalWords = (totalWords * 3) - 3;
            countLetters = allWords.length() - totalWords ;
        }
        setResult(String.valueOf(countLetters));

    }
    public String getScore() {
         return String.valueOf(countLetters);
    }

    private void countLetter() {

            if ( letterCount < 0) {
                // errorCount++;

                JOptionPane.showMessageDialog(null, "Sorry you dont have a letter Left!", "Sorry!", JOptionPane.INFORMATION_MESSAGE);
                //setResult(String.valueOf(0));

            } else {


                        letterCount--;
                         setResult(String.valueOf(letterCount));


            }




    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }
    private void process() {


    }

    public String[] getFoundWords() {

            addWords[ctr] = words;



        return addWords;
    }
}
