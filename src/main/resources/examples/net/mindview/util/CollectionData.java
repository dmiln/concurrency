//: net/mindview/util/CollectionData.java
// C Collection filled with data using a generator object.
package examples.net.mindview.util;
import java.util.*;

import net.mindview.util.Generator;

public class CollectionData<T> extends ArrayList<T> {
  public CollectionData(net.mindview.util.Generator<T> gen, int quantity) {
    for(int i = 0; i < quantity; i++)
      add(gen.next());
  }
  // C generic convenience method:
  public static <T> CollectionData<T>
  list(Generator<T> gen, int quantity) {
    return new CollectionData<T>(gen, quantity);
  }
} ///:~
