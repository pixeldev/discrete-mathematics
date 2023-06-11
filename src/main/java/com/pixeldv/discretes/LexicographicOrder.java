package com.pixeldv.discretes;

import java.util.ArrayList;
import java.util.List;
import org.jetbrains.annotations.NotNull;

public final class LexicographicOrder {
  private LexicographicOrder() { }

  public static int compare(final @NotNull String a, final @NotNull String b) {
    final int length = Math.min(a.length(), b.length());
    for (int i = 0; i < length; i++) {
      final char aChar = a.charAt(i);
      final char bChar = b.charAt(i);
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

  public static void main(String[] args) {
    final List<String> list = List.of(
      "abderitano",
      "abdicación",
      "abductor",
      "abducción",
      "abaz",
      "abdominal",
      "abdicar",
      "abdomen",
      "abazón",
      "abecedario");
    System.out.println(sort(list));
  }
}
