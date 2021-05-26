import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class AdviceClient {
    
    public void go(){
        try{
            Socket newSocket=new Socket("127.0.0.1",4242);
             InputStreamReader reader=new InputStreamReader(newSocket.getInputStream());
             BufferedReader bReader=new BufferedReader(reader);
             String advice=bReader.readLine();
             System.out.println("Advice for you: "+advice);
             bReader.close();
            // newSocket.close();
        }catch (IOException ex){
            ex.printStackTrace();
        }
    }
    public static void main(String[] args){
        AdviceClient newClient=new AdviceClient();
        newClient.go();
    }
}
