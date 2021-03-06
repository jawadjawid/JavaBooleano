package booleanoofunc;

public class UnassignedVariableException extends RuntimeException {

  private static final long serialVersionUID = 1L;

  public UnassignedVariableException() {}

  public UnassignedVariableException(String message) {
    super(message);
  }
}
