package edu.grinnell.csc207.main;

import java.io.PrintWriter;
import java.util.HashMap; // import the HashMap class (my beloved)
import edu.grinnell.csc207.util.CipherUtils;
public class Cipher {
  public static void main(String[] args) {
    //initialize program flags
    HashMap<String, String> programFlags = new HashMap<String, String>();

    for (int i = 0; i < args.length; i++) {
      if (args[i].charAt(0) == '-') { // check if this arguement is a flag
        programFlags.put(args[i],"true");
      } else if(!programFlags.containsKey("param_stringToEncode")) { // if the arguement is not a flag, and we haven't set the encoding parameter, set the encoding parameter
        programFlags.put("param_stringToEncode",args[i]);
      } else if(!programFlags.containsKey("param_encodingKey")) { // if the arguement is not a flag, and we haven't set the key parameter, set the key parameter
        programFlags.put("param_encodingKey",args[i]);
      } else { // throw an error for too many arguements
        System.err.println("Error: Too many parameters");
        return;
      }
    } // for args

    // validate program flags
    if (
      !(
        programFlags.containsKey("param_stringToEncode") & programFlags.containsKey("param_encodingKey") & // check parameters
        ((programFlags.containsKey("-encode") ^ programFlags.containsKey("-decode")) & (programFlags.containsKey("-encode") | programFlags.containsKey("-decode"))) & // check desired result
        ((programFlags.containsKey("-caesar") ^ programFlags.containsKey("-vigenere")) & (programFlags.containsKey("-caesar") | programFlags.containsKey("-vigenere"))) // check encoding method
      )
    ) {
      System.err.println("Error: Invalid parameters");
      return;
    }
    // print program flags out
    PrintWriter pen = new PrintWriter(System.out, true);
    for (int i = 0; i < args.length; i++) {
      pen.printf("args[%d] = \"%s\"\n", i, args[i]);
    } // for args
    pen.printf("Success: Parameters valid\n");
    pen.flush();

    // validate string param
    String str = programFlags.get("param_stringToEncode");
    if (!CipherUtils.isValidString(str)) {
      System.err.println("Error: String is invalid");
      return;
    }

    // program flags validated, begin execution of program
    if (programFlags.containsKey("-encode")) {
      if (programFlags.containsKey("-caesar")) {
        // encrypt text with caesar cipher
        pen.printf("Output: Encrypted " + programFlags.get("param_stringToEncode") + " with caesar cipher, key: " + programFlags.get("param_encodingKey") + "\n");
        pen.printf(CipherUtils.caesarEncrypt(programFlags.get("param_stringToEncode"),programFlags.get("param_encodingKey").charAt(0)) + "\n");
      } else { // we know the '-vigenere' flag must be present
        // encrypt text with vigenere cipher
        pen.printf("Output: Encrypted " + programFlags.get("param_stringToEncode") + " with vigenere cipher, key: " + programFlags.get("param_encodingKey") + "\n");
        pen.printf(CipherUtils.vigenereEncrypt(programFlags.get("param_stringToEncode"),programFlags.get("param_encodingKey")) + "\n");
      }
    } else { // we know the '-decode' flag must be present, begin decoding
      if (programFlags.containsKey("-caesar")) {
        // decrypt text with caesar cipher
        pen.printf("Output: Decrypted " + programFlags.get("param_stringToEncode") + " with caesar cipher, key: " + programFlags.get("param_encodingKey") + "\n");
        pen.printf(CipherUtils.caesarDecrypt(programFlags.get("param_stringToEncode"),programFlags.get("param_encodingKey").charAt(0)) + "\n");
      } else { // we know the '-vigenere' flag must be present
        // decrypt text with vigenere cipher
        pen.printf("Output: Decrypted " + programFlags.get("param_stringToEncode") + " with vigenere cipher, key: " + programFlags.get("param_encodingKey") + "\n");
        pen.printf(CipherUtils.vigenereDecrypt(programFlags.get("param_stringToEncode"),programFlags.get("param_encodingKey") + "\n"));
      }
    }
    pen.close();
  } // class main
} // class Cipher
