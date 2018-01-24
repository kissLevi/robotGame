package robotgame.robot;

import robotgame.model.robotmodel.Robot;
import robotgame.model.robotmodel.TableInfo;
import robotgame.model.tablemodel.Direction;
import robotgame.model.tablemodel.Event;
import robotgame.model.tablemodel.EventType;


public class Robot2 implements Robot{

    @Override
    public Event makeStep(TableInfo table) {
//        System.out.println("működök");
//        System.out.println(table.getEnemyArmour());
//        System.out.println(table.getEnemyPosition());
//        System.out.println(table.getOwnArmour());
//        System.out.println(table.getOwnPosition());
//        System.out.println(table.getTableSize());
        return new Event(EventType.MOVE,Direction.UP);
    }
    
}
