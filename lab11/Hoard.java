//Created by Shixiong Jing on Feb 21st
//BlackJack Program as the COE401 Assignment #2


import java.util.Random;
import java.util.Scanner;
import java.io.IOException;

public class Hoard{

    int gold;

    public Hoard(){
        Random rng=new Random();
        gold=rng.nextInt(100);
    }
    
    public int getgold(){
        return gold;
    }
    
}