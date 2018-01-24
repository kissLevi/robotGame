package robotgame.consoleview;

import robotgame.model.robotmodel.TableInfo;
import robotgame.model.tablemodel.Position;
import robotgame.model.tablemodel.Table;

public class ConsoleView implements ConsoleTableProcesser{
    @Override
    public void renderTable(Table table,TableInfo info) {
        int tableSize = table.getTableSize();
        Position player1 = new Position(table.getPlayer1Position().getX()+table.getPlayer1Position().getX()-1, table.getPlayer1Position().getY());
        Position player2 = new Position(table.getPlayer2Position().getX()+table.getPlayer2Position().getX()-1, table.getPlayer2Position().getY());
        for (int i = 0; i <= tableSize+1 ; i++) {
            for (int j = 0; j <= tableSize * 2; j++) {
                if (i == 0 || i == tableSize+1 || j == 0 || j == tableSize * 2) {
                    System.out.print("#");
                }
                else if(player1.getX()==j && player1.getY() == i){
                    System.out.print("A");
                }
                else if(player2.getX()==j && player2.getY() == i){
                    System.out.print("B");
                }
                else if(j%2 == 0){
                    if(j%2 == 0){
                        System.out.print("|"); 
                    }
                }
                else {
                    System.out.print("_");
                }
            }
            System.out.println("");
        }
    }
    
    
}
