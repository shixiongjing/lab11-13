import java.util.Random;
import java.util.Scanner;
import java.io.IOException;


public class Troll extends Monster{
    public Troll(){
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
        return 1;
    }

    public void showinfo(){
        System.out.println("Troll HP: " + hitpoint);
    }

}