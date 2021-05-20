public class Main {
    public static void main(String[] args) {

        String name = "DKT";
        int age = 28;
        long phNum = 9876543210L;
        System.out.println("Hello " + name + " you are " + age + " yrs old");
        System.out.println("Ph number is " + phNum);

        String[] cars = { "Volvo", "BMW", "Ford", "Mazda" };
        for (String car : cars) {
            System.out.println(car);
        }
        for (int i = 0; i < 10; i++) {
            if (i == 4) {
                continue;
            }
            System.out.println(i);
        }
        String[] cars2 = { "Volvo", "BMW", "Ford", "Mazda" };
        cars2[0] = "Opel";
        System.out.println(cars2[0]);
    }
}