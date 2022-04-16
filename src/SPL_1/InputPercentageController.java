package SPL_1;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import javafx.event.ActionEvent;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class InputPercentageController extends RandomNumberGenerator{
    @FXML
    private TextField easyQField;
    @FXML
    private TextField mediumQField;
    @FXML
    private TextField hardQField;
    @FXML
    private Label percentageErrorText;
    @FXML
    private Label percentageSuccessText;
    @FXML
    private Button inputPercentageBack;
    @FXML
    private Button makeQuestions;



    public void makeQuestionsButton(ActionEvent event) throws IOException {

        if(easyQField.getText().isEmpty() || mediumQField.getText().isEmpty() || hardQField.getText().isEmpty()){
            percentageErrorText.setText("Please fill out all the cells!");
            percentageSuccessText.setText("");
        }

        if(Integer.parseInt(easyQField.getText()) + Integer.parseInt(mediumQField.getText())
                + Integer.parseInt(hardQField.getText()) <= 100){
            if(Integer.parseInt(easyQField.getText())%10 == 0 && Integer.parseInt(mediumQField.getText())%10 == 0
                    && Integer.parseInt(hardQField.getText())%10 == 0){


                //needs work!!
                int[] arrOfRandEasy = randomNumbers(Integer.parseInt(easyQField.getText()));
                int[] arrOfRandMed = randomNumbers(Integer.parseInt(mediumQField.getText()));
                int[] arrOfRandHard = randomNumbers(Integer.parseInt(hardQField.getText()));

                FileWriter easyQuestionsFileWriter = new FileWriter("C:\\Users\\Admin\\IdeaProjects\\QuizManagementSystem\\src\\Files\\allQuestions.txt", true);
                BufferedWriter easyQBufferedWriter = new BufferedWriter(easyQuestionsFileWriter);

                for(int i=0; i<Integer.parseInt(easyQField.getText())/10; i++){
                    for(int j=0; j<6; j++){
                        easyQBufferedWriter.write(Files.readAllLines(Paths.get("src/Files/easyQuestions.txt")).get(arrOfRandEasy[i] + j) + "\n");
                    }
                }
                easyQBufferedWriter.close();

                FileWriter medQuestionsFileWriter = new FileWriter("C:\\Users\\Admin\\IdeaProjects\\QuizManagementSystem\\src\\Files\\allQuestions.txt", true);
                BufferedWriter medQBufferedWriter = new BufferedWriter(medQuestionsFileWriter);

                for(int i=0; i<Integer.parseInt(mediumQField.getText())/10; i++){
                    for(int j=0; j<6; j++){
                        medQBufferedWriter.write(Files.readAllLines(Paths.get("src/Files/mediumQuestions.txt")).get(arrOfRandMed[i] + j) + "\n");
                    }
                }
                medQBufferedWriter.close();

                FileWriter hardQuestionsFileWriter = new FileWriter("C:\\Users\\Admin\\IdeaProjects\\QuizManagementSystem\\src\\Files\\allQuestions.txt", true);
                BufferedWriter hardQBufferedWriter = new BufferedWriter(hardQuestionsFileWriter);

                for(int i=0; i<Integer.parseInt(hardQField.getText())/10; i++){
                    for(int j=0; j<6; j++){
                        hardQBufferedWriter.write(Files.readAllLines(Paths.get("src/Files/hardQuestions.txt")).get(arrOfRandHard[i] + j) + "\n");
                    }
                }
                hardQBufferedWriter.close();


                percentageSuccessText.setText("Question made successfully!");
                percentageErrorText.setText("");
            }

            else{
                percentageErrorText.setText("Please input in correct format!");
                percentageSuccessText.setText("");
            }
        }

        else{
            percentageErrorText.setText("Percentage cannot cross 100%!");
            percentageSuccessText.setText("");
        }
    }

    public void inputPercentageBackButton(ActionEvent event) throws IOException {
        Main m = new Main();
        m.changeScene("adminDashboard.fxml");
    }
}
