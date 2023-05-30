package com.pixeldv.discretes;

import java.util.Scanner;

public final class LeastCommonMultiple {
  private LeastCommonMultiple() {
    throw new UnsupportedOperationException("This is a utility class and cannot be instantiated");
  }

  public static long calculate(final long a, final long b) {
    return (a * b) / GreatestCommonDivisor.calculate(a, b);
  }

  public static void start() {
    final var scanner = new Scanner(System.in);
    System.out.println(
      """
      -=-= Bienvenido =-=-
      Este programa calcula el MCM de dos números.
      """
    );
    var a = 0L;
    var b = 0L;
    do {
      System.out.print("Ingresa el primer número\n>> ");
      a = scanner.nextLong();
    } while (a < 0);
    do {
      System.out.print("Ingresa el segundo número\n>> ");
      b = scanner.nextLong();
    } while (b < 0);
    System.out.printf("El MCM de %d y %d es %d\n", a, b, calculate(a, b));
  }
}
