package booleanoo;

public class Implies implements BinaryOperator {

    @Override
    public Boolean apply(Boolean left, Boolean right) {
        if (left)
            return right;
        return true;
    }
}
