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
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Modality;
import javafx.stage.Stage;
import sample.Main;

import java.io.FileInputStream;


public class RmvScene extends Application {
    private int n;

    public static void main(String[] args) {

        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        try {
            stage.setScene(getRemoveScene());
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public Scene getRemoveScene() {
        ManagingRooms M = new ManagingRooms();
        ManagingRestaurant k = new ManagingRestaurant();

        k. LoadResFile();
        k. LoadBeverageFile();
        k. LoadBreFile();
        k. LoadDinFile();
        k.LoadLunFile();
        M.loadRoom();
        Label label1 = new Label("Removing No: ");
        label1.setFont(new Font("Arial", 16));
        label1.setStyle("-fx-font-weight: bold");
        label1.setTextFill(Color.web("#e3782b"));

        String list[] =  { "0: OrderList", "1: Breakfast Foodlist", "2: Lunch Foodlist","3: Dinner Foodlist","4: Beverage Foodlist" };

        ComboBox combo_box = new ComboBox(FXCollections.observableArrayList(list));

        EventHandler<ActionEvent> event =  new EventHandler<ActionEvent>() {
            public void handle(ActionEvent e)
            {
                String choice = combo_box.getValue().toString();
                n = Integer.parseInt(String.valueOf(choice.charAt(0)));
            }
        };
        combo_box.setOnAction(event);
        //TextField textField1 = new TextField();
        Label label2=new Label("Remove by food/room code: ");
        label2.setFont(new Font("Arial", 16));
        label2.setStyle("-fx-font-weight: bold");
        label2.setTextFill(Color.web("#e3782b"));

        TextField textField2=new TextField();
        label2.setFont(new Font("Arial", 16));

        GridPane gridPane = new GridPane();
        gridPane.add(label1, 0,0);
        gridPane.add(combo_box, 1,0);
        gridPane.add(new Label(), 0,1);
        gridPane.add(label2, 0,2);
        gridPane.add(textField2,1,2);

        gridPane.setAlignment(Pos.CENTER);

        Button okay = new Button();
        okay.setPrefWidth(110);
        okay.setPrefHeight(25);
        okay.setFont(new Font("Arial", 14));
        try {
            Background background = new Background(new BackgroundImage(new Image(new FileInputStream("icons/RemoveButton.png")), BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER,new BackgroundSize(250,33,false,false, false,false)));

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

        gridPane.add(new Label(), 0,7);
        gridPane.add(okay, 0,8);
        gridPane.add(back,1,8);

        VBox vBox = new VBox();

        vBox.getChildren().addAll(new Label(), new Label(), gridPane);
        vBox.setAlignment(Pos.CENTER);
        back.setOnAction(e-> {
            try {
                RestaurantMainScene o=new RestaurantMainScene();

                Main.window.setScene(o.getRestaurantScene());
            }catch (Exception ex){

            }
        });

        okay.setOnAction(e-> {
            Restaurant r=new Restaurant();

            k.RemoveFood(n,textField2.getText());

            Stage stage = new Stage();
            stage.initModality(Modality.APPLICATION_MODAL);
            try {
                stage.getIcons().add(new Image(new FileInputStream("icons/TSAAppIcon.png")));
            }catch (Exception ex){
                System.out.println("Ico");
            }
            stage.setTitle("Confirmation Box");

            Label label10 = new Label("Removed Sucessfully.....");
            label10.setFont(new Font("Arial", 16));
            label10.setStyle("-fx-font-weight: bold");
            label10.setTextFill(Color.web("#e3782b"));

            Button back2 = new Button();
            back2.setPrefWidth(110);
            back2.setPrefHeight(25);
            back2.setFont(new Font("Arial", 14));
            try {
                Background background = new Background(new BackgroundImage(new Image(new FileInputStream("icons/BackButton.png")), BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER,new BackgroundSize(250,33,false,false, false,false)));

                back2.setBackground(background);
            }catch (Exception ex){

            }


            GridPane gridPane1 = new GridPane();
            gridPane1.add(label10,0,0);

            gridPane1.add(new Label(),0,3);

            gridPane1.setAlignment(Pos.CENTER);
            VBox vBox1 = new VBox();

            vBox1.getChildren().addAll(gridPane1,new Label(), back2);
            vBox1.setAlignment(Pos.CENTER);

            try {
                Background background = new Background(new BackgroundImage(new Image(new FileInputStream("icons/ConfirmBoxLandscape.png")), BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER,new BackgroundSize(400,300,false,false, false,false)));

                vBox1.setBackground(background);
            }catch (Exception ex){

            }

            Scene scene1 = new Scene(vBox1,400,300);
            stage.setScene(scene1);
            stage.show();

            back2.setOnAction(e1-> {
                stage.close();
            });

            textField2.setText("");

        });

        HBox hBox = new HBox();
        hBox.getChildren().addAll(vBox, new Label("                                                                                                                                                                "));
        hBox.setAlignment(Pos.CENTER);

        try {
            Background background = new Background(new BackgroundImage(new Image(new FileInputStream("icons/FoodHubRemoveMenuScene.png")), BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER,new BackgroundSize(1050,750,false,false, false,false)));

            hBox.setBackground(background);
        }catch (Exception ex){

        }

        Scene scene = new Scene(hBox, 1050,750);

        return scene;
    }
}
