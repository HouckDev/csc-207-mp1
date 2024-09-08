package edu.grinnell.csc207.util;

public class CipherUtils {
  private static int letter2int(char letter) {
    return letter - '0'; // return the ascii id of letter
  }

  private static char int2letter(int i) {
    return (char) i; // convert int to ascii
  }
  private static char addLetters(char a, char b) {
    return int2letter(((letter2int(a) + letter2int(b) - 49) % 26) + 49); // add ascii codes, wrap around alphabet
  }

  public static String caesarEncrypt(String str, char letter) {
    String newStr = "";
    for (int i = 0; i < str.length(); i++) {
      newStr = newStr + addLetters(str.charAt(i), letter);
    }
    return newStr; // STUB
  }

  public static String caesarDecrypt(String str, char letter) {
    return str; // STUB
  }

  public static String vigenereEncrypt(String str, String key) {
    return str; // STUB
  }

  public static String vigenereDecrypt(String str, String key) {
    return str;
  }
}
