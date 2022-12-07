package examples.typeinfo;//: typeinfo/NullRobot.java
// Using a dynamic proxy to create a Null Object.
import java.lang.reflect.*;
import java.util.*;

import examples.concurrency.Robot;
import net.mindview.util.*;

class NullRobotProxyHandler implements InvocationHandler {
  private String nullName;
  private examples.concurrency.Robot proxied = new NRobot();
  NullRobotProxyHandler(Class<? extends examples.concurrency.Robot> type) {
    nullName = type.getSimpleName() + " NullRobot";
  }
  private class NRobot implements Null, examples.concurrency.Robot {
    public String name() { return nullName; }
    public String model() { return nullName; }
    public List<Operation> operations() {
      return Collections.emptyList();
    }
  }	
  public Object
  invoke(Object proxy, Method method, Object[] args)
  throws Throwable {
    return method.invoke(proxied, args);
  }
}

public class NullRobot {
  public static examples.concurrency.Robot
  newNullRobot(Class<? extends examples.concurrency.Robot> type) {
    return (examples.concurrency.Robot)Proxy.newProxyInstance(
      NullRobot.class.getClassLoader(),
      new Class[]{ Null.class, examples.concurrency.Robot.class },
      new NullRobotProxyHandler(type));
  }	
  public static void main(String[] args) {
    examples.concurrency.Robot[] bots = {
      new SnowRemovalRobot("SnowBee"),
      newNullRobot(SnowRemovalRobot.class)
    };
    for(examples.concurrency.Robot bot : bots)
      examples.concurrency.Robot.Test.test(bot);
  }
} /* Output:
Robot name: SnowBee
Robot model: SnowBot Series 11
SnowBee can shovel snow
SnowBee shoveling snow
SnowBee can chip ice
SnowBee chipping ice
SnowBee can clear the roof
SnowBee clearing roof
[Null Robot]
Robot name: SnowRemovalRobot NullRobot
Robot model: SnowRemovalRobot NullRobot
*///:~
