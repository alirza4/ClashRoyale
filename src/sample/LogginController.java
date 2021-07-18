package sample;

import com.sun.xml.internal.bind.v2.runtime.unmarshaller.Loader;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.*;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Random;
import java.util.ResourceBundle;

public class LogginController {
    Stage stage=new Stage();
    @FXML
    private TextField username;

    @FXML
    private Button login;

    @FXML
    private PasswordField password;

    @FXML
    private RadioButton showPassword;

    @FXML
    private Button signUp;

    @FXML
    private TextField textpass;

    @FXML
    private Label Label;

    @FXML
    void login(ActionEvent event) {
        if (showPassword.isSelected()) {
            textpass.setText(password.getText()) ;
            textpass.setVisible(true);
            password.setVisible(false);
            return;
        }
        password.setText(textpass.getText()) ;
        password.setVisible(true);
        textpass.setVisible(false);
    }

    @FXML
    void loginAction(ActionEvent event) {

        if ( event.getSource() == login ){
            Random random=new Random();
            int rand=random.nextInt(2);
            String name=username.getText();
            try(FileReader fileReader=new FileReader(name) ;
                BufferedReader bufferedReader=new BufferedReader(fileReader)){
                int character;
                boolean s=false;
                String pass="";
                while((character= bufferedReader.read()) != -1){
                    if(s) {
                        pass += ((char) character);
                    }
                    if((char)character==' ') {
                        s=true;
                    }
                }
                System.out.println(pass);
                if(pass.equals(password.getText())){
                    System.out.println("1");
                    Main main=new Main();
                    FXMLLoader loader=new FXMLLoader(getClass().getResource("menu1.fxml"));
                    Parent root=loader.load();
                    MenuController menu=loader.getController();
                    menu.setUsername(username.getText());
                    Stage stage = new Stage();
                    stage.setScene(new Scene(root));
                    stage.setTitle("Second Window");
                    stage.show();
                    main.unvisible();
//                    if (rand==0){
//                        main.changeScene("menu1.fxml");
//                    }
//                    else if (rand==1)
//                    {
//                        main.changeScene("menu2.fxml");
//                    }
//                    else {
//                        main.changeScene("menu3.fxml");
//                    }
                }else{
                    Label.setText("Password Incorrect");
                }
            }catch(IOException e){
                e.printStackTrace();
            }
        }
    }

    @FXML
    void signUpAction(ActionEvent event) {
        if ( event.getSource() == signUp ) {
           try {
               Main main=new Main();
               main.changeScene("SignUp.fxml");
           }catch (IOException e){
               e.printStackTrace();
           }
        }
    }
    public void transst(Stage stage1){
        stage=stage1;
    }
    private void initialize(URL location , ResourceBundle resourceBundle){
        this.login(null);
    }

}
class Player implements Serializable {

    String username;
    String pass;

    public Player(String username , String pass) {
        this.username = username;
        this.pass=pass;
    }
}