package com.pixeldv.primes;

import java.math.BigInteger;
import java.util.Random;
import java.util.Scanner;
import org.jetbrains.annotations.NotNull;

public final class Primes {
  private static final Random RANDOM = new Random();

  private Primes() {
    throw new UnsupportedOperationException("This class cannot be instantiated");
  }

  public static boolean isPrime(final @NotNull BigInteger number, final int certainty) {
    final var absolute = number.abs();
    if (absolute.equals(BigInteger.TWO)) {
      return true;
    }
    if (!absolute.testBit(0) || absolute.equals(BigInteger.ONE)) {
      return false;
    }
    final var iterations = (Math.min(certainty, Integer.MAX_VALUE - 1) + 1) / 2;
    final var rounds = Math.min(iterations, 50);
    // Find a and m such that m is odd and this == 1 + 2**a * m
    final var thisMinusOne = absolute.subtract(BigInteger.ONE);
    var numberBefore = thisMinusOne;
    final var lowestSetBit = numberBefore.getLowestSetBit();
    numberBefore = numberBefore.shiftRight(lowestSetBit);
    for (int i = 0; i < rounds; i++) {
      // Generate a uniform random on (1, this)
      BigInteger b;
      do {
        b = new BigInteger(absolute.bitLength(), RANDOM);
      } while (b.compareTo(BigInteger.ONE) <= 0 || b.compareTo(absolute) >= 0);
      var j = 0;
      var z = b.modPow(numberBefore, absolute);
      while (!((j == 0 && z.equals(BigInteger.ONE)) || z.equals(thisMinusOne))) {
        if (j > 0 && z.equals(BigInteger.ONE) || ++j == lowestSetBit) {
          return false;
        }
        z = z.modPow(BigInteger.TWO, absolute);
      }
    }
    return true;
  }

  public static void main(final @NotNull String[] args) {
    final var scanner = new Scanner(System.in);
    System.out.println(
      """
      -=-= Bienvenido =-=-
      Este programa verifica si un número es primo o no.
      Puedes ingresar un número muy grande y el programa lo verificará.
      Mientras más grande sea el número, más tiempo tardará el programa en verificarlo.
      Sin embargo, el programa está optimizado para verificar números grandes.

      Ingresa un número para verificar si es primo:"""
    );
    System.out.print(">> ");
    final var number = scanner.nextBigInteger();
    final var start = System.currentTimeMillis();
    final var isPrime = isPrime(number, 25);
    final var end = System.currentTimeMillis();
    if (isPrime) {
      System.out.println("¡El número es primo!");
    } else {
      System.out.println("El número no es primo.");
    }
    System.out.printf("Tiempo de ejecución: %dms%n", end - start);
  }
}
