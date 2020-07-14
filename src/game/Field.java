package game;

import javafx.scene.canvas.GraphicsContext;

import java.util.ArrayList;

public class Field {

    private ArrayList<GameObject> objects;
    private GraphicsContext contextToDraw;

    public Field(GraphicsContext contextToDraw){
        objects = new ArrayList<>();
        this.contextToDraw = contextToDraw;
    }

    public void addGameObject(GameObject go){
        objects.add(go);
    }

    public void nextFrame(){
        for (GameObject obj: objects) {
            obj.nextFrame();
            obj.paint(contextToDraw);
        }
    }

    public void paint(){
        for (GameObject obj: objects) {
            obj.paint(contextToDraw);
        }
    }
}
