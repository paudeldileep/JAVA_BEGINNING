public class GuessGame {
    Player p1;
    Player p2;
    Player p3;

    public void startGame(){
        p1= new Player();
        p2= new Player();
        p3= new Player();

        int p1number=0;
        int p2number=0;
        int p3number=0;

        boolean p1isRight=false;
        boolean p2isRight=false;
        boolean p3isRight=false;

        int numberToGuess=(int)(Math.random()*10);

        System.out.println("I'm guessing a number between 0 and 9....");

        while(true){
            System.out.println("The number to guess is "+numberToGuess);

            System.out.print("P1 says:");
            p1.guess();
            System.out.print("P2 says:");
            p2.guess();
            System.out.print("P3 says:");
            p3.guess();

            p1number=p1.number;
            p2number=p2.number;
            p3number=p3.number;

            if(p1number==numberToGuess){
                p1isRight=true;
            }
            
            if(p2number==numberToGuess){
                p2isRight=true;
            }
            
            if(p3number==numberToGuess){
                p3isRight=true;
            }

            if(p1isRight || p2isRight || p3isRight){

                System.out.println("We have the winner/winners.");
                if(p1isRight)
                    System.out.println("P1 guessed it correctly");
                if(p2isRight)    
                    System.out.println("P2 guessed it correctly");
                if(p3isRight)    
                    System.out.println("P3 guessed it correctly");
                break;
            }
            else{
                System.out.println("No one made right guess, Trying again..");
            }
        }


    }

}




