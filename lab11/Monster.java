import java.util.Random;
import java.util.Scanner;
import java.io.IOException;

public class Monster{
    public int hitpoint;
    public boolean alive;
    Random ran=new Random();

    public Monster(){
        hitpoint=100;
        alive=true;
    }

    public void hurt(int a){
        hitpoint=hitpoint-a;
        System.out.println("hurted!");
        if(hitpoint<=0){
            alive=false;
        }
    }

    public int attack(Player p){
        p.hurt(10);
        return 10;
    }

    public int check(){
        return -1;
    }

    public void showinfo(){
        System.out.println("Monster HP: " + hitpoint);
    }
}

