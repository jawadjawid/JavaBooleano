package booleanoo;

public class Variable implements BooleanExpression{

  @Override
  public boolean equals(Object other) {
    
    return other != null
        && other.getClass().equals(Variable.class)
        && id.equals(((Variable)other).id);
  }
  
  @Override
  public String toString() {
    return id;
  }
}
