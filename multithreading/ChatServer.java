import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Iterator;

public class ChatServer {
    
    ArrayList clientOutStreamsList;

    //inner class for handling client request in a thread
    public class ClientHandler implements Runnable{
        BufferedReader bReader;
        Socket newSocket;

        //constructor 
        public ClientHandler(Socket clientSocket){
            try{
                //initialize a reader for outputting msg to screen
                newSocket=clientSocket;
                InputStreamReader iStreamReader=new InputStreamReader(newSocket.getInputStream());
                bReader=new BufferedReader(iStreamReader);
            }catch(Exception ex){
                ex.printStackTrace();
            }
        }

        public void run(){
            String msgString;
            try{
                while((msgString=bReader.readLine())!=null){
                    System.out.println("read: "+msgString);
                    //function call to display the incoming messages
                    showMessage(msgString);
                }
            }catch(Exception ex){
                ex.printStackTrace();
            }
        }
    }//inner class closing

    //main method
    public static void main(String[] args) {
        new ChatServer().go();
    }

    public void go(){
        clientOutStreamsList=new ArrayList();

        try{
            //server at port 5000
            ServerSocket newSSocket=new ServerSocket(5000);

            //listen for client
            while(true){
                Socket clientSocket=newSSocket.accept();
                //accept connection,read from client ,store message to list Array
                PrintWriter pWriter=new PrintWriter(clientSocket.getOutputStream());
                
                clientOutStreamsList.add(pWriter);

                //creating thread 
                Thread t=new Thread(new ClientHandler(clientSocket));
                t.start();
                System.out.println("got a connection!");
                
                //my own
                newSSocket.close();
            }

        }catch(Exception ex){
            ex.printStackTrace();

        }
    }

    public void showMessage(String message){

        //iterator iterates through a collection like arraylist or hashset
        Iterator iterate=clientOutStreamsList.iterator();
        while(iterate.hasNext()){
            try{
                PrintWriter pWriter=(PrintWriter) iterate.next();
                pWriter.println(message);
                pWriter.flush();
            }catch(Exception ex){
                ex.printStackTrace();
            }
        }
    }



}
