package sample;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.Random;

public class SignUpController {

    @FXML
    private Button Ok;

    @FXML
    private TextField Username;

    @FXML
    private PasswordField Password;

    @FXML
    private PasswordField ConfirmPassword;

    @FXML
    private Label Label;

    @FXML
    void SignUp(ActionEvent event) {
        if ( event.getSource() == Ok ) {
            if (Password.getText().equals(ConfirmPassword.getText())){
                Random random=new Random();
                int rand=random.nextInt(3);
                Player player=new Player(Username.getText() , Password.getText());
                try(FileOutputStream outputStream = new FileOutputStream(Username.getText());
                    ObjectOutputStream obj=new ObjectOutputStream(outputStream)){
                    obj.writeObject(" "+player.pass);
                    Main main=new Main();
                    FXMLLoader loader=new FXMLLoader(getClass().getResource("menu1.fxml"));
                    Parent root=loader.load();
                    MenuController menu=loader.getController();
                    menu.setUsername(Username.getText());
                    Stage stage = new Stage();
                    stage.setScene(new Scene(root));
                    stage.setTitle("Second Window");
                    stage.show();
                    main.unvisible();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
            else {
                Label.setText("Your ConfirmPassword Not Match");
            }

        }
    }

}
