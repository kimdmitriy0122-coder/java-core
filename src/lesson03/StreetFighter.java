package lesson03;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Random;

public class StreetFighter {
    private int firstShot = new Random().nextInt(2);
    private static final List<Fighter> FIGHTERS = new ArrayList<>();

    public void fight(Fighter fighter1, Fighter fighter2) {
        if(fighter1 == null || fighter2 == null)
            throw new NoSuchFighter();

        if(firstShot == 0)
            takeHit(fighter1, fighter2);
        else
            takeHit(fighter2, fighter1);

    }
    private void takeHit(Fighter fighter1, Fighter fighter2){
        fighter2.setHealth(fighter2.getHealth() - fighter1.getAttack());
        if(fighter2.getHealth() <= 0){
            System.out.println("боец " + fighter1.getName() + " победил ");
        } else {
            takeHit(fighter2, fighter1);
            if(fighter1.getHealth() <= 0){
                System.out.println("боец " + fighter2.getName() + " победил ");
            } else
                takeHit(fighter1, fighter2);
        }
    }
    public Fighter getFighterInfo(int code){
        return FIGHTERS.stream()
            .filter(fighter -> fighter.code == code)
            .findFirst()
            .orElse(null);
    }
    //getFighters() обеспечит Lombok

    @Data
    class Fighter {
        private String name;
        private int health, attack, code;
    }
    class NoSuchFighter extends NoSuchElementException{
        String message = "no such fighter";
    }
}
