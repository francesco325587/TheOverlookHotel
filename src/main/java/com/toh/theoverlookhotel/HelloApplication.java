package com.toh.theoverlookhotel;

import com.toh.database.entity.Room;
import com.toh.database.entity.RoomType;
import com.toh.database.repository.RoomRepository;
import com.toh.database.repository.RoomTypeRepository;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 320, 240);
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();


    }

    public static void main(String[] args) {
        Room r01 = new Room();
        r01.setBeds(5);
        r01.setSmoking(true);
        r01.setNumber("201");
        r01.setPrice(200.4);
        RoomType villa = new RoomType();
        villa.setName("k");
        r01.setType(villa);
        RoomTypeRepository.execute().saveAndFlush(villa);
        RoomRepository.execute().save(r01);
        RoomRepository.execute().flush();


        launch();
    }
}