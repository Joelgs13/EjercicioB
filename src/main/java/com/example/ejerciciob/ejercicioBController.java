package com.example.ejerciciob;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import model.Persona;

public class ejercicioBController {

    @FXML
    private Button agregarButton;

    @FXML
    private TextField nombreField;

    @FXML
    private TextField apellidosField;

    @FXML
    private TextField edadField;

    @FXML
    private TableView<Persona> personTable;

    @FXML
    private TableColumn<Persona, String> nombreColumn;

    @FXML
    private TableColumn<Persona, String> apellidosColumn;

    @FXML
    private TableColumn<Persona, Integer> edadColumn;

    private ObservableList<Persona> personasList = FXCollections.observableArrayList();

    @FXML
    public void initialize() {
        // Vincular las columnas con los campos de la clase Persona
        nombreColumn.setCellValueFactory(cellData -> new javafx.beans.property.SimpleStringProperty(cellData.getValue().getNombre()));
        apellidosColumn.setCellValueFactory(cellData -> new javafx.beans.property.SimpleStringProperty(cellData.getValue().getApellido()));
        edadColumn.setCellValueFactory(cellData -> new javafx.beans.property.SimpleIntegerProperty(cellData.getValue().getEdad()).asObject());

        // Configurar la tabla
        personTable.setItems(personasList);
    }

    @FXML
    private void agregar() {
        String nombre = nombreField.getText().trim();
        String apellidos = apellidosField.getText().trim();
        String edadText = edadField.getText().trim();
        StringBuilder errores = new StringBuilder();

        // Verificar que los campos no estén vacíos
        if (nombre.isEmpty()) {
            errores.append("El campo 'Nombre' no puede estar vacío.\n");
        }
        if (apellidos.isEmpty()) {
            errores.append("El campo 'Apellidos' no puede estar vacío.\n");
        }

        // Verificar que la edad sea un número entero válido
        int edad = -1;
        try {
            edad = Integer.parseInt(edadText);
            if (edad < 0) {
                errores.append("La edad debe ser un número positivo.\n");
            }
        } catch (NumberFormatException e) {
            errores.append("El campo 'Edad' debe ser un número entero válido.\n");
        }

        // Mostrar errores si hay alguno
        if (errores.length() > 0) {
            mostrarError(errores.toString());
            return;
        }

        // Crear una nueva persona con los datos válidos
        Persona nuevaPersona = new Persona(nombre, apellidos, edad);

        // Comprobar si la persona ya existe en la tabla
        if (personasList.contains(nuevaPersona)) {
            mostrarError("Persona duplicada: Ya existe una persona con los mismos datos.");
            return;
        }

        // Si no está duplicada, agregar la persona a la lista y mostrar un mensaje de éxito
        personasList.add(nuevaPersona);
        mostrarInformacion("Persona agregada con éxito.");

    }

    // Método para mostrar un mensaje de error
    private void mostrarError(String mensaje) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error en los datos");
        alert.setHeaderText(null);
        alert.setContentText(mensaje);
        alert.showAndWait();
    }

    // Método para mostrar un mensaje informativo
    private void mostrarInformacion(String mensaje) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Éxito");
        alert.setHeaderText(null);
        alert.setContentText(mensaje);
        alert.showAndWait();
    }
}

