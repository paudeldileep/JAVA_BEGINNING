public class SimpleDotCom {
    int noOfHits=0;
    int[] locationCells;

    public void setLocationCells(int[] lc ){
        locationCells=lc;
    }

    public String CheckGuess(String userGuess){
        int guess=Integer.parseInt(userGuess);
        //default result
        String result="miss";

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
        System.out.println("It's a "+result);
        return result;
    }
}
