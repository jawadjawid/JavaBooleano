package booleanoofunc;

import java.util.Map;
import java.util.function.Function;
import java.util.function.UnaryOperator;

public abstract class UnaryExpression implements BooleanExpression {

  private UnaryOperator<Boolean> operator;
  private booleanoofunc.BooleanExpression operand;
  private Function<BooleanExpression, BooleanExpression> simplifier;

  public UnaryExpression(
      UnaryOperator<Boolean> operator,
      BooleanExpression operand,
      Function<BooleanExpression, BooleanExpression> simplifier) {
    this.operator = operator;
    this.operand = operand;
    this.simplifier = simplifier;
  }

  public Boolean evaluate(Map<String, Boolean> context) {
    return this.operator.apply(this.operand.evaluate(context));
  }

  public booleanoofunc.BooleanExpression simplify(Map<String, Boolean> context) {
    return simplifier.apply(this.operand.simplify(context));
  }

  @Override
  public boolean equals(Object other) {
    return other != null
        && other.getClass().equals(this.getClass())
        && ((UnaryExpression) other).operand.equals(operand);
  }

  public abstract String toStringOp();

  @Override
  public String toString() {
    return String.format("(%s %s)", toStringOp(), operand.toString());
  }

  protected final BooleanExpression getOperand() {
    return operand;
  }
}
