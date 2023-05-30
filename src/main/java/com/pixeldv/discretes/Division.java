package com.pixeldv.discretes;

import java.util.Scanner;

public final class Division {
  private Division() {
    throw new UnsupportedOperationException("This is a utility class and cannot be instantiated");
  }

  public static void start() {
    final var scanner = new Scanner(System.in);
    System.out.println(
      """
      -=-= Bienvenido =-=-
      Este programa aplica el algoritmo de la división
      para obtener el cociente y el residuo de una división.
      """
    );
    System.out.print("Ingresa el número 'a'\n>> ");
    final var a = scanner.nextLong();
    var b = 0L;
    do {
      System.out.print("Ingresa el número 'b'\n>> ");
      b = scanner.nextLong();
    } while (b < 1);
    var quotient = a >= 0 ?
                   0 :
                   a - 1;
    var remainder = a >= 0 ?
                    a :
                    a - quotient * b;
    while ((remainder -= b) >= 0) {
      quotient++;
    }
    remainder += b;
    System.out.printf("%d = %d(%d) + %d%n", a, b, quotient, remainder);
  }
}
