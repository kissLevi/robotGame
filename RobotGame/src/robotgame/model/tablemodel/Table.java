package robotgame.model.tablemodel;

import java.util.Random;

public class Table {

    final private int tableSize;
    private Position player1;
    private Position player2;
    private int roundCount;

    //Constructor witch takes tableSize and start position of players
    public Table(int tableSize, Position player1, Position player2) {
        this.tableSize = tableSize;
        this.player1 = player1;
        this.player2 = player2;
        this.roundCount = 0;
    }

    //Constructor witch takes tableSize. In that case start positions of players
    //are generated randomly.
    public Table(int tableSize) {
        Random randomNumber = new Random();
        this.player1 = new Position(randomNumber.nextInt(tableSize)+1,
                randomNumber.nextInt(tableSize)+1);
        this.player2 = new Position(randomNumber.nextInt(tableSize)+1,
                randomNumber.nextInt(tableSize)+1);
        //If the start positions are same we generate new start positions for 
        // player2.
        while (this.player1.equals(this.player2)) {
            this.player2 = new Position(randomNumber.nextInt(tableSize)+1,
                    randomNumber.nextInt(tableSize)+1);
        }
        this.tableSize = tableSize;
    }

    public void roundPlayed(){
        this.roundCount ++;
    }
    
    public int getTableSize() {
        return this.tableSize;
    }

    public int getRoundCount(){
        return this.roundCount;
    }
    public Position getPlayer1Position() {
        return player1;
    }

    public Position getPlayer2Position() {
        return player2;
    }

    public void setPlayer1Position(Position player1) {
        this.player1.setPosition(player1);
    }

    public void setPlayer2Position(Position player2) {
        this.player2.setPosition(player2); 
    }
    
    private Position transformPosition(Position oldPosition, Direction direction) {
        Position newPosition = oldPosition.transform(direction);

        final Position MAXXMAXY = new Position(tableSize, tableSize);
        final Position MINXMINY = new Position(1, 1);

        //checks if the new position in the table
        if (newPosition.compareInXAxis(MAXXMAXY) <= 0 && newPosition.compareInXAxis(MINXMINY) >= 0
                && newPosition.compareInYAxis(MAXXMAXY) <= 0 && newPosition.compareInYAxis(MINXMINY) >= 0) {
            return newPosition;
        }
        return oldPosition;
    }
    


}
