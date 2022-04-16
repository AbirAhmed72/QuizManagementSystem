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
    @FXML
    private Button inputPercent;


    public void addQuestionsButton(ActionEvent event) throws IOException {
        Main m = new Main();
        m.changeScene("addQuestions.fxml");
    }

    public void inputPercentButton(ActionEvent event) throws IOException{
        Main m = new Main();
        m.changeScene("inputPercentage.fxml");
    }

    public void adminDashboardBackButton(ActionEvent event) throws IOException {
        Main m = new Main();
        m.changeScene("homepage.fxml");
    }
}
