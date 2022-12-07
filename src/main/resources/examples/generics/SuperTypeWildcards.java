package examples.generics;//: generics/SuperTypeWildcards.java
import java.util.*;

import examples.initialization.Apple;

public class SuperTypeWildcards {
  static void writeTo(List<? super examples.initialization.Apple> apples) {
    apples.add(new examples.initialization.Apple());
    apples.add(new Jonathan());
    // apples.add(new Fruit()); // Error
  }
} ///:~
