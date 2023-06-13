package com.pixeldv.discretes;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import org.jetbrains.annotations.NotNull;

public final class LexicographicOrder {
  private LexicographicOrder() { }

  public static char lower(final char c) {
    if (c >= 'A' && c <= 'Z') {
      return (char) (c + 32);
    }
    return c;
  }

  public static int compare(final @NotNull String a, final @NotNull String b) {
    final int length = Math.min(a.length(), b.length());
    for (int i = 0; i < length; i++) {
      final char aChar = lower(a.charAt(i));
      final char bChar = lower(b.charAt(i));
      if (aChar != bChar) {
        return aChar - bChar;
      }
    }
    return a.length() - b.length();
  }

  public static @NotNull List<String> sort(final @NotNull List<String> list) {
    final List<String> sorted = new ArrayList<>(list.size());
    final List<String> unsorted = new ArrayList<>(list);
    while (!unsorted.isEmpty()) {
      String min = unsorted.get(0);
      for (final String comparing : unsorted) {
        if (compare(comparing, min) < 0) {
          min = comparing;
        }
      }
      sorted.add(min);
      unsorted.remove(min);
    }
    return sorted;
  }

  public static int largestWordLength(final @NotNull List<String> list) {
    int max = 0;
    for (final String word : list) {
      if (word.length() > max) {
        max = word.length();
      }
    }
    return max;
  }

  public static void main(final @NotNull String[] args) {
    final var scanner = new Scanner(System.in);
    System.out.println(
      """
      -=-= Bienvenido =-=-
      Este programa aplica el algoritmo de ordenamiento lexicográfico
      a una lista de palabras, donde se ordenan de menor a mayor.
      """);
    var n = 0;
    while (n <= 0) {
      System.out.print("Ingresa el número de palabras a ordenar \n>> ");
      n = scanner.nextInt();
    }
    final var list = new ArrayList<String>(n);
    for (int i = 0; i < n; i++) {
      System.out.print("Ingresa la palabra #" + (i + 1) + "\n>> ");
      list.add(scanner.next());
    }
    final var builder = new StringBuilder();
    builder.append("\n-=-= Lista de palabras (original - ordenada) =-=-\n");
    final var max = largestWordLength(list);
    final var sorted = sort(list);
    for (int i = 0; i < n; i++) {
      final var word = list.get(i);
      final var sortedWord = sorted.get(i);
      builder.append(word)
        .append(" ".repeat(max - word.length() + 3))
        .append(" | ")
        .append(sortedWord)
        .append("\n");
    }
    builder.append("-=".repeat(max + 3));
    System.out.println(builder);
  }
}
