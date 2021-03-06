package booleanoo;

public class Iff implements BinaryOperator {
  
  @Override
  public boolean equals(Object other) {
    return other != null
        && other.getClass().equals(Iff.class);
  }

  @Override
  public String toString() {
    return Constants.IFF;
  }
}
