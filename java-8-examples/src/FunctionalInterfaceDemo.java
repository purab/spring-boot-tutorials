
@FunctionalInterface
public interface FunctionalInterfaceDemo {

    void singleAbstMethod();

    default void printName(){
        System.out.println("this is test functional interface");
    }
}
