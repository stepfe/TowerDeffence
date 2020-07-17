package sample;

import game.Enemy;
import game.Field;
import game.Tower;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.Button;
import game.GameObject;
import javafx.scene.input.MouseEvent;

public class Controller {
    @FXML
    Button mainButton;
    @FXML
    Button nextButton;
    @FXML
    Canvas canvas;

    private Field field;
    private Tower towerToAdd;

    @FXML
    private void initialize(){
        field = new Field(canvas.getGraphicsContext2D());
    }

    public void click(){
        towerToAdd = new Tower(0, 0);
    }

    public void next(){
        field.nextFrame();
    }

    public void addNewTower(MouseEvent mouseEvent) {
        field.addGameObject(towerToAdd);
        towerToAdd = null;
    }

    public void newCoord(MouseEvent mouseEvent) {
        if (towerToAdd != null){
            towerToAdd.x = (int)mouseEvent.getX();
            towerToAdd.y = (int)mouseEvent.getY();
            field.paint();
            towerToAdd.paint(canvas.getGraphicsContext2D());
        }
    }

    public void addEnemy(ActionEvent actionEvent) {
        field.addGameObject(new Enemy(0, 0));
    }
}
