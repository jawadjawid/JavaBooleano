package booleanoo;

public class Disjunction extends BinaryExpression {

    public Disjunction(BooleanExpression left, BooleanExpression right) {
        super(new Or(), left, right);
    }


}
