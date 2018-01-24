package robotgame.model.robotmodel;

import robotgame.model.tablemodel.Position;

public class TableInfo {
    private final Position ownPosition;
    private final Position enemyPosition;
    private final int ownArmour;
    private final int enemyArmour;
    private final int tableSize;
    
    private TableInfo(RobotPlayer player,RobotPlayer enemy,
            Position enemyPosition, Position playerPosition,int tableSize){
        this.ownPosition = playerPosition;
        this.enemyPosition = enemyPosition;
        this.ownArmour = player.getArmour();
        this.enemyArmour = enemy.getArmour();
        this.tableSize = tableSize;
    }
    
    public static TableInfo getTableInfo(RobotPlayer player,RobotPlayer enemy,
            Position enemyPosition, Position playerPosition,int tableSize){
        return new TableInfo(player,enemy,enemyPosition,playerPosition,tableSize);
    }
    
    public Position getOwnPosition(){
        return this.ownPosition;
    }
    
    public Position getEnemyPosition() {
        return enemyPosition;
    }

    public int getOwnArmour() {
        return ownArmour;
    }

    public int getEnemyArmour() {
        return enemyArmour;
    }

    public int getTableSize() {
        return tableSize;
    }
    
}
