package restaurant;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import sample.Main;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class ResTfile extends Application {
    private int n;

    public static void main(String[] args) {
        launch(args);
    }
    @Override
    public void start(Stage stage) throws Exception {
        try{
            stage.setScene(FileTable());
            stage.show();}
        catch (Exception e){e.printStackTrace();}
    }
    public ObservableList<Restaurant> getInf(int n){
        ManagingRestaurant k=new ManagingRestaurant();
        ObservableList<Restaurant> r = FXCollections.observableArrayList();
        if(n==1) {
            k.LoadBreFile();
            for (int i = 0; i < k.ra1.size(); i++) {

                r.add(k.ra1.get(i));
            }
        }
        else if(n==2){
            k.LoadLunFile();
            for (int i = 0; i < k.ra2.size(); i++){
                r.add(k.ra2.get(i));
            }
        }
        else if(n==3){
            k.LoadDinFile();
            for (int i = 0; i < k.ra3.size(); i++){
                r.add(k.ra3.get(i));
            }
        }
        else if(n==4){
            k.LoadBeverageFile();
            for (int i = 0; i < k.ra4.size(); i++){
                r.add(k.ra4.get(i));
            }
        }
        else {
            k.LoadResFile();
            for (int i = 0; i < k.ra.size(); i++){
                r.add(k.ra.get(i));
            }
        }
        return r;
    }

    public Scene FileTable() throws FileNotFoundException{
        ManagingRestaurant k=new ManagingRestaurant();
        Label labell = new Label("Please Enter Your Desireable List Name ");
        labell.setFont(new Font("Arial", 16));
        labell.setStyle("-fx-font-weight: bold");
        labell.setTextFill(Color.web("#e3782b"));

        Label label22 = new Label("List No :");
        label22.setFont(new Font("Arial", 16));
        label22.setStyle("-fx-font-weight: bold");
        label22.setTextFill(Color.web("#e3782b"));

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

        Label labelk = new Label();
        labelk.setFont(new Font("Arial", 16));
        labelk.setStyle("-fx-font-weight: bold");
        labelk.setTextFill(Color.web("#e3782b"));

        GridPane gridPane = new GridPane();
        gridPane.add(labell, 0,0);
        gridPane.add(new Label(), 0,1);

        gridPane.add(label22, 0,2);
        gridPane.add(combo_box,1,2);

        gridPane.setAlignment(Pos.CENTER);
        Button okay = new Button();
        okay.setPrefWidth(110);
        okay.setPrefHeight(25);
        okay.setFont(new Font("Arial", 14));
        try {
            Background background = new Background(new BackgroundImage(new Image(new FileInputStream("icons/ShowButton.png")), BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER,new BackgroundSize(250,33,false,false, false,false)));

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

        gridPane.add(new Label(), 0,3);
        gridPane.add(okay, 0,5);
        gridPane.add(back,1,5);

        VBox vBox = new VBox();

        vBox.getChildren().addAll(labelk, new Label(), gridPane);
        vBox.setAlignment(Pos.CENTER);
        back.setOnAction(e-> {
            try {
                RestaurantMainScene o=new RestaurantMainScene();

                Main.window.setScene(o.getRestaurantScene());
            }catch (Exception ex){

            }
        });
        okay.setOnAction(e-> {

            if(n==1) {
                TableColumn<Restaurant, String> Code = new TableColumn<>("Food Code: ");
                Code.setMinWidth(200);
                Code.setCellValueFactory(new PropertyValueFactory<>("code"));

                TableColumn<Restaurant, String> B = new TableColumn<>("BDT");
                B.setMinWidth(200);
                B.setCellValueFactory(new PropertyValueFactory<>("BDT"));

                TableColumn<Restaurant, String> price = new TableColumn<>("Price :");
                price.setMinWidth(200);
                price.setCellValueFactory(new PropertyValueFactory<>("price"));

                TableColumn<Restaurant, String> name = new TableColumn<>("Food Name:");
                name.setMinWidth(200);
                name.setCellValueFactory(new PropertyValueFactory<>("name"));

                TableView<Restaurant> table = new TableView<>();
                table.setItems(getInf(1));
                table.getColumns().addAll(Code, B, price, name);

                Button back2 = new Button();
                back2.setPrefWidth(110);
                back2.setPrefHeight(25);
                back2.setFont(new Font("Arial", 14));
                try {
                    Background background = new Background(new BackgroundImage(new Image(new FileInputStream("icons/BackButton.png")), BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER,new BackgroundSize(250,33,false,false, false,false)));

                    back2.setBackground(background);
                }catch (Exception ex){

                }

                Label label = new Label();
                label.setFont(new Font("Arial", 20));
                Label label1 = new Label();
                Label label2 = new Label();
                Label label3 = new Label();
                Label label4 = new Label();
                Label label5 = new Label();
                Label label6 = new Label();
                VBox root = new VBox();
                root.getChildren().addAll(label1, label2, label, label3, table, label4, label5, back2, label6);
                root.setAlignment(Pos.CENTER);

                try {
                    Background background = new Background(new BackgroundImage(new Image(new FileInputStream("icons/BreakFastList.png")), BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER,new BackgroundSize(1050,750,false,false, false,false)));

                    root.setBackground(background);
                }catch (Exception ex){

                }

                Scene display = new Scene(root, 1050, 750);

                Main.window.setScene(display);
                back2.setOnAction(e1 -> {
                    try {
                        Main.window.setScene(FileTable());
                    }catch (Exception ex){

                    }
                });

            }
            else if(n==2){
                TableColumn<Restaurant, String> Code=new TableColumn<>("Food Code: ");
                Code.setMinWidth(200);
                Code.setCellValueFactory(new PropertyValueFactory<>("code"));

                TableColumn<Restaurant , String>B=new TableColumn<>("BDT");
                B.setMinWidth(200);
                B.setCellValueFactory(new PropertyValueFactory<>("BDT"));

                TableColumn<Restaurant , String>price=new TableColumn<>("Price :");
                price.setMinWidth(200);
                price.setCellValueFactory(new PropertyValueFactory<>("price"));

                TableColumn<Restaurant , String>name=new TableColumn<>("Food Name:");
                name.setMinWidth(200);
                name.setCellValueFactory(new PropertyValueFactory<>("name"));

                TableView<Restaurant> table=new TableView<>();
                table.setItems(getInf(2));
                table.getColumns().addAll(Code,B,price,name);

                Button back2 = new Button();
                back2.setPrefWidth(110);
                back2.setPrefHeight(25);
                back2.setFont(new Font("Arial", 14));
                try {
                    Background background = new Background(new BackgroundImage(new Image(new FileInputStream("icons/BackButton.png")), BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER,new BackgroundSize(250,33,false,false, false,false)));

                    back2.setBackground(background);
                }catch (Exception ex){

                }

                Label label = new Label();
                label.setFont(new Font("Arial", 20));
                Label label1 = new Label();
                Label label2 = new Label();
                Label label3 = new Label();
                Label label4 = new Label();
                Label label5 = new Label();
                Label label6 = new Label();
                VBox root = new VBox();
                root.getChildren().addAll(label1, label2, label, label3, table, label4, label5, back2, label6);
                root.setAlignment(Pos.CENTER);

                try {
                    Background background = new Background(new BackgroundImage(new Image(new FileInputStream("icons/LunchFoodlistScene.png")), BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER,new BackgroundSize(1050,750,false,false, false,false)));

                    root.setBackground(background);
                }catch (Exception ex){

                }


                Scene display = new Scene(root, 1050, 750);

                Main.window.setScene(display);
                back2.setOnAction(e1 -> {
                    try {
                        Main.window.setScene(FileTable());
                    }catch (Exception ex){

                    }
                });
            }
            else if(n==3){
                TableColumn<Restaurant, String> Code=new TableColumn<>("Food Code: ");
                Code.setMinWidth(200);
                Code.setCellValueFactory(new PropertyValueFactory<>("code"));

                TableColumn<Restaurant , String>B=new TableColumn<>("BDT");
                B.setMinWidth(200);
                B.setCellValueFactory(new PropertyValueFactory<>("BDT"));

                TableColumn<Restaurant , String>price=new TableColumn<>("Price :");
                price.setMinWidth(200);
                price.setCellValueFactory(new PropertyValueFactory<>("price"));

                TableColumn<Restaurant , String>name=new TableColumn<>("Food Name:");
                name.setMinWidth(200);
                name.setCellValueFactory(new PropertyValueFactory<>("name"));

                TableView<Restaurant> table=new TableView<>();
                table.setItems(getInf(3));
                table.getColumns().addAll(Code,B,price,name);
                Button back2 = new Button();
                back2.setPrefWidth(110);
                back2.setPrefHeight(25);
                back2.setFont(new Font("Arial", 14));
                try {
                    Background background = new Background(new BackgroundImage(new Image(new FileInputStream("icons/BackButton.png")), BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER,new BackgroundSize(250,33,false,false, false,false)));

                    back2.setBackground(background);
                }catch (Exception ex){

                }

                Label label = new Label();
                label.setFont(new Font("Arial", 20));
                Label label1 = new Label();
                Label label2 = new Label();
                Label label3 = new Label();
                Label label4 = new Label();
                Label label5 = new Label();
                Label label6 = new Label();
                VBox root = new VBox();
                root.getChildren().addAll(label1, label2, label, label3, table, label4, label5, back2, label6);
                root.setAlignment(Pos.CENTER);

                try {
                    Background background = new Background(new BackgroundImage(new Image(new FileInputStream("icons/FoodHubDinnerListScene.png")), BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER,new BackgroundSize(1050,750,false,false, false,false)));

                    root.setBackground(background);
                }catch (Exception ex){

                }

                Scene display = new Scene(root, 1050, 750);

                Main.window.setScene(display);
                back2.setOnAction(e1 -> {
                    try {
                        Main.window.setScene(FileTable());
                    }catch (Exception ex){

                    }
                });

            }
            else if(n==4){
                TableColumn<Restaurant, String> Code=new TableColumn<>("Food Code: ");
                Code.setMinWidth(200);
                Code.setCellValueFactory(new PropertyValueFactory<>("code"));

                TableColumn<Restaurant , String>B=new TableColumn<>("BDT");
                B.setMinWidth(200);
                B.setCellValueFactory(new PropertyValueFactory<>("BDT"));

                TableColumn<Restaurant , String>price=new TableColumn<>("Price :");
                price.setMinWidth(200);
                price.setCellValueFactory(new PropertyValueFactory<>("price"));

                TableColumn<Restaurant , String>name=new TableColumn<>("Food Name:");
                name.setMinWidth(200);
                name.setCellValueFactory(new PropertyValueFactory<>("name"));

                TableView<Restaurant> table=new TableView<>();
                table.setItems(getInf(4));
                table.getColumns().addAll(Code,B,price,name);

                Button back2 = new Button();
                back2.setPrefWidth(110);
                back2.setPrefHeight(25);
                back2.setFont(new Font("Arial", 14));
                try {
                    Background background = new Background(new BackgroundImage(new Image(new FileInputStream("icons/BackButton.png")), BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER,new BackgroundSize(250,33,false,false, false,false)));

                    back2.setBackground(background);
                }catch (Exception ex){

                }

                Label label = new Label();
                label.setFont(new Font("Arial", 20));
                Label label1 = new Label();
                Label label2 = new Label();
                Label label3 = new Label();
                Label label4 = new Label();
                Label label5 = new Label();
                Label label6 = new Label();
                VBox root = new VBox();
                root.getChildren().addAll(label1, label2, label, label3, table, label4, label5, back2, label6);
                root.setAlignment(Pos.CENTER);

                try {
                    Background background = new Background(new BackgroundImage(new Image(new FileInputStream("icons/FoodHubBeverageList.png")), BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER,new BackgroundSize(1050,750,false,false, false,false)));

                    root.setBackground(background);
                }catch (Exception ex){

                }

                Scene display = new Scene(root, 1050, 750);

                Main.window.setScene(display);
                back2.setOnAction(e1 -> {
                    try {
                        Main.window.setScene(FileTable());
                    }catch (Exception ex){

                    }
                });
            }
            else {
                TableColumn<Restaurant, String>room=new TableColumn<>("Room No: ");
                room.setMinWidth(200);
                room.setCellValueFactory(new PropertyValueFactory<>("room"));

                TableColumn<Restaurant , String>Code=new TableColumn<>("Food Code:");
                Code.setMinWidth(200);
                Code.setCellValueFactory(new PropertyValueFactory<>("code"));

                TableColumn<Restaurant , String>quantity=new TableColumn<>("Quantity :");
                quantity.setMinWidth(200);
                quantity.setCellValueFactory(new PropertyValueFactory<>("quantity"));

                TableColumn<Restaurant , String>price=new TableColumn<>("Total Price:");
                price.setMinWidth(200);
                price.setCellValueFactory(new PropertyValueFactory<>("Price"));

                TableView<Restaurant> table=new TableView<>();
                table.setItems(getInf(0));
                table.getColumns().addAll(room,Code,quantity,price);

                Button back2 = new Button();
                back2.setPrefWidth(110);
                back2.setPrefHeight(25);
                back2.setFont(new Font("Arial", 14));
                try {
                    Background background = new Background(new BackgroundImage(new Image(new FileInputStream("icons/BackButton.png")), BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER,new BackgroundSize(250,33,false,false, false,false)));

                    back2.setBackground(background);
                }catch (Exception ex){

                }

                Label label = new Label();
                label.setFont(new Font("Arial", 20));
                Label label1 = new Label();
                Label label2 = new Label();
                Label label3 = new Label();
                Label label4 = new Label();
                Label label5 = new Label();
                Label label6 = new Label();
                VBox root = new VBox();
                root.getChildren().addAll(label1, label2, label, label3, table, label4, label5, back2, label6);
                root.setAlignment(Pos.CENTER);

                try {
                    Background background = new Background(new BackgroundImage(new Image(new FileInputStream("icons/OrderListShow.png")), BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER,new BackgroundSize(1050,750,false,false, false,false)));

                    root.setBackground(background);
                }catch (Exception ex){

                }

                Scene display = new Scene(root, 1050, 750);

                Main.window.setScene(display);
                back2.setOnAction(e1 -> {
                    try {
                        Main.window.setScene(FileTable());
                    }catch (Exception ex){

                    }
                });
            }
        });

        HBox hBox = new HBox();
        hBox.getChildren().addAll(vBox, new Label("                                                                                                                                                                "));
        hBox.setAlignment(Pos.CENTER);

        try {
            Background background = new Background(new BackgroundImage(new Image(new FileInputStream("icons/FoodOrderListScene.png")), BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER,new BackgroundSize(1050,750,false,false, false,false)));

            hBox.setBackground(background);
        }catch (Exception ex){

        }

        Scene scene = new Scene(hBox, 1050,750);

        return scene;


    }
}
