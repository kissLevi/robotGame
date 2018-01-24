package robotgame.model;

import robotgame.model.robotmodel.RobotPlayer;
import robotgame.model.robotmodel.TableInfo;
import robotgame.model.tablemodel.Direction;
import robotgame.model.tablemodel.Event;
import robotgame.model.tablemodel.Position;
import robotgame.model.tablemodel.Table;

public class GameEngine {

    private final Table table;
    private final RobotPlayer player1;
    private final RobotPlayer player2;
    private int numberOfRounds;
    private int roundsPlayed = 0;

    public GameEngine(Table table, int numberOfRounds,
            RobotPlayer player1, RobotPlayer player2) {
        this.table = table;
        this.numberOfRounds = numberOfRounds;
        this.player1 = player1;
        this.player2 = player2;
    }

    public Table playRound() {
        roundsPlayed++;
        numberOfRounds--;
        Event player1Event = player1.makeStep(TableInfo.getTableInfo( 
                player1,player2, table.getPlayer2Position(),
                table.getPlayer1Position(), table.getTableSize()));
        Event player2Event = player2.makeStep(TableInfo.getTableInfo(
                player2,player1, table.getPlayer1Position(),
                table.getPlayer2Position(), table.getTableSize()));
        updatePlayerData(player1Event, player2Event);

        return this.table;
    }
    public int getNumberOfRoundsPlayed(){
        return this.roundsPlayed;
    }
    
    public RobotPlayer getPlayer1(){
        return this.player1;
    }
    public RobotPlayer getPlayer2(){
        return this.player2;
    }
    
    public boolean endOfGame() {
        return numberOfRounds < 1 || player1.dead() || player2.dead();
    }
    public TableInfo getTableInfo(){
        return TableInfo.getTableInfo(player1, player2, table.getPlayer1Position(),
                table.getPlayer2Position(), table.getTableSize());
    }

    public String getResultOfGame() {
        if(player1.dead() && player2.dead()){
            return "Eredmény: döntetlen!\n";
        }
        else if(!player1.dead() && player2.dead()){
            return "Eredmény: "+ player1.getName() +" nyert!\n";
        }
        else if(player1.dead() && !player2.dead()){
            return "Eredmény: "+ player2.getName() +" nyert!\n";
        }
        else if(!player1.dead() && !player2.dead()){
            if(player1.getArmour()>player2.getArmour()){
                return "Eredmény: "+ player1.getName() +" nyert!\n";
            }
            else if(player1.getArmour()<player2.getArmour()){
                return "Eredmény: "+ player2.getName() +" nyert!\n";
            }
        }
        
        return "Eredmény: döntetlen!\n";
        
    }

    // This method checks is the movement of players can happen and if can it does it.
    private void updatePlayerData(Event player1Event, Event player2Event) {
        Position directionOfPlayer1Movement = transformPosition(
                table.getPlayer1Position(), player1Event.getDirection());
        Position directionOfPlayer2Movement = transformPosition(
                table.getPlayer2Position(), player2Event.getDirection());
        switch (player1Event.getEventType()) {
            case MOVE:
                switch (player2Event.getEventType()) {
                    case MOVE:
                        if (directionOfPlayer1Movement.compareInXAxis(directionOfPlayer2Movement) != 0
                                || directionOfPlayer1Movement.compareInYAxis(directionOfPlayer2Movement) != 0) {
                            this.table.setPlayer1Position(directionOfPlayer1Movement);
                            this.table.setPlayer2Position(directionOfPlayer2Movement);
                        }
                        break;
                    case ATTACK:
                        if (directionOfPlayer2Movement.equals(directionOfPlayer1Movement)) {
                            table.setPlayer1Position(directionOfPlayer1Movement);
                            player1.decraseArmour(1);
                        }
                        else{
                            table.setPlayer1Position(directionOfPlayer1Movement);
                        }
                        break;
                    case DEFEND:
                    case STAY:
                        if(!table.getPlayer2Position().equals(directionOfPlayer1Movement)){
                            table.setPlayer1Position(directionOfPlayer1Movement);
                        }
                        break;
                }
                break;
            case ATTACK:
                switch (player2Event.getEventType()) {
                    case MOVE:
                        if (directionOfPlayer1Movement.equals(directionOfPlayer2Movement)) {
                            table.setPlayer2Position(directionOfPlayer2Movement);
                            player2.decraseArmour(1);
                        }
                        else{
                            table.setPlayer2Position(directionOfPlayer2Movement);
                        }
                        break;
                    case ATTACK:
                        if (directionOfPlayer1Movement.equals(table.getPlayer2Position())) {
                            player2.decraseArmour(1);
                        }
                        if (directionOfPlayer2Movement.equals(table.getPlayer1Position())) {
                            player1.decraseArmour(1);
                        }
                        break;
                    case DEFEND:
                        if (directionOfPlayer1Movement.equals(table.getPlayer2Position())
                                && !directionOfPlayer2Movement.equals(table.getPlayer1Position())) {
                            player2.decraseArmour(1);
                        }
                        break;
                    case STAY:
                        if (directionOfPlayer1Movement.equals(table.getPlayer2Position())) {
                            player2.decraseArmour(1);
                        }
                        break;
                }
                break;
            case DEFEND:
                switch (player2Event.getEventType()) {
                    case MOVE:
                        if (!table.getPlayer1Position().equals(directionOfPlayer2Movement)) {
                            table.setPlayer2Position(directionOfPlayer2Movement);
                        }
                        break;
                    case ATTACK:
                        if (directionOfPlayer2Movement.equals(table.getPlayer1Position())
                                && !directionOfPlayer1Movement.equals(table.getPlayer2Position())) {
                            player1.decraseArmour(1);
                        }
                        break;
                    case DEFEND:
                    case STAY:
                        break;
                }
                break;
            case STAY:
                switch (player2Event.getEventType()) {
                    case MOVE:
                        if (!table.getPlayer1Position().equals(directionOfPlayer2Movement)) {
                            table.setPlayer2Position(directionOfPlayer2Movement);
                        }
                        break;
                    case ATTACK:
                        if (directionOfPlayer2Movement.equals(table.getPlayer1Position())
                                && !directionOfPlayer2Movement.equals(directionOfPlayer1Movement)) {
                            player1.decraseArmour(1);
                        }
                        break;
                    case DEFEND:
                    case STAY:
                        break;
                }
                break;

        }
        table.roundPlayed();
    }

    //Checks if step is possible. Step is possible if it's not outside of table.
    private Position transformPosition(Position oldPosition, Direction direction) {
        Position newPosition = oldPosition.transform(direction);
        
        final Position MAXXMAXY = new Position(table.getTableSize(), table.getTableSize());
        final Position MINXMINY = new Position(1, 1);

        //checks if the new position in the table
        if (newPosition.compareInXAxis(MAXXMAXY) <= 0 && newPosition.compareInXAxis(MINXMINY) >= 0
                && newPosition.compareInYAxis(MAXXMAXY) <= 0 && newPosition.compareInYAxis(MINXMINY) >= 0) {
            return newPosition;
        }
        return oldPosition;
    }

}
