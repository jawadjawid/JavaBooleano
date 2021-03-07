package booleanoofunc;

import java.util.Map;

public class BooleanValue implements booleanoofunc.BooleanExpression {

  private Boolean value;

  public BooleanValue(Boolean value) {
    this.value = value;
  }

  @Override
  public Boolean evaluate(Map<String, Boolean> context) {
    return value;
  }

  @Override
  public booleanoofunc.BooleanExpression simplify(Map<String, Boolean> context) {
    return this;
  }

  @Override
  public String toString() {
    return value.toString();
  }

  @Override
  public boolean equals(Object other) {
    return other != null
        && other.getClass().equals(BooleanValue.class) 
        && ((BooleanValue)other).value.equals(value);
  }
}
