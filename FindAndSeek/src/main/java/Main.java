import dev.jaakkovirtanen.findandseek.game.*;

public class Main {

    public static void main(String[] args) {
        MapObject pelaaja = new Player();
        pelaaja.performMove();
        pelaaja.changeMoveBehaviour(new MoveDiagonally());
        pelaaja.performMove();
        MapObject firstAnswer = new Answer();
        System.out.println(firstAnswer.getCol());
        System.out.println(firstAnswer.getRow());
        firstAnswer.performMove();
    }
}
