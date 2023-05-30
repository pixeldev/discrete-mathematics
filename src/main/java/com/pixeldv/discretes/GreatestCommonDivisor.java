package com.pixeldv.discretes;

public final class GreatestCommonDivisor {
  private GreatestCommonDivisor() {
    throw new UnsupportedOperationException("This is a utility class and cannot be instantiated");
  }

  public static long calculate(final long a, final long b) {
    var x = a;
    var y = b;
    while (y != 0) {
      final var r = x % y;
      x = y;
      y = r;
    }
    return x;
  }

  public static long calculate(final long a, final long b, final long c) {
    return calculate(calculate(a, b), c);
  }
}
