import java.util.*;

public class MainClass {
    public  static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        System.out.println("\t\t\tWelcome to my game");
        char ans;
        do {
            Player.intializeGame();
            System.out.print("Player choose your symbol X or O : ");
            char symbol=sc.next().charAt(0);
            Player []players=new Player[2];
            players[0]=new Player(symbol);
            players[1]= new Player((symbol=='X')?'O':'X');

            int ctr=0;
            int x=3;
            while (Player.canPlay) {
                players[ctr++ % 2].play();
            }
            System.out.println("to play again press y");
            ans=sc.next().charAt(0);
        }
        while (ans=='y');

    }
}
