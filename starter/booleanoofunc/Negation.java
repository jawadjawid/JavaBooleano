package booleanoofunc;

/** Negation Expression. */
public class Negation extends UnaryExpression {

  // This is to get you started using Java's functional features.
  public Negation(BooleanExpression operand) {
    super(x -> !x, operand, Negation::simplifyNot); // this is called a "method reference"
  }

  private static BooleanExpression simplifyNot(BooleanExpression expr) {
    BooleanValue trueObj = new BooleanValue(true);
    BooleanValue falseObj = new BooleanValue(false);

    if (expr instanceof UnaryExpression) {
      return ((booleanoofunc.UnaryExpression) expr).getOperand();
    } else if (expr.equals(trueObj)) {
      return falseObj;
    } else if (expr.equals(falseObj)) {
      return trueObj;
    }
    return new Negation(expr);
  }

  @Override
  public String toStringOp() {
    return Constants.NOT;
  }
}
