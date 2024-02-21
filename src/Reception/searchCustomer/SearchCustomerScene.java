package Reception.searchCustomer;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import sample.Main;

import java.io.FileInputStream;

public class SearchCustomerScene extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        stage.setScene(getSearchCustomerScene());
        stage.show();
    }

    public Scene getSearchCustomerScene() {
        Label label1, label2, label3, label4, label5, label6, label7, label8;

        GridPane gridPane = new GridPane();
        gridPane.setAlignment(Pos.CENTER);

        label1 = new Label();
        label1.setFont(new Font("Arial", 16));
        label1.setStyle("-fx-font-weight: bold");
        label1.setTextFill(Color.web("#2f479e"));
        label2 = new Label();
        label3 = new Label();

        VBox root1 = new VBox();
        root1.getChildren().addAll(label1, label2, label3);
        gridPane.add(root1, 0, 0);

        label4 = new Label("Customer Name ");
        label4.setFont(new Font("Arial", 16));
        label4.setStyle("-fx-font-weight: bold");
        label4.setTextFill(Color.web("#2f479e"));

        TextField textField1 = new TextField();
        textField1.setFont(new Font("Arial", 16));
        gridPane.add(label4, 0,1);
        gridPane.add(textField1, 1,1);

        label5 = new Label();
        gridPane.add(label5, 0,2);

        label6 = new Label("Phone Number ");
        label6.setFont(new Font("Arial", 16));
        label6.setStyle("-fx-font-weight: bold");
        label6.setTextFill(Color.web("#2f479e"));

        TextField textField2 = new TextField();
        textField2.setFont(new Font("Arial", 16));
        gridPane.add(label6, 0,3);
        gridPane.add(textField2, 1,3);

        label7 = new Label();
        label8 = new Label();
        Button search = new Button();
        search.setPrefWidth(110);
        search.setPrefHeight(25);
        search.setFont(new Font("Arial", 14));
        try {
            Background background = new Background(new BackgroundImage(new Image(new FileInputStream("icons/SearchButton.png")), BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER,new BackgroundSize(250,33,false,false, false,false)));

            search.setBackground(background);
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

        gridPane.add(label7, 0,4);
        gridPane.add(label8, 0,5);
        gridPane.add(search, 0,6);
        gridPane.add(back, 1,6);

        search.setOnAction(e-> {
            ShowDetails S = new ShowDetails();

            Main.window.setScene(S.getShowDetails(textField1.getText(), textField2.getText()));

            textField1.setText("");
            textField2.setText("");
        });

        back.setOnAction(e-> {
            Main mm = new Main();

            Main.window.setScene(mm.mainScene());
        });

        HBox hBox = new HBox();
        hBox.getChildren().addAll(gridPane, new Label("                                                                                                                                                                                                 "));
        hBox.setAlignment(Pos.CENTER);

        try {
            Background background = new Background(new BackgroundImage(new Image(new FileInputStream("icons/CustomerSearch.png")), BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER,new BackgroundSize(1050,750,false,false, false,false)));

            hBox.setBackground(background);
        }catch (Exception ex){

        }

        Scene searchCustomerScene = new Scene(hBox,1050, 750);
        return searchCustomerScene;
    }
}
