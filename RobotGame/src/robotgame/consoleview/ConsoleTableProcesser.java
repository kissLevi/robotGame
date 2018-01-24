package robotgame.consoleview;

import robotgame.model.robotmodel.TableInfo;
import robotgame.model.tablemodel.Table;


public interface ConsoleTableProcesser {
    void renderTable(Table table,TableInfo info);
}
