/*
    The Programa is called the Dice game.
    This program will roll dice and give you points based on what you roll.
    There will be examples of varibles, conditionals, expressions, loops, data, classes and so on.
*/


import java.util.ArrayList;  
import java.util.Scanner; 

public class App {
    public static void main(String[] args) throws Exception {

        System.out.println(" ");
        System.out.println("Dice Game");
        Director myStart = new Director();
        myStart.start_game();
    
        // System.out.println("Game Over!!");

        // System.out.println("Your Total score was" + " " + myStart.do_outputs() );
    }
}

class Director {
    boolean keep_playing = true;
    int score = 0;
    Thrower myObj2 = new Thrower();

    void start_game(){

        // Does a loop through the game.
        while (this.keep_playing) { 
            get_inputs();
            do_updates();
            do_outputs();
        }
    }

    // Gets the inputs.
    void get_inputs() {
        myObj2.throw_dice();
    }

    // Gets the updates of the game.
    void do_updates() {
        int points = myObj2.get_points();
        this.score += points;
    }

    // Gets the outpus of the game.
    void do_outputs() {
        System.out.println("You rolled:" + myObj2.throw_dice());
        System.out.println("Your score is:" + " " + this.score);
        boolean bool = myObj2.can_throw() == myObj2.can_throw();
        if(bool) {
            Scanner text = new Scanner(System.in);
            System.out.println("Roll again? [true/false]");   
            String userAnswer = text.nextLine();
            Boolean bool2 = Boolean.parseBoolean(userAnswer);
            if(bool2 == true){
                this.keep_playing = true;
            } else if(bool2 != true) {
                this.keep_playing = false;
            }

        } else if(bool = false) {
            this.keep_playing = false;
        }
        // return myObj2.get_points();
    }

}


class Thrower {
    ArrayList<Integer> rolled = new ArrayList<Integer>();
    int score = 0;
    int[] dice = {};
    int num_throws = 0;
    int val = 6;
    int val2 = 1;

    int can_throw() {

        int count = 0;
        
        for (int i : rolled) {
          if (this.rolled.indexOf(i) == this.val) {
            count++;
          } else if(rolled.indexOf(i) == this.val2) {
            count++;
          }
        }
        return count;
        // return (listAmount.count(5) * listAmount.count(1) > 0 || this.num_throws == 0);
    }

    int get_points() {
        for (int i : rolled) {
          int realValue = i;
          if (realValue == 5) {
            score = this.score + 2;
          } else if(realValue == 1) {
            score = this.score + 1;
          } else if(realValue != this.val || rolled.indexOf(i) != this.val2){
            score = score + 0;
          }
        }
        return score;
        // return (this.dice.count(5) * 50 + this.dice.count(1) * 100);
    }

    ArrayList<Integer> throw_dice() {
        // String s = String.valueOf(this.dice);
        // List al = Arrays.asList(s);
        rolled.clear();
        int min = 1;
        int max = 6;

        // System.out.println("Random value in int from "+min+" to "+max+ ":");
        // int random_int = (int)Math.floor(Math.random()*(max-min+1)+min);

        for (int i = 0; i <= 5; i++) {
            int random_int = (int)Math.floor(Math.random()*(max-min+1)+min);
            rolled.add(random_int);
        }
        this.num_throws += 1;
        return rolled;

    }
}