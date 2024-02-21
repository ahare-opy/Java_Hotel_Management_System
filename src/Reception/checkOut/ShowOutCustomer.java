package Reception.checkOut;

import Rooms.ManagingRooms;
import Rooms.Room;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import sample.Main;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ShowOutCustomer {
    public Scene showDetails;
    ManagingRooms M = new ManagingRooms();
    Room R;


    public Scene getShowDetails(String name, String number) {
        R = M.searchByNameAndNumber(name, number);

        if(R == null){
            GridPane gridPane = new GridPane();


            Label label1 = new Label();
            javafx.scene.control.Button back= new javafx.scene.control.Button();
            back.setPrefWidth(110);
            back.setPrefHeight(25);
            back.setFont(new Font("Arial", 14));
            try {
                Background background = new Background(new BackgroundImage(new Image(new FileInputStream("icons/BackButton.png")), BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER,new BackgroundSize(250,33,false,false, false,false)));

                back.setBackground(background);
            }catch (Exception ex){

            }

            back.setOnAction(e-> {
                CheckOutScene cc = new CheckOutScene();

                Main.window.setScene(cc.getCheckOutScene());
            });

            gridPane.add(new Label(), 0,0);
            gridPane.add(label1,0,1);
            gridPane.add(back, 0,2);
            gridPane.setAlignment(Pos.CENTER);

            VBox vBox = new VBox();
            vBox.getChildren().addAll(new Label(" "),new Label(" "), new Label(" "), new Label(" "),new Label(" "),new Label(" "),new Label(" "), new Label(" "),new Label(" "),new Label(" "),new Label(" "), new Label(" "),new Label(" "), back);

            vBox.setAlignment(Pos.CENTER);

            HBox hBox1 = new HBox();
            hBox1.getChildren().addAll(vBox, new Label("                                                                                                                                                                                                        "));
            hBox1.setAlignment(Pos.CENTER);

            try {
                Background background = new Background(new BackgroundImage(new Image(new FileInputStream("icons/CheckOutCustomerNotFound.png")), BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER,new BackgroundSize(1050,750,false,false, false,false)));

                hBox1.setBackground(background);
            }catch (Exception ex){

            }

            showDetails = new Scene(hBox1, 1050, 750);
        }

        else{
            javafx.scene.control.Button back= new javafx.scene.control.Button();
            back.setPrefWidth(110);
            back.setPrefHeight(25);
            back.setFont(new Font("Arial", 14));
            try {
                Background background = new Background(new BackgroundImage(new Image(new FileInputStream("icons/BackButton.png")), BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER,new BackgroundSize(250,33,false,false, false,false)));

                back.setBackground(background);
            }catch (Exception ex){

            }

            GridPane gridPane = new GridPane();

            Label label0,label1, label2, label3, label4, label5, label6, label7, label8, label9, label10, label11, label12, label13, label14, label15, label16, label17, label18, label19, label20, label21, label22, label23, label24, label25, label26, label27, label28, label29, label30, label31;

            label0 = new Label("Room No");
            label0.setFont(new Font("Arial", 16));
            label0.setStyle("-fx-font-weight: bold");
            label0.setTextFill(Color.web("#2f479e"));

            label1 = new Label("  :  ");
            label1.setFont(new Font("Arial", 16));
            label1.setStyle("-fx-font-weight: bold");
            label1.setTextFill(Color.web("#2f479e"));

            label2 = new Label(Integer.toString(R.getRoomNo()) + "\n");
            label2.setFont(new Font("Arial", 16));
            label2.setStyle("-fx-font-weight: bold");
            label2.setTextFill(Color.web("#2f479e"));

            label3 = new Label("Customer Name");
            label3.setFont(new Font("Arial", 16));
            label3.setStyle("-fx-font-weight: bold");
            label3.setTextFill(Color.web("#2f479e"));

            label4 = new Label("  :  ");
            label4.setFont(new Font("Arial", 16));
            label4.setStyle("-fx-font-weight: bold");
            label4.setTextFill(Color.web("#2f479e"));

            label5 = new Label(R.getCustomerName());
            label5.setFont(new Font("Arial", 16));
            label5.setStyle("-fx-font-weight: bold");
            label5.setTextFill(Color.web("#2f479e"));

            label6 = new Label("Phone Number");
            label6.setFont(new Font("Arial", 16));
            label6.setStyle("-fx-font-weight: bold");
            label6.setTextFill(Color.web("#2f479e"));

            label7 = new Label("  :  ");
            label7.setFont(new Font("Arial", 16));
            label7.setStyle("-fx-font-weight: bold");
            label7.setTextFill(Color.web("#2f479e"));

            label8 = new Label(R.getPhoneNumber());
            label8.setFont(new Font("Arial", 16));
            label8.setStyle("-fx-font-weight: bold");
            label8.setTextFill(Color.web("#2f479e"));

            label9 = new Label("Period Of Stay");
            label9.setFont(new Font("Arial", 16));
            label9.setStyle("-fx-font-weight: bold");
            label9.setTextFill(Color.web("#2f479e"));

            label10 = new Label("  :  ");
            label10.setFont(new Font("Arial", 16));
            label10.setStyle("-fx-font-weight: bold");
            label10.setTextFill(Color.web("#2f479e"));

            label11 = new Label(Integer.toString(R.getPeriodOfStay()));
            label11.setFont(new Font("Arial", 16));
            label11.setStyle("-fx-font-weight: bold");
            label11.setTextFill(Color.web("#2f479e"));

            label12 = new Label("City");
            label12.setFont(new Font("Arial", 16));
            label12.setStyle("-fx-font-weight: bold");
            label12.setTextFill(Color.web("#2f479e"));

            label13 = new Label("  :  ");
            label13.setFont(new Font("Arial", 16));
            label13.setStyle("-fx-font-weight: bold");
            label13.setTextFill(Color.web("#2f479e"));

            label14 = new Label(R.getCity());
            label14.setFont(new Font("Arial", 16));
            label14.setStyle("-fx-font-weight: bold");
            label14.setTextFill(Color.web("#2f479e"));

            label15 = new Label("Nationality");
            label15.setFont(new Font("Arial", 16));
            label15.setStyle("-fx-font-weight: bold");
            label15.setTextFill(Color.web("#2f479e"));

            label16 = new Label("  :  ");
            label16.setFont(new Font("Arial", 16));
            label16.setStyle("-fx-font-weight: bold");
            label16.setTextFill(Color.web("#2f479e"));

            label17 = new Label(R.getNationality());
            label17.setFont(new Font("Arial", 16));
            label17.setStyle("-fx-font-weight: bold");
            label17.setTextFill(Color.web("#2f479e"));

            label18 = new Label("No Of Guest");
            label18.setFont(new Font("Arial", 16));
            label18.setStyle("-fx-font-weight: bold");
            label18.setTextFill(Color.web("#2f479e"));

            label19 = new Label("  :  ");
            label19.setFont(new Font("Arial", 16));
            label19.setStyle("-fx-font-weight: bold");
            label19.setTextFill(Color.web("#2f479e"));

            label20 = new Label(Integer.toString(R.getMemberStaying()));
            label20.setFont(new Font("Arial", 16));
            label20.setStyle("-fx-font-weight: bold");
            label20.setTextFill(Color.web("#2f479e"));

            label21 = new Label("Date");
            label21.setFont(new Font("Arial", 16));
            label21.setStyle("-fx-font-weight: bold");
            label21.setTextFill(Color.web("#2f479e"));

            label22 = new Label("  :  ");
            label22.setFont(new Font("Arial", 16));
            label22.setStyle("-fx-font-weight: bold");
            label22.setTextFill(Color.web("#2f479e"));

            label23 = new Label(new SimpleDateFormat("EEE MMM dd HH:mm:ss zzz yyyy").format(R.getDate()));
            label23.setFont(new Font("Arial", 16));
            label23.setStyle("-fx-font-weight: bold");
            label23.setTextFill(Color.web("#2f479e"));

            label24 = new Label("Room Type");
            label24.setFont(new Font("Arial", 16));
            label24.setStyle("-fx-font-weight: bold");
            label24.setTextFill(Color.web("#2f479e"));

            label25 = new Label("  :  ");
            label25.setFont(new Font("Arial", 16));
            label25.setStyle("-fx-font-weight: bold");
            label25.setTextFill(Color.web("#2f479e"));

            label26 = new Label(R.getRoomType());
            label26.setFont(new Font("Arial", 16));
            label26.setStyle("-fx-font-weight: bold");
            label26.setTextFill(Color.web("#2f479e"));

            label27 = new Label("Expense");
            label27.setFont(new Font("Arial", 16));
            label27.setStyle("-fx-font-weight: bold");
            label27.setTextFill(Color.web("#2f479e"));

            label28 = new Label("  :  ");
            label28.setFont(new Font("Arial", 16));
            label28.setStyle("-fx-font-weight: bold");
            label28.setTextFill(Color.web("#2f479e"));

            label29 = new Label(Double.toString(R.getExpense()));
            label29.setFont(new Font("Arial", 16));
            label29.setStyle("-fx-font-weight: bold");
            label29.setTextFill(Color.web("#2f479e"));

            label30 = new Label();
            label31 = new Label();

            gridPane.add(label0, 0, 0);
            gridPane.add(label1, 1, 0);
            gridPane.add(label2, 2, 0);
            gridPane.add(label3, 0, 1);
            gridPane.add(label4, 1, 1);
            gridPane.add(label5, 2, 1);
            gridPane.add(label6, 0, 2);
            gridPane.add(label7, 1, 2);
            gridPane.add(label8, 2, 2);
            gridPane.add(label9, 0, 3);
            gridPane.add(label10, 1, 3);
            gridPane.add(label11, 2, 3);
            gridPane.add(label12, 0, 4);
            gridPane.add(label13, 1, 4);
            gridPane.add(label14, 2, 4);
            gridPane.add(label15, 0, 5);
            gridPane.add(label16, 1, 5);
            gridPane.add(label17, 2, 5);
            gridPane.add(label18, 0, 6);
            gridPane.add(label19, 1, 6);
            gridPane.add(label20, 2, 6);
            gridPane.add(label21, 0, 7);
            gridPane.add(label22, 1, 7);
            gridPane.add(label23, 2, 7);
            gridPane.add(label24, 0, 8);
            gridPane.add(label25, 1, 8);
            gridPane.add(label26, 2, 8);
            gridPane.add(label27, 0, 9);
            gridPane.add(label28, 1, 9);
            gridPane.add(label29, 2, 9);
            gridPane.add(label30, 0,10);
            gridPane.add(label31, 0, 11);

            gridPane.add(back, 2,12);

            Button checkOut = new Button();
            checkOut.setPrefWidth(110);
            checkOut.setPrefHeight(25);
            checkOut.setFont(new Font("Arial", 14));
            try {
                Background background = new Background(new BackgroundImage(new Image(new FileInputStream("icons/checkoutButton.png")), BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER,new BackgroundSize(250,33,false,false, false,false)));

                checkOut.setBackground(background);
            }catch (Exception ex){

            }
            gridPane.add(checkOut,0,12);

            back.setOnAction(e-> {
                CheckOutScene cc = new CheckOutScene();

                Main.window.setScene(cc.getCheckOutScene());
            });

            checkOut.setOnAction(e-> {
                int room = R.getRoomNo();
                try {
                    Connection connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/hotel_management_system", "root", "Tanvir420");

                    Statement statement = connect.createStatement();


                    PreparedStatement jhanku = connect.prepareStatement("Update HotelLog SET customerName = 'null', phoneNumber = 0, periodOfStay = 0, city = 'null', nationality = 'null', noOfGuest = 0, date = ?, roomType = 'null', expence = 0.0 WHERE roomNo= ?");

                    Date d = new Date();

                    jhanku.setString(1,d.toString());
                    jhanku.setInt(2,room);

                    jhanku.executeUpdate();

                }catch (Exception EX){
                    System.out.println(EX.getStackTrace());
                }

                M.loadRoom();

                CheckOutConfirmBox.display("Confirm Box", "Check Out Successful");

                CheckOutScene cc = new CheckOutScene();

                Main.window.setScene(cc.getCheckOutScene());
            });

            gridPane.setAlignment(Pos.CENTER);

            gridPane.setVgap(15);

            HBox hBox = new HBox();
            hBox.getChildren().addAll(gridPane, new Label("                                                                                                                                                                                         "));
            hBox.setAlignment(Pos.CENTER);

            try {
                Background background = new Background(new BackgroundImage(new Image(new FileInputStream("icons/CheckOut.png")), BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER,new BackgroundSize(1050,750,false,false, false,false)));

                hBox.setBackground(background);
            }catch (Exception ex){

            }

            showDetails = new Scene(hBox, 1050,750);
        }

        return showDetails;
    }
}
