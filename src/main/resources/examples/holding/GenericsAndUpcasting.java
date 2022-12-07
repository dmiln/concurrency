package examples.holding;//: holding/GenericsAndUpcasting.java
import java.util.*;

import examples.initialization.Apple;

class GrannySmith extends examples.initialization.Apple {}
class Gala extends examples.initialization.Apple {}
class Fuji extends examples.initialization.Apple {}
class Braeburn extends examples.initialization.Apple {}

public class GenericsAndUpcasting {
  public static void main(String[] args) {
    ArrayList<examples.initialization.Apple> apples = new ArrayList<examples.initialization.Apple>();
    apples.add(new GrannySmith());
    apples.add(new Gala());
    apples.add(new Fuji());
    apples.add(new Braeburn());
    for(examples.initialization.Apple c : apples)
      System.out.println(c);
  }
} /* Output: (Sample)
GrannySmith@7d772e
Gala@11b86e7
Fuji@35ce36
Braeburn@757aef
*///:~
