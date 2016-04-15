import java.util.Random;
import java.util.Scanner;
import java.io.IOException;


public class Dragon extends Monster{
    static int number=0;
    public Dragon(){
        hitpoint=100;
        alive=true;
    }

    public int attack(Player p){
        int hit = ran.nextInt(19);
        hit++;
        p.hurt(hit);
        return hit;
    }

    public int check(){
        return 2;
    }

    public void showinfo(){
        System.out.println("Dragon HP: " + hitpoint);
    }

}

