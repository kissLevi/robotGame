package robotgame.model.tablemodel;

public class Event {
    private Direction direction;
    private EventType event;
    
    public Event(EventType event, Direction direction){
        this.direction = direction;
        this.event = event;
    }
    
   final void setEventType(EventType event){
       this.event = event;
   }
   final void setDirection(Direction direction){
       this.direction = direction;
   }
   
   public final Direction getDirection(){
       return this.direction;
   }
   
   public final EventType getEventType(){
       return this.event;
   }
   
}
