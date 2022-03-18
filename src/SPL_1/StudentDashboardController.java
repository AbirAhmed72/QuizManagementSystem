package SPL_1;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

import java.io.IOException;

public class StudentDashboardController {

    @FXML
    private Button studentDashboardBack;
    @FXML
    private Button startQuiz;

    public void studentDashboardBackButton(ActionEvent event) throws IOException {
        Main m = new Main();
        m.changeScene("homepage.fxml");

    }

    public void startQuizButton(ActionEvent event) throws IOException {
        Main m = new Main();
        m.changeScene("quizUI.fxml");

    }
}
