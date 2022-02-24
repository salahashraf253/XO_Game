import java.util.*;
public class Grid {
    private  char [][]grid;
    int emptyPositions;
    Grid(){
        this.emptyPositions=9;
        this.grid=new char[5][5];
        intializeGridWithDots();
    }
    private void intializeGridWithDots(){
        for(int i=1;i<=3;i++){
            for(int j=1;j<=3;j++){
                grid[i][j]='.';
            }
        }
    }
    public void setGrid(int i,int j ,char symbol){
        grid[i][j]=symbol;
    }
    public  void draw(){
        System.out.println("Grid: ");
        for(int i=1;i<=3;i++){
            for(int j=1;j<=3;j++){
                System.out.print(grid[i][j]+" ");
            }
            System.out.println();
        }
    }
    public  Boolean isAvailablePosition(int i,int j) {
        return i >= 1 && i <= 3 && j >= 1 && j <= 3 && grid[i][j] == '.';
    }

    public char isGameEnded(){
        char ans=checkRowsAndColumns();
        return ans;
    }
    private char checkRowsAndColumns(){
        Set<Character> rows = new HashSet<Character>();
        Set<Character> columns = new HashSet<Character>();
        for(int i=1;i<=3;i++){
            rows.clear();
            columns.clear();
            for(int j=1;j<=3;j++){
                rows.add(grid[i][j]);
                columns.add(grid[j][i]);
            }
            if(rows.size()==1 && !rows.iterator().next().equals('.')){
                System.out.println("fdffff   "+rows.iterator().next());
                return rows.iterator().next();
            }
            if(columns.size()==1 && !columns.iterator().next().equals('.')){
                return columns.iterator().next();
            }
        }
        return 'D';
    }


}
