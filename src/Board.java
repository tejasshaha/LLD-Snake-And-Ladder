import java.util.concurrent.ThreadLocalRandom;

public class Board {

    Cell[][] cells;
    int boardSize;
    public Board(int boardSize,int snakeCount,int ladderCount){
        this.boardSize=boardSize;
        cells=new Cell[boardSize][boardSize];
        for(int index1=0;index1<boardSize;index1++){
            for(int index2=0;index2<boardSize;index2++){
                cells[index1][index2]=new Cell();
            }
        }
        initializeBoard(snakeCount,ladderCount);
    }

    void initializeBoard(int snakeCount,int ladderCount){
        int count=0;

        while(count<snakeCount){
            int start= ThreadLocalRandom.current().nextInt(1,boardSize*boardSize-1);
            int end= ThreadLocalRandom.current().nextInt(1,boardSize*boardSize-1);

            if(end>=start){
                continue;
            }
            Cell cell =getCell(start);
            Jump jump=new Jump();
            jump.start=start;
            jump.end=end;
            cell.jump=jump;
            count++;
        }

        count=0;

        while(count<ladderCount){
            int start=ThreadLocalRandom.current().nextInt(1,boardSize*boardSize-1);
            int end=ThreadLocalRandom.current().nextInt(1,boardSize*boardSize-1);

            if(start>=end){
                continue;
            }

            Cell cell=getCell(start);
            Jump jump=new Jump();
            jump.start=start;
            jump.end=end;
            cell.jump=jump;
            count++;
        }
    }

    Cell getCell(int position){
        return cells[position/boardSize][position%boardSize];
    }
}
