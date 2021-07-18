package sample;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

public class GroundController {
    public String username;
    int k=4;
    public ArrayList<Image>images=new ArrayList<>();
    public ArrayList<Image>Pimages=new ArrayList<>();
    public ArrayList<Image>Oimages=new ArrayList<>();
    ArrayList<String> Cimages=new ArrayList<>();
    public void setUsername(String username) {
        this.username = username;
    }

    @FXML
    private Button ready;
    @FXML
    private VBox cards;

    @FXML
    void clickReady(ActionEvent event)throws Exception {
        ready.setVisible(false);
        System.out.println(username);
        try(FileReader fileReader=new FileReader(username+"Cards");
            BufferedReader bufferedReader=new BufferedReader(fileReader)) {
            int character;
            boolean s = false;
            String namecard = "";

            while ((character = bufferedReader.read()) != -1) {
                if (s) {
                    if ((char) character=='.'){
                        Cimages.add(namecard);
                        namecard="";
                        s=false;
                    }
                    else {
                        namecard += ((char) character);
                    }
                }
                if ((char) character == '?') {
                    s = true;
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        for (String s:Cimages) {
            System.out.println(s);
            Image i=new Image("image/"+s+".png");
            images.add(i);
        }

        for (int i = 0; i < 4; i++) {
            Pimages.add(images.get(i));
        }

        for (int i = 4; i < 8; i++) {
            Oimages.add(images.get(i));
        }

        for (int i = 0; i < Pimages.size(); i++) {
            ImageView imgv=new ImageView();
            imgv.setFitHeight(120);
            imgv.setFitWidth(97);
            imgv.setOnMouseClicked(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent event) {
                    Oimages.add(imgv.getImage());
                    Pimages.remove(imgv.getImage());
                    cards.getChildren().remove(imgv);
                    imgv.setImage(Oimages.get(0));
                    Pimages.add(Oimages.get(0));
                    Oimages.remove(0);
                    cards.getChildren().add(imgv);
                }
            });
            imgv.setImage(Pimages.get(i));
            cards.getChildren().add(imgv);
        }
    }

}
