/**
 * Created by fcalderon on 4/16/16.
 */
public class DefaultMethods {
    public static void main(String args[]){
        Vehicle vehicle = new Car();
        vehicle.print();
    }
}
interface Vehicle {
    /* Interfaces can have a default implementation of an method,
    and the class implementing these interfaces need not implement the same.*/
    default void print(){
        System.out.println("I am a vehicle!");
    }

    // can also have static methods
    static void blowHorn(){
        System.out.println("Blowing horn!!!");
    }
}

interface FourWheeler {
    default void print(){
        System.out.println("I am a four wheeler!");
    }
}

class Car implements Vehicle, FourWheeler {
    public void print(){
        //Using super to call the method of the specific interface
        Vehicle.super.print();
        FourWheeler.super.print();
        Vehicle.blowHorn();
        System.out.println("I am a car!");

    }
}
