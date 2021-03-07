package booleanoo;


import java.util.Map;

public class Implication extends BinaryExpression  {

    public Implication(BooleanExpression left, BooleanExpression right) {
        super(new Implies(), left, right);
    }

    public BooleanExpression simplify(Map<String, Boolean> context) {

return null;
    }
}
