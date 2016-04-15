import java.util.Random;
import java.util.Scanner;
import java.io.IOException;


public class Goblin extends Monster{
    static int number=0;
    public Goblin(){
        hitpoint=10;
        alive=true;
    }

    public int attack(Player p){
        int hit=ran.nextInt(4);
        hit++;
        p.hurt(hit);
        return hit;
    }

    public int check(){
        return 0;
    }

    public void showinfo(){
        System.out.println("Goblin HP: " + hitpoint);
    }

}