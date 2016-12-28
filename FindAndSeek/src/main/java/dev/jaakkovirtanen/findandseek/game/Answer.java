package dev.jaakkovirtanen.findandseek.game;

public class Answer extends MapObject {

    public Answer() {
        location = new Location(1,1);
        moveBehaviour = new MoveNoWay();
    }
    
}
