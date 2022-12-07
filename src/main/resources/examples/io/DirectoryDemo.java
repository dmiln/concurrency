package examples.io;//: io/DirectoryDemo.java
// Sample use of Directory utilities.
import java.io.*;

import examples.net.mindview.util.Directory;
import net.mindview.util.*;
import static examples.net.mindview.util.Print.*;

public class DirectoryDemo {
  public static void main(String[] args) {
    // All directories:
    examples.net.mindview.util.PPrint.pprint(examples.net.mindview.util.Directory.walk(".").dirs);
    // All files beginning with 'T'
    for(File file : examples.net.mindview.util.Directory.local(".", "T.*"))
      print(file);
    print("----------------------");
    // All Java files beginning with 'T':
    for(File file : examples.net.mindview.util.Directory.walk(".", "T.*\\.java"))
      print(file);
    print("======================");
    // Class files containing "Z" or "z":
    for(File file : Directory.walk(".",".*[Zz].*\\.class"))
      print(file);
  }
} /* Output: (Sample)
[.\xfiles]
.\TestEOF.class
.\TestEOF.java
.\TransferTo.class
.\TransferTo.java
----------------------
.\TestEOF.java
.\TransferTo.java
.\xfiles\ThawAlien.java
======================
.\FreezeAlien.class
.\GZIPcompress.class
.\ZipCompress.class
*///:~
