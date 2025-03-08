package dev.yuriyprogg;

public enum RomanEnum {
  I(1),
  V(5),
  X(10),
  L(50),
  C(100),
  D(500),
  M(1000);

  private final int value;

  RomanEnum(int value) {
    this.value = value;
  }

  public int getValue() {
    return value;
  }

  public boolean check(int number) {
    if (this.getValue() <= 0)
      return false;
    for (RomanEnum r : RomanEnum.values())
      if (r.getValue() + number == this.getValue())
        return true;
    return false;
  }

}
