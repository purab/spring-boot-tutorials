import java.util.function.Consumer;

public class ConsumerDemo {
    public static void main(String[] args) {
        ConsumerDemo consumerDemo = new ConsumerDemo();
        consumerDemo.squreInt(5);

        Consumer<Integer> squareMe= i -> System.out.println("Taking input and performing operation "+i*i);
        squareMe.accept(5);
    }

    public void squreInt(int i) {
        int squred = i *i;
        System.out.println("Square number is "+ squred);
    }
}
