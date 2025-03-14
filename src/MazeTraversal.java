import java.util.ArrayList;
import java.util.Arrays;

public class MazeTraversal {
    private String[][] maze;
    private int[] position = {0, 0};
    private ArrayList<int[]> positions = new ArrayList<int[]>();
    private ArrayList<int[]> forks = new ArrayList<int[]>();

    public MazeTraversal(String[][] maze){
        this.maze = maze;
        positions.add(position.clone());

    }
    private void move(){
        int choices = 0;
        boolean fork = false;
        if(moveLeft()){
            choices ++;
            position[0] -= 1;
            positions.add(position.clone());
        }
        if(moveRight()){
            choices ++;
            position[0] += 1;
            positions.add(position.clone());
        }
        if(moveUp()){
            choices ++;
            position[1] -= 1;
            positions.add(position.clone());
        }
        if(moveDown()){
            choices ++;
            position[1] += 1;
            positions.add(position.clone());
        }
        if(choices > 1){
            forks.add(position.clone());
            System.out.println("FORK DETECTED");
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
