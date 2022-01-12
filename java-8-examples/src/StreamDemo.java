import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class StreamDemo {
    public static void main(String[] args) {
        List<Integer> arList = new ArrayList<Integer>();
        arList.add(15);
        arList.add(25);
        arList.add(5);

        //With Stream
        List<Integer> newA1=new ArrayList<Integer>();
        newA1 = arList.stream().filter(x -> x>=15).collect(Collectors.toList());
        newA1.stream().forEach(x-> System.out.println(x));

        //without steam
        /*List<Integer> arListFromMethod = findElements(arList);
        for (Integer i: arListFromMethod) {
            System.out.println(i);
        }*/
    }

    private static List<Integer> findElements(List<Integer> arList) {
        List<Integer> newA1 = new ArrayList<Integer>();
        for (Integer i: arList) {
            if(i>=15) {
                newA1.add(i);
            }
        }
        return newA1;
    }
}
