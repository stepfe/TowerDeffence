package game;

import javafx.scene.image.Image;

import java.util.ArrayList;
import java.util.Objects;

public class Enemy extends GameObject {

    public int movement_speed = 50;
    public int start_position_x = 800;
    public int start_position_y = 500;

    public Enemy(int x, int y) {
        super(x, y);

        movement_speed = 10;
    }

    @Override
    protected void setImage(){
        image = new Image(Objects.requireNonNull(getClass().getClassLoader().getResourceAsStream("res/kamikadse.png")), 100, 100, false, false);
    }

    @Override
    public void nextFrame(ArrayList<GameObject> targets){
        super.nextFrame(targets);

        move();
    }
    protected void move(){
        this.x -= movement_speed;
    }
}
