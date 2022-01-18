package com.example.lab5fix;

import functions.Building;
import functions.Elevator;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.layout.VBox;

import java.util.ArrayList;
import java.util.List;

public class GUIController {
    public Button build;
    public VBox forFloors;
    public TextArea liftSystem;
    Building building = new Building();
    @FXML
    protected void buildSystem() {
        forFloors.getChildren().removeAll();
        List<Button> floors = new ArrayList<>();
        for (int i = 0; i < 9; i++) {
            floors.add(i,new Button(String.valueOf(i+1)));
        }
        for (Button floorButton:
             floors) {
            floorButton.setOnAction(actionEvent -> moveElevator(floorButton));
            forFloors.getChildren().add(floorButton);
        }

        build.setVisible(false);
    }
    @FXML
    protected void moveElevator(Button button) {
        liftSystem.clear();
        building.moveElevator(Integer.parseInt(button.getText()));
        building.keepFreeElevatorOnFirstFloor();
        for (Elevator elevator:
                building.getElevatorSystemInfo()) {
            liftSystem.setText(liftSystem.getText() + "\n" + "Лифт " + elevator.getNumber() + " :  Этаж " + elevator.getPosition());
        }
    }
}