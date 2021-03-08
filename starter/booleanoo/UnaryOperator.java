package booleanoo;

/** Unary Operator. */
public interface UnaryOperator extends BooleanOperator {
  public Boolean apply(Boolean operand);
}
