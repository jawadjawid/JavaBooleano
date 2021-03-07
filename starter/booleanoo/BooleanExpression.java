package booleanoo;

import java.util.Map;

public interface BooleanExpression {

    public Boolean evaluate(Map<String, Boolean> context) throws Exception;
    public BooleanExpression simplify(Map<String, Boolean> context) throws Exception;

    public boolean equals(Object other);

    public String toString();

}
