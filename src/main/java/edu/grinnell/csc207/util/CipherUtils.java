package edu.grinnell.csc207.util;

public class CipherUtils {
  private static int letter2int(char letter) {
    return (int) letter; // return the ascii id of letter
  }

  private static char int2letter(int i) {
    return (char) i; // convert int to ascii
  }

  // this could be done more cleanly, but it works
  private static char addLetters(char a, char b) {
    return int2letter((((letter2int(a) - 97) + (letter2int(b) - 97)) % 26) + 97); // add ascii codes, wrap around alphabet
  }

  private static char subtractLetters(char a, char b) {
    return int2letter((((letter2int(a) - 97) - (letter2int(b) - 97)) % 26) + 97); // add ascii codes, wrap around alphabet
  }

  public static String caesarEncrypt(String str, char letter) {
    String newStr = "";
    for (int i = 0; i < str.length(); i++) {
      newStr = newStr + addLetters(str.charAt(i), letter); // mathmatically add current letter and key letter, add to working string
    }
    return newStr;
  }

  public static String caesarDecrypt(String str, char letter) {
    String newStr = "";
    for (int i = 0; i < str.length(); i++) {
      newStr = newStr + subtractLetters(str.charAt(i), letter); // mathmatically subtract current letter and key letter, add to working string
    }
    return newStr;
  }

  public static String vigenereEncrypt(String str, String key) {
    return str; // STUB
  }

  public static String vigenereDecrypt(String str, String key) {
    return str;
  }
}
