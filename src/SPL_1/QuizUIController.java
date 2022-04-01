package SPL_1;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Timer;
import java.util.TimerTask;

public class QuizUIController extends RandomNumberGenerator{
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


    public int[] arrOfRand = randomNumbers(100,18);
    public int score=0;
    public int q=0;

    public String[][] QuesOptAns = new String[20][20];     //includes questions options answers

    public void showQuestionButton (ActionEvent event1) throws IOException {

        for(int i=0; i<3; i++){
            for(int j=0; j<6; j++){
                try {
                    QuesOptAns[i][j] = Files.readAllLines(Paths.get("src/Files/questionsFile.txt")).get(arrOfRand[i] + j);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                System.out.println(QuesOptAns[i][j]);
            }
        }

        String question = "";
        String option1 = "";
        String option2 = "";
        String option3 = "";
        String option4 = "";

//        try {
//
//            question = Files.readAllLines(Paths.get("src/Files/questionsFile.txt")).get(arr[0] - 1);
//            //System.out.println(question);
//            option1 = Files.readAllLines(Paths.get("src/Files/questionsFile.txt")).get(arr[0]);
//            option2 = Files.readAllLines(Paths.get("src/Files/questionsFile.txt")).get(arr[0] + 1);
//            option3 = Files.readAllLines(Paths.get("src/Files/questionsFile.txt")).get(arr[0] + 2);
//            option4 = Files.readAllLines(Paths.get("src/Files/questionsFile.txt")).get(arr[0] + 3);
//    //            option1 = Files.readAllLines(Paths.get("C:\\Users\\Admin\\IdeaProjects\\QuizManagementSystem\\src\\Files\\questionsFile.txt")).get(arr[0] + 1);
//    //            option2 = Files.readAllLines(Paths.get("C:\\Users\\Admin\\IdeaProjects\\QuizManagementSystem\\src\\Files\\questionsFile.txt")).get(arr[0] + 2);
//    //            option3 = Files.readAllLines(Paths.get("C:\\Users\\Admin\\IdeaProjects\\QuizManagementSystem\\src\\Files\\questionsFile.txt")).get(arr[0] + 3);
//    //            option4 = Files.readAllLines(Paths.get("C:\\Users\\Admin\\IdeaProjects\\QuizManagementSystem\\src\\Files\\questionsFile.txt")).get(arr[0] + 4);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
        questionField.setText(QuesOptAns[q][0]);
        firstOptionField.setText(QuesOptAns[q][1]);
        secondOptionField.setText(QuesOptAns[q][2]);
        thirdOptionField.setText(QuesOptAns[q][3]);
        fourthOptionField.setText(QuesOptAns[q][4]);


        //from here

        Timer timer = new Timer();
        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                Platform.runLater(new Runnable() {
                    @Override
                    public void run() {
                        int time = 10;
                        timerLabel.setText("" + time);
                        time--;
                    }
                });

            }
        };

        timer.schedule(task, 0, 1000);

        //to here



    }

    public void submitFirstButton (ActionEvent event2) throws IOException {
//        String answer = "";
//
//        try {
//            //question = Files.readAllLines(Paths.get("C:\\Users\\Admin\\IdeaProjects\\QuizManagementSystem\\src\\Files\\questionsFile.txt")).get(arr[0]-1);
//            answer = Files.readAllLines(Paths.get("src/Files/questionsFile.txt")).get(arr[0] + 5);
//            System.out.println(answer);
//
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

        if (firstOptionField.isSelected() && firstOptionField.getText().equals(QuesOptAns[q][5])) {
            score++;
        }

        else if (secondOptionField.isSelected() && secondOptionField.getText().equals(QuesOptAns[q][5])) {
            score++;
        }

        else if (thirdOptionField.isSelected() && thirdOptionField.getText().equals(QuesOptAns[q][5])) {
            score++;
        }

        else if (fourthOptionField.isSelected() && fourthOptionField.getText().equals(QuesOptAns[q][5])) {
            score++;
        }

        q++;
        showQuestionButton(event2);

        if(q==3){
            questionField.setText("You scored " + score);
        }

        //questionField.setText("You scored " + score);

    }

}
