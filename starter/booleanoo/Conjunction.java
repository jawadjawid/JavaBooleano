package booleanoo;


import java.util.Map;

public class Conjunction extends BinaryExpression  {
  public Conjunction(BooleanExpression left, BooleanExpression right) {
    super(new And(), left, right);
  }

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
