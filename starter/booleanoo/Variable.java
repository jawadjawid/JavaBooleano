package booleanoo;

import java.util.Map;

public class Variable implements BooleanExpression{

  private String id;

  public Variable(String id) {
    this.id = id;
  }

  @Override
  public Boolean evaluate(Map<String, Boolean> context) {
    return null;
  }

  @Override
  public BooleanExpression simplify(Map<String, Boolean> context) {
    return null;
  }

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
