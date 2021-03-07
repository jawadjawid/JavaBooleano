package booleanoofunc;

import java.util.function.BiFunction;
import java.util.function.BinaryOperator;

public class Implication extends BinaryExpression {
  public Implication(BooleanExpression left, BooleanExpression right) {
    super((x, y) -> (!x || y), left, right, Implication::simplifyImplies);  // this is called a "method reference"
  }
  private static BooleanExpression simplifyImplies(BooleanExpression left, BooleanExpression right) {
    return null; // implement this method
  }

  @Override
  public String toStringOp() {
    return Constants.IMPLIES;
  }   
}
