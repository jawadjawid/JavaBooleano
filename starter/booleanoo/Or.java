package booleanoo;

public class Or {
  @Override
  public boolean equals(Object other) {
    return other != null
        && other.getClass().equals(Or.class);
  }

  @Override
  public String toString() {
    return Constants.OR;
  }
}
