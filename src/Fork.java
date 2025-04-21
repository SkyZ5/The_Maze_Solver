import java.util.ArrayList;
import java.util.Arrays;

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
    public String toString(){
        return "Position: " + Arrays.toString(pos) + "(U,D,L,R): " + up + "," + down + "," + left + "," + right + ",";
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

    public int[] getPos() {
        return pos;
    }

    public String paths(){
        if(up){
            pathTaken = "up";
            return "up";
        }
        else if(down){
            pathTaken = "down";
            return "down";
        }
        else if(left){
            pathTaken = "left";
            return "left";
        }
        else if(right){
            pathTaken = "right";
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
