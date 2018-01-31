import java.util.Random;

public class Dice {
    private int value;

    public Dice() {
        this.value = 0;
    }

    public void roll() {
        Random random = new Random();

        this.value = random.nextInt(6) + 1;
    }

    public int getValue() {
        return this.value;
    }
}
