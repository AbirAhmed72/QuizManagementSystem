package SPL_1;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class StudentSignInController {

    @FXML
    private Label studentSignInError;
    @FXML
    private Label enrollSuccess;
    @FXML
    private Button studentEnroll;
    @FXML
    private Button studentSignInBack;
    @FXML
    private TextField studentSetName;
    @FXML
    private TextField studentSetAddress;
    @FXML
    private DatePicker studentSetDOB;
    @FXML
    private TextField studentSetMail;
    @FXML
    private PasswordField studentSetPass;

    public void studentSignInBackButton(ActionEvent event) throws IOException{
        Main m = new Main();
        m.changeScene("homepage.fxml");
    }

    public void studentEnrollButton(ActionEvent event) throws IOException {

//        String storedStudentUsername = "";
//        String storedStudentPassword = "";
//
//        System.out.println("storedStudentUsername: " + storedStudentUsername);
//        System.out.println("storedStudentPassword: " + storedStudentPassword);
//
//        try {
//            File studentUsernameFile = new File("C:\\Users\\Admin\\IdeaProjects\\QuizManagementSystem\\src\\Files\\studentUsername.txt");
//            System.out.println(studentUsernameFile.getAbsolutePath());
//            File studentPasswordFile = new File("C:\\Users\\Admin\\IdeaProjects\\QuizManagementSystem\\src\\Files\\studentPassword.txt");
//            System.out.println(studentPasswordFile.getAbsolutePath());
//
//            Scanner usernameScanner = new Scanner(studentUsernameFile);
//            Scanner phoneScanner = new Scanner(studentPasswordFile);
//
//            storedStudentUsername = usernameScanner.nextLine();
//            storedStudentPassword = phoneScanner.nextLine();
//
//            usernameScanner.close();
//            phoneScanner.close();
//        } catch (Exception e) {
//            System.out.println("Exception caught.");
//            e.printStackTrace();
//        }
//
//        System.out.println("storedStudentUsername: " + storedStudentUsername);
//        System.out.println("storedStudentPassword: " + storedStudentPassword);

//        if (!studentSetName.getText().toString().equals(storedStudentUsername) || !mobile.getText().toString().equals(storedStudentPassword)) {
//            confirmation.setText("Username or Mobile do not match!");
//            return;
//        }

        String studentName = studentSetName.getText().toString();
        String studentAddress = studentSetAddress.getText().toString();
        //String studentDOB = studentSetDOB.getValue().toString();
        String studentMail = studentSetMail.getText().toString();
        String studentPass = studentSetPass.getText().toString();

        if(studentName.isEmpty() || studentAddress.isEmpty() || studentMail.isEmpty() || studentPass.isEmpty()){
            studentSignInError.setText(("Please fillout all the fields!"));
        }

        else if(studentPass.length() < 6) {
            studentSignInError.setText("Password length should be atleast 6!");
            return;
        }

        else if(studentPass.matches("^[a-zA-Z0-9]*$")) {
            studentSignInError.setText("Must contain AlphaNumeric and Symbols!");
            return;
        }

        else if (!studentName.startsWith("@")){
            studentSignInError.setText("Username must start with @ symbol");
            return;
        }

        else {
            try {
                FileWriter studentUsernameWriter = new FileWriter("C:\\Users\\Admin\\IdeaProjects\\QuizManagementSystem\\src\\Files\\studentUsername.txt");
                studentUsernameWriter.write("" + studentName);
                studentUsernameWriter.close();

                FileWriter studentCredentialsWriter = new FileWriter("C:\\Users\\Admin\\IdeaProjects\\QuizManagementSystem\\src\\Files\\studentCredentials.txt");
                studentCredentialsWriter.write("" + studentAddress + "\n" + studentMail);
                studentCredentialsWriter.close();

                FileWriter studentPasswordWriter = new FileWriter("C:\\Users\\Admin\\IdeaProjects\\QuizManagementSystem\\src\\Files\\studentPassword.txt");
                studentPasswordWriter.write("" + studentPass);
                studentPasswordWriter.close();

                System.out.println("Successfully wrote to the file.");
                studentSignInError.setText("Credentials saved successfully!");
                enrollSuccess.setText("Now You're a QuizBizzer Too!");

            } catch (IOException e) {
                System.out.println("An error occurred.");
                e.printStackTrace();
            }
        }
    }

}
