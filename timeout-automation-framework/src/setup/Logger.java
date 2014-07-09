package setup;

import java.io.PrintStream;

public class Logger
{
  private Class<?> clas = null;
  private static String debugCategory = "debug";

  public Logger(Class<?> clas) {
    this.clas = clas;
  }

  public void debug(String message) {
    if ("debug".equalsIgnoreCase(debugCategory))
      System.out.println("[" + this.clas.getName() + "] DEBUG: " + message);
  }

  public void info(String message)
  {
    if (("info".equalsIgnoreCase(debugCategory)) || ("debug".equalsIgnoreCase(debugCategory)))
      System.out.println("[" + this.clas.getName() + "] INFO: " + message);
  }

  public void warn(String message)
  {
    if (("warn".equalsIgnoreCase(debugCategory)) || ("debug".equalsIgnoreCase(debugCategory)) || ("info".equalsIgnoreCase(debugCategory)))
      System.out.println("[" + this.clas.getName() + "] WARN: " + message);
  }

  public void error(String message)
  {
    System.err.println("[" + this.clas.getName() + "] ERROR: " + message);
  }

  public void error(String message, Throwable throwable) {
    System.out.println("[" + this.clas.getName() + "] ERROR: " + message + "\n Localised message:" + throwable.getLocalizedMessage() + 
      "\n Message:" + throwable.getMessage());
    System.out.println("StackTrace for: " + throwable.toString());
    for (StackTraceElement ste : throwable.getStackTrace()) {
      System.out.println(ste);
    }
    System.out.println("----------------------------------\n");
  }

  public static String getDebugCategory() {
    return debugCategory;
  }

  public static void setDebugCategory(String debugCategory) {
    debugCategory = debugCategory;
  }
}