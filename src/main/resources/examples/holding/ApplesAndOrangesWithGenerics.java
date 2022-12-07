package examples.holding;//: holding/ApplesAndOrangesWithGenerics.java
import java.util.*;

import examples.initialization.Apple;

public class ApplesAndOrangesWithGenerics {
  public static void main(String[] args) {
    ArrayList<examples.initialization.Apple> apples = new ArrayList<examples.initialization.Apple>();
    for(int i = 0; i < 3; i++)
      apples.add(new examples.initialization.Apple());
    // Compile-time error:
    // apples.add(new Orange());
    for(int i = 0; i < apples.size(); i++)
      System.out.println(apples.get(i).id());
    // Using foreach:
    for(examples.initialization.Apple c : apples)
      System.out.println(c.id());
  }
} /* Output:
0
1
2
0
1
2
*///:~
