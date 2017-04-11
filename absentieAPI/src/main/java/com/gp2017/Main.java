package com.gp2017;

import com.gp2017.Model.AbsentieModel;
import com.gp2017.Model.DatabaseModel;
import javafx.application.Platform;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import org.apache.catalina.core.ApplicationContext;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import org.springframework.context.ConfigurableApplicationContext;

import java.sql.SQLException;

@SpringBootApplication
public class Main extends Application {
    DatabaseModel databaseModel;

    public static void main(String[] args) {

        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Absentie Server");
        Button submitButton = new Button();

        // database url
        TextField databaseUrl = new TextField("localhost");
        databaseUrl.setMinWidth(150);
        databaseUrl.setMaxWidth(250);
        databaseUrl.setPrefWidth(200);

        // database name
        TextField databaseField = new TextField("AbsentieSys");
        databaseField.setMinWidth(150);
        databaseField.setMaxWidth(250);
        databaseField.setPrefWidth(200);

        // database name
        TextField portField = new TextField("8889");
        portField.setMinWidth(150);
        portField.setMaxWidth(250);
        portField.setPrefWidth(200);
        portField.textProperty().addListener(new ChangeListener<String>() {
            // makes sure only numbers are allowed
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                if (!newValue.matches("\\d*")) {
                    portField.setText(newValue.replaceAll("[^\\d]", ""));
                }
            }
        });

        // database name
        TextField usernameField = new TextField("root");
        usernameField.setMinWidth(150);
        usernameField.setMaxWidth(250);
        usernameField.setPrefWidth(200);

        // database name
        TextField passwordField = new TextField("dbwarrior");
        passwordField.setMinWidth(150);
        passwordField.setMaxWidth(250);
        passwordField.setPrefWidth(200);

        submitButton.setText("Run");


        submitButton.setOnAction(event -> {

            try {
                System.out.println(databaseUrl.getText());
                databaseModel = new DatabaseModel(
                        databaseUrl.getText(),
                        databaseField.getText(),
                        Integer.parseInt(portField.getText()),
                        usernameField.getText(),
                        passwordField.getText());

                databaseModel.setDatabaseUrl(databaseUrl.getText());
                databaseModel.databaseUrl = databaseUrl.getText();
                databaseModel.databasePort = Integer.parseInt(portField.getText());
                databaseModel.databaseName = databaseField.getText();
                databaseModel.databaseUser = usernameField.getText();
                databaseModel.databasePass = passwordField.getText();


                databaseModel.open();
                ConfigurableApplicationContext x = SpringApplication.run(Main.class);
                VBox p = new VBox();
                Label success = new Label("Succes!");
                Label name = new Label("database:\t\t" +databaseModel.databaseName);
                Label host = new Label("host:\t\t\t" +databaseModel.databaseUrl);
                Label port = new Label("port:\t\t\t\t" +databaseModel.databasePort);
                Label status = new Label("status:\t\t\trunning!");
                status.setTextFill(Color.web("#32B232"));
                Button terminate = new Button("terminate");
                terminate.setAlignment(Pos.BOTTOM_RIGHT);
                terminate.setOnAction(e ->{
                    x.close();
                    Platform.exit();
                });
                p.setPadding(new Insets(10,10,10,10));

                p.getChildren().addAll(success,new Label(""),name,host,port,status,new Label(""), terminate);


                primaryStage.setScene(new Scene(p, 300, 250));

            } catch (Exception e) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Oops!");
                alert.setHeaderText("It looks like something went wrong :---(");
                alert.setContentText("Please make sure the information provided is correct and the MySQL instance is running.");
                alert.showAndWait();
            }
        });

        VBox vBox = new VBox(5);
        vBox.setPadding(new Insets(10,10,10,10));
        vBox.getChildren().addAll(databaseUrl, portField, databaseField, usernameField, passwordField, submitButton);
        primaryStage.setScene(new Scene(vBox, 300, 250));
        primaryStage.setResizable(false);
        primaryStage.show();
    }
}