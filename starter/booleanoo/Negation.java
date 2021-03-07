package booleanoo;

public class Negation extends UnaryExpression{
    public Negation(BooleanExpression op) {
        super(new Not(), op);
    }
}
