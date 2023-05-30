package com.pixeldv.discretes;

import java.util.Scanner;

public final class Bezout {
  private Bezout() {
    throw new UnsupportedOperationException("This is a utility class and cannot be instantiated");
  }

  public static void start() {
    final var scanner = new Scanner(System.in);
    System.out.println(
      """
      -=-= Bienvenido =-=-
      Este programa aplica el algoritmo de Euclides
      para obtener el Máximo Común Divisor y posteriormente
      obtener los coeficientes de Bezout.
      """
    );
    var a = 0L;
    var b = 0L;
    do {
      System.out.print("Ingresa el número 'a'\n>> ");
      a = scanner.nextLong();
    } while (a < 0);
    do {
      System.out.print("Ingresa el número 'b'\n>> ");
      b = scanner.nextLong();
    } while (b < 0);
    if (a == 0 && b == 0) {
      System.out.printf("No se puede calcular el MCD de %d y %d porque no está definido.", a, b);
      return;
    }
    final var euclidesBuilder = new StringBuilder();
    euclidesBuilder.append("-+-+-+-+-+-+-+-+-+ Euclides +-+-+-+-+-+-+-+-+-\n");
    final var bezoutBuilder = new StringBuilder();
    bezoutBuilder.append("-+-+-+-+-+-+-+-+-+ Bezout +-+-+-+-+-+-+-+-+-\n");
    if (b == 0) {
      euclidesBuilder.append(String.format("%d = %d(%d) + %d%n", a, b, 0, a))
        .append(String.format("MCD(%d, %d) = %d%n", a, b, a))
        .append("-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-\n");
      bezoutBuilder.append(String.format("%d = %d(%d) + %d(%d)", a, a, 1, b, 0))
        .append("\nx = 1, y = 0")
        .append("\n-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-\n");
      System.out.println(euclidesBuilder);
      System.out.println(bezoutBuilder);
      return;
    } else if (a == 0) {
      euclidesBuilder.append(String.format("%d = %d(%d) + %d%n", b, a, 0, b))
        .append(String.format("MCD(%d, %d) = %d%n", a, b, b))
        .append("-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-\n");
      bezoutBuilder.append(String.format("%d = %d(%d) + %d(%d)%n", b, a, 0, b, 1))
        .append("x = 0, y = 1")
        .append("\n-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-\n");
      System.out.println(euclidesBuilder);
      System.out.println(bezoutBuilder);
      return;
    } else if (a % b == 0) {
      final var quotient = a / b;
      final var remainder = a % b;
      euclidesBuilder.append(String.format("%d = %d(%d) + %d%n", a, b, quotient, remainder))
        .append(String.format("MCD(%d, %d) = %d%n", a, b, b))
        .append("-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-\n");
      bezoutBuilder.append(String.format("%d = %d(%d) + %d(%d)%n", b, a, 0, b, 1))
        .append("x = 0, y = 1")
        .append("\n-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-\n");
      System.out.println(euclidesBuilder);
      System.out.println(bezoutBuilder);
      return;
    }
    var dividend = a;
    var divisor = b;
    var x = 1L;
    var y = 0L;
    var nextX = 0L;
    var nextY = 1L;
    var remainder = dividend % divisor;
    while (remainder > 0) {
      final var quotient = dividend / divisor;
      remainder = dividend % divisor;
      euclidesBuilder.append(String.format("%d = %d(%d) + %d%n", dividend, divisor, quotient, remainder));
      final var x2 = x - quotient * nextX;
      final var y2 = y - quotient * nextY;
      dividend = divisor;
      divisor = remainder;
      x = nextX;
      y = nextY;
      nextX = x2;
      nextY = y2;
      bezoutBuilder.append(String.format("%d(%d) + %d(%d) = %d%n", a, x, b, y, remainder));
    }
    euclidesBuilder.append("\n")
      .append(String.format("MCD(%d, %d) = %d%n", a, b, dividend))
      .append("-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-\n");
    final var bezoutResult = a * x + b * y;
    bezoutBuilder.append("\n")
      .append(String.format("%d(%d) + %d(%d) = %d%n", a, x, b, y, dividend))
      .append(String.format("%d = %d%n", bezoutResult, dividend))
      .append(String.format("x = %d, y = %d%n", x, y))
      .append("-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-\n");
    System.out.println(euclidesBuilder);
    System.out.println(bezoutBuilder);
  }
}
