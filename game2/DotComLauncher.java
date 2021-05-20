import java.util.Scanner;

public class DotComLauncher {
    public static void main(String[] args){

        int noOfGuesses=0;
        SimpleDotCom game1=new SimpleDotCom();

        //geenrating random locations for the game
        int randomNum=(int)(Math.random()*5);
        int[] locations={randomNum,randomNum+1,randomNum+2};
        game1.setLocationCells(locations);
        //for input
        Scanner input=new Scanner(System.in);
        //boolean to check alive or kill
        boolean isAlive=true;

        while(isAlive){
            System.out.println("Enter a guess:");
            String userGuess=input.nextLine();
            String result=game1.CheckGuess(userGuess);
            noOfGuesses++;
            if(result=="kill"){
                isAlive=false;
                System.out.println("You took "+noOfGuesses+" no. of guesses");
            }
        }
    }
}
