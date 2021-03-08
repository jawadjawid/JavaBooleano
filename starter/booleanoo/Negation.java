package booleanoo;

import java.util.Map;

public class Negation extends UnaryExpression {
  public Negation(BooleanExpression op) {
    super(new Not(), op);
  }

  public BooleanExpression simplify(Map<String, Boolean> context) {
    BooleanValue trueObj = new BooleanValue(true);
    BooleanValue falseObj = new BooleanValue(false);
    BooleanExpression operandSimple = this.getOperand().simplify(context);

    if (operandSimple instanceof UnaryExpression) {
      return ((UnaryExpression) operandSimple).getOperand().simplify(context);
    } else if (operandSimple.equals(trueObj)) {
      return falseObj;
    } else if (operandSimple.equals(falseObj)) {
      return trueObj;
    }
    return new Negation(operandSimple);
  }
}
