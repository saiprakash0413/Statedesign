package com.motorcyclestatedesignpattern.motorcycle;


class MotorCycle {

   GearState gearState;

   public MotorCycle(){
       gearState = new FirstGear(this);
   }

   public void gearUp(){
       gearState.gearUp();
   }

   public void gearDown(){
       gearState.gearDown();
   }
}
abstract class GearState {
   MotorCycle motorCycle;
   GearState(MotorCycle bike){
       this.motorCycle = bike;
   }
   public abstract void gearUp();
   public abstract void gearDown();
}
class FirstGear extends  GearState{

   FirstGear(MotorCycle cycle) {
       super(cycle);
   }

   @Override
   public void gearUp() {
       System.out.println("Moving Up from FirstGear to SecondGear");
       motorCycle.gearState =  new SecondGear(motorCycle);
   }

   @Override
   public void gearDown() {
       System.out.println("Already in the FirstGear - cannot go lower");
   }
}
class SecondGear extends  GearState{

   SecondGear(MotorCycle cycle) {
       super(cycle);
   }

   @Override
   public void gearUp() {
       System.out.println("Moving Up  from SecondGear to ThirdGear");
       motorCycle.gearState =  new ThirdGear(motorCycle);

   }

   @Override
   public void gearDown() {
       System.out.println("Moving Down from SecondGear to FirstGear");
       motorCycle.gearState =  new FirstGear(motorCycle);
   }


}
class ThirdGear extends GearState {

   public ThirdGear(MotorCycle cycle) {
       super(cycle);
   }

   @Override
   public void gearUp() {
       System.out.println("Already in the ThirdGear - cannot go higher");
   }

   @Override
   public void gearDown() {
       System.out.println("Moving Down from ThirdGear to SecondGear");
       motorCycle.gearState =  new SecondGear(motorCycle);
   }
}



public class MotorCycleStateDesignPattern {
	public static void main(String[] args) {
	       MotorCycle motorCycle = new MotorCycle();
	           motorCycle.gearDown();
	           motorCycle.gearUp();
	           motorCycle.gearUp();
	           motorCycle.gearUp();
	           motorCycle.gearUp();
	           motorCycle.gearDown();
	           motorCycle.gearDown();
	           motorCycle.gearDown();   
	   }
}
