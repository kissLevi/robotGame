package robotgame.controller;

import robotgame.consoleview.ConsoleView;
import robotgame.model.GameEngine;
import robotgame.model.robotmodel.Robot;
import robotgame.model.robotmodel.RobotPlayer;
import robotgame.model.tablemodel.Position;
import robotgame.model.tablemodel.Table;


public class GameController {
    public static void main(String[] args){
        ClassLoader classLoader = GameController.class.getClassLoader();
        

        
        if(args.length !=5){
            System.out.println("The program needs 5 parameters.\n"
                    + "1:size of table\n"
                    + "2-3: names of robot classes\n"
                    + "4: number of rounds\n"
                    + "5: armour");
            System.exit(1);
        }
        int maxArmour = Integer.parseInt(args[4]);
        RobotPlayer player1 = getRobot(args[1], classLoader, maxArmour);
        RobotPlayer player2 = getRobot(args[2], classLoader, maxArmour);
 
        

        if (player1 != null && player2 != null){
            
            //Table table = new Table(Integer.parseInt(args[0]));
            Table table = new Table(Integer.parseInt(args[0]), new Position(2, 2), new Position(3, 1));
            GameEngine engine = new GameEngine(table, Integer.parseInt(args[3]), player1, player2);
            ConsoleView console = new ConsoleView();
            console.renderTable(table,engine.getPlayer1(),engine.getPlayer2(),maxArmour);
//            System.out.println(table.getPlayer1Position());
//            System.out.println(table.getPlayer2Position());
//            
            do{
                console.renderTable(engine.playRound(),engine.getPlayer1(),
                        engine.getPlayer2(),maxArmour);
            }while(!engine.endOfGame());
            System.out.println(engine.getResultOfGame());

        }
        
       
        
    }
    
    
    public static RobotPlayer getRobot(String className,ClassLoader loader,int armour){
        
         try{
             Class robotClass = loader.loadClass(className);
             RobotPlayer robot = new RobotPlayer((Robot) robotClass.newInstance(), armour, className);
             return robot;
         }catch(Exception ex){
             System.out.println("Class " + className +" doesn't exist or "
                    + "doesn't implemets Robot interface.");
         }
         return null;
    }
    
    
    
}
