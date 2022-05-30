package SPL_1;

import javax.crypto.*;
import javax.crypto.spec.DESKeySpec;
import java.io.*;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;

//import static org.graalvm.compiler.nodes.extended.StoreHubNode.write;

public class DES {
    public static void encryptDecrypt(String key, int cipherMode, File inputFile, File outputFile) throws InvalidKeyException,
            NoSuchAlgorithmException, InvalidKeySpecException, NoSuchPaddingException, IOException
    {
        FileInputStream fis = new FileInputStream(inputFile);
        FileOutputStream fos = new FileOutputStream(outputFile);

        DESKeySpec desKeySpec = new DESKeySpec(key.getBytes());

        SecretKeyFactory skf = SecretKeyFactory.getInstance("DES");
        SecretKey secretKey = skf.generateSecret(desKeySpec);

        Cipher cipher = Cipher.getInstance("DES/ECB/PKCS5Padding");

        if (cipherMode == Cipher.ENCRYPT_MODE) {
            cipher.init(Cipher.ENCRYPT_MODE, secretKey, SecureRandom.getInstance("SHA1PRNG"));
            CipherInputStream cis = new CipherInputStream(fis, cipher);
            write(cis, fos);
        }

        else if (cipherMode == Cipher.DECRYPT_MODE) {
            cipher.init(Cipher.DECRYPT_MODE, secretKey, SecureRandom.getInstance("SHA1PRNG"));
            CipherOutputStream cos = new CipherOutputStream(fos, cipher);
            write(fis, cos);
        }
    }

    private static void write(InputStream in, OutputStream out) throws IOException {
        byte[] buffer = new byte[64];
        int numOfBytesRead;
        while ((numOfBytesRead = in.read(buffer)) != -1) {
            out.write(buffer, 0, numOfBytesRead);
        }

        out.close();
        in.close();
    }

    public static void doEncrypt(File from, File to){

//        File adminUsernameFile = new File("C:\\Users\\Admin\\IdeaProjects\\QuizManagementSystem\\src\\Files\\adminUsername.txt");
//        System.out.println(adminUsernameFile.getAbsolutePath());
        File adminPasswordFile = new File("C:\\Users\\Admin\\IdeaProjects\\QuizManagementSystem\\src\\Files\\adminPassword.txt");
        //System.out.println(adminPasswordFile.getAbsolutePath());
        File adminPassTempFile = new File("C:\\Users\\Admin\\IdeaProjects\\QuizManagementSystem\\src\\Files\\adminTemp.txt");


        try {

            encryptDecrypt("12345678", Cipher.ENCRYPT_MODE, from, to);

//            System.out.println("Encryption complete");

        } catch (InvalidKeyException | NoSuchAlgorithmException | InvalidKeySpecException |
                NoSuchPaddingException | IOException e) {

            e.printStackTrace();

        }
    }

    public static void doDecrypt(File from, File to) {

        //File adminUsernameFile = new File("C:\\Users\\Admin\\IdeaProjects\\QuizManagementSystem\\src\\Files\\adminUsername.txt");
        //System.out.println(adminUsernameFile.getAbsolutePath());
        File adminPasswordFile = new File("C:\\Users\\Admin\\IdeaProjects\\QuizManagementSystem\\src\\Files\\adminPassword.txt");
        //System.out.println(adminPasswordFile.getAbsolutePath());
        File adminPassTempFile = new File("C:\\Users\\Admin\\IdeaProjects\\QuizManagementSystem\\src\\Files\\adminTemp.txt");


        try {

            encryptDecrypt("12345678", Cipher.DECRYPT_MODE, from, to);

//            System.out.println("Decryption complete");

        } catch (InvalidKeyException | NoSuchAlgorithmException | InvalidKeySpecException |
                NoSuchPaddingException | IOException e) {

            e.printStackTrace();

        }
    }

}

