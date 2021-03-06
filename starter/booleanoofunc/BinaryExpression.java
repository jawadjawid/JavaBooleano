package booleanoofunc;

public class BinaryExpression {
    
  @Override
  public boolean equals(Object other) {
    return other != null
        && other.getClass().equals(this.getClass()) 
        && ((BinaryExpression)other).left.equals(left)
        && ((BinaryExpression)other).right.equals(right);
  }
    
  @Override
  public String toString() {
    return String.format("(%s %s %s)", left, toStringOp(), right);
  }

  protected final BooleanExpression getLeft() {
    return left;
  }

  protected final BooleanExpression getRight() {
    return right;
  }
}
