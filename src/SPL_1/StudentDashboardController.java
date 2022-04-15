package SPL_1;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class StudentDashboardController extends RandomNumberGenerator{

    @FXML
    private Button studentDashboardBack;
    @FXML
    private Button startQuiz;
    @FXML
    private Button viewAns;

//    public int[] arrOfRand = randomNumbers(100,18);
//    public String[][] QuesOptAns = new String[20][20];     //includes questions options answers


    public void studentDashboardBackButton(ActionEvent event) throws IOException {
        Main m = new Main();
        m.changeScene("homepage.fxml");

    }

    public void startQuizButton(ActionEvent event) throws IOException {

//        for(int i=0; i<3; i++){
//            for(int j=0; j<6; j++){
//                try {
//                    QuesOptAns[i][j] = Files.readAllLines(Paths.get("src/Files/allQuestions.txt")).get(arrOfRand[i] + j);
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//                System.out.println(QuesOptAns[i][j]);
//            }
//        }
        Main m = new Main();
        m.changeScene("quizUI.fxml");

    }

    public void viewAnsButton(ActionEvent event) throws IOException {
        Main m = new Main();
        m.changeScene("viewAnswer.fxml");
    }

}
