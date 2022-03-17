package SPL_1;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class AddQuestionsController {

    @FXML
    private TextField questionsField;
    @FXML
    private TextField firstOptionField;
    @FXML
    private TextField secondOptionField;
    @FXML
    private TextField thirdOptionField;
    @FXML
    private TextField fourthOptionField;
    @FXML
    private TextField correctAnswerField;
    @FXML
    private Button addQuestionsBack;
    @FXML
    private Button saveQuestions;
    @FXML
    private Label questionsErrorLabel;

    public void addQuestionsBackButton(ActionEvent event) throws IOException {
        Main m = new Main();
        m.changeScene("adminDashboard.fxml");
    }
    public void saveQuestionsButton(ActionEvent event) throws IOException {

        String question = questionsField.getText();
        String firstOption = firstOptionField.getText();
        String secondOption = secondOptionField.getText();
        String thirdOption = thirdOptionField.getText();
        String fourthOption = fourthOptionField.getText();
        String correctAnswer = correctAnswerField.getText();

        try{
            FileWriter questionsFileWriter = new FileWriter("C:\\Users\\Admin\\IdeaProjects\\QuizManagementSystem\\src\\Files\\questionsFile.txt", true);
            BufferedWriter qBufferedWriter = new BufferedWriter(questionsFileWriter);

            qBufferedWriter.write("" + question + "\n" + firstOption + "\n" + secondOption + "\n" +
                    thirdOption + "\n" + fourthOption + "\n" + correctAnswer + "\n");

            qBufferedWriter.close();

        }catch(Exception e){
        System.out.println("Exception caught.");
        e.printStackTrace();
    }
        if(questionsField.getText().isEmpty() || firstOptionField.getText().isEmpty() ||
                secondOptionField.getText().isEmpty() || thirdOptionField.getText().isEmpty() ||
                fourthOptionField.getText().isEmpty() || correctAnswerField.getText().isEmpty()){

            questionsErrorLabel.setText("Please Fillout All Cells!");
        }

        else questionsErrorLabel.setText("Questions Saved Successfully!");

    }
}
