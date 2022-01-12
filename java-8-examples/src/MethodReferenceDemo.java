public class MethodReferenceDemo {

    public static void main(String[] args) {
        FunctionalInterfaceDemo functionalInterfaceDemo = Test::testImplementation;
        functionalInterfaceDemo.singleAbstMethod();

        FunctionalInterfaceDemo f = ()-> System.out.println("implementation of sam");
        f.singleAbstMethod();
    }


}

class Test {
    public static void testImplementation() {
        System.out.println("this is test implementation of your abstract method");
     }
}
