package booleanoo;


public class Implication extends BinaryExpression  {

    public Implication(BooleanExpression left, BooleanExpression right) {
        super(new Implies(), left, right);
    }
}
