package booleanoo;

public class And {

  @Override
  public boolean equals(Object other) {
    return other != null
        && other.getClass().equals(And.class);
  }
  
  @Override
  public String toString() {
    return Constants.AND;
  }
}
