package booleanoofunc;

import java.util.function.BiFunction;
import java.util.function.BinaryOperator;

public class Conjunction extends BinaryExpression {

  public Conjunction(BooleanExpression left, BooleanExpression right) {
    super((x, y) -> (x && y), left, right, Conjunction::simplifyAnd);  // this is called a "method reference"
  }
  private static BooleanExpression simplifyAnd(BooleanExpression left, BooleanExpression right) {
    return null; // implement this method
  }

  @Override
  public String toStringOp() {
    return Constants.AND;
  }
}
