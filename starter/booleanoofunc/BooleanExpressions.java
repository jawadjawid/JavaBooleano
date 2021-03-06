package booleanoofunc;

import java.util.List;
import java.util.Map;
import java.util.function.BiFunction;
import java.util.stream.Collectors;

/** Boolean Expressions methods to be applied on a list of Booleans in functional programming. */
public abstract class BooleanExpressions {

  // Returns a List of the results of evaluating all expressions. Do NOT use any loops.
  // Use Java Streams and the method map.
  public static List<Boolean> evaluateAll(
      List<BooleanExpression> expressions, Map<String, Boolean> context)
      throws booleanoofunc.UnassignedVariableException {
    return expressions.stream().map(a -> a.evaluate(context)).collect(Collectors.toList());
  }

  /**
   * evaluateAndReduce.
   *
   * @param expressions list of boolean expressions.
   * @param context of values.
   * @return conjuction of all results of evaluating all expressions.
   * @throws booleanoofunc.UnassignedVariableException for when context doesnt contain a value
   */
  // Returns the conjuction of all results of evaluating all expressions. Do NOT use any loops.
  // Use Java Streams and the method reduce ONLY.
  public static Boolean evaluateAndReduce(
      List<BooleanExpression> expressions, Map<String, Boolean> context)
      throws booleanoofunc.UnassignedVariableException {
    return expressions.stream()
        .reduce(
            new BooleanValue(true),
            (a, b) -> new BooleanValue(a.evaluate(context) && b.evaluate(context)))
        .evaluate(context);
  }

  // Returns the conjuction of all results of evaluating all expressions. Do NOT use any loops.
  // Use Java Streams and the methods map and reduce.
  public static Boolean evaluateAndMapReduce(
      List<BooleanExpression> expressions, Map<String, Boolean> context)
      throws booleanoofunc.UnassignedVariableException {
    return evaluateAll(expressions, context).stream().reduce(true, (a, b) -> a && b);
  }

  // Returns the disjuction of all results of evaluating all expressions. Do NOT use any loops.
  // Use Java Streams and the methods map and reduce.
  public static Boolean evaluateOrMapReduce(
      List<BooleanExpression> expressions, Map<String, Boolean> context)
      throws booleanoofunc.UnassignedVariableException {
    return evaluateAll(expressions, context).stream().reduce(false, (a, b) -> a || b);
  }

  // Returns the reduction of all results of evaluating all expressions using the reduction function
  // func and the identity. Do NOT use any loops.  Use Java Streams and the methods map and reduce.
  public static Boolean evaluateMapReduce(
      BiFunction<Boolean, Boolean, Boolean> func,
      Boolean identity,
      List<BooleanExpression> expressions,
      Map<String, Boolean> context)
      throws booleanoofunc.UnassignedVariableException {
    return evaluateAll(expressions, context).stream().reduce(identity, (a, b) -> func.apply(a, b));
  }
}
