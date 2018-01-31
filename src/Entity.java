public class Entity {

    private Dice[]   dices;
    private int      gamesWon;

    public Entity() {
        this.dices = new Dice[2];
        this.dices[0] = new Dice();
        this.dices[1] = new Dice();
        this.gamesWon = 0;
    }

    public void rollDice() {
        for (Dice dice: this.dices) {
            dice.roll();
        }
    }

    public Dice[] getDices() {
        return this.dices;
    }

    public int getWonGames() {
        return this.gamesWon;
    }

    public void gameWon() {
        this.gamesWon += 1;
    }

}
