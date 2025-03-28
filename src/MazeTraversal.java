import java.util.ArrayList;
import java.util.Arrays;

public class MazeTraversal {
    private String[][] maze;
    private int[] position = {0, 0};
    private ArrayList<int[]> positions = new ArrayList<int[]>();
    private ArrayList<Fork> forks = new ArrayList<Fork>();

    public MazeTraversal(String[][] maze){
        this.maze = maze;
        positions.add(position.clone());

    }
    private void move(){
        int choices = 0;
        boolean left = false;
        boolean right = false;
        boolean up = false;
        boolean down = false;
        if(moveLeft()){
            choices ++;
            left = true;
        }
        if(moveRight()){
            choices ++;
            right = true;
        }
        if(moveUp()){
            choices++;
            up = true;
        }
        if(moveDown()){
            choices++;
            down = true;
        }
        if(choices > 1){
            Fork newFork = new Fork(position, up, down, left, right);
            forks.add(newFork);
            System.out.println("FORK DETECTED");
            System.out.println(Arrays.toString(position));
        }
        if (choices == 0) {
            boolean found = false;
            while(!found){
                if(forks.get(forks.size() - 1).deadEnd()){
                    forks.remove(forks.size() - 1);
                }
                else{
                    found = true;
                    String path = forks.get(forks.size() - 1).paths();
                    if(path.equals("up")){
                        up = true;
                    }
                    else if(path.equals("down")){
                        down = true;
                    }
                    else if(path.equals("left")){
                        left = true;
                    }
                    else if(path.equals("right")){
                        right = true;
                    }
                }
            }
        }
        if(left){
            if(choices > 1){
                forks.get(forks.size() - 1).setPathTaken("left");
            }
            position[0] -= 1;
            positions.add(position.clone());
        }
        else if(right){
            if(choices > 1){
                forks.get(forks.size() - 1).setPathTaken("right");
            }
            position[0] += 1;
            positions.add(position.clone());
        }
        else if(up){
            if(choices > 1){
                forks.get(forks.size() - 1).setPathTaken("up");
            }
            position[1] -= 1;
            positions.add(position.clone());
        }
        else if(down){
            if(choices > 1){
                forks.get(forks.size() - 1).setPathTaken("down");
            }
            position[1] += 1;
            positions.add(position.clone());
        }
    }
    public ArrayList<int[]> getPositions(){
        while(position[0] != maze[0].length - 1 || position[1] != maze.length - 1){
            move();
        }

        return positions;
    }
    private boolean moveRight(){
        if(position[0] != maze[0].length - 1){
            if (maze[position[1]][position[0] + 1].equals(".")) {
                int[] temp = position.clone();
                temp[0] += 1;
                try{
                    if(temp[0] != positions.get(positions.size() - 2)[0] || temp[1] != positions.get(positions.size() - 2)[1] ){
                        return true;
                    }
                }
                catch(Exception e){
                    return true;
                }
            }
        }
        return false;
    }
    private boolean moveLeft(){
        if(position[0] != 0){
            if (maze[position[1]][position[0] - 1].equals(".")) {
                int[] temp = position.clone();
                temp[0] -= 1;
                try{
                    if(temp[0] != positions.get(positions.size() - 2)[0] || temp[1] != positions.get(positions.size() - 2)[1]){
                        return true;
                    }
                }
                catch(Exception e){
                    return true;
                }
            }
        }
        return false;
    }
    private boolean moveUp(){
        if(position[1] != 0){
            if (maze[position[1] - 1][position[0]].equals(".")) {
                int[] temp = position.clone();
                temp[1] -= 1;
                try{
                    if(temp[0] != positions.get(positions.size() - 2)[0] || temp[1] != positions.get(positions.size() - 2)[1]){
                        return true;
                    }
                }
                catch(Exception e){
                    return true;
                }
            }
        }
        return false;
    }
    private boolean moveDown(){
        if(position[1] != maze.length - 1){
            if (maze[position[1] + 1][position[0]].equals(".")) {
                int[] temp = position.clone();
                temp[1] += 1;
                try{
                    if(temp[0] != positions.get(positions.size() - 2)[0] || temp[1] != positions.get(positions.size() - 2)[1]){
                        return true;
                    }
                }
                catch(Exception e){
                    return true;
                }
            }
        }
        return false;
    }
}
