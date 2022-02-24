import java.util.*;
public class Player {
//    public static boolean canPlay;
    Scanner sc= new Scanner(System.in);
    private final char symbol;
    private static final Grid gridForPlaying = new Grid() ;
    private static int ctr=0;
    public static Boolean canPlay=true;
    Player(char symbol){
        this.symbol=symbol;

    }
    public void play() {
        int i, j;
        System.out.print("Player " + (ctr++ % 2 + 1) + " turn\nEnter the position you want to play : ");
        i = sc.nextInt();
        j = sc.nextInt();
        while (!gridForPlaying.isAvailablePosition(i, j)) {
            System.out.print("Invalid position for x or y.\nPlease enter a valid position : ");
            i = sc.nextInt();
            j = sc.nextInt();
        }
        gridForPlaying.setGrid(i, j, symbol);
        gridForPlaying.draw();
        gridForPlaying.emptyPositions--;
        System.out.println("Empty Positions : " + gridForPlaying.emptyPositions);
        char winner=gridForPlaying.isGameEnded();
        if(winner=='D' && gridForPlaying.emptyPositions==0){
            System.out.println("Draw\nGame is Ended");
            canPlay=false;
        }
        else if (winner!='.' && winner!='D') {
            canPlay=false;
            viewWinner(winner);
        }
    }
    private void viewWinner(char winner){
        if(winner==symbol) System.out.println("Player "+(ctr++ % 2 + 1)+" is won");
        else System.out.println("Player "+((ctr++ % 2 + 1 ==1)?2:1 )+" is won");
    }


}
