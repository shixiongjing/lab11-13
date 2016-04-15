//Created by Shixiong Jing on Feb 21st
//BlackJack Program as the COE401 Assignment #2


import java.util.Random;
import java.util.Scanner;
import java.io.*;

public class Player{

    private int hitpoint;
    private int magicpoint;
    private int defence;
    private int gold;
    public static Random rng=new Random();
    
    public static void main(String[] args){
    	
    	//set scanner
        int[] diary=new int[3];
        Scanner sc = new Scanner(System.in);
        Player p=new Player();
    	boolean win=false;
        while(!win&&p.gethp()>0){
            int leave=0;
            Monster m=Player.meet();
            while(m.alive&&leave==0){
                System.out.println("Player HP: "+p.gethp());
                System.out.println("Player MP: "+p.getmp());
                m.showinfo();
                System.out.println("Your turn: ");
                System.out.println("(A)ttack\n(B)erserk\n(R)un away\n(M)agic");
                System.out.print("Please choose >>");
                String choice=sc.next();
                while((!choice.equals("A"))&&(!choice.equals("B"))&&(!choice.equals("R"))&&(!choice.equals("M"))){
                    choice=sc.next();
                }
                if(choice.equals("A")){
                    p.attack(m);
                }
                else if(choice.equals("B")){
                    System.out.println("Berserk!");
                    p.berserk(m);
                }
                else if(choice.equals("R")){
                    leave=1;
                    System.out.println("You escaped!");
                }
                else if(choice.equals("M")){
                    p.magic();
                }
                else{
                    System.out.println("magic blows up!!!");
                }
                
                if(m.alive==false){
                    System.out.println("Monster is defeated!");
                    Hoard hoard = new Hoard();
                    int num=hoard.getgold();
                    gold+=num;
                    System.out.println("You received "+num+" gold.");
                    diary[m.check()]++;
                }
                else{
                    m.attack(p);
                }
                if(hitpoint<=0){
                    System.out.println("You are defeated!");
                }
            }
            if(diary[2]>0){
                win=true;
            }   
            
        }
        if(win==true){
            System.out.println("Cong! you win!");
            System.out.println("\nkilled Goblin: "+diary[0]+
                             "\nkilled Troll: "+diary[1]+
                             "\nkilled dragon: "+diary[2]+
                             "\nreceived gold: "+gold);
        }
        else{
            System.out.println("Fail~~~");
        }
    }

    public Player(){
        hitpoint=100;
        magicpoint=3;
        defence=0;
        gold=0;
    }

    private void attack(Monster m){
        int hit=rng.nextInt(14);
        hit++;
        m.hurt(hit);
        defence=1;
        System.out.println("you attack. Hit "+hit+" points");
    }

    public void hurt(int a){
        if(defence==0){
            a=2*a;
        }
        hitpoint-=a;
        System.out.println("You recieved hurt "+a+" points");
    }

    private void magic(){
        hitpoint=100;
        magicpoint--;
        System.out.println("You healed yourself!");
    }

    private void berserk(Monster m){
        int hit=rng.nextInt(15);
        m.hurt(hit*3);
        System.out.println("hitted!");
        System.out.println("you attack. Hit "+hit*3+" points");
    }

    private static Monster meet(){
        int num=rng.nextInt(10);
        Monster m;
        if(num<5){
            m=new Goblin();
            System.out.println("\nYou meet a goblin!");
        }
        else if(num<9){
            m=new Troll();
            System.out.println("\nYou meet a Troll!");
        }
        else{
            m=new Dragon();
            System.out.println("\nYou meet a Dragon!");
        }
        return m;
    }

    public int gethp(){
        return hitpoint;
    }

    public int getmp(){
        return magicpoint;
    }
 }