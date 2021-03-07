package booleanoo;

import java.util.Map;

public abstract class UnaryExpression implements BooleanExpression{

  private UnaryOperator operator;
  private BooleanExpression operand;

  public UnaryExpression(UnaryOperator operator, BooleanExpression operand) {
    this.operator = operator;
    this.operand = operand;
  }

  public Boolean evaluate(Map<String, Boolean> context) {
    return true;
  }

  protected final UnaryOperator  getOperator() {
    return operator;
  }

  protected final BooleanExpression getOperand() {
    return operand;
  }

  @Override
  public boolean equals(Object other) {
    return other != null
        && other.getClass().equals(this.getClass()) 
        && ((UnaryExpression)other).operator.equals(operator)
        && ((UnaryExpression)other).operand.equals(operand);
  }

  @Override
  public String toString() {
    return String.format("(%s %s)", operator, operand.toString());
  }
}
