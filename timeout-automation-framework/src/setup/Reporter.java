package setup;

import java.lang.reflect.Method;

public abstract interface Reporter
{
  public abstract void startTestSteps(String paramString);

  public abstract void beforeStep(Method paramMethod, String paramString);

  public abstract void inStep(String paramString);

  public abstract void afterStep(Method paramMethod, Object paramObject);

  public abstract void endTestSteps(int paramInt1, int paramInt2);

  public abstract void endTestCycle(int paramInt1, int paramInt2);
}