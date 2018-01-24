package robotgame.consoleview;

import robotgame.model.robotmodel.RobotPlayer;
import robotgame.model.tablemodel.Position;
import robotgame.model.tablemodel.Table;

public class ConsoleView{
    public void renderTable(Table table,RobotPlayer player1 ,RobotPlayer player2, int maxArmour) {
        int tableSize = table.getTableSize();
        Position player1Position = new Position(table.getPlayer1Position().getX()+table.getPlayer1Position().getX()-1, table.getPlayer1Position().getY());
        Position player2Position = new Position(table.getPlayer2Position().getX()+table.getPlayer2Position().getX()-1, table.getPlayer2Position().getY());
        
        System.out.println(table.getRoundCount()+".kör");
        for (int i = 0; i <= tableSize+1 ; i++) {
            for (int j = 0; j <= tableSize * 2; j++) {
                if (i == 0 || i == tableSize+1 || j == 0 || j == tableSize * 2) {
           
                    System.out.print("#");
           
                }
                else if(player1Position.getX()==j && player1Position.getY() == i){
                    System.out.print("A");
                }
                else if(player2Position.getX()==j && player2Position.getY() == i){
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
        System.out.println("");
        System.out.println("\"A\" robot: "+ player1.getName());
        System.out.println("Páncél: "+player1.getArmour()+"/"+maxArmour);
        System.out.println("");
        System.out.println("\"B\" robot: "+ player2.getName());
        System.out.println("Páncél: "+player2.getArmour()+"/"+maxArmour);
        System.out.println("");
     
//        System.out.println(info.getEnemyArmour());
//        System.out.println(info.getOwnArmour());
    }
    
    
}
