package game;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.transform.Rotate;

import java.io.File;
import java.net.URISyntaxException;

public class GameObject {
    public int x;
    public int y;
    protected int hp;
    protected int maxHp;
    protected int angle;
    protected Image image;

    public GameObject(int x, int y) {
        this.x = x;
        this.y = y;
        angle = 0;
        setImage();
    }

    protected void setImage(){
        image = new Image(getClass().getClassLoader().getResourceAsStream("res/tower.png"), 100, 100, false, false);
    }

    public void nextFrame(){

    }

    public void getDamage(int damage){
        hp -= damage;
    }

    public void paint(GraphicsContext gc){

        drawRotatedImage(gc, image, angle, x, y);
    }

    protected void rotateGC(GraphicsContext gc, double angle, double px, double py) {
        Rotate r = new Rotate(angle, px, py);
        gc.setTransform(r.getMxx(), r.getMyx(), r.getMxy(), r.getMyy(), r.getTx(), r.getTy());
    }

    protected void drawRotatedImage(GraphicsContext gc, Image image, double angle, double tlpx, double tlpy) {
        gc.save(); // saves the current state on stack, including the current transform
        rotateGC(gc, angle, tlpx + image.getWidth() / 2, tlpy + image.getHeight() / 2);
        gc.drawImage(image, tlpx, tlpy);
        gc.restore(); // back to original state (before rotation)
    }
}
