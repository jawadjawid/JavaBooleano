package booleanoofunc;

import java.util.Map;

/** Variable name. */
public class Variable implements BooleanExpression {

  private String id;

  public Variable(String id) {
    this.id = id;
  }

  @Override
  public Boolean evaluate(Map<String, Boolean> context)
      throws booleanoofunc.UnassignedVariableException {
    if (!context.containsKey(id)) {
      throw new booleanoofunc.UnassignedVariableException();
    } else {
      return context.get(id);
    }
  }

  @Override
  public booleanoofunc.BooleanExpression simplify(Map<String, Boolean> context) {
    if (!context.containsKey(id)) {
      return this;
    } else {
      return new booleanoofunc.BooleanValue(context.get(id));
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
