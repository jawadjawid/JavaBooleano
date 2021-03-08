package booleanoofunc;

import java.util.function.BiFunction;
import java.util.function.BinaryOperator;

/** Iff Expression. */
public class IffExpression extends BinaryExpression {
  /**
   * if and only if exprssion.
   *
   * @param left side
   * @param right side
   */
  public IffExpression(BooleanExpression left, BooleanExpression right) {
    super(
        (x, y) -> (x == y),
        left,
        right,
        IffExpression::simplifyIff); // this is called a "method reference"
  }

  private static BooleanExpression simplifyIff(BooleanExpression left, BooleanExpression right) {
    BooleanValue trueObj = new BooleanValue(true);
    BooleanValue falseObj = new BooleanValue(false);

    if (left.equals(right)) {
      return trueObj;
    } else if (left.equals(trueObj)) {
      return right;
    } else if (right.equals(trueObj)) {
      return left;
    } else if (left.equals(falseObj)) {
      if (right instanceof Negation) {
        return ((Negation) right).getOperand();
      }
      return new Negation(right);
    } else if (right.equals(falseObj)) {
      if (left instanceof Negation) {
        return ((Negation) left).getOperand();
      }
      return new Negation(left);
    }
    return new IffExpression(left, right);
  }

  @Override
  public String toStringOp() {
    return Constants.IFF;
  }
}
