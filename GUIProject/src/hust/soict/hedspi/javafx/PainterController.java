package hust.soict.hedspi.javafx;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Toggle;
import javafx.scene.control.ToggleGroup;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class PainterController {

    @FXML
    private Pane drawingAreaPane;

    @FXML
    private Toggle ButtonPen;

    @FXML
    private Toggle ButtonEraser;

    @FXML
    void clearButtonPressed(ActionEvent event) {
        drawingAreaPane.getChildren().clear();
    }

    @FXML
    void drawingAreaMouseDragged(MouseEvent event) {
        if(ButtonEraser.isSelected()) {
            Circle newCircle = new Circle(event.getX(), event.getY(), 4, Color.WHITE);
            drawingAreaPane.getChildren().add(newCircle);
        }else {
            Circle newCircle = new Circle(event.getX(), event.getY(), 4, Color.BLACK);
            drawingAreaPane.getChildren().add(newCircle);
        }
    }


    @FXML
    void selected(ActionEvent event) {
        ToggleGroup question= new ToggleGroup();
        ButtonPen.setToggleGroup(question);
        ButtonEraser.setToggleGroup(question);
        if(ButtonPen.isSelected()) {
            ButtonEraser.setSelected(false);
        }else {
            ButtonPen.setSelected(false);
        }
    }
}

