package booleanoo;

public class IffExpression extends BinaryExpression {

    public IffExpression(BooleanExpression left, BooleanExpression right) {
        super(new Iff(), left, right);
    }

}
