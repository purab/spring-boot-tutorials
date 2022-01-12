import java.util.function.Consumer;

public class ConsumerChaining {

    public static void main(String[] args) {
        Consumer<Integer> squareMe= i -> System.out.println("Taking input and performing square operation "+i*i);
        squareMe.accept(5);

        Consumer<Integer> doubleMe= i -> System.out.println("Taking input and performing doubling operation "+i*2);
        doubleMe.accept(5);

        squareMe.andThen(doubleMe).accept(5);
    }
}
