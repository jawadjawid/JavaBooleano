package booleanoofunc;

import java.util.Map;
import java.util.function.BiFunction;
import java.util.function.BinaryOperator;

public abstract class BinaryExpression implements BooleanExpression {

  private BinaryOperator<Boolean> operator;
  private booleanoofunc.BooleanExpression left;
  private booleanoofunc.BooleanExpression right;
  private BiFunction<BooleanExpression, BooleanExpression, BooleanExpression> simplifier;

  public BinaryExpression(
      BinaryOperator<Boolean> operator,
      booleanoofunc.BooleanExpression left,
      booleanoofunc.BooleanExpression right,
      BiFunction<BooleanExpression, BooleanExpression, BooleanExpression> simplifier) {
    this.operator = operator;
    this.left = left;
    this.right = right;
    this.simplifier = simplifier;
  }

  public Boolean evaluate(Map<String, Boolean> context)
      throws booleanoofunc.UnassignedVariableException {
    return this.operator.apply(this.left.evaluate(context), this.right.evaluate(context));
  }

  public booleanoofunc.BooleanExpression simplify(Map<String, Boolean> context) {
    return simplifier
        .apply(this.left.simplify(context), this.right.simplify(context));
  }

  @Override
  public boolean equals(Object other) {
    return other != null
        && other.getClass().equals(this.getClass())
        && ((BinaryExpression) other).left.equals(left)
        && ((BinaryExpression) other).right.equals(right);
  }

  public abstract String toStringOp();

  @Override
  public String toString() {
    return String.format("(%s %s %s)", left, toStringOp(), right);
  }

  protected final BooleanExpression getLeft() {
    return left;
  }

  protected final BooleanExpression getRight() {
    return right;
  }
}
