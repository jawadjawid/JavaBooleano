package booleanoofunc;

public class BooleanValue {
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
