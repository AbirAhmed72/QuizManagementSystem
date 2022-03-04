package SPL_1;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;

import java.io.IOException;

public class HomepageController {

    @FXML
    private Pane homePane;
    @FXML
    private Label welcomeText;
    @FXML
    private Label subtitleText;
    @FXML
    private Button adLogProceed;
    @FXML
    private Button stuLogProceed;
    @FXML
    private Button stuSignProceed;

    public void adminLoginProceed(ActionEvent event) throws IOException {
        Main m = new Main();
        m.changeScene("adminLogin.fxml");
    }

    public void studentLoginProceed(ActionEvent event) throws IOException {
        Main n = new Main();
        n.changeScene("studentLogin.fxml");
    }

    public void studentSigninProceed(ActionEvent event) throws IOException {
        Main o = new Main();
        o.changeScene("studentSignin.fxml");
    }
}
