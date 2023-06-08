package com.pixeldv.discretes;

import java.util.Scanner;

public class Relations {
  private static final String SUBINDEX = "₀₁₂₃₄₅₆₇₈₉";

  public static void main(String[] args) {
    final var scanner = new Scanner(System.in);
    System.out.println(
      """
      -=-= Bienvenido =-=-
      Este programa muestra las relaciones a partir de dos
      números n y m, donde n es el módulo y m es el número
      al que x + y es congruente.
      [x]n R [y]n <=> [x + y]n = [m]n
      """
    );
    System.out.print("Ingresa el módulo n \n>> ");
    final var n = scanner.nextInt();
    System.out.print("Ingresa el número m \n>> ");
    final var m = scanner.nextInt();
    final var builder = new StringBuilder();
    builder.append("-=-= Relaciones =-=-\n");
    final var subindex = subindexOf(n);
    for (var x = 0; x < n; x++) {
      for (var y = 0; y < n; y++) {
        if ((x + y) % n == m) {
          builder.append("[")
            .append(x)
            .append("]")
            .append(subindex)
            .append(" ====> [")
            .append(y)
            .append("]")
            .append(subindex)
            .append("\n");
        }
      }
    }
    System.out.println(builder);
  }

  public static String subindexOf(int number) {
    final var builder = new StringBuilder();
    while (number > 0) {
      final var digit = number % 10;
      builder.insert(0, SUBINDEX.charAt(digit));
      number /= 10;
    }
    return builder.toString();
  }
}
