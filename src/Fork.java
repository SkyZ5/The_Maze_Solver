import java.util.ArrayList;

public class Fork {
    private ArrayList<Fork> parentForks;
    private ArrayList<Fork> childForks;
    private int[] pos;
    private boolean up;
    private boolean down;
    private boolean left;
    private boolean right;
    private String pathTaken;

    public Fork(int[] pos, boolean up, boolean down, boolean left, boolean right){
        this.pos = pos;
        this.up = up;
        this.down = down;
        this.left = left;
        this.right = right;
    }
    public void setPathTaken(String path){
        pathTaken = path;
    }
    public void addParent(Fork fork){
        parentForks.add(fork);
    }
    public void addChild(Fork fork){
        childForks.add(fork);
    }
    public String paths(){
        if(up){
            return "up";
        }
        else if(down){
            return "down";
        }
        else if(left){
            return "left";
        }
        else if(right){
            return "right";
        }
        return "";
    }
    public boolean deadEnd(){
        if(pathTaken.equals("left")){
            left = false;
        }
        else if(pathTaken.equals("right")){
            right = false;
        }
        else if(pathTaken.equals("up")){
            up = false;
        }
        else if(pathTaken.equals("down")){
            down = false;
        }
        if(!left && !right && !up && !down){
            return true;
        }
        return false;
    }

}
