package SPL_1;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class StudentLoginController {

    @FXML
    private Button studentLogin;
    @FXML
    private Label studentError;
    @FXML
    private TextField studentUser;
    @FXML
    private PasswordField studentPassword;

    public void studentLoginButton(ActionEvent event) throws IOException {
        checkLogin();

    }

    private void checkLogin() throws IOException {
        Main m = new Main();

        String storedUsername = "";
        String storedPassword = "";

//        System.out.println("storedUsername: " + storedUsername);
//        System.out.println("storedPassword: " + storedPassword);

        try {
            File usernameFile = new File("C:\\Users\\Admin\\IdeaProjects\\QuizManagementSystem\\src\\Files\\studentUsername.txt");
            //System.out.println(usernameFile.getAbsolutePath());
            File passwordFile = new File("C:\\Users\\Admin\\IdeaProjects\\QuizManagementSystem\\src\\Files\\studentPassword.txt");
            //System.out.println(passwordFile.getAbsolutePath());

            Scanner usernameScanner = new Scanner(usernameFile);
            Scanner passwordScanner = new Scanner(passwordFile);

            storedUsername = usernameScanner.nextLine();
            storedPassword = passwordScanner.nextLine();

            usernameScanner.close();
            passwordScanner.close();
        }catch(Exception e){
            System.out.println("Exception caught.");
            e.printStackTrace();
        }

//        System.out.println("storedUsername: " + storedUsername);
//        System.out.println("storedPassword: " + storedPassword);

        if(studentUser.getText().toString().equals(storedUsername) && studentPassword.getText().toString().equals(storedPassword)) {
            studentError.setText("Success!");

            m.changeScene("studentDashboard.fxml");
        }

        else if(studentUser.getText().isEmpty() || studentPassword.getText().isEmpty()) {
            studentError.setText("Please enter your credentials!");
        }

        else {
            studentError.setText("Wrong username or password!");
        }
    }
}
