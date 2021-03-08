package booleanoofunc;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
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
    demoFunctional();
  }
  
  /**
   * Examples of using lists of Boolean Expressions.
   */
  private static void demoFunctional() {
  
    List<BooleanExpression> list = Arrays.asList(
        new BooleanExpression[] {
            new BooleanValue(true),
            new Variable("a"),
            new Conjunction(new Variable("b"), new Variable("c")),
            new Implication(
                new Conjunction(new Variable("a"), new Variable("b")),
                new Implication(new BooleanValue(false), new Variable("d")))
        });
  
    System.out.println("evaluateAll returns " +
        BooleanExpressions.evaluateAll(list, context));
    System.out.println("evaluateAndReduce returns " +
        BooleanExpressions.evaluateAndReduce(list, context));
    System.out.println("evaluateAndMapRedule returns " +
        BooleanExpressions.evaluateAndMapReduce(list, context));
    System.out.println("evaluateOrMapRedule returns " +
        BooleanExpressions.evaluateOrMapReduce(list, context));
    System.out.println("evaluateMapReduce with and/true returns " +
        BooleanExpressions.evaluateMapReduce(
            (x, y) -> x && y,
            true,
            list,
            context));
    System.out.println("evaluateMapReduce with or/false returns " +
        BooleanExpressions.evaluateMapReduce(
            (x, y) -> x || y,
            false,
            list,
            context));
  }
  
  /**
   * Examples of using the hierarchy of Boolean Expressions.
   */
  private static void demoHierarchy() {

    BooleanExpression expr14 = new Implication(new Variable("x"), new BooleanValue(false));
    System.out.println(String.format("Expresison %s", expr14));
    System.out.println(String.format("under context %s", context2));
    try {
      System.out.println(expr14.evaluate(context2));
    } catch (UnassignedVariableException exn) {
      System.out.println(String.format("when evaluated raises an exception: %s", exn));
    }
    System.out.println(String.format("and simplifies to %s", expr14.simplify(context2)));
      
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

    BooleanExpression expr3 = new Conjunction(new BooleanValue(true), new Variable("x"));
    System.out.println(String.format("Expresison %s", expr3));
    System.out.println(String.format("under context %s", context2));
    try {
      System.out.println(expr3.evaluate(context2));
    } catch (UnassignedVariableException exn) {
      System.out.println(String.format("when evaluated raises an exception: %s", exn));
    }
    System.out.println(String.format("and simplifies to %s", expr3.simplify(context2)));

    BooleanExpression expr4 = new Conjunction(new BooleanValue(false), new Variable("x"));
    System.out.println(String.format("Expresison %s", expr4));
    System.out.println(String.format("under context %s", context2));
    try {
      System.out.println(expr4.evaluate(context2));
    } catch (UnassignedVariableException exn) {
      System.out.println(String.format("when evaluated raises an exception: %s", exn));
    }
    System.out.println(String.format("and simplifies to %s", expr4.simplify(context2)));

    BooleanExpression expr5 = new Conjunction(new Variable("x"), new BooleanValue(true));
    System.out.println(String.format("Expresison %s", expr5));
    System.out.println(String.format("under context %s", context2));
    try {
      System.out.println(expr5.evaluate(context2));
    } catch (UnassignedVariableException exn) {
      System.out.println(String.format("when evaluated raises an exception: %s", exn));
    }
    System.out.println(String.format("and simplifies to %s", expr5.simplify(context2)));

    BooleanExpression expr6 = new Conjunction(new Variable("x"), new BooleanValue(false));
    System.out.println(String.format("Expresison %s", expr6));
    System.out.println(String.format("under context %s", context2));
    try {
      System.out.println(expr6.evaluate(context2));
    } catch (UnassignedVariableException exn) {
      System.out.println(String.format("when evaluated raises an exception: %s", exn));
    }
    System.out.println(String.format("and simplifies to %s", expr6.simplify(context2)));

    BooleanExpression expr7 = new Disjunction(new BooleanValue(true), new Variable("x"));
    System.out.println(String.format("Expresison %s", expr7));
    System.out.println(String.format("under context %s", context2));
    try {
      System.out.println(expr7.evaluate(context2));
    } catch (UnassignedVariableException exn) {
      System.out.println(String.format("when evaluated raises an exception: %s", exn));
    }
    System.out.println(String.format("and simplifies to %s", expr7.simplify(context2)));

    BooleanExpression expr8 = new Disjunction(new BooleanValue(false), new Variable("x"));
    System.out.println(String.format("Expresison %s", expr8));
    System.out.println(String.format("under context %s", context2));
    try {
      System.out.println(expr8.evaluate(context2));
    } catch (UnassignedVariableException exn) {
      System.out.println(String.format("when evaluated raises an exception: %s", exn));
    }
    System.out.println(String.format("and simplifies to %s", expr8.simplify(context2)));

    BooleanExpression expr9 = new Disjunction(new Variable("x"), new BooleanValue(true));
    System.out.println(String.format("Expresison %s", expr9));
    System.out.println(String.format("under context %s", context2));
    try {
      System.out.println(expr9.evaluate(context2));
    } catch (UnassignedVariableException exn) {
      System.out.println(String.format("when evaluated raises an exception: %s", exn));
    }
    System.out.println(String.format("and simplifies to %s", expr9.simplify(context2)));

    BooleanExpression expr10 = new Disjunction(new Variable("x"), new BooleanValue(false));
    System.out.println(String.format("Expresison %s", expr10));
    System.out.println(String.format("under context %s", context2));
    try {
      System.out.println(expr10.evaluate(context2));
    } catch (UnassignedVariableException exn) {
      System.out.println(String.format("when evaluated raises an exception: %s", exn));
    }
    System.out.println(String.format("and simplifies to %s", expr10.simplify(context2)));

    BooleanExpression expr11 = new Implication(new BooleanValue(true), new Variable("x"));
    System.out.println(String.format("Expresison %s", expr11));
    System.out.println(String.format("under context %s", context2));
    try {
      System.out.println(expr11.evaluate(context2));
    } catch (UnassignedVariableException exn) {
      System.out.println(String.format("when evaluated raises an exception: %s", exn));
    }
    System.out.println(String.format("and simplifies to %s", expr11.simplify(context2)));

    BooleanExpression expr12 = new Implication(new Variable("x"), new BooleanValue(true));
    System.out.println(String.format("Expresison %s", expr12));
    System.out.println(String.format("under context %s", context2));
    try {
      System.out.println(expr12.evaluate(context2));
    } catch (UnassignedVariableException exn) {
      System.out.println(String.format("when evaluated raises an exception: %s", exn));
    }
    System.out.println(String.format("and simplifies to %s", expr12.simplify(context2)));

    BooleanExpression expr13 = new Implication(new BooleanValue(false), new Variable("x"));
    System.out.println(String.format("Expresison %s", expr13));
    System.out.println(String.format("under context %s", context2));
    try {
      System.out.println(expr13.evaluate(context2));
    } catch (UnassignedVariableException exn) {
      System.out.println(String.format("when evaluated raises an exception: %s", exn));
    }
    System.out.println(String.format("and simplifies to %s", expr13.simplify(context2)));



    BooleanExpression expr15 = new IffExpression(new BooleanValue(true), new Variable("x"));
    System.out.println(String.format("Expresison %s", expr15));
    System.out.println(String.format("under context %s", context2));
    try {
      System.out.println(expr15.evaluate(context2));
    } catch (UnassignedVariableException exn) {
      System.out.println(String.format("when evaluated raises an exception: %s", exn));
    }
    System.out.println(String.format("and simplifies to %s", expr15.simplify(context2)));

    BooleanExpression expr16 = new IffExpression(new Variable("x"), new BooleanValue(true));
    System.out.println(String.format("Expresison %s", expr16));
    System.out.println(String.format("under context %s", context2));
    try {
      System.out.println(expr16.evaluate(context2));
    } catch (UnassignedVariableException exn) {
      System.out.println(String.format("when evaluated raises an exception: %s", exn));
    }
    System.out.println(String.format("and simplifies to %s", expr16.simplify(context2)));

    BooleanExpression expr17 = new IffExpression(new BooleanValue(false), new Variable("x"));
    System.out.println(String.format("Expresison %s", expr17));
    System.out.println(String.format("under context %s", context2));
    try {
      System.out.println(expr17.evaluate(context2));
    } catch (UnassignedVariableException exn) {
      System.out.println(String.format("when evaluated raises an exception: %s", exn));
    }
    System.out.println(String.format("and simplifies to %s", expr17.simplify(context2)));

    BooleanExpression expr18 = new IffExpression(new Variable("x"), new BooleanValue(false));
    System.out.println(String.format("Expresison %s", expr18));
    System.out.println(String.format("under context %s", context2));
    try {
      System.out.println(expr18.evaluate(context2));
    } catch (UnassignedVariableException exn) {
      System.out.println(String.format("when evaluated raises an exception: %s", exn));
    }
    System.out.println(String.format("and simplifies to %s", expr18.simplify(context2)));

    BooleanExpression expr19 = new Negation(new Negation(new Variable("x")));
    System.out.println(String.format("Expresison %s", expr19));
    System.out.println(String.format("under context %s", context2));
    try {
      System.out.println(expr19.evaluate(context2));
    } catch (UnassignedVariableException exn) {
      System.out.println(String.format("when evaluated raises an exception: %s", exn));
    }
    System.out.println(String.format("and simplifies to %s", expr19.simplify(context2)));

    BooleanExpression expr20 = new Conjunction(new Variable("x"), new Variable("x"));
    System.out.println(String.format("Expresison %s", expr20));
    System.out.println(String.format("under context %s", context2));
    try {
      System.out.println(expr20.evaluate(context2));
    } catch (UnassignedVariableException exn) {
      System.out.println(String.format("when evaluated raises an exception: %s", exn));
    }
    System.out.println(String.format("and simplifies to %s", expr20.simplify(context2)));

    BooleanExpression expr21 = new Disjunction(new Variable("x"), new Variable("x"));
    System.out.println(String.format("Expresison %s", expr21));
    System.out.println(String.format("under context %s", context2));
    try {
      System.out.println(expr21.evaluate(context2));
    } catch (UnassignedVariableException exn) {
      System.out.println(String.format("when evaluated raises an exception: %s", exn));
    }
    System.out.println(String.format("and simplifies to %s", expr21.simplify(context2)));

    booleanoofunc.BooleanExpression expr22 = new Implication(new Variable("x"), new Variable("x"));
    System.out.println(String.format("Expresison %s", expr22));
    System.out.println(String.format("under context %s", context2));
    try {
      System.out.println(expr22.evaluate(context2));
    } catch (UnassignedVariableException exn) {
      System.out.println(String.format("when evaluated raises an exception: %s", exn));
    }
    System.out.println(String.format("and simplifies to %s", expr22.simplify(context2)));

    BooleanExpression expr23 = new IffExpression(new Variable("x"), new Variable("x"));
    System.out.println(String.format("Expresison %s", expr23));
    System.out.println(String.format("under context %s", context2));
    try {
      System.out.println(expr23.evaluate(context2));
    } catch (UnassignedVariableException exn) {
      System.out.println(String.format("when evaluated raises an exception: %s", exn));
    }
    System.out.println(String.format("and simplifies to %s", expr23.simplify(context2)));

    BooleanExpression expr24 = new Negation(new BooleanValue(true));
    System.out.println(String.format("Expresison %s", expr24));
    System.out.println(String.format("under context %s", context2));
    try {
      System.out.println(expr24.evaluate(context2));
    } catch (UnassignedVariableException exn) {
      System.out.println(String.format("when evaluated raises an exception: %s", exn));
    }
    System.out.println(String.format("and simplifies to %s", expr24.simplify(context2)));

    BooleanExpression expr25 = new Negation(new Variable("x"));
    System.out.println(String.format("Expresison %s", expr25));
    System.out.println(String.format("under context %s", context2));
    try {
      System.out.println(expr25.evaluate(context2));
    } catch (UnassignedVariableException exn) {
      System.out.println(String.format("when evaluated raises an exception: %s", exn));
    }
    System.out.println(String.format("and simplifies to %s", expr25.simplify(context2)));

    BooleanExpression expr26 = new Negation(new Variable("c"));
    System.out.println(String.format("Expresison %s", expr26));
    System.out.println(String.format("under context %s", context2));
    try {
      System.out.println(expr26.evaluate(context2));
    } catch (UnassignedVariableException exn) {
      System.out.println(String.format("when evaluated raises an exception: %s", exn));
    }
    System.out.println(String.format("and simplifies to %s", expr26.simplify(context2)));

    BooleanExpression expr27 = new Negation(new Variable("d"));
    System.out.println(String.format("Expresison %s", expr27));
    System.out.println(String.format("under context %s", context2));
    try {
      System.out.println(expr27.evaluate(context2));
    } catch (UnassignedVariableException exn) {
      System.out.println(String.format("when evaluated raises an exception: %s", exn));
    }
    System.out.println(String.format("and simplifies to %s", expr27.simplify(context2)));

    BooleanExpression expr28 = new Negation(new BooleanValue(false));
    System.out.println(String.format("Expresison %s", expr28));
    System.out.println(String.format("under context %s", context2));
    try {
      System.out.println(expr28.evaluate(context2));
    } catch (UnassignedVariableException exn) {
      System.out.println(String.format("when evaluated raises an exception: %s", exn));
    }
    System.out.println(String.format("and simplifies to %s", expr28.simplify(context2)));

    BooleanExpression expr29 = new Implication(new Variable("c"), new BooleanValue(false));
    System.out.println(String.format("Expresison %s", expr29));
    System.out.println(String.format("under context %s", context2));
    try {
      System.out.println(expr29.evaluate(context2));
    } catch (UnassignedVariableException exn) {
      System.out.println(String.format("when evaluated raises an exception: %s", exn));
    }
    System.out.println(String.format("and simplifies to %s", expr29.simplify(context2)));

    BooleanExpression expr30 = new Negation(new Negation(new Variable("c")));
    System.out.println(String.format("Expresison %s", expr30));
    System.out.println(String.format("under context %s", context2));
    try {
      System.out.println(expr30.evaluate(context2));
    } catch (UnassignedVariableException exn) {
      System.out.println(String.format("when evaluated raises an exception: %s", exn));
    }
    System.out.println(String.format("and simplifies to %s", expr30.simplify(context2)));

    BooleanExpression expr31 = new Negation(new Negation(new IffExpression(new Variable("c"), new Variable("d"))));
    System.out.println(String.format("Expresison %s", expr31));
    System.out.println(String.format("under context %s", context2));
    try {
      System.out.println(expr31.evaluate(context2));
    } catch (UnassignedVariableException exn) {
      System.out.println(String.format("when evaluated raises an exception: %s", exn));
    }
    System.out.println(String.format("and simplifies to %s", expr31.simplify(context2)));

    BooleanExpression expr32 = new Negation(new Negation(new IffExpression(new Variable("x"), new Variable("d"))));
    System.out.println(String.format("Expresison %s", expr32));
    System.out.println(String.format("under context %s", context2));
    try {
      System.out.println(expr32.evaluate(context2));
    } catch (UnassignedVariableException exn) {
      System.out.println(String.format("when evaluated raises an exception: %s", exn));
    }
    System.out.println(String.format("and simplifies to %s", expr32.simplify(context2)));

    // (true -> d) iff (not (false and c)): true by (x <-> x) == true
    BooleanExpression expr33 = new IffExpression(new Implication(new BooleanValue(true), new Variable("d")), new Negation(new Conjunction(new BooleanValue(false), new Variable("c"))));
    System.out.println(String.format("Expresison %s", expr33));
    System.out.println(String.format("under context %s", context2));
    try {
      System.out.println(expr33.evaluate(context2));
    } catch (UnassignedVariableException exn) {
      System.out.println(String.format("when evaluated raises an exception: %s", exn));
    }
    System.out.println(String.format("and simplifies to %s", expr33.simplify(context2)));

    // (true -> d) iff (not (true or c)): false
    BooleanExpression expr34 = new IffExpression(new Implication(new BooleanValue(true), new Variable("d")), new Negation(new Disjunction(new BooleanValue(true), new Variable("c"))));
    System.out.println(String.format("Expresison %s", expr34));
    System.out.println(String.format("under context %s", context2));
    try {
      System.out.println(expr34.evaluate(context2));
    } catch (UnassignedVariableException exn) {
      System.out.println(String.format("when evaluated raises an exception: %s", exn));
    }
    System.out.println(String.format("and simplifies to %s", expr34.simplify(context2)));

    // (true -> d) iff (not (false or x)): (false or x) -> x, then (true iff (not x)) should give (not x)
    BooleanExpression expr35 = new IffExpression(new Implication(new BooleanValue(true), new Variable("d")), new Negation(new Disjunction(new BooleanValue(false), new Variable("x"))));
    System.out.println(String.format("Expresison %s", expr35));
    System.out.println(String.format("under context %s", context2));
    try {
      System.out.println(expr35.evaluate(context2));
    } catch (UnassignedVariableException exn) {
      System.out.println(String.format("when evaluated raises an exception: %s", exn));
    }
    System.out.println(String.format("and simplifies to %s", expr35.simplify(context2)));

    // ((a or b) and true) -> not(not(not true)): using (x->false)==(not x) rule, returns not (a or b)
    BooleanExpression expr36 = new Implication(new Conjunction(new Disjunction(new Variable("a"), new Variable("b")), new BooleanValue(true)), new Negation(new Negation(new Negation(new BooleanValue(true)))));
    System.out.println(String.format("Expresison %s", expr36));
    System.out.println(String.format("under context %s", context2));
    try {
      System.out.println(expr36.evaluate(context2));
    } catch (UnassignedVariableException exn) {
      System.out.println(String.format("when evaluated raises an exception: %s", exn));
    }
    System.out.println(String.format("and simplifies to %s", expr36.simplify(context2)));

    // ((a or b) and true) -> (c or x)): (c or x) == x, and ((a or b) and true)== (a or b), this returns (a or b) -> x
    BooleanExpression expr37 = new Implication(new Conjunction(new Disjunction(new Variable("a"), new Variable("b")), new BooleanValue(true)), new Disjunction(new Variable("c"), new Variable("x")));
    System.out.println(String.format("Expresison %s", expr37));
    System.out.println(String.format("under context %s", context2));
    try {
      System.out.println(expr37.evaluate(context2));
    } catch (UnassignedVariableException exn) {
      System.out.println(String.format("when evaluated raises an exception: %s", exn));
    }
    System.out.println(String.format("and simplifies to %s", expr37.simplify(context2)));

    // ((((true and x) and true) and false) and x): false, uses all the conjunction rules seen below
    // (t and x) == x, (x and t) == x, (x and f) == f, (f and x) == f
    BooleanExpression expr38 = new Conjunction(new Conjunction(new Conjunction(new Conjunction(new BooleanValue(true), new Variable("x")), new BooleanValue(true)), new BooleanValue(false)), new Variable("x"));
    System.out.println(String.format("Expresison %s", expr38));
    System.out.println(String.format("under context %s", context2));
    try {
      System.out.println(expr38.evaluate(context2));
    } catch (UnassignedVariableException exn) {
      System.out.println(String.format("when evaluated raises an exception: %s", exn));
    }
    System.out.println(String.format("and simplifies to %s", expr38.simplify(context2)));

    // (x or (true or (false or (x or false)))): true, uses the disjunction rules below
    // (x or false) == x, (false or x) == x, (true or x) == t, (x or true) == x
    BooleanExpression expr39 = new Disjunction(new Variable("x"), new Disjunction(new BooleanValue(true), new Disjunction(new BooleanValue(false), new Disjunction(new Variable("x"), new BooleanValue(false)))));
    System.out.println(String.format("Expresison %s", expr39));
    System.out.println(String.format("under context %s", context2));
    try {
      System.out.println(expr39.evaluate(context2));
    } catch (UnassignedVariableException exn) {
      System.out.println(String.format("when evaluated raises an exception: %s", exn));
    }
    System.out.println(String.format("and simplifies to %s", expr39.simplify(context2)));

    // (x -> (not (((f -> x) -> x) -> t))): not x
    // (f -> x) == t, (t -> x) == x, (x -> t) == t, x->f == not x
    BooleanExpression expr40 = new Implication(new Variable("x"), new Negation(new Implication(new Implication(new Implication(new BooleanValue(false), new Variable("x")), new Variable("x")), new BooleanValue(true))));
    System.out.println(String.format("Expresison %s", expr40));
    System.out.println(String.format("under context %s", context2));
    try {
      System.out.println(expr40.evaluate(context2));
    } catch (UnassignedVariableException exn) {
      System.out.println(String.format("when evaluated raises an exception: %s", exn));
    }
    System.out.println(String.format("and simplifies to %s", expr40.simplify(context2)));

    // (f <=> (((t <=> x) <=> t) <=> f)): (not (not x)) or x?
    BooleanExpression expr41 = new IffExpression(new BooleanValue(false), new IffExpression(new IffExpression(new IffExpression(new BooleanValue(true), new Variable("x")), new BooleanValue(true)), new BooleanValue(false)));
    System.out.println(String.format("Expresison %s", expr41));
    System.out.println(String.format("under context %s", context2));
    try {
      System.out.println(expr41.evaluate(context2));
    } catch (UnassignedVariableException exn) {
      System.out.println(String.format("when evaluated raises an exception: %s", exn));
    }
    System.out.println(String.format("and simplifies to %s", expr41.simplify(context2)));

    // (x or (t->x)): x
    BooleanExpression expr42 = new Disjunction(new Variable("x"), new Implication(new BooleanValue(true), new Variable("x")));
    System.out.println(String.format("Expresison %s", expr42));
    System.out.println(String.format("under context %s", context2));
    try {
      System.out.println(expr42.evaluate(context2));
    } catch (UnassignedVariableException exn) {
      System.out.println(String.format("when evaluated raises an exception: %s", exn));
    }
    System.out.println(String.format("and simplifies to %s", expr42.simplify(context2)));

    // (x and (f or x)): x
    BooleanExpression expr43 = new Conjunction(new Variable("x"), new Disjunction(new BooleanValue(false), new Variable("x")));
    System.out.println(String.format("Expresison %s", expr43));
    System.out.println(String.format("under context %s", context2));
    try {
      System.out.println(expr43.evaluate(context2));
    } catch (UnassignedVariableException exn) {
      System.out.println(String.format("when evaluated raises an exception: %s", exn));
    }
    System.out.println(String.format("and simplifies to %s", expr43.simplify(context2)));

    // (not (not (x -> f))): not x
    BooleanExpression expr44 = new Negation(new Negation(new Implication(new Variable("x"), new BooleanValue(false))));
    System.out.println(String.format("Expresison %s", expr44));
    System.out.println(String.format("under context %s", context2));
    try {
      System.out.println(expr44.evaluate(context2));
    } catch (UnassignedVariableException exn) {
      System.out.println(String.format("when evaluated raises an exception: %s", exn));
    }
    System.out.println(String.format("and simplifies to %s", expr44.simplify(context2)));

    // (not (not (c -> f))): true
    BooleanExpression expr45 = new Negation(new Negation(new Implication(new Variable("c"), new BooleanValue(false))));
    System.out.println(String.format("Expresison %s", expr45));
    System.out.println(String.format("under context %s", context2));
    try {
      System.out.println(expr45.evaluate(context2));
    } catch (UnassignedVariableException exn) {
      System.out.println(String.format("when evaluated raises an exception: %s", exn));
    }
    System.out.println(String.format("and simplifies to %s", expr45.simplify(context2)));

    // (x <=> x) and x: x
    BooleanExpression expr46 = new Conjunction(new IffExpression(new Variable("x"), new Variable("x")), new Variable("x"));
    System.out.println(String.format("Expresison %s", expr46));
    System.out.println(String.format("under context %s", context2));
    try {
      System.out.println(expr46.evaluate(context2));
    } catch (UnassignedVariableException exn) {
      System.out.println(String.format("when evaluated raises an exception: %s", exn));
    }
    System.out.println(String.format("and simplifies to %s", expr46.simplify(context2)));

    // (d <=> d) or false: true
    BooleanExpression expr47 = new Disjunction(new IffExpression(new Variable("d"), new Variable("d")), new BooleanValue(false));
    System.out.println(String.format("Expresison %s", expr47));
    System.out.println(String.format("under context %s", context2));
    try {
      System.out.println(expr47.evaluate(context2));
    } catch (UnassignedVariableException exn) {
      System.out.println(String.format("when evaluated raises an exception: %s", exn));
    }
    System.out.println(String.format("and simplifies to %s", expr47.simplify(context2)));

    // ((c or x) and (a and (c -> d))): x and a
    BooleanExpression expr48 = new Conjunction(new Disjunction(new Variable("c"), new Variable("x")), new Conjunction(new Variable("a"), new Implication(new Variable("c"), new Variable("d"))));
    System.out.println(String.format("Expresison %s", expr48));
    System.out.println(String.format("under context %s", context2));
    try {
      System.out.println(expr48.evaluate(context2));
    } catch (UnassignedVariableException exn) {
      System.out.println(String.format("when evaluated raises an exception: %s", exn));
    }
    System.out.println(String.format("and simplifies to %s", expr48.simplify(context2)));

    // (((c or x) and (a and (c -> d))) -> (false and d)): not (x and a)
    BooleanExpression expr49 = new Implication(new Conjunction(new Disjunction(new Variable("c"), new Variable("x")), new Conjunction(new Variable("a"), new Implication(new Variable("c"), new Variable("d")))), new Conjunction(new BooleanValue(false), new Variable("d")));
    System.out.println(String.format("Expresison %s", expr49));
    System.out.println(String.format("under context %s", context2));
    try {
      System.out.println(expr49.evaluate(context2));
    } catch (UnassignedVariableException exn) {
      System.out.println(String.format("when evaluated raises an exception: %s", exn));
    }
    System.out.println(String.format("and simplifies to %s", expr49.simplify(context2)));

    // (((c or true) and (a and (c -> d))) -> (false and d)): not a
    BooleanExpression expr50 = new Implication(new Conjunction(new Disjunction(new Variable("c"), new BooleanValue(true)), new Conjunction(new Variable("a"), new Implication(new Variable("c"), new Variable("d")))), new Conjunction(new BooleanValue(false), new Variable("d")));
    System.out.println(String.format("Expresison %s", expr50));
    System.out.println(String.format("under context %s", context2));
    try {
      System.out.println(expr50.evaluate(context2));
    } catch (UnassignedVariableException exn) {
      System.out.println(String.format("when evaluated raises an exception: %s", exn));
    }
    System.out.println(String.format("and simplifies to %s", expr50.simplify(context2)));

    // ((not a) implies false)
    BooleanExpression expr51 = new Implication(new Negation(new Variable("a")), new BooleanValue(false));
    System.out.println(String.format("Expresison %s", expr51));
    System.out.println(String.format("under context %s", context2));
    try {
      System.out.println(expr51.evaluate(context2));
    } catch (UnassignedVariableException exn) {
      System.out.println(String.format("when evaluated raises an exception: %s", exn));
    }
    System.out.println(String.format("and simplifies to %s", expr51.simplify(context2)));
  }
}
