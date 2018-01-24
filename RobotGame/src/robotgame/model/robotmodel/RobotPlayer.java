package robotgame.model.robotmodel;

import robotgame.model.tablemodel.Event;


public class RobotPlayer{

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
    
    public String getName(){
        return this.name;
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

    public Event makeStep(TableInfo tableInfo) {
        return this.robot.makeStep(tableInfo);
    }
    
    @Override
    public String toString(){
        return "Name of robot:" + this.name + "\nArmour:" + armour;
    }

    
}
