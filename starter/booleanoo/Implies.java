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
}
