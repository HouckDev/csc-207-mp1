package edu.grinnell.csc207.util;

public class CipherUtils {
  public static final int ALPHABET_LENGTH = 26;
  public static final int ASCII_OFFSET = 97;

  /**
   * letter2int
   * Converts a Char (letter) into an int.
   * 
   * @param letter
   * @return
   */
  private static int letter2int(char letter) {
    return (int) letter - ASCII_OFFSET; // return the ascii id of letter
  } // letter2int

  /**
   * int2letter
   * Converts an int (i) into its ascii character.
   * 
   * @param i
   * @return
   */
  private static char int2letter(int i) {
    return (char) (i + ASCII_OFFSET); // convert int to ascii
  } // int2letter

  /**
   * addLetters
   * Numerically adds two Chars (a,b) applies alphabetical wrapping, returns
   * result as a Char.
   * 
   * @param a
   * @param b
   * @return
   */
  private static char addLetters(char a, char b) {
    return int2letter(((letter2int(a) + letter2int(b)) + ALPHABET_LENGTH) % ALPHABET_LENGTH); // add ascii codes, wrap
                                                                                              // around alphabet
  } // addLetters

  /**
   * addLetters
   * Numerically subtracts two Chars (a,b) applies alphabetical wrapping, returns
   * result as a Char.
   * 
   * @param a
   * @param b
   * @return
   */
  private static char subtractLetters(char a, char b) {
    return int2letter(((letter2int(a) - letter2int(b)) + ALPHABET_LENGTH) % ALPHABET_LENGTH); // add ascii codes, wrap
                                                                                              // around alphabet
  } // subtractLetters

  /**
   * caesarEncrypt
   * Returns an encrypted String by using a caesar shift on String (str) using the
   * shift based on Char (letter).
   * 
   * @param str
   * @param letter
   * @return
   */
  public static String caesarEncrypt(String str, char letter) {
    String newStr = "";
    for (int i = 0; i < str.length(); i++) {
      newStr = newStr + addLetters(str.charAt(i), letter); // mathmatically add current letter and key letter, add to
                                                           // working string
    } // for str.length
    return newStr;
  } // caesarEncrypt

  /**
   * caesarDecrypt
   * Returns an decrypted String by using a caesar shift on String (str) using the
   * reverse shift based on Char (letter).
   * 
   * @param str
   * @param letter
   * @return
   */
  public static String caesarDecrypt(String str, char letter) {
    String newStr = "";
    for (int i = 0; i < str.length(); i++) {
      newStr = newStr + subtractLetters(str.charAt(i), letter); // mathmatically subtract current letter and key letter,
                                                                // add to working string
    } // for str.length
    return newStr;
  } // caesarDecrypt

  /**
   * vigenereEncrypt
   * Returns an encrypted String by using a vigenere cipher on String (str) using
   * the shift based on String (key).
   * Each letter is caesar shifted based on a corresponding character in the key
   * string.
   * 
   * @param str
   * @param letter
   * @return
   */
  public static String vigenereEncrypt(String str, String key) {
    String newStr = "";
    for (int i = 0; i < str.length(); i++) {
      newStr = newStr + addLetters(str.charAt(i), key.charAt(i % (key.length()))); // mathmatically add current letter
                                                                                   // and key letter, add to working
                                                                                   // string
    } // for str.length
    return newStr;
  } // vigenereEncrypt

  /**
   * vigenereDecrypt
   * Returns an decrypted String by using a vigenere cipher on String (str) using
   * the reverse shift based on String (key).
   * Each letter is caesar shifted based on a corresponding character in the key
   * string.
   * 
   * @param str
   * @param letter
   * @return
   */
  public static String vigenereDecrypt(String str, String key) {
    String newStr = "";
    for (int i = 0; i < str.length(); i++) {
      newStr = newStr + subtractLetters(str.charAt(i), key.charAt(i % (key.length()))); // mathmatically add current
                                                                                        // letter and key letter, add to
                                                                                        // working string
    } // for str.length
    return newStr;
  } // vigenereDecrypt

  /**
   * isValidString
   * Iterates through a String (str), checks each character and tests if it is
   * valid for encryptiong (not whitespace, is lowercase).
   * 
   * @param str
   * @return
   */
  public static boolean isValidString(String str) {
    for (int i = 0; i < str.length(); i++) {
      if (Character.isUpperCase(str.charAt(i)) || Character.isWhitespace(str.charAt(i))) {
        return false;
      } // if
    } // for str.length
    return true;
  } // isValidString
} // CipherUtils
