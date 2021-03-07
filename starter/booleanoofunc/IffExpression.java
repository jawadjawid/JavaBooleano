package booleanoofunc;

import java.util.function.BiFunction;
import java.util.function.BinaryOperator;

public class IffExpression extends BinaryExpression {
  public IffExpression(BooleanExpression left, BooleanExpression right) {
    super((x, y) -> (x == y), left, right, IffExpression::simplifyIff);  // this is called a "method reference"
  }
  private static BooleanExpression simplifyIff(BooleanExpression left, BooleanExpression right) {
    return null; // implement this method
  }

  @Override
  public String toStringOp() {
    return Constants.IFF;
  }
}
  
