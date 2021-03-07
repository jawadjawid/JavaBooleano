package booleanoo;

import java.util.Map;

public class Negation extends UnaryExpression{
    public Negation(BooleanExpression op) {
        super(new Not(), op);
    }

    public BooleanExpression simplify(Map<String, Boolean> context)  {
        BooleanExpression operandSimple = this.getOperand().simplify(context);

        if (operandSimple instanceof UnaryExpression)
            return ((UnaryExpression) operandSimple).getOperand().simplify(context);

        return new Negation(operandSimple);
    }
}
