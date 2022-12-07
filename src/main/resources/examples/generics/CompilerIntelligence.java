package examples.generics;//: generics/CompilerIntelligence.java
import java.util.*;

import examples.initialization.Apple;

public class CompilerIntelligence {
  public static void main(String[] args) {
    List<? extends Fruit> flist =
      Arrays.asList(new examples.initialization.Apple());
    examples.initialization.Apple a = (examples.initialization.Apple)flist.get(0); // No warning
    flist.contains(new examples.initialization.Apple()); // Argument is 'Object'
    flist.indexOf(new examples.initialization.Apple()); // Argument is 'Object'
  }
} ///:~
