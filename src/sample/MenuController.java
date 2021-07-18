package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class MenuController {
    String username;
   static Stage stage;
    public void setUsername(String username) {
        this.username = username;
    }

    @FXML
    private Button nono;
    @FXML
    private Button Profile;

    @FXML
    private Button BattleDeck;

    @FXML
    private Button TrainingCamp;

    @FXML
    private Button BattleHistory;

    @FXML
    void ClickButton(ActionEvent event) throws Exception {
        System.out.println(username);
        Main main=new Main();
        if (event.getSource().equals(BattleDeck)){
            System.out.println("1");
            FXMLLoader loader=new FXMLLoader(getClass().getResource("BDeck.fxml"));
            Parent root=loader.load();
            BattleDeck battleDeck=loader.getController();
            battleDeck.trans(username);
            stage=(Stage)BattleDeck.getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.setTitle("Battle Deck");
            stage.show();
            main.unvisible();

        }
        else if (event.getSource().equals(Profile)){
            FXMLLoader loader=new FXMLLoader(getClass().getResource("Profile.fxml"));
            Parent root=loader.load();
            ProfileController profile=loader.getController();
            profile.trans(username);
            stage=(Stage)Profile.getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.setTitle("Profile");
            stage.show();
            main.unvisible();
        }else if (event.getSource().equals(TrainingCamp)){
            FXMLLoader loader=new FXMLLoader(getClass().getResource("Game.fxml"));
            Parent root=loader.load();
            GroundController game=loader.getController();
            game.setUsername(username);
            stage=(Stage)TrainingCamp.getScene().getWindow();
            stage.setHeight(847);
            stage.setWidth(1200);
            stage.setScene(new Scene(root));
            stage.setTitle("Game");
            stage.show();
            main.unvisible();
        }
    }
    public void unvisible(){
        stage.hide();
    }

}
