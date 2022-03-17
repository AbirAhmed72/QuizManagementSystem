package SPL_1;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

import java.io.IOException;

public class AdminDashboardController {

    @FXML
    private Button adminDashboardBack;
    @FXML
    private Button addQuestions;

    public void adminDashboardBackButton(ActionEvent event) throws IOException {
        Main m = new Main();
        m.changeScene("homepage.fxml");
    }

    public void addQuestionsButton(ActionEvent event) throws IOException {
        Main m = new Main();
        m.changeScene("addQuestions.fxml");
    }
}
