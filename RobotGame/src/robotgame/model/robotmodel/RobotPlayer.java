package robotgame.model.robotmodel;

import robotgame.model.tablemodel.Event;
import robotgame.model.tablemodel.Position;


public class RobotPlayer {

    private final Robot robot;
    private final String name;
    private int armour;
    

    public RobotPlayer(Robot robot, int armour, String name) throws Exception {
        this.robot = robot;
        this.armour = armour;
        this.name = name;
    }

    public int getArmour() {
        return this.armour;
    }

    public void setArmour(int armour) {
        this.armour = armour;
    }
    
    public void decraseArmour(int amount){
        this.armour -= amount;
    }

    public boolean dead() {
        return this.armour < 1;
    }

    public Event makeStep(RobotPlayer enemy, Position enemyPosition, Position playerPosition, int tableSize) {
        return this.robot.makeStep(TableInfo.getTableInfo(this, enemy, enemyPosition, playerPosition, tableSize));
    }
    
    @Override
    public String toString(){
        return "Name of robot:" + this.name + "\nArmour:" + armour;
    }

    
}
