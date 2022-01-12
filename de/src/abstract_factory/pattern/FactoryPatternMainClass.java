package abstract_factory.pattern;

import java.util.Optional;

public class FactoryPatternMainClass {

    public static void main(String[] args) {

        //first get factory instance from facotry of factory class, if you want trinee
        AbstractFactory abstractFactory= AbstractFactoryProducer.getProfession(true);
        Profession eng = abstractFactory.getProfession("Engineer");

        eng.print();


        Optional<String> vehicle = Optional.of("car");
        vehicle = Optional.ofNullable(null);
        System.out.println(""+vehicle.map(s -> "This is " + s + "!").orElse("this is not car!"));


    }

}