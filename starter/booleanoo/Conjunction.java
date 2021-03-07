package booleanoo;


import java.util.Map;

public class Conjunction extends BinaryExpression  {
    public Conjunction(BooleanExpression left, BooleanExpression right) {
        super(new And(), left, right);
    }

    public BooleanExpression simplify(Map<String, Boolean> context)  {
        BooleanValue trueObj = new BooleanValue(true);
        BooleanValue falseObj = new BooleanValue(false);

        if (this.getLeft() instanceof BooleanValue && this.getRight() instanceof BooleanValue){
            return new BooleanValue(this.getLeft().equals(trueObj) && this.getRight().equals(trueObj));
        }
        return new Conjunction(this.getLeft().simplify(context), this.getRight().simplify(context));
    }
}
