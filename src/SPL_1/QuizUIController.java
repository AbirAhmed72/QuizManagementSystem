package SPL_1;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static SPL_1.RandomNumberGenerator.randomNumbers;

public class QuizUIController extends RandomNumberGenerator{
    @FXML
    private Label questionField;
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


    int[] arr = randomNumbers(100,18);
    int score=0;

    public void showQuestionButton (ActionEvent event1) throws IOException
    {
        String question = "";
        String option1 = "";
        String option2 = "";
        String option3 = "";
        String option4 = "";

        try {
            //question = Files.readAllLines(Paths.get("C:\\Users\\Admin\\IdeaProjects\\QuizManagementSystem\\src\\Files\\questionsFile.txt")).get(arr[0]-1);
            question = Files.readAllLines(Paths.get("src/Files/questionsFile.txt")).get(arr[0] - 1);
            //System.out.println(question);
            option1 = Files.readAllLines(Paths.get("src/Files/questionsFile.txt")).get(arr[0]);
            option2 = Files.readAllLines(Paths.get("src/Files/questionsFile.txt")).get(arr[0] + 1);
            option3 = Files.readAllLines(Paths.get("src/Files/questionsFile.txt")).get(arr[0] + 2);
            option4 = Files.readAllLines(Paths.get("src/Files/questionsFile.txt")).get(arr[0] + 3);
    //            option1 = Files.readAllLines(Paths.get("C:\\Users\\Admin\\IdeaProjects\\QuizManagementSystem\\src\\Files\\questionsFile.txt")).get(arr[0] + 1);
    //            option2 = Files.readAllLines(Paths.get("C:\\Users\\Admin\\IdeaProjects\\QuizManagementSystem\\src\\Files\\questionsFile.txt")).get(arr[0] + 2);
    //            option3 = Files.readAllLines(Paths.get("C:\\Users\\Admin\\IdeaProjects\\QuizManagementSystem\\src\\Files\\questionsFile.txt")).get(arr[0] + 3);
    //            option4 = Files.readAllLines(Paths.get("C:\\Users\\Admin\\IdeaProjects\\QuizManagementSystem\\src\\Files\\questionsFile.txt")).get(arr[0] + 4);
        } catch (IOException e) {
            e.printStackTrace();
        }

        questionField.setText(question);
        firstOptionField.setText(option1);
        secondOptionField.setText(option2);
        thirdOptionField.setText(option3);
        fourthOptionField.setText(option4);

    }

    public void submitFirstButton (ActionEvent event2)
    {
        String answer = "";

        try {
            //question = Files.readAllLines(Paths.get("C:\\Users\\Admin\\IdeaProjects\\QuizManagementSystem\\src\\Files\\questionsFile.txt")).get(arr[0]-1);
            answer = Files.readAllLines(Paths.get("src/Files/questionsFile.txt")).get(arr[0] + 4);
            System.out.println(answer);

        } catch (IOException e) {
            e.printStackTrace();
        }

        if (firstOptionField.isSelected() && firstOptionField.getText().equals(answer))
            score++;

        else if (secondOptionField.isSelected() && secondOptionField.getText().equals(answer))
            score++;

        else if (thirdOptionField.isSelected() && thirdOptionField.getText().equals(answer))
            score++;

        else if (fourthOptionField.isSelected() && fourthOptionField.getText().equals(answer))
            score++;

        questionField.setText("You scored " + score);
    }

}
