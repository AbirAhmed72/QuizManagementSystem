package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class AdminLoginController {

    @FXML
    private Button adminLogin;
    @FXML
    private Label adminError;
    @FXML
    private TextField adminUser;
    @FXML
    private PasswordField adminPassword;

    public void adminLoginButton(ActionEvent event) throws IOException {
        checkLogin();

    }

    private void checkLogin() throws IOException {
        Main m = new Main();

        String storedUsername = "";
        String storedPassword = "";

//        System.out.println("storedUsername: " + storedUsername);
//        System.out.println("storedPassword: " + storedPassword);


        try {
            File usernameFile = new File("C:\\Users\\Admin\\IdeaProjects\\QuizManagementSystem\\src\\Files\\adminUsername.txt");
            //System.out.println(usernameFile.getAbsolutePath());
            File passwordFile = new File("C:\\Users\\Admin\\IdeaProjects\\QuizManagementSystem\\src\\Files\\adminPassword.txt");
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

        if(adminUser.getText().toString().equals(storedUsername) && adminPassword.getText().toString().equals(storedPassword)) {
            adminError.setText("Success!");

            m.changeScene("adminDashboard.fxml");
        }

        else if(adminUser.getText().isEmpty() || adminPassword.getText().isEmpty()) {
            adminError.setText("Please enter your credentials!");
        }

        else {
            adminError.setText("Wrong username or password!");
        }
    }
}