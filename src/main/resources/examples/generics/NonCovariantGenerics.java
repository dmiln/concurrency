package examples.generics;//: generics/NonCovariantGenerics.java
// {CompileTimeError} (Won't compile)
import java.util.*;

import examples.initialization.Apple;

public class NonCovariantGenerics {
  // Compile Error: incompatible types:
  List<Fruit> flist = new ArrayList<examples.initialization.Apple>();
} ///:~
