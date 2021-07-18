package sample;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.text.Text;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import static java.lang.Thread.sleep;

public class LoadingController {

    @FXML
    private Label Label;
    @FXML
     void Load() throws IOException {
        TimeUnit timeUnit= TimeUnit.SECONDS;
        try {
            timeUnit.sleep(1);
        }catch ( InterruptedException e){
            e.printStackTrace();
        }
        Main main= new Main();
        main.changeScene("Loggin.fxml");


    }
}