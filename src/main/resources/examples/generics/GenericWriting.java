package examples.generics;//: generics/GenericWriting.java
import java.util.*;

import examples.initialization.Apple;

public class GenericWriting {
  static <T> void writeExact(List<T> list, T item) {
    list.add(item);
  }
  static List<examples.initialization.Apple> apples = new ArrayList<examples.initialization.Apple>();
  static List<Fruit> fruit = new ArrayList<Fruit>();
  static void f1() {
    writeExact(apples, new examples.initialization.Apple());
    // writeExact(fruit, new Apple()); // Error:
    // Incompatible types: found Fruit, required Apple
  }
  static <T> void
  writeWithWildcard(List<? super T> list, T item) {
    list.add(item);
  }	
  static void f2() {
    writeWithWildcard(apples, new examples.initialization.Apple());
    writeWithWildcard(fruit, new examples.initialization.Apple());
  }
  public static void main(String[] args) { f1(); f2(); }
} ///:~
