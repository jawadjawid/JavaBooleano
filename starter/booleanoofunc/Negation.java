package booleanoofunc;

public class Negation {

  // This is to get you started using Java's functional features. 
  public Negation(BooleanExpression operand) {
    super(x -> !x, operand, Negation::simplifyNot);  // this is called a "method reference"
  }
  
  private static BooleanExpression simplifyNot(BooleanExpression expr) {
    return null; // implement this method
  } 
  
  @Override
  public String toStringOp() {
    return Constants.NOT;
  }
}
