package booleanoo;

import java.util.Map;

public class Negation extends UnaryExpression{
    public Negation(BooleanExpression op) {
        super(new Not(), op);
    }

    public BooleanExpression simplify(Map<String, Boolean> context) {
        return null;
    }

}
