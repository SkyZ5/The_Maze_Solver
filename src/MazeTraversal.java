import java.util.ArrayList;

public class MazeTraversal {
    private String[][] maze;
    private int[] position = {0, 0};
    private ArrayList<int[]> positions = new ArrayList<int[]>();

    public MazeTraversal(String[][] maze){
        this.maze = maze;

    }
    private void move(){
        positions.add(position);
        if(moveLeft()){
            position[0] += 1;
        }
        else if(moveRight()){
            position[0] -= 1;
        }
        else if(moveUp()){
            position[1] -= 1;
        }
        else if(moveDown()){
            position[1] += 1;
        }
    }
    public ArrayList<int[]> getPositions(){
        while(position != [maze.length, maze[0].length])
    }
    private boolean moveRight(){
        if(position[0] != maze[0].length - 1){
            if (maze[position[1]][position[0] + 1].equals(".")) {
                int[] temp = position;
                temp[0] += 1;
                try{
                    if(temp != positions.get(positions.size() - 2)){
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
                int[] temp = position;
                temp[0] -= 1;
                try{
                    if(temp != positions.get(positions.size() - 2)){
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
                int[] temp = position;
                temp[1] -= 1;
                try{
                    if(temp != positions.get(positions.size() - 2)){
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
                int[] temp = position;
                temp[1] += 1;
                try{
                    if(temp != positions.get(positions.size() - 2)){
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
