package booleanoo;

import java.util.Map;

/** Iff Expression. */
public class IffExpression extends BinaryExpression {
  /**
   * If and only if expression.
   *
   * @param left side of expression.
   * @param right side of expression.
   */
  public IffExpression(BooleanExpression left, BooleanExpression right) {
    super(new Iff(), left, right);
  }

  /**
   * simplfy.
   *
   * @param context of evaluation.
   * @return simplfied version.
   */
  public BooleanExpression simplify(Map<String, Boolean> context) {
    BooleanValue trueObj = new BooleanValue(true);
    BooleanValue falseObj = new BooleanValue(false);
    BooleanExpression leftSimple = this.getLeft().simplify(context);
    BooleanExpression rightSimple = this.getRight().simplify(context);

    if (leftSimple.equals(rightSimple)) {
      return trueObj;
    } else if (leftSimple.equals(trueObj)) {
      return rightSimple;
    } else if (rightSimple.equals(trueObj)) {
      return leftSimple;
    } else if (leftSimple.equals(falseObj)) {
      return new Negation(rightSimple).simplify(context);
    } else if (rightSimple.equals(falseObj)) {
      return new Negation(leftSimple).simplify(context);
    }
    return new IffExpression(leftSimple, rightSimple);
  }
}
