package booleanoo;

/** Implies opreator. */
public class Implies implements BinaryOperator {

  @Override
  public Boolean apply(Boolean left, Boolean right) {
    if (left) {
      return right;
    }
    return true;
  }

  @Override
  public String toString() {
    return Constants.IMPLIES;
  }

  @Override
  public boolean equals(Object other) {
    return other != null && other.getClass().equals(Implies.class);
  }
}
