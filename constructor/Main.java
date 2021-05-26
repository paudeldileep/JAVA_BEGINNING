public class Main {
    
    int value;

    public Main(){
        System.out.println("Default constructor");
    }
    public Main(int v){
        value=v;
        System.out.println("Parameterized constructor with one argument");
    }
    public Main(int v,int w){
        value=v+w;
        
        System.out.println("Parameterized constructor with two argument");
    }
    public void getValue(){
        System.out.println("Value is "+value);
    }
    public static void main(String[] args){

        Main obj1=new Main();
        Main obj2=new Main(2);
        Main obj3=new Main(2,3);

        obj1.getValue();
        obj2.getValue();
        obj3.getValue();



    }
}
