package solidPrinciple;

import java.util.ArrayList;
import java.util.List;

public class LiskovSubstitutionPriniciple {
    public static void main(String[] args) {
        List<Vehicle> vehicles = new ArrayList<>();
        vehicles.add(new Car());
        vehicles.add(new MotorCycle());
        vehicles.add(new Bicycle()); // isse vreatif code

        for (Vehicle v : vehicles){
            System.out.println(v.getNoOfWheeels());
        }
    }
}

//class  Vehicle{
//    public int getNoOfWheeels(){
//        return 2;
//    }
//
//    public Boolean hasEngine(){
//        return true;
//    }
//}
//
//class MotorCycle extends Vehicle{
//
//}
//
//class Car extends Vehicle{
//    @Override
//    public int getNoOfWheeels(){
//        return 4;
//    }
//}


//problem arrises when bicycle ckass comes that will only downsize te capability
//class Bicycle extends Vehicle{
//    @Override
//    public Boolean hasEngine(){
//        return null;
//    }
//}


//how to solve this issue  - put people who are non changeable together

class  Vehicle{
    public int getNoOfWheeels(){
        return 2;
    }
}

class EngineVehicle extends Vehicle{
    public Boolean hasEngine(){
        return true;
    }
}

class MotorCycle extends EngineVehicle{

}

class Car extends EngineVehicle{
    @Override
    public int getNoOfWheeels(){
        return 4;
    }
}

//problem arrises when bicycle ckass comes that will only downsize te capability
class Bicycle extends Vehicle{
}

//can we even done usng the interfaces here
