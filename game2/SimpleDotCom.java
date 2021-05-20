import java.util.ArrayList;
public class SimpleDotCom {
    //int noOfHits=0;
    //array list to access different methods for easier game logic implementation
    private ArrayList<Integer> locationCells;

    public void setLocationCells(ArrayList<Integer> lc ){
        locationCells=lc;
    }

    public String CheckGuess(String userGuess){
        int guess=Integer.parseInt(userGuess);
        //default result
        String result="miss";
        //get index of userGuessed value
        int index=locationCells.indexOf(guess);

        if(index>=0){
            //implies user made a right guess
            locationCells.remove(index);
            if(locationCells.isEmpty()){
                result="kill";
            }
            else{
                result="hit";
            }
        }

        /*
        //check guess against given locationcells
        for(int cell:locationCells){
            if(guess==cell){
                result="hit";
                noOfHits++;
                //if guess is right stop the loop
                break;
            }
        }

        if (noOfHits==locationCells.length){
            result="kill";
        }
        */
        System.out.println("It's a "+result);
        return result;
    }
}
