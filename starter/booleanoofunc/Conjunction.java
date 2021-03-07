package booleanoofunc;

import java.util.function.BiFunction;
import java.util.function.BinaryOperator;

public class Conjunction extends BinaryExpression {

  public Conjunction(BooleanExpression left, BooleanExpression right) {
    super((x, y) -> (x && y), left, right, Conjunction::simplifyAnd);  // this is called a "method reference"
  }
  private static BooleanExpression simplifyAnd(BooleanExpression left, BooleanExpression right) {
    BooleanValue trueObj = new BooleanValue(true);
    BooleanValue falseObj = new BooleanValue(false);

    if (left.equals(right))
      return left;
    else if(left.equals(trueObj))
      return right;
    else if(right.equals(trueObj))
      return left;
    else if(left.equals(falseObj) || right.equals(falseObj))
      return falseObj;
    return new Conjunction(left, right);
  }

  @Override
  public String toStringOp() {
    return Constants.AND;
  }
}
