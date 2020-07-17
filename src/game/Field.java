package game;

import javafx.scene.canvas.GraphicsContext;

import java.util.ArrayList;

public class Field {

    private ArrayList<GameObject> gameObjects;
    private GraphicsContext contextToDraw;

    public Field(GraphicsContext contextToDraw){
        gameObjects = new ArrayList<>();
        this.contextToDraw = contextToDraw;
    }

    public void addGameObject(GameObject go){
            gameObjects.add(go);
    }

    public void nextFrame(){

        contextToDraw.clearRect(0, 0, 800, 300);
        for (GameObject gameObject: gameObjects) {
            gameObject.nextFrame(gameObjects);
            gameObject.paint(contextToDraw);
        }

        ArrayList<GameObject> goToDelete = new ArrayList<>();//какой-то костыль
        for (GameObject go: gameObjects) {
            if (go.isDead()){
                goToDelete.add(go);
            }
        }
        for (GameObject go: goToDelete) {
            gameObjects.remove(go);
        }

    }

    public void paint(){
        contextToDraw.clearRect(0, 0, 800, 300);

        for (GameObject gameObject: gameObjects) {
            gameObject.paint(contextToDraw);
        }
    }
}
