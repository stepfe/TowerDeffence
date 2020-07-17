package game;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

import java.util.ArrayList;

public class Tower extends GameObject {


    public Tower(int x, int y) {
        super(x, y);
        damage = 1;
        attackRadius = 300;
    }

    @Override
    protected void setTarget(ArrayList<GameObject> targets){
        for (GameObject go: targets) {
            if(go instanceof Enemy && isTargetInRange(go)) {
                target = go;
                break;
            }
        }
    }

    @Override
    public void paint(GraphicsContext gc) {
        super.paint(gc);
        gc.strokeOval(x -attackRadius/2 + width/2, y - attackRadius/2 + height/2, attackRadius, attackRadius);
    }

    @Override
    protected void setImage(){
        image = new Image(getClass().getClassLoader().getResourceAsStream("res/tower.png"), 100, 100, false, false);
    }
}
