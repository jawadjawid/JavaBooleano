package booleanoo;

import java.util.Map;

public class IffExpression extends BinaryExpression {

    public IffExpression(BooleanExpression left, BooleanExpression right) {
        super(new Iff(), left, right);
    }

    public BooleanExpression simplify(Map<String, Boolean> context)  {
      return null;
    }

}
