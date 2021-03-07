package booleanoofunc;

import java.util.function.BiFunction;
import java.util.function.BinaryOperator;

public class Disjunction extends BinaryExpression{
  public Disjunction(BooleanExpression left, BooleanExpression right) {
    super((x, y) -> (x || y), left, right, Disjunction::simplifyOr);  // this is called a "method reference"
  }
  private static BooleanExpression simplifyOr(BooleanExpression left, BooleanExpression right) {
    return null; // implement this method
  }

  @Override
  public String toStringOp() {
    return Constants.OR;
  }
}
