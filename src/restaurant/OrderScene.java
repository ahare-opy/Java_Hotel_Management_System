package restaurant;

import Rooms.ManagingRooms;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import sample.Main;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class OrderScene extends Application {
    private int n;


    public static void main(String[] args) {

        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        try {
            Main.window = new Stage();
            Main.window.setScene(getThatScene());
            Main.window.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Scene getThatScene() {
        ManagingRooms M = new ManagingRooms();
        ManagingRestaurant k = new ManagingRestaurant();


        Label label1 = new Label("Enter List :");
        label1.setFont(new Font("Arial", 16));
        label1.setStyle("-fx-font-weight: bold");
        label1.setTextFill(Color.web("#e3782b"));

        String list1[] = {"1: Breakfast FoodList", "2: Lunch FoodList", "3: Dinner FoodList", "4: Beverage FoodList"};

        ComboBox combo_box = new ComboBox(FXCollections.observableArrayList(list1));
        EventHandler<ActionEvent> event = new EventHandler<ActionEvent>() {
            public void handle(ActionEvent e) {
                String choice = combo_box.getValue().toString();
                n = Integer.parseInt(String.valueOf(choice.charAt(0)));
            }
        };
        combo_box.setOnAction(event);
        Label label5 = new Label();
        label5.setFont(new Font("Arial", 20));

        GridPane gridPane = new GridPane();
        gridPane.add(label1, 0, 0);
        gridPane.add(combo_box, 1, 0);
        gridPane.add(new Label(), 0, 1);

        gridPane.setHgap(10);

        gridPane.setAlignment(Pos.CENTER);

        Button okay = new Button();
        okay.setPrefWidth(110);
        okay.setPrefHeight(25);
        okay.setFont(new Font("Arial", 14));
        try {
            Background background = new Background(new BackgroundImage(new Image(new FileInputStream("icons/OkayButton.png")), BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER,new BackgroundSize(250,33,false,false, false,false)));

            okay.setBackground(background);
        }catch (Exception ex){

        }

        Button back = new Button();
        back.setPrefWidth(110);
        back.setPrefHeight(25);
        back.setFont(new Font("Arial", 14));
        try {
            Background background = new Background(new BackgroundImage(new Image(new FileInputStream("icons/BackButton.png")), BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER,new BackgroundSize(250,33,false,false, false,false)));

            back.setBackground(background);
        }catch (Exception ex){

        }

        gridPane.add(new Label(), 0, 7);
        gridPane.add(okay, 0, 8);
        gridPane.add(back, 1, 8);

        VBox vBox = new VBox();

        vBox.getChildren().addAll(label5, new Label(), gridPane);
        vBox.setAlignment(Pos.CENTER);
        back.setOnAction(e -> {
            try {
                RestaurantMainScene o = new RestaurantMainScene();

                Main.window.setScene(o.getRestaurantScene());
            } catch (Exception ex) {

            }
        });

        okay.setOnAction(e -> {
            OrderChooselist ex = new OrderChooselist();
            try {
                Main.window.setScene(ex.FileTable(n));
            } catch (FileNotFoundException exp) {
                exp.printStackTrace();
            }

        });

        HBox hBox = new HBox();
        hBox.getChildren().addAll(vBox, new Label("                                                                                                                                                                "));
        hBox.setAlignment(Pos.CENTER);

        try {
            Background background = new Background(new BackgroundImage(new Image(new FileInputStream("icons/FoodHubAddMenuScene.png")), BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER,new BackgroundSize(1050,750,false,false, false,false)));

            hBox.setBackground(background);
        }catch (Exception ex){

        }

        Scene scene = new Scene(hBox, 1050, 750);

        return scene;
    }



}
