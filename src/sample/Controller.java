package sample;

import game.Field;
import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.Button;
import game.GameObject;

public class Controller {
    @FXML
    Button mainButton;
    @FXML
    Button nextButton;
    @FXML
    Canvas canvas;

    private Field field;

    @FXML
    private void initialize(){
        field = new Field(canvas.getGraphicsContext2D());
    }

    public void click(){
        field.addGameObject(new GameObject(100, 100));
    }

    public void next(){
        field.nextFrame();
    }
}
