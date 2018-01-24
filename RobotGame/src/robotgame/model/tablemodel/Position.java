package robotgame.model.tablemodel;

import java.util.Objects;


public class Position implements Comparable<Position>{
    private int x;
    private int y;
    
    public Position(int x,int y){
        this.x = x;
        this.y = y;
    }
    public void setPosition(int x,int y){
        this.x = x;
        this.y = y;
    }
    public void setPosition(Position position){
        this.x = position.x;
        this.y = position.y;
    }
 
    Position getPosition() {
        return new Position(this.x, this.y);
    }
    
    public int getX(){
        return this.x;
    }
    public int getY(){
        return this.y;
    }
    public Position transform(Direction direction) {
        return new Position(this.x + direction.getXCoordinate(), this.y + direction.getYCoordinate());
    }
    public int compareInXAxis(Position o){
        return this.x-o.x;
    }
    public int compareInYAxis(Position o){
        return this.y-o.y;
    }
    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (this.getClass() != obj.getClass()) {
            return false;
        }

        Position other = (Position) obj;
        return x == other.x && y == other.y;
    }

    @Override
    public int compareTo(Position o) {
        int compare = x - o.x;
        if(compare!= 0) return compare;
        return y-o.y;
    }
    @Override
    public String toString(){
        return "x:" + x + " y:" + y;
    }
    
}
