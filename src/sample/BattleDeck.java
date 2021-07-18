package sample;
import javafx.animation.Transition;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

import javax.imageio.stream.FileImageOutputStream;
import javax.swing.*;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Random;


public class BattleDeck {
    String player;
    public void trans(String m){
        player=m;
    }
    public BattleDeck(){

    }
    public void setPlayer(String player) {
        this.player = player;
    }

    public HBox upc;
    public HBox dc;
    public ArrayList<Image>ccuimage=new ArrayList<>();
    public ArrayList<Image>ccdimage=new ArrayList<>();
    public ArrayList<Image>images=new ArrayList<>();
    public ArrayList<Image>Ccimage=new ArrayList<>();
    public ArrayList<String>cardname=new ArrayList<>();
    {

        Image arrows=new Image("image/arrows.png");
        Image archer=new Image("image/archer.png");
        Image giant=new Image("image/giant.png");
        Image barbarians=new Image("image/barbarian.png");
        Image cannon=new Image("image/cannon.png");
        Image dragon=new Image("image/dragon.png");
        Image fireball=new Image("image/fireball.png");
        Image mini=new Image("image/mini.png");
        Image rage=new Image("image/rage.png");
        Image tower=new Image("image/tower.png");
        Image wizard=new Image("image/wizard.png");
        Image valkk=new Image("image/valk.png");
        images.add(archer);
        images.add(arrows);
        images.add(giant);
        images.add(cannon);
        images.add(dragon);
        images.add(fireball);
        images.add(mini);
        images.add(barbarians);
        images.add(rage);
        images.add(tower);
        images.add(wizard);
        images.add(valkk);
    }
        @FXML
        private HBox ccu;

        @FXML
        private HBox ccd;

        @FXML
        private HBox cu;

        @FXML
        private HBox cm;

        @FXML
        private HBox cd;
        @FXML
        private Button back;
        @FXML
        private Label label;

    @FXML
    void backAction(ActionEvent event) throws IOException {
        if (Ccimage.size()!=8){
            label.setText("Choose 8 Cards");
        }else {
            Random random=new Random();
            int rand=random.nextInt(3);
            System.out.println(player);
            try(FileOutputStream outputStream = new FileOutputStream(player+"Cards");
                ObjectOutputStream obj=new ObjectOutputStream(outputStream)) {
                for (Image image:Ccimage){
                    obj.writeObject('?'+image.impl_getUrl().substring(99));
                }
                outputStream.close();
                obj.close();

            }catch (Exception e){
                e.printStackTrace();
            }

            try {
                Main main=new Main();
                FXMLLoader loader=new FXMLLoader(getClass().getResource("menu1.fxml"));
                Parent root=loader.load();
                MenuController menu=loader.getController();
                menu.setUsername(player);
                Stage stage = new Stage();
                stage.setScene(new Scene(root));
                stage.setTitle("Menu");
                stage.show();
                menu.unvisible();
            }catch (Exception e){
                e.printStackTrace();
                System.out.println("2");
            }
        }
    }
    public void initialize(){

        for (int i = 0; i < 4; i++) {
            ImageView imgv=new ImageView();
            imgv.setFitHeight(90);
            imgv.setFitWidth(67);
            imgv.setOnMouseClicked(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent event) {
                    if (cu.getChildren().contains(imgv)){
                        if (ccu.getChildren().size()<4){
                            ccu.getChildren().add(imgv);
                            cu.getChildren().remove(imgv);
                            ccu.setSpacing(32);
                            Ccimage.add(imgv.getImage());
                            System.out.println(Ccimage.size());
                        }else if(ccd.getChildren().size()<4){
                            ccd.getChildren().add(imgv);
                            ccd.setSpacing(32);
                            cu.getChildren().remove(imgv);
                            Ccimage.add(imgv.getImage());
                            System.out.println(Ccimage.size());
                        }else {
                            System.out.println("no");
                        }
                    }
                    else if (ccu.getChildren().contains(imgv)){
                            cu.getChildren().add(imgv);
                            Ccimage.remove(imgv.getImage());
                            ccu.getChildren().remove(imgv);
                            cu.setSpacing(32);
                        System.out.println(Ccimage.size());
                    }
                    else if (ccd.getChildren().contains(imgv)){
                            cu.getChildren().add(imgv);
                        Ccimage.remove(imgv.getImage());
                            ccd.getChildren().remove(imgv);
                            cu.setSpacing(32);
                        System.out.println(Ccimage.size());
                    }
                }
            });
            imgv.setImage(images.get(i));
            cu.getChildren().add(imgv);
            cu.setSpacing(32);
        }
        for (int i = 4; i < 8; i++) {
            ImageView imgv=new ImageView();
            imgv.setFitHeight(90);
            imgv.setFitWidth(67);
            imgv.setOnMouseClicked(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent event) {
                    if (cm.getChildren().contains(imgv)){
                        if (ccu.getChildren().size()<4){
                            ccu.getChildren().add(imgv);
                            cm.getChildren().remove(imgv);
                            ccu.setSpacing(32);
                            Ccimage.add(imgv.getImage());
                            System.out.println(Ccimage.size());
                        }else if(ccd.getChildren().size()<4){
                            ccd.getChildren().add(imgv);
                            ccd.setSpacing(32);
                            cm.getChildren().remove(imgv);
                            Ccimage.add(imgv.getImage());
                        }else {
                            System.out.println("no");
                        }
                    }
                    else if (ccu.getChildren().contains(imgv)){
                            cm.getChildren().add(imgv);
                            ccu.getChildren().remove(imgv);
                            Ccimage.remove(imgv.getImage());
                            cm.setSpacing(32);
                        System.out.println(Ccimage.size());
                    }
                    else if (ccd.getChildren().contains(imgv)){
                            cm.getChildren().add(imgv);
                            ccd.getChildren().remove(imgv);
                            Ccimage.remove(imgv.getImage());
                            cm.setSpacing(32);
                    }
                }
            });
            imgv.setImage(images.get(i));
            cm.getChildren().add(imgv);
            cm.setSpacing(32);
        }
        for (int i = 8; i < 12; i++) {
            ImageView imgv=new ImageView();
            imgv.setFitHeight(90);
            imgv.setFitWidth(67);
            imgv.setOnMouseClicked(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent event) {
                    System.out.println("3");
                    if (cd.getChildren().contains(imgv)){
                        if (ccu.getChildren().size()<4){
                            ccu.getChildren().add(imgv);
                            cd.getChildren().remove(imgv);
                            ccu.setSpacing(32);
                            Ccimage.add(imgv.getImage());
                            System.out.println(Ccimage.size());
                        }else if(ccd.getChildren().size()<4){
                            ccd.getChildren().add(imgv);
                            ccd.setSpacing(32);
                            cd.getChildren().remove(imgv);
                            Ccimage.add(imgv.getImage());
                        }else {
                            System.out.println("no");
                        }
                    }
                    else if (ccu.getChildren().contains(imgv)){
                            cd.getChildren().add(imgv);
                            Ccimage.remove(imgv.getImage());
                            ccu.getChildren().remove(imgv);
                            cd.setSpacing(32);
                        System.out.println(Ccimage.size());
                    }
                    else if (ccd.getChildren().contains(imgv)){
                            cd.getChildren().add(imgv);
                            Ccimage.remove(imgv.getImage());
                            ccd.getChildren().remove(imgv);
                            cd.setSpacing(32);
                    }

                }
            });
            imgv.setImage(images.get(i));
            cd.getChildren().add(imgv);
            cd.setSpacing(32);
        }
    }
}
