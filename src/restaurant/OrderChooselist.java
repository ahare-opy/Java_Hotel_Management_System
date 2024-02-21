package restaurant;

import Rooms.ManagingRooms;
import Rooms.Room;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Modality;
import javafx.stage.Stage;
import sample.Main;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;

public class OrderChooselist extends Application {
    public static void main(String[] args) {
        launch(args);
    }


    @Override
    public void start(Stage stage) throws Exception {
        Main.window.setScene(FileTable(1));
        Main.window.show();
    }

    public ObservableList<Restaurant> getInf(int n) {
        ManagingRestaurant k = new ManagingRestaurant();
        ObservableList<Restaurant> r = FXCollections.observableArrayList();
        if (n == 1) {
            k.LoadBreFile();
            for (int i = 0; i < k.ra1.size(); i++) {

                r.add(k.ra1.get(i));
            }
        } else if (n == 2) {
            k.LoadLunFile();
            for (int i = 0; i < k.ra2.size(); i++) {
                r.add(k.ra2.get(i));
            }
        } else if (n == 3) {
            k.LoadDinFile();
            for (int i = 0; i < k.ra3.size(); i++) {
                r.add(k.ra3.get(i));
            }
        } else if (n == 4) {
            k.LoadBeverageFile();
            for (int i = 0; i < k.ra4.size(); i++) {
                r.add(k.ra4.get(i));
            }
        } else {

            k.LoadResFile();
            for (int i = 0; i < k.ra.size(); i++) {
                r.add(k.ra.get(i));
            }
        }


        return r;
    }

