package booleanoo;

import java.util.Map;

/** A Conjunction. */
public class Conjunction extends BinaryExpression {
  /**
   * Contract.
   *
   * @param left left side.
   * @param right right side.
   */
  public Conjunction(BooleanExpression left, BooleanExpression right) {
    super(new And(), left, right);
  }

  /**
   * simplify.
   *
   * @param context context of eval.
   * @return simplifeid version
   */
  public BooleanExpression simplify(Map<String, Boolean> context) {
    BooleanValue trueObj = new BooleanValue(true);
    BooleanValue falseObj = new BooleanValue(false);
    BooleanExpression leftSimple = this.getLeft().simplify(context);
    BooleanExpression rightSimple = this.getRight().simplify(context);

    if (leftSimple.equals(rightSimple)) {
      return leftSimple;
    } else if (leftSimple.equals(trueObj)) {
      return rightSimple;
    } else if (rightSimple.equals(trueObj)) {
      return leftSimple;
    } else if (leftSimple.equals(falseObj) || rightSimple.equals(falseObj)) {
      return falseObj;
    }
    return new Conjunction(leftSimple, rightSimple);
  }
}
