package dev.yuriyprogg;

public enum OperationsEnum {
  ADD("+"),
  SUB("-"),
  MUL("*"),
  DIV("/");

  private final String value;

  OperationsEnum(String value) {
    this.value = value;
  }

  public String getValue() {
    return value;
  }

  // Метод для поиска элемента перечисления по значению
  public static OperationsEnum fromValue(String value) {
    for (OperationsEnum operation : OperationsEnum.values()) {
      if (operation.value.equals(value)) {
        return operation;
      }
    }
    throw new IllegalArgumentException("Неизвестное значение: " + value);
  }
}
