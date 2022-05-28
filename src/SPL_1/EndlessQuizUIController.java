package SPL_1;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Timer;
import java.util.TimerTask;
import java.util.*;

public class EndlessQuizUIController extends RandomNumberGenerator{
    @FXML
    private Label questionField;
    @FXML
    public Label timerLabel;
    @FXML
    private RadioButton firstOptionField;
    @FXML
    private RadioButton secondOptionField;
    @FXML
    private RadioButton thirdOptionField;
    @FXML
    private RadioButton fourthOptionField;
    @FXML
    private Button submitFirst;
    @FXML
    private Button showQuestion;


    public int[] arrOfRand = randomNumbers(59);
    public int score=0;
    public int q=0, r=1, count=2;
    public int time = 100;

    public String[][][] AllQuesOptAns = new String[100][100][100];     //includes all questions options answers

    public void showQuestionButton (ActionEvent event1) throws IOException {

        for(int i=0; i<10; i++){
            for(int j=0; j<6; j++){
                try {
                    AllQuesOptAns[0][i][j] = Files.readAllLines(Paths.get("src/Files/easyQuestions.txt")).get(arrOfRand[i] + j);
                } catch (IOException e) {
                    System.out.println("Could not load questions in the array");
                }
//                System.out.println(AllQuesOptAns[i][j]);
            }
        }

        for(int i=0; i<10; i++){
            for(int j=0; j<6; j++){
                try {
                    AllQuesOptAns[1][i][j] = Files.readAllLines(Paths.get("src/Files/mediumQuestions.txt")).get(arrOfRand[i] + j);
                } catch (IOException e) {
                    System.out.println("Could not load questions in the array");
                }
//                System.out.println(AllQuesOptAns[i][j]);
            }
        }

        for(int i=0; i<10; i++){
            for(int j=0; j<6; j++){
                try {
                    AllQuesOptAns[2][i][j] = Files.readAllLines(Paths.get("src/Files/hardQuestions.txt")).get(arrOfRand[i] + j);
                } catch (IOException e) {
                    System.out.println("Could not load questions in the array");
                }
//                System.out.println(AllQuesOptAns[i][j]);
            }
        }


        questionField.setText(AllQuesOptAns[r][q][0]);
        firstOptionField.setText(AllQuesOptAns[r][q][1]);
        secondOptionField.setText(AllQuesOptAns[r][q][2]);
        thirdOptionField.setText(AllQuesOptAns[r][q][3]);
        fourthOptionField.setText(AllQuesOptAns[r][q][4]);
        timerLabel.setText("" +score);


        //from here


//        Timer timer = new Timer();
//        TimerTask task1 = new TimerTask() {
//            @Override
//            public void run() {
//                time--;
//            }
//        };
//
//        timerLabel.setText("" + time);
//        timer.scheduleAtFixedRate(task1, 0, 1000);

        //to here
    }

    public void submitFirstButton (ActionEvent event2) throws IOException {

        Main m = new Main();

//
//        FileWriter answersFileWriter = new FileWriter("C:\\Users\\Admin\\IdeaProjects\\QuizManagementSystem\\src\\Files\\answerSheet.txt", true);
//        BufferedWriter ansBufferedWriter = new BufferedWriter(answersFileWriter);
//
//        String option1 = firstOptionField.getText();
//        String option2 = secondOptionField.getText();
//        String option3 = thirdOptionField.getText();
//        String option4 = fourthOptionField.getText();

        Timer timer = new Timer();
        TimerTask task2 = new TimerTask() {
            @Override
            public void run() {
                    try {
                        m.changeScene("studentDashboard.fxml");
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
            }
        };

        if (firstOptionField.isSelected() && firstOptionField.getText().equals(AllQuesOptAns[r][q][5])) {
            score++;
            count++;
        }

        else if (secondOptionField.isSelected() && secondOptionField.getText().equals(AllQuesOptAns[r][q][5])) {
            score++;
            count++;
        }

        else if (thirdOptionField.isSelected() && thirdOptionField.getText().equals(AllQuesOptAns[r][q][5])) {
            score++;
            count++;
        }

        else if (fourthOptionField.isSelected() && fourthOptionField.getText().equals(AllQuesOptAns[r][q][5])) {
            score++;
            count++;
        }
        else count--;

        if (count==0 && r==0) {
            questionField.setText("Your Game is over!");
            timer.schedule(task2, 3000);
//            m.changeScene("studentDashboard.fxml");
        }
        else if (count==5 && r==2) {
            questionField.setText("You beat the Game!");
            timer.schedule(task2, 3000);
//            m.changeScene("studentDashboard.fxml");
        }
        else if(count==0 && r!=0){
            r--;
            count=2;
            q=0;
        }
        else if (count==5 && r!=2) {
            r++;
            count=2;
            q=0;
        }

        q++;
        showQuestionButton(event2);

        //int incorrect = 10 - score;

//        if(q==10){
//            questionField.setText("You scored " + score);
////            ansBufferedWriter.write("Total Correct: " + score + "Total Incorrect: " + incorrect +"\n");
////            ansBufferedWriter.close();
//            timer.schedule(task2, 3000);
//        }

    }

}
