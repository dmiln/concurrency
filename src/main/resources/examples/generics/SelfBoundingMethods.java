package examples.generics;//: generics/SelfBoundingMethods.java

import examples.initialization.A;

public class SelfBoundingMethods {
  static <T extends SelfBounded<T>> T f(T arg) {
    return arg.set(arg).get();
  }
  public static void main(String[] args) {
    examples.initialization.A a = f(new examples.initialization.A());
  }
} ///:~
