package booleanoo;

import java.util.Map;

public class Disjunction extends BinaryExpression {

    public Disjunction(BooleanExpression left, BooleanExpression right) {
        super(new Or(), left, right);
    }

    public BooleanExpression simplify(Map<String, Boolean> context) throws Exception {
        throw new Exception("Exception message");

        //return left;
    }
}