    public Scene FileTable(int k1) throws FileNotFoundException {
        ManagingRestaurant k = new ManagingRestaurant();
        ManagingRooms M = new ManagingRooms();
        Room[] rooms = M.getRooms();

        TableColumn<Restaurant, String> Code = new TableColumn<>("Food Code: ");
        Code.setMinWidth(100);
        Code.setCellValueFactory(new PropertyValueFactory<>("code"));

        TableColumn<Restaurant, String> B = new TableColumn<>("BDT");
        B.setMinWidth(100);
        B.setCellValueFactory(new PropertyValueFactory<>("BDT"));

        TableColumn<Restaurant, String> price = new TableColumn<>("Price :");
        price.setMinWidth(100);
        price.setCellValueFactory(new PropertyValueFactory<>("price"));

        TableColumn<Restaurant, String> name = new TableColumn<>("Food Name:");
        name.setMinWidth(200);
        name.setCellValueFactory(new PropertyValueFactory<>("name"));

        TableView<Restaurant> table = new TableView<>();
        table.setItems(getInf(k1));
        table.getColumns().addAll(Code, B, price, name);
        M.loadRoom();
        k.LoadResFile();
        Label label1 = new Label("Room No ");
        label1.setFont(new Font("Arial", 16));
        label1.setStyle("-fx-font-weight: bold");
        label1.setTextFill(Color.web("#e3782b"));

        TextField textField1 = new TextField();
        textField1.setFont(new Font("Arial", 16));

        Label label2 = new Label("Order Code: ");
        label2.setFont(new Font("Arial", 16));
        label2.setStyle("-fx-font-weight: bold");
        label2.setTextFill(Color.web("#e3782b"));

        TextField textField2 = new TextField();
        textField2.setFont(new Font("Arial", 16));

        Label label3 = new Label("Quantity: ");
        label3.setFont(new Font("Arial", 16));
        label3.setStyle("-fx-font-weight: bold");
        label3.setTextFill(Color.web("#e3782b"));

        TextField textField3 = new TextField();
        textField3.setFont(new Font("Arial", 16));

        Label label4 = new Label("Price: ");
        label4.setFont(new Font("Arial", 16));
        label4.setStyle("-fx-font-weight: bold");
        label4.setTextFill(Color.web("#e3782b"));

        TextField textField4 = new TextField();
        textField4.setFont(new Font("Arial", 16));


        GridPane gridPane = new GridPane();
        gridPane.add(label1, 0, 0);
        gridPane.add(textField1, 1, 0);
        gridPane.add(new Label(), 0, 1);

        gridPane.add(label2, 0, 2);
        gridPane.add(textField2, 1, 2);
        gridPane.add(new Label(), 0, 3);
        gridPane.add(label3, 0, 4);
        gridPane.add(textField3, 1, 4);
        gridPane.add(new Label(), 0, 5);
        gridPane.add(label4, 0, 6);
        gridPane.add(textField4, 1, 6);

        gridPane.setAlignment(Pos.CENTER);

        Button okay = new Button();
        okay.setPrefWidth(110);
        okay.setPrefHeight(25);
        okay.setFont(new Font("Arial", 14));
        try {
            Background background = new Background(new BackgroundImage(new Image(new FileInputStream("icons/AddButton.png")), BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER,new BackgroundSize(250,33,false,false, false,false)));

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

        back.setOnAction(e -> {
            try {
                RestaurantMainScene o = new RestaurantMainScene();

                Main.window.setScene(o.getRestaurantScene());
            } catch (Exception ex) {

            }
        });
        okay.setOnAction(e -> {
            Restaurant r = new Restaurant();
            r.setRoom(textField1.getText());
            r.setCode(textField2.getText());
            r.setQuantity(textField3.getText());
            int room = Integer.parseInt(textField1.getText());
            int l = Integer.parseInt(textField2.getText());
            int quantity = Integer.parseInt(textField3.getText());
            int b = Integer.parseInt(textField4.getText());
            int a = (b * quantity);
            r.setPrice(Integer.toString(a));
            rooms[room - 1].setExpense(a);

            k.ra.add(r);

            try {
                Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/hotel_management_system", "root", "Tanvir420");

                Statement A = connection.createStatement();

                PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO restaurantlog VALUES(?,?,?,?)");

                preparedStatement.setInt(1, Integer.parseInt(r.getRoom()));
                preparedStatement.setInt(2, Integer.parseInt(r.getCode()));
                preparedStatement.setInt(3, Integer.parseInt(r.getQuantity()));
                preparedStatement.setInt(4, Integer.parseInt(r.getPrice()));

                preparedStatement.executeUpdate();

            }catch (Exception ex){
                System.out.println(ex.getStackTrace());
            }

           // k.UPdate(0);

            M.updateRoom();

            Stage stage = new Stage();
            stage.initModality(Modality.APPLICATION_MODAL);
            try {
                stage.getIcons().add(new Image(new FileInputStream("icons/TSAAppIcon.png")));
            }catch (Exception ex){
                System.out.println("Ico");
            }
            stage.setTitle("Confirmation Box");

            Label label10 = new Label("Room No : ");
            label10.setFont(new Font("Arial", 16));
            label10.setStyle("-fx-font-weight: bold");
            label10.setTextFill(Color.web("#e3782b"));

            Label label11 = new Label(Integer.toString(room));
            label11.setFont(new Font("Arial", 16));
            label11.setStyle("-fx-font-weight: bold");
            label11.setTextFill(Color.web("#e3782b"));

            Label label12 = new Label("Today's Food Expense: ");
            label12.setFont(new Font("Arial", 16));
            label12.setStyle("-fx-font-weight: bold");
            label12.setTextFill(Color.web("#e3782b"));

            Label label13 = new Label(r.getPrice());
            label13.setFont(new Font("Arial", 16));
            label13.setStyle("-fx-font-weight: bold");
            label13.setTextFill(Color.web("#e3782b"));

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
            gridPane1.add(label10, 0, 0);
            gridPane1.add(label11, 1, 0);
            gridPane1.add(new Label(), 0, 1);
            gridPane1.add(label12, 0, 2);
            gridPane1.add(label13, 1, 2);


            gridPane1.add(new Label(), 0, 3);


            gridPane1.setAlignment(Pos.CENTER);
            VBox vBox1 = new VBox();

            vBox1.getChildren().addAll(gridPane1, new Label(), back2);
            vBox1.setAlignment(Pos.CENTER);

            try {
                Background background = new Background(new BackgroundImage(new Image(new FileInputStream("icons/ConfirmBoxLandscape.png")), BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER,new BackgroundSize(400,300,false,false, false,false)));

                vBox1.setBackground(background);
            }catch (Exception ex){

            }

            Scene scene1 = new Scene(vBox1, 400, 300);
            stage.setScene(scene1);
            stage.show();

            back2.setOnAction(e1 -> {
                stage.close();
            });

            textField1.setText("");
            textField2.setText("");
            textField3.setText("");
            textField4.setText("");
        });


        gridPane.add(new Label(), 0, 7);
        gridPane.add(okay, 0, 8);
        gridPane.add(back, 1, 8);

        gridPane.setHgap(10);

        VBox vBox = new VBox();

        vBox.getChildren().addAll(new Label(), new Label(), gridPane);
        vBox.setAlignment(Pos.CENTER);

        VBox root = new VBox();
        root.getChildren().addAll(new Label(), new Label(), new Label(), new Label(),new Label(), new Label(), new Label(), new Label(),new Label(), new Label(), new Label(), new Label(), new Label(), table, new Label());
        root.setAlignment(Pos.CENTER);
        HBox hBox = new HBox();
        hBox.getChildren().addAll(new Label("       "), vBox, new Label("       "), root);
        hBox.setAlignment(Pos.CENTER);

        try {
            Background background = new Background(new BackgroundImage(new Image(new FileInputStream("icons/FoodHubOrderFoodMenuScene.png")), BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER,new BackgroundSize(1050,750,false,false, false,false)));

            hBox.setBackground(background);
        }catch (Exception ex){

        }

        Scene scene = new Scene(hBox, 1050, 750);

        return scene;


    }
}