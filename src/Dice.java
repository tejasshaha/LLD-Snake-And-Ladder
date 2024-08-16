import java.util.concurrent.ThreadLocalRandom;

public class Dice {

    int diceCount;
    int minimum=1;
    int maximum=6;
    public Dice(int diceCount) {
        this.diceCount = diceCount;
    }

    public int rollDice(){
        int total=0;
        int count=0;

        while(count<diceCount){
            int sum= ThreadLocalRandom.current().nextInt(minimum,maximum+1);
            total+=sum;
            count++;
        }

        return total;
    }
}
