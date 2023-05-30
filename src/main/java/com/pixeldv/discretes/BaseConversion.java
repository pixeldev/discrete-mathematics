package com.pixeldv.discretes;

import java.util.Scanner;

public final class BaseConversion {
  private BaseConversion() {
    throw new UnsupportedOperationException("This is a utility class and cannot be instantiated");
  }

  public static String convertToBase(final long number, final long base, final long newBase) {
    return convertToBase(convertToDecimal(number, base), newBase);
  }

  public static long convertToDecimal(final long number, final long base) {
    var result = 0L;
    var power = 1L;
    var q = number;
    var r = 0L;
    while (q > 0) {
      r = q % 10;
      q = q / 10;
      result += r * power;
      power *= base;
    }
    return result;
  }

  public static String convertToBase(final long decimal, final long base) {
    final var result = new StringBuilder();
    var q = decimal;
    var r = 0L;
    while (q > 0) {
      r = q % base;
      q = q / base;
      result.insert(0, r + ", ");
    }
    return result.toString();
  }

  public static void start() {
    final var scanner = new Scanner(System.in);
    System.out.println(
      """
      -=-= Bienvenido =-=-
      Este programa convierte un número de una base a otra.
      """
    );
    var number = 0L;
    var baseA = 0L;
    var newBase = 0L;
    do {
      System.out.print("Ingresa el número\n>> ");
      number = scanner.nextLong();
    } while (number < 0);
    do {
      System.out.print("Ingresa el la base del número\n>> ");
      baseA = scanner.nextLong();
    } while (baseA < 0);
    do {
      System.out.print("Ingresa la nueva base\n>> ");
      newBase = scanner.nextLong();
    } while (newBase < 0);
    System.out.println("El resultado es: " + convertToBase(number, baseA, newBase));
  }
}
