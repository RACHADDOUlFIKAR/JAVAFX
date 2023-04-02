package com.example.demo1;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        BorderPane borderPaneroot=new BorderPane();
        Scene scene = new Scene(borderPaneroot, 800, 600);
        stage.setTitle("Matiéres");
        stage.setScene(scene);
        HBox hBox=new HBox();
        hBox.setPadding(new Insets(10));
        hBox.setSpacing(10);
        Label labelname=new Label("Nom Table De Matiére");
        labelname.setPadding(new Insets(5));
        TextField textField=new TextField();
        Button buttonadd=new Button("Ajouter");
        Button buttondelete = new Button("Supprimer");
        hBox.getChildren().addAll(labelname,textField,buttonadd,buttondelete);
        VBox vBox=new VBox();
        vBox.setPadding(new Insets(10));
        ListView<String> listView=new ListView<>();
        listView.getItems().addAll("linux","probabilite","JEE");
        vBox.getChildren().add(listView);
        borderPaneroot.setCenter(vBox);
        borderPaneroot.setTop(hBox);

        stage.show();
        buttonadd.setOnAction((event)->{
            String name=textField.getText();
            listView.getItems().add(name);
        });
        buttondelete.setOnAction((event) -> {
            int selectedIndex = listView.getSelectionModel().getSelectedIndex();
            if (selectedIndex != -1) {
                listView.getItems().remove(selectedIndex);
            }
        });
    }

    public static void main(String[] args) {
        launch();
    }
}