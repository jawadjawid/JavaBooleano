package booleanoo;

import java.util.Map;

/** A Binary Expression. */
public abstract class BinaryExpression implements BooleanExpression {

  private BinaryOperator operator;
  private BooleanExpression left;
  private BooleanExpression right;

  /**
   * Constructor.
   *
   * @param operator The operator.
   * @param left left side.
   * @param right right side.
   */
  public BinaryExpression(
      BinaryOperator operator, BooleanExpression left, BooleanExpression right) {
    this.operator = operator;
    this.left = left;
    this.right = right;
  }

  public Boolean evaluate(Map<String, Boolean> context) throws UnassignedVariableException {
    return this.operator.apply(this.left.evaluate(context), this.right.evaluate(context));
  }

  protected final BinaryOperator getOperator() {
    return operator;
  }

  protected final BooleanExpression getLeft() {
    return left;
  }

  protected final BooleanExpression getRight() {
    return right;
  }

  @Override
  public boolean equals(Object other) {
    return other != null
        && other.getClass().equals(this.getClass())
        && ((BinaryExpression) other).operator.equals(operator)
        && ((BinaryExpression) other).left.equals(left)
        && ((BinaryExpression) other).right.equals(right);
  }

  @Override
  public String toString() {
    return String.format("(%s %s %s)", left, operator, right);
  }
}
