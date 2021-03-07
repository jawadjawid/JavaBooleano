package booleanoo;


import java.util.Map;

public class Conjunction extends BinaryExpression  {
    public Conjunction(BooleanExpression left, BooleanExpression right) {
        super(new And(), left, right);
    }

    public BooleanExpression simplify(Map<String, Boolean> context) throws Exception {
        throw new Exception("Exception message");

        //return left;
    }
}
