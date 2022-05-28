package SPL_1;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;

public class AdminChangePassController {
    @FXML
    public TextField username;
    @FXML
    public TextField email;
    @FXML
    public PasswordField passwordField;
    @FXML
    public PasswordField confirmPasswordField;
    @FXML
    public Button changePass;
    @FXML
    public Button homePage;
    @FXML
    public Label confirmation;

    public void changePass(ActionEvent event) throws IOException {
        checkInfo();
    }

    public void checkInfo() throws IOException {

        String storedUsername = "";
        String storedMail = "";

        //System.out.println("storedUsername: " + storedUsername);
        //System.out.println("storedMail: " + storedMail);

        try {
            File usernameFile = new File("C:\\Users\\Admin\\IdeaProjects\\QuizManagementSystem\\src\\Files\\adminUsername.txt");
//            System.out.println(usernameFile.getAbsolutePath());
            File mailFile = new File("C:\\Users\\Admin\\IdeaProjects\\QuizManagementSystem\\src\\Files\\studentCredentials.txt");
//            System.out.println(mailFile.getAbsolutePath());

            Scanner usernameScanner = new Scanner(usernameFile);
            Scanner mailScanner = new Scanner(mailFile);

            storedUsername = usernameScanner.nextLine();
            storedMail = Files.readAllLines(Paths.get("src/Files/studentCredentials.txt")).get(1);

            System.out.println(storedUsername);
            System.out.println(storedMail);

            usernameScanner.close();
            mailScanner.close();
        } catch (Exception e) {
            System.out.println("Exception caught at 57.");
            e.printStackTrace();
        }

        //System.out.println("storedUsername: " + storedUsername);
        //System.out.println("storedMail: " + storedMail);



        String password = passwordField.getText().toString();
        String confirmPassword = confirmPasswordField.getText().toString();

        if (!username.getText().toString().equals(storedUsername) || !email.getText().toString().equals(storedMail)) {
            confirmation.setText("Username or emails do not match!");
            return;
        }
        if ((password.length() < 6) || (confirmPassword.length() < 6)){
            confirmation.setText("Password length should be atleast 6!");
            return;
        }

        if (!password.equals(confirmPassword)) {
            confirmation.setText("Passwords do not match!");
            return;
        }

        if(password.matches("^[a-zA-Z0-9]*$")) {
            confirmation.setText("Must contain AlphaNumeric and Symbols!");
            return;
        }

        try {
            FileWriter pinWriter = new FileWriter("C:\\Users\\Admin\\IdeaProjects\\QuizManagementSystem\\src\\Files\\adminTemp.txt");
            pinWriter.write("" + password);
            pinWriter.close();
//            System.out.println("Successfully wrote to the file.");
            confirmation.setText("Password changed successfully!");
        } catch (IOException e) {
            System.out.println("An error occurred at 90.");
            e.printStackTrace();
        }
    }

    public void homePage(ActionEvent event) throws IOException {
        Main m = new Main();
        m.changeScene("adminLogin.fxml");

    }

}
