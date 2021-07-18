package sample;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
public class ProfileController {
    String username;
    ArrayList<String> Cimages=new ArrayList<>();
    public void trans(String username) {
        this.username = username;
    }

    ArrayList<Image>images=new ArrayList<>();

    {
        Image mini=new Image("image/mini.png");
        Image arrows=new Image("image/arrows.png");
        Image archer=new Image("image/archer.png");
        Image giant=new Image("image/giant.png");
        Image barbarians=new Image("image/barbarian.png");
        Image cannon=new Image("image/cannon.png");
        Image dragon=new Image("image/dragon.png");
        Image fireball=new Image("image/fireball.png");
//        images.add(archer);
//        images.add(arrows);
//        images.add(giant);
//        images.add(cannon);
//        images.add(dragon);
//        images.add(fireball);
//        images.add(mini);
//        images.add(barbarians);
    }

    @FXML
    private Button back;

    @FXML
    private HBox ccu;

    @FXML
    private HBox ccd;
    @FXML
    private Button show;

    @FXML
    void initialize(ActionEvent event) {
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
            System.out.println(images.size());
            for (int i = 0; i < 4; i++) {
                ImageView imgv=new ImageView();
                imgv.setFitHeight(90);
                imgv.setFitWidth(67);
                imgv.setImage(images.get(i));
                System.out.println("1");
                ccu.getChildren().add(imgv);
                System.out.println("2");
                ccu.setSpacing(32);
            }
            for (int i = 4; i < 8; i++) {
                ImageView imgv=new ImageView();
                imgv.setFitHeight(90);
                imgv.setFitWidth(67);
                imgv.setImage(images.get(i));
                ccd.getChildren().add(imgv);
                ccd.setSpacing(32);
            }
    }
    @FXML
    void backClick(ActionEvent event) throws IOException {
        FXMLLoader loader=new FXMLLoader(getClass().getResource("menu1.fxml"));
        Parent root=loader.load();
        MenuController menu=loader.getController();
        menu.setUsername(username);
        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.setTitle("Menu");
        stage.show();
        menu.unvisible();
    }
//    public void initialize(){
//        System.out.println(username);
//        try(FileReader fileReader=new FileReader(username+"Cards");
//            BufferedReader bufferedReader=new BufferedReader(fileReader)) {
//            int character;
//            boolean s = false;
//            String namecard = "";
//
//            while ((character = bufferedReader.read()) != -1) {
//                if (s) {
//                    if ((char) character=='.'){
//                        Cimages.add(namecard);
//                        namecard="";
//                        s=false;
//                    }
//                    else {
//                        namecard += ((char) character);
//                    }
//                }
//                if ((char) character == '?') {
//                    s = true;
//                }
//            }
//        }catch (Exception e){
//            e.printStackTrace();
//        }
//        for (String s:Cimages) {
//            System.out.println(s);
//            Image i=new Image("image/"+s+".png");
//            images.add(i);
//        }
//        System.out.println(images.size());
//        for (int i = 0; i < 4; i++) {
//            ImageView imgv=new ImageView();
//            imgv.setFitHeight(90);
//            imgv.setFitWidth(67);
//            imgv.setImage(images.get(i));
//            System.out.println("1");
//            ccu.getChildren().add(imgv);
//            System.out.println("2");
//            ccu.setSpacing(32);
//        }
//        for (int i = 4; i < 8; i++) {
//            ImageView imgv=new ImageView();
//            imgv.setFitHeight(90);
//            imgv.setFitWidth(67);
//            imgv.setImage(images.get(i));
//            ccd.getChildren().add(imgv);
//            ccd.setSpacing(32);
//        }
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//    }


    }

