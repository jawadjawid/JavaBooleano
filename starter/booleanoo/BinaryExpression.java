package booleanoo;

import java.util.Map;

public abstract class BinaryExpression implements BooleanExpression{

  private final BinaryOperator operator;
  private final BooleanExpression left;
  private final BooleanExpression right;

  public BinaryExpression(BinaryOperator operator, BooleanExpression left, BooleanExpression right) {
    this.operator = operator;
    this.left = left;
    this.right = right;
  }

  public Boolean evaluate(Map<String, Boolean> context) throws Exception {
    throw new Exception("Exception message");
    //return true;
  }

  protected BinaryOperator getOperator() {
    return operator;
  }

  protected BooleanExpression getLeft() {
    return left;
  }

  protected BooleanExpression getRight() {
    return right;
  }

  @Override
  public boolean equals(Object other) {
    return other != null
        && other.getClass().equals(this.getClass()) 
        && ((BinaryExpression)other).operator.equals(operator)
        && ((BinaryExpression)other).left.equals(left)
        && ((BinaryExpression)other).right.equals(right);
  }

  @Override
  public String toString() {
    return String.format("(%s %s %s)", left, operator, right);
  }
}
