package com.pixeldv.discretes;

import java.util.Scanner;

public final class Main {
  private Main() {
    throw new UnsupportedOperationException("This is a utility class and cannot be instantiated");
  }

  public static void main(final String[] args) {
    final var scanner = new Scanner(System.in);
    var option = 0;
    do {
      System.out.println(
        """
        -=-= Bienvenido =-=-
        1. Verificar si un número es primo.
        2. Aplicar el algoritmo de la división.
        3. Convertir un número de una base a otra.
        4. Bezout y MCD.
        5. MCM
        0. Salir.
        """
      );
      System.out.print(">> ");
      option = scanner.nextInt();
      switch (option) {
        case 1 -> Primes.start();
        case 2 -> Division.start();
        case 3 -> BaseConversion.start();
        case 4 -> Bezout.start();
        case 5 -> LeastCommonMultiple.start();
      }
    } while (option != 0);
  }
}
