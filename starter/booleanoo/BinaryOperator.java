package booleanoo;

/** A binary Operator.*/
public interface BinaryOperator extends BooleanOperator {
  public Boolean apply(Boolean left, Boolean right);
}
