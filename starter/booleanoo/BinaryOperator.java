package booleanoo;

import java.util.Map;

public interface BinaryOperator extends BooleanOperator {
  public Boolean apply(Boolean left, Boolean right);
}
