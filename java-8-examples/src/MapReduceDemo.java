import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class MapReduceDemo {

    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(3,7,933,99,58);

        List<String> words = Arrays.asList("purab","changu","mangu","bangu");

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

        //multiplication
        Integer reduceMulti = numbers.stream().reduce(1, (a, b) -> a * b);
        System.out.println(reduceMulti);

        //return max value
        Integer reduceMaxVal = numbers.stream().reduce(0, (a, b) -> a > b ? a : b);
        System.out.println(reduceMaxVal);

        //return min value
        Integer reduceMinVal = numbers.stream().reduce(Integer::min).get();
        System.out.println(reduceMinVal);

        //find longest string
        Optional<String> longestString = words.stream().reduce((word1, word2) -> word1.length() > word2.length() ? word1 : word2);
        System.out.println(longestString.get());

        //get employee whose grade A
        //get salary
        double averageSalary = EmployeeDatabase.getEmployees().stream()
                .filter(employee -> employee.getGrade().equalsIgnoreCase("A"))
                .map(employee -> employee.getSalary())
                .mapToDouble(i -> i)
                .average().getAsDouble();
        System.out.println("average sal:"+ averageSalary);


    }
}
