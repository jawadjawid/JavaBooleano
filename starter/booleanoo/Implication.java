package booleanoo;


import java.util.Map;

public class Implication extends BinaryExpression  {

    public Implication(BooleanExpression left, BooleanExpression right) {
        super(new Implies(), left, right);
    }

    public BooleanExpression simplify(Map<String, Boolean> context)  {
        BooleanValue trueObj = new BooleanValue(true);
        if (this.getLeft() instanceof BooleanValue && this.getRight() instanceof BooleanValue){
            if(this.getLeft().equals(trueObj))
                return this.getRight();
            return trueObj;
        }
        return new Implication(this.getLeft().simplify(context), this.getRight().simplify(context));
    }
}
