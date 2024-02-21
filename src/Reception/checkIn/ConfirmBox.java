package Reception.checkIn;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.FileInputStream;

public class ConfirmBox extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        display("hi");
    }

    public static void display(String message){
        Stage window = new Stage();

        window.initModality(Modality.APPLICATION_MODAL);
        try {
            window.getIcons().add(new Image(new FileInputStream("icons/TSAAppIcon.png")));
        }catch (Exception ex){
            System.out.println("Ico");
        }
        window.setTitle("Confirmation Box");
        window.setHeight(300);
        window.setWidth(400);

        Label label = new Label();
        label.setText(message);
        label.setFont(new Font("Arial", 20));
        label.setStyle("-fx-font-weight: bold");
        label.setTextFill(Color.web("#2f479e"));

        Label label1 = new Label();

        Button ok = new Button();
        ok.setPrefWidth(110);
        ok.setPrefHeight(25);
        ok.setFont(new Font("Arial", 14));
        try {
            Background background = new Background(new BackgroundImage(new Image(new FileInputStream("icons/ConfirmButton.png")), BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER,new BackgroundSize(250,30,false,false, false,false)));

            ok.setBackground(background);
        }catch (Exception ex){

        }

        ok.setOnAction(e-> {
            window.close();
        });

        VBox layout = new VBox();
        layout.getChildren().addAll(label, label1,ok);
        layout.setAlignment(Pos.CENTER);

        try {
            Background background = new Background(new BackgroundImage(new Image(new FileInputStream("icons/ConfirmBoxLandscape.png")), BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER,new BackgroundSize(400,300,false,false, false,false)));

            layout.setBackground(background);
        }catch (Exception ex){

        }

        Scene scene = new Scene(layout);
        window.setScene(scene);
        window.showAndWait();
    }
}
