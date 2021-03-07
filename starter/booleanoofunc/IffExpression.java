package booleanoofunc;

import java.util.function.BiFunction;
import java.util.function.BinaryOperator;

public class IffExpression extends BinaryExpression {
  public IffExpression(BooleanExpression left, BooleanExpression right) {
    super((x, y) -> (x == y), left, right, IffExpression::simplifyIff);  // this is called a "method reference"
  }
  private static BooleanExpression simplifyIff(BooleanExpression left, BooleanExpression right) {
    BooleanValue trueObj = new BooleanValue(true);
    BooleanValue falseObj = new BooleanValue(false);

    if (left.equals(right))
      return trueObj;
    else if(left.equals(trueObj))
      return right;
    else if(right.equals(trueObj))
      return left;
    else if(left.equals(falseObj))
      return new Negation(right);
    else if(right.equals(falseObj))
      return new Negation(left);
    return new IffExpression(left, right);
  }

  @Override
  public String toStringOp() {
    return Constants.IFF;
  }
}
  
