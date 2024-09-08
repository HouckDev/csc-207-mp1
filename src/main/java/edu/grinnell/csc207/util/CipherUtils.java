package edu.grinnell.csc207.util;

public class CipherUtils {
  private static int letter2int(char letter) {
    return letter - '0'; // return the ascii id of letter
  }

  private static char int2letter(int i) {
    return (char) i; // convert int to ascii
  }

  public static String caesarEncrypt(String str, char letter) {
    String newStr = "";
    for (int i = 0; i < str.length(); i++) {
      newStr = newStr + int2letter(letter2int(str.charAt(i)));
    }
    return str; // STUB
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
