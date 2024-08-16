import java.util.ArrayDeque;
import java.util.Deque;

public class Game {

    Board board;
    Dice dice;
    Deque<Player> playersList = new ArrayDeque<>();
    Player winner;

    public Game(){
        board = new Board(10,5,5);
        dice = new Dice(1);
        playersList.add(new Player("PlayerA",0));
        playersList.add(new Player("PlayerB",0));
        winner=null;
    }

    public void StartGame(){

        while(winner==null){
            Player player=getPlayer();
            int sum=dice.rollDice();
            int position=player.currentPosition+sum;
            //Check if winner

            if(checkWinner(position)){
                System.out.println("Winning position : " +position);
                winner=player;
                break;
            }

            //Check for Snake or ladders

            Cell cell = board.getCell(position);
            if(cell.jump!=null && cell.jump.start==position){
                position=cell.jump.end;
            }
            player.currentPosition=position;
            System.out.println("Current position of player " + player.getPlayerName() + " is : "+player.currentPosition);

        }

        System.out.println("Winner is : " + winner.getPlayerName());
    }

    public Player getPlayer(){
        Player player = playersList.removeFirst();
        playersList.addLast(player);
        return player;
    }

    public boolean checkWinner(int position){
        return position >= board.boardSize * board.boardSize - 1;
    }
}
