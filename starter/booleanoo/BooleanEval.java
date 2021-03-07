package booleanoo;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

@SuppressWarnings("serial")
public class BooleanEval {

  static Map<String, Boolean> context = Collections.unmodifiableMap(new HashMap<String, Boolean>() {
    {
      put("a", true);
      put("b", false);
      put("c", false);
      put("d", true);
    }
  });
  
  static Map<String, Boolean> context2 = Collections.unmodifiableMap(new HashMap<String, Boolean>() {
    {
      put("c", false);
      put("d", true);
    }
  });
  
  /**
   * Show some examples.
   * 
   * @param args as usual
   */
  public static void main(String[] args) {
    demoHierarchy();
  }
  
  /**
   * Examples of using the hierarchy of Boolean Expressions.
   */
  private static void demoHierarchy() throws Exception {
      
    // ((a iff (not b)) implies ((true and c) iff ((not b) and c)))
    BooleanExpression expr =
        new Implication(
            new IffExpression(new Variable("a"), new Negation(new Variable("b"))),
            new IffExpression(new Conjunction(new BooleanValue(true), new Variable("c")),
                              new Conjunction(new Negation(new Variable("b")), new Variable("c"))));

    System.out.println(String.format("Expresison %s", expr));
    System.out.println(String.format("under context %s", context));
    try {
      System.out.println(String.format("evaluates to %s", expr.evaluate(context)));
    } catch (UnassignedVariableException exn) {
      System.out.println("I should not be here.");
    }
    System.out.println(String.format("and simplifies to %s", expr.simplify(context)));

    // ((not (not (a and c))) or b)
    BooleanExpression expr2 = new Disjunction(
        new Negation(new Negation(new Conjunction(new Variable("a"), new Variable("c")))),
        new Variable("b"));

    System.out.println(String.format("Expresison %s", expr2));
    System.out.println(String.format("under context %s", context2));
    try {
      System.out.println(expr2.evaluate(context2));
    } catch (UnassignedVariableException exn) {
      System.out.println(String.format("when evaluated raises an exception: %s", exn));
    }
    System.out.println(String.format("and simplifies to %s", expr2.simplify(context2)));
  }
}
