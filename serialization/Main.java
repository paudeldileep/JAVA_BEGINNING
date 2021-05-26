import java.io.File;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class Main implements Serializable {
    
    private int value;

    Main(){

    }
    Main(int v){
        value=v;
    }

    public static void main(String[] args){
        Main obj1=new Main(4);
        Main obj2=new Main(5);
        try{
        File newfile=new File("main.txt");
        newfile.createNewFile();
        FileOutputStream filestream=new FileOutputStream(newfile,false);
        ObjectOutputStream objstream=new ObjectOutputStream(filestream);

        try{
            objstream.writeObject(obj1);
            objstream.writeObject(obj2);
            objstream.close();
        }
        catch(Exception ex){
            ex.printStackTrace();
        }
    }
    catch(Exception ex){
        ex.printStackTrace();
    }
    }
}
