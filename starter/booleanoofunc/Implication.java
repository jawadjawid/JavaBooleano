package booleanoofunc;

import java.util.function.BiFunction;
import java.util.function.BinaryOperator;

/** Implication expression. */
public class Implication extends BinaryExpression {
  /**
   * construct.
   *
   * @param left side
   * @param right side
   */
  public Implication(BooleanExpression left, BooleanExpression right) {
    super(
        (x, y) -> (!x || y),
        left,
        right,
        Implication::simplifyImplies); // this is called a "method reference"
  }

  private static BooleanExpression simplifyImplies(
      BooleanExpression left, BooleanExpression right) {
    BooleanValue trueObj = new BooleanValue(true);
    BooleanValue falseObj = new BooleanValue(false);

    if (left.equals(right)) {
      return trueObj;
    } else if (left.equals(trueObj)) {
      return right;
    } else if (right.equals(falseObj)) {
      if (left instanceof Negation) {
        return ((Negation) left).getOperand();
      }
      return new Negation(left);
    } else if (left.equals(falseObj) || right.equals(trueObj)) {
      return trueObj;
    }
    return new Implication(left, right);
  }

  @Override
  public String toStringOp() {
    return Constants.IMPLIES;
  }
}
