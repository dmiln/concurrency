package examples.generics;//: generics/SimpleDogsAndRobots.java
// Removing the generic; code still works.

import examples.concurrency.Robot;

class CommunicateSimply {
  static void perform(Performs performer) {
    performer.speak();
    performer.sit();
  }
}

public class SimpleDogsAndRobots {
  public static void main(String[] args) {
    CommunicateSimply.perform(new PerformingDog());
    CommunicateSimply.perform(new examples.concurrency.Robot());
  }
} /* Output:
Woof!
Sitting
Click!
Clank!
*///:~
