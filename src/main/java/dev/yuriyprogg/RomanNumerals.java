package dev.yuriyprogg;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RomanNumerals {
  public static int parseToInt(String roman) {
    List<RomanEnum> romanEnums = new ArrayList<>(List.of(RomanEnum.values()));
    Collections.reverse(romanEnums);
    int result = 0, tmp = 0;
    for (int i = 0; i < roman.length(); i++)
      for (RomanEnum r : romanEnums)
        if (roman.charAt(i) == r.name().charAt(0)) {
          if (r.getValue() > tmp) {
            result += r.getValue() - tmp * 2;
            tmp = r.getValue();
          } else if (i + 1 < roman.length() && roman.charAt(i + 1) != r.name().charAt(0))
            tmp = r.getValue();
          else
            result += r.getValue();
        }

    return result;
  }

  public static String parseToRoman(int number) {
    String result = "";
    List<RomanEnum> romanEnums = new ArrayList<>(List.of(RomanEnum.values()));
    Collections.reverse(romanEnums);

    while (number > 0)
      for (RomanEnum romanEnum : romanEnums) {
        if (number + 1 >= romanEnum.getValue() && romanEnum.check(number)) { // TODO: Сделать правельный parse
          result += "I" + romanEnum.name();
          number -= romanEnum.getValue() + 1;
        } else if (number >= romanEnum.getValue()) {
          result += romanEnum.name();
          number -= romanEnum.getValue();
        }
      }

    return result;
  }

  public static boolean isRoman(String roman) {
    for (RomanEnum romanEnum : RomanEnum.values())
      if (roman.contains(romanEnum.name()))
        return true;

    return false;
  }
}
