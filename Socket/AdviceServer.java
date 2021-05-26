import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class AdviceServer {
    
    String[] Advices={"Think and Grow Rich","Be your own version","Think before you leap","Eat healthy","Focus on your goals","Do not give a f**king s**t","Respect the norms"};

    public void go(){
        try{
            ServerSocket mysocket=new ServerSocket(4242);

            //loop continuously listening to client requests
            while(true){
                Socket mysock=mysocket.accept();
                PrintWriter writer=new PrintWriter(mysock.getOutputStream());
                String adviceToGive=getAdvice();
                writer.println(adviceToGive);
                writer.close();
                System.out.println(adviceToGive);

            }
        }catch(IOException ex){
            ex.printStackTrace();
        }
    }

    private String getAdvice(){
        int index=(int)(Math.random()*Advices.length);
        return Advices[index];
    }
    public static void main(String[] args){
        AdviceServer newServer=new AdviceServer();
        newServer.go();
    }
}
