package booleanoofunc;

import java.util.Map;

public interface BooleanExpression {
  public Boolean evaluate(Map<String, Boolean> context)
      throws booleanoofunc.UnassignedVariableException;

  public booleanoofunc.BooleanExpression simplify(Map<String, Boolean> context);

  public boolean equals(Object other);

  public String toString();
}
