import java.lang.reflect.Array;
import java.util.ArrayList;

public class Maze {
    private String[][] maze;


    public Maze(String[][] maze){
        this.maze = maze;
    }

    public String toString(){
        String returnString = "";
        for(String[] list : maze){
            for(String letter : list){
                returnString += letter;
            }
            returnString += "\n";
        }
        return returnString;
    }
    public ArrayList<int[]> mazeTraversal(){
        MazeTraversal mazeTraversal = new MazeTraversal(maze);
        return mazeTraversal.getPositions();
    }
}
