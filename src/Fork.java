import java.util.ArrayList;

public class Fork {
    private ArrayList<Fork> parentForks;
    private ArrayList<Fork> childForks;
    private int[] pos;
    private boolean up;
    private boolean down;
    private boolean left;
    private boolean right;

    public Fork(int[] pos, boolean up, boolean down, boolean left, boolean right){
        this.pos = pos;
        this.up = up;
        this.down = down;
        this.left = left;
        this.right = right;
    }
    public void addParent(Fork fork){
        parentForks.add(fork);
    }
    public void addChild(Fork fork){
        childForks.add(fork);
    }
    public boolean paths(){
        if(up || down || left || right){
            return true;
        }
        return false;
    }

}
