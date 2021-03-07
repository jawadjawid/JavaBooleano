package booleanoo;

import java.util.Map;

public class Disjunction extends BinaryExpression {

    public Disjunction(BooleanExpression left, BooleanExpression right) {
        super(new Or(), left, right);
    }

    public BooleanExpression simplify(Map<String, Boolean> context)  {
        BooleanValue trueObj = new BooleanValue(true);
        BooleanValue falseObj = new BooleanValue(false);
        BooleanExpression leftSimple = this.getLeft().simplify(context);
        BooleanExpression rightSimple = this.getRight().simplify(context);

        if (leftSimple.equals(rightSimple))
            return leftSimple;
        else if(leftSimple.equals(falseObj))
            return rightSimple;
        else if(rightSimple.equals(falseObj))
            return leftSimple;
        else if(leftSimple.equals(trueObj) || rightSimple.equals(trueObj))
            return trueObj;
        return new Disjunction(leftSimple, rightSimple);
    }
}
