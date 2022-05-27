package SPL_1;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import java.io.*;
import java.util.Scanner;

import static SPL_1.DES.doDecrypt;
import static SPL_1.DES.doEncrypt;

public class AdminLoginController {

    @FXML
    private Label adminError;
    @FXML
    private Button adminLogin;
    @FXML
    private Button adminLoginBack;
    @FXML
    private TextField adminUser;
    @FXML
    private PasswordField adminPassword;


    public AdminLoginController() throws FileNotFoundException {
    }

    public void adminLoginBackButton(ActionEvent event) throws IOException {
        Main m = new Main();
        m.changeScene("homepage.fxml");

    }

    public void adminLoginButton(ActionEvent event) throws IOException {

//        storedTempPassword = adminPassword.getText();
//        System.out.println(storedTempPassword);
//        FileWriter passFileWriter = new FileWriter("C:\\Users\\Admin\\IdeaProjects\\QuizManagementSystem\\src\\Files\\adminTemp.txt");
//        BufferedWriter passBufferedWriter = new BufferedWriter(passFileWriter);
//        passBufferedWriter.write(storedTempPassword);
//        System.out.println(tempPasswordScanner.next());
//        doEncrypt(adminPasswordTemp, adminPasswordTemp);
        checkLogin();

    }

    private void checkLogin() throws IOException {
        Main m = new Main();


        String storedUsername = "";
        String storedPassword = "";


//        System.out.println("storedUsername: " + storedUsername);
//        System.out.println("storedPassword: " + storedPassword);


        try {

            File adminUsernameFile = new File("C:\\Users\\Admin\\IdeaProjects\\QuizManagementSystem\\src\\Files\\adminUsername.txt");
            //System.out.println(adminUsernameFile.getAbsolutePath());
            File adminPasswordFile = new File("C:\\Users\\Admin\\IdeaProjects\\QuizManagementSystem\\src\\Files\\adminTemp.txt");
            //System.out.println(adminPasswordFile.getAbsolutePath());
            File adminPasswordTemp = new File("C:\\Users\\Admin\\IdeaProjects\\QuizManagementSystem\\src\\Files\\adminPassword.txt");

            doEncrypt(adminPasswordFile, adminPasswordTemp);
            doDecrypt(adminPasswordTemp, adminPasswordTemp);


            Scanner usernameScanner = new Scanner(adminUsernameFile);
            Scanner passwordScanner = new Scanner(adminPasswordFile);

            storedUsername = usernameScanner.nextLine();
            storedPassword = passwordScanner.nextLine();

            usernameScanner.close();
            passwordScanner.close();


        }catch(Exception e){
            System.out.println("Exception caught.");
            e.printStackTrace();
        }

//        doDecrypt();

//        System.out.println("storedUsername: " + storedUsername);
//        System.out.println("storedPassword: " + storedPassword);

        if(adminUser.getText().toString().equals(storedUsername) && adminPassword.getText().equals(storedPassword)) {
            adminError.setText("Success!");

            m.changeScene("adminDashboard.fxml");
        }

        else if(adminUser.getText().isEmpty() || adminPassword.getText().isEmpty()) {
            adminError.setText("Please enter all of your credentials!");
        }

        else {
            adminError.setText("Wrong username or password!");
        }
    }
}
