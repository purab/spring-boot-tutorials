import java.util.function.Predicate;

public class PredicateJoining {

    public static void main(String[] args) {
        Predicate<String> checkLength = s -> s.length() >= 5;
        System.out.println("the length greater than 5:"+ checkLength.test("testing purab"));

        Predicate<String> checkEvenLength = s -> s.length() %2 == 0;
        System.out.println("the length string is:"+ checkLength.test("testing purab"));

        //it can join with and
        System.out.println("after merging with and "+ checkLength.and(checkEvenLength).test("testing purab"));

        //join with or
        System.out.println("after merging with and "+ checkLength.or(checkEvenLength).test("testing purab"));

        //join with negate
        System.out.println("after merging with and "+ checkLength.negate().test("testing purab"));


    }

}
