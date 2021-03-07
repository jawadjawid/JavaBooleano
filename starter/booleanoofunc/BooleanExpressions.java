package booleanoofunc;

import java.util.List;
import java.util.Map;
import java.util.function.BiFunction;
import java.util.stream.Collectors;

public abstract class BooleanExpressions {

  // Returns a List of the results of evaluating all expressions. Do NOT use any loops.
  // Use Java Streams and the method map.
  public static List<Boolean> evaluateAll(List<BooleanExpression> expressions,
      Map<String, Boolean> context) {
    return expressions.stream().map(expression -> expression.evaluate(context)).collect(Collectors.toList());
  }
  
  // Returns the conjuction of all results of evaluating all expressions. Do NOT use any loops.
  // Use Java Streams and the method reduce ONLY.
  public static Boolean evaluateAndReduce(List<BooleanExpression> expressions,
      Map<String, Boolean> context) {
    return expressions.stream().reduce(new BooleanValue(true), (a, b) -> new BooleanValue(a.evaluate(context) && b.evaluate(context))).evaluate(context);
  }
    
  // Returns the conjuction of all results of evaluating all expressions. Do NOT use any loops.
  // Use Java Streams and the methods map and reduce.
  public static Boolean evaluateAndMapReduce(List<BooleanExpression> expressions,
      Map<String, Boolean> context) {
    return evaluateAll(expressions, context).stream().reduce(true, (a, b) -> a && b);
  }
  
  // Returns the disjuction of all results of evaluating all expressions. Do NOT use any loops.
  // Use Java Streams and the methods map and reduce.
  public static Boolean evaluateOrMapReduce(List<BooleanExpression> expressions,
      Map<String, Boolean> context) {
    return evaluateAll(expressions, context).stream().reduce(false, (a, b) -> a || b);
  }

  // Returns the reduction of all results of evaluating all expressions using the reduction function
  // func and the identity. Do NOT use any loops.  Use Java Streams and the methods map and reduce.
  public static Boolean evaluateMapReduce(BiFunction<Boolean,Boolean,Boolean> func, Boolean identity,
                                          List<BooleanExpression> expressions, Map<String, Boolean> context) {
      return null;
  }
}
