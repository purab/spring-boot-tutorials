import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class MapReduceDemo {

    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(3,7,933,99,58);

        int sum=0;
        for (int no:numbers){
            sum=sum+no;
        }
        System.out.println(sum);

        int sum1 = numbers.stream().mapToInt(i -> i).sum();
        System.out.println(sum1);

        Integer reduceSum = numbers.stream().reduce(0, (a, b) -> a + b);
        System.out.println(reduceSum);

        Optional<Integer> reduceSum2 = numbers.stream().reduce(Integer::sum);
        System.out.println(reduceSum2.get());
    }
}
