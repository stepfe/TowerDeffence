package game;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.transform.Rotate;
import java.util.ArrayList;

public class GameObject {
    public int x;
    public int y;
    protected int damage;
    protected int height;
    protected int width;
    protected int hp;
    protected int maxHp;
    protected int angle;
    protected boolean dead;
    protected Image image;
    protected int attackRadius;
    protected GameObject target;

    public boolean isDead() {
        return dead;
    }

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }

    public GameObject(int x, int y) {
        this.x = x;
        this.y = y;
        dead = false;
        angle = 0;
        setImage();
        width = (int)image.getWidth();
        height = (int)image.getHeight();
    }

    protected void setImage(){
        image = new Image(getClass().getClassLoader().getResourceAsStream("res/tower.png"), 100, 100, false, false);
    }

    public void nextFrame(ArrayList<GameObject> targets){
        if(target != null) {
            if (isTargetInRange(target)) {
                attackTarget();
                if(target.isDead())
                    target = null;
            }
        }else{
            setTarget(targets);
        }
    }

    protected void setTarget(ArrayList<GameObject> targets){

    }

    public void getDamage(int damage){
        hp -= damage;
        if(hp <= 0){
            hp = 0;
            dead = true;
        }
    }

    protected boolean isTargetInRange(GameObject target){//TODO:Доработать для всех случаев. Оптимизировать?
        if(Math.pow ((target.x - x + width/2),2) + Math.pow ((target.y - y + height/2),2) <= Math.pow(attackRadius,2)){
            return true;
        }
        return false;
    }

    protected void attackTarget(){
        target.getDamage(damage);
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
