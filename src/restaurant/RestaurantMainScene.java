package restaurant;

import Rooms.ManagingRooms;
import Rooms.Room;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import sample.Main;

import java.io.FileInputStream;

public class RestaurantMainScene extends Application {

    public static void main(String[] args){
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        stage = new Stage();
        stage.setScene(getRestaurantScene());
        stage.show();
    }

    public Scene getRestaurantScene(){
        ManagingRooms M = new ManagingRooms();
        Room[] rooms = M.getRooms();

        Button order = new Button();
        order.setPrefHeight(25);
        order.setPrefWidth(200);
        try {
            Background background = new Background(new BackgroundImage(new Image(new FileInputStream("icons/OrderFoodItemsButton.png")), BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER,new BackgroundSize(250,30,false,false, false,false)));

            order.setBackground(background);
        }catch (Exception ex){

        }

        Button add = new Button();
        add.setPrefHeight(25);
        add.setPrefWidth(200);
        try {
            Background background = new Background(new BackgroundImage(new Image(new FileInputStream("icons/AddFoodIdemsButton.png")), BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER,new BackgroundSize(250,30,false,false, false,false)));

            add.setBackground(background);
        }catch (Exception ex){

        }

        Button remove = new Button();
        remove.setPrefHeight(25);
        remove.setPrefWidth(200);
        try {
            Background background = new Background(new BackgroundImage(new Image(new FileInputStream("icons/RemoveOrderButton.png")), BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER,new BackgroundSize(250,30,false,false, false,false)));

            remove.setBackground(background);
        }catch (Exception ex){

        }

        Button show = new Button();
        show.setPrefHeight(25);
        show.setPrefWidth(200);
        try {
            Background background = new Background(new BackgroundImage(new Image(new FileInputStream("icons/ShowOrderButton.png")), BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER,new BackgroundSize(250,30,false,false, false,false)));

            show.setBackground(background);
        }catch (Exception ex){

        }

        Button back= new Button();
        back.setPrefHeight(25);
        back.setPrefWidth(200);
        try {
            Background background = new Background(new BackgroundImage(new Image(new FileInputStream("icons/BackButton.png")), BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER,new BackgroundSize(250,30,false,false, false,false)));

            back.setBackground(background);
        }catch (Exception ex){

        }

        order.setOnAction(e-> {
            try {
                OrderScene o = new OrderScene();

                Main.window.setScene(o.getThatScene());
            }catch (Exception ex){

            }
        });
        add.setOnAction(e-> {
            try {
                ResScene o = new ResScene();

                Main.window.setScene(o.getResServiceScene());
            }catch (Exception ex){

            }
        });
        remove.setOnAction(e-> {
            try {
                RmvScene o = new RmvScene();

                Main.window.setScene(o.getRemoveScene());
            }catch (Exception ex){

            }
        });
        show.setOnAction(e-> {
            try {
                ResTfile o = new ResTfile();

                Main.window.setScene(o.FileTable());
            }catch (Exception ex){

            }
        });

        back.setOnAction(e-> {
            Main mm = new Main();

            Main.window.setScene(mm.mainScene());
        });

        VBox vBox = new VBox();

        vBox.getChildren().addAll(new Label(), new Label(), new Label(), new Label(), new Label(), order, new Label(), add, new Label(), remove, new Label(), show, new Label(), back);
        vBox.setAlignment(Pos.CENTER);

        HBox hBox = new HBox();
        hBox.getChildren().addAll(vBox, new Label("                                                                                                                                                                "));
        hBox.setAlignment(Pos.CENTER);

        try {
            Background background = new Background(new BackgroundImage(new Image(new FileInputStream("icons/TSAFoodHubScene.png")), BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER,new BackgroundSize(1050,750,false,false, false,false)));

            hBox.setBackground(background);
        }catch (Exception ex){

        }

        Scene scene1 = new Scene(hBox,1050,750);

        return scene1;
    }

}
