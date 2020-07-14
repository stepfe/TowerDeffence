package game;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.transform.Rotate;

import java.io.File;
import java.net.URISyntaxException;

public class GameObject {
    public int x;
    public int y;
    private int hp;
    private int maxHp;
    private int angle;

    public GameObject(int x, int y) {
        this.x = x;
        this.y = y;
        angle = 0;
    }

    public void nextFrame(){

    }

    public void getDamage(int damage){
        hp -= damage;
    }

    public void paint(GraphicsContext gc){

        Image image = new Image(getClass().getClassLoader().getResourceAsStream("res/tower.png"), 500, 300, false, false);
        //Rotate rotate = new Rotate();
        //rotate.setAngle(45);
//        gc.clearRect(0,0,800,500);
//        gc.save(); // saves the current state on stack, including the current transform
//        gc.rotate(angle);
//        gc.drawImage(image, 0, 0);
//        gc.restore();
        drawRotatedImage(gc, image, angle, 0, 0);
        //gc.drawImage(image,0,0);


    }

    private void rotateGC(GraphicsContext gc, double angle, double px, double py) {
        Rotate r = new Rotate(angle, px, py);
        gc.setTransform(r.getMxx(), r.getMyx(), r.getMxy(), r.getMyy(), r.getTx(), r.getTy());
    }

    private void drawRotatedImage(GraphicsContext gc, Image image, double angle, double tlpx, double tlpy) {
        gc.save(); // saves the current state on stack, including the current transform
        rotateGC(gc, angle, tlpx + image.getWidth() / 2, tlpy + image.getHeight() / 2);
        gc.drawImage(image, tlpx, tlpy);
        gc.restore(); // back to original state (before rotation)
    }
}
