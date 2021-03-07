package booleanoo;


public class Conjunction extends BinaryExpression  {
    public Conjunction(BooleanExpression left, BooleanExpression right) {
        super(new And(), left, right);
    }
}
