package booleanoo;

import java.util.Map;

public class IffExpression extends BinaryExpression {

    public IffExpression(BooleanExpression left, BooleanExpression right) {
        super(new Iff(), left, right);
    }

    public BooleanExpression simplify(Map<String, Boolean> context)  {
        BooleanValue trueObj = new BooleanValue(true);
        BooleanValue falseObj = new BooleanValue(false);

        if (this.getLeft() instanceof  BooleanValue && this.getRight() instanceof  BooleanValue){
//            return new BooleanValue((this.getLeft().equals(trueObj) && this.getRight().equals(trueObj))
//                    || (this.getLeft().equals(falseObj) && this.getRight().equals(falseObj)));
            return new BooleanValue(this.getLeft().equals(this.getRight()));
        }
        return new IffExpression(this.getLeft().simplify(context), this.getRight().simplify(context));
    }
}
