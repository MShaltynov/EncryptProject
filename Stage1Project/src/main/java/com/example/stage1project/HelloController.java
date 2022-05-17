package com.example.stage1project;

import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.io.File;
import java.net.URL;
import java.util.Random;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.stage.Window;

public class HelloController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button decodeButton;

    @FXML
    private TextArea decodedTextArea;

    @FXML
    private Button encodeButton;

    @FXML
    private TextArea encodedTextArea;

    @FXML
    private TextField offsetTextArea;

    @FXML
    private Button randomButton;

    @FXML
    private Button browseButton;


    @FXML
    void initialize() {

        //Нажатие на кнопку Browse
        FileChooser fileChooser = new FileChooser();
      //  File file = fileChooser.showOpenDialog();




        //Нажатие на кнопку Random
        randomButton.setOnAction(actionEvent -> {
            offsetTextArea.clear();
            Random random = new Random();
            offsetTextArea.setText(String.valueOf(random.nextInt(100)));
        });

        //нажатие на кнопку закодировать
        encodeButton.setOnAction(actionEvent -> {
            decodedTextArea.clear();
            System.out.println("Нажата кнопка закодировать");
            TextAnalizer textAnalizer = new TextAnalizer();
            try {
                decodedTextArea.setText(textAnalizer.encrypt(encodedTextArea.getText(), Integer.parseInt(offsetTextArea.getText())));
            } catch (NumberFormatException numberFormatException) {
                System.out.println(numberFormatException.getMessage());
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Ошибка!");
                alert.setHeaderText("Введите числовое значение!");
                alert.setContentText("Вы ввели " + offsetTextArea.getText());
                alert.show();
            }

        });
        //нажатие на кнопку раскодировать
        decodeButton.setOnAction(actionEvent -> {
            encodedTextArea.clear();
            System.out.println("Нажата кнопка раскодировать");
            TextAnalizer textAnalizer = new TextAnalizer();
            encodedTextArea.setText(textAnalizer.decrypt(decodedTextArea.getText(), Integer.parseInt(offsetTextArea.getText())));
        });


    }

}