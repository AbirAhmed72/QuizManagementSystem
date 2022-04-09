package SPL_1;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class ViewAnswerController {

    @FXML
    private Label l1;
    @FXML
    private Label l2;
    @FXML
    private Label l3;
    @FXML
    private Label l4;
    @FXML
    private Label l5;
    @FXML
    private Label l6;
    @FXML
    private Label l7;
    @FXML
    private Label l8;
    @FXML
    private Label l9;
    @FXML
    private Label l10;
    @FXML
    private Label l11;
    @FXML
    private Button viewAnswersBack;
    @FXML
    private Button viewAnswers;

    public void viewAnswersBackButton(ActionEvent event) throws IOException {
        Main m = new Main();
        m.changeScene("studentDashboard.fxml");
    }

    public void viewAnswersButton(ActionEvent event) throws IOException {
        l1.setText(Files.readAllLines(Paths.get("src/Files/answerSheet.txt")).get(0));
        l2.setText(Files.readAllLines(Paths.get("src/Files/answerSheet.txt")).get(1));
        l3.setText(Files.readAllLines(Paths.get("src/Files/answerSheet.txt")).get(2));
        l4.setText(Files.readAllLines(Paths.get("src/Files/answerSheet.txt")).get(3));
        l5.setText(Files.readAllLines(Paths.get("src/Files/answerSheet.txt")).get(4));
        l6.setText(Files.readAllLines(Paths.get("src/Files/answerSheet.txt")).get(5));
        l7.setText(Files.readAllLines(Paths.get("src/Files/answerSheet.txt")).get(6));
        l8.setText(Files.readAllLines(Paths.get("src/Files/answerSheet.txt")).get(7));
        l9.setText(Files.readAllLines(Paths.get("src/Files/answerSheet.txt")).get(8));
        l10.setText(Files.readAllLines(Paths.get("src/Files/answerSheet.txt")).get(9));
//        l11.setText(Files.readAllLines(Paths.get("src/Files/answerSheet.txt")).get(10));
    }
}
