package booleanoo;

import java.util.Map;

public class Variable implements BooleanExpression {

  private String id;

  public Variable(String id) {
    this.id = id;
  }

  @Override
  public Boolean evaluate(Map<String, Boolean> context) throws UnassignedVariableException {
    if (!context.containsKey(id)) {
      throw new UnassignedVariableException();
    } else {
      return context.get(id);
    }
  }

  @Override
  public BooleanExpression simplify(Map<String, Boolean> context) {
    if (!context.containsKey(id)) {
      return this;
    } else {
      return new BooleanValue(context.get(id));
    }
  }

  @Override
  public boolean equals(Object other) {
    return other != null
        && other.getClass().equals(Variable.class)
        && id.equals(((Variable) other).id);
  }

  @Override
  public String toString() {
    return id;
  }
}
