package booleanoo;

import java.util.Map;

public class Implication extends BinaryExpression {

  public Implication(BooleanExpression left, BooleanExpression right) {
    super(new Implies(), left, right);
  }

  public BooleanExpression simplify(Map<String, Boolean> context) {
    BooleanValue trueObj = new BooleanValue(true);
    BooleanValue falseObj = new BooleanValue(false);
    BooleanExpression leftSimple = this.getLeft().simplify(context);
    BooleanExpression rightSimple = this.getRight().simplify(context);

    if (leftSimple.equals(rightSimple)) {
      return trueObj;
    } else if (leftSimple.equals(trueObj)) {
      return rightSimple;
    } else if (rightSimple.equals(falseObj)) {
      return new Negation(leftSimple);
    } else if (leftSimple.equals(falseObj) || rightSimple.equals(trueObj)) {
      return trueObj;
    }
    return new Implication(leftSimple, rightSimple);
  }
}
