package booleanoofunc;

import java.util.function.BiFunction;
import java.util.function.BinaryOperator;

public class Disjunction extends BinaryExpression{
  public Disjunction(BooleanExpression left, BooleanExpression right) {
    super((x, y) -> (x || y), left, right, Disjunction::simplifyOr);  // this is called a "method reference"
  }
  private static BooleanExpression simplifyOr(BooleanExpression left, BooleanExpression right) {
    BooleanValue trueObj = new BooleanValue(true);
    BooleanValue falseObj = new BooleanValue(false);

    if (left.equals(right))
      return left;
    else if(left.equals(falseObj))
      return right;
    else if(right.equals(falseObj))
      return left;
    else if(left.equals(trueObj) || right.equals(trueObj))
      return trueObj;
    return new Disjunction(left, right);
  }

  @Override
  public String toStringOp() {
    return Constants.OR;
  }
}
