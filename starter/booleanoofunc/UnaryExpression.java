package booleanoofunc;

public class UnaryExpression {
  @Override
  public boolean equals(Object other) {
    return other != null
        && other.getClass().equals(this.getClass()) 
        && ((UnaryExpression)other).operand.equals(operand);
  }

  @Override
  public String toString() {
    return String.format("(%s %s)", toStringOp(), operand.toString());
  }
  
  protected final BooleanExpression getOperand() {
    return operand;
  }
}
