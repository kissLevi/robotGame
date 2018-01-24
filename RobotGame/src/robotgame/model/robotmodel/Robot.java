package robotgame.model.robotmodel;


import robotgame.model.tablemodel.Event;

public interface Robot {
    Event makeStep(TableInfo table);
    
}
