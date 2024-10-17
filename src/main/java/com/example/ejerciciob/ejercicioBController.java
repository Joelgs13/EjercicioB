package com.example.ejerciciob;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

public class ejercicioBController {

    @FXML
    private Button agregarButton;

    @FXML
    private TableColumn<?, ?> apellidosColumn;

    @FXML
    private TextField apellidosField;

    @FXML
    private TableColumn<?, ?> edadColumn;

    @FXML
    private TextField edadField;

    @FXML
    private TableColumn<?, ?> nombreColumn;

    @FXML
    private TextField nombreField;

    @FXML
    private TableView<?> personTable;



}
