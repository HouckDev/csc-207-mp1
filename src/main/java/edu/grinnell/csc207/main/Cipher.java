package edu.grinnell.csc207.main;

import java.io.PrintWriter;
import java.util.HashMap; // import the HashMap class
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
      }
    }
    // validate program flags
    if (
      programFlags.containsKey("param_stringToEncode") && programFlags.containsKey("param_encodingKey") && // check parameters
      (programFlags.containsKey("-encode") ^ programFlags.containsKey("-decode")) && // check desired result
      (programFlags.containsKey("-caesar") ^ programFlags.containsKey("-vigenere")) // check encoding method
    ) {
      // print program flags out
      PrintWriter pen = new PrintWriter(System.out, true);
      for (int i = 0; i < args.length; i++) {
        pen.printf("args[%d] = \"%s\"\n", i, args[i]);
      }
      pen.close();
      
      // program flags validated, begin execution of program
      PrintWriter penOutput = new PrintWriter(System.out, true);
      if (programFlags.containsKey("-encode")) {
        if (programFlags.containsKey("-caesar")) {
          // encrypt text with caesar cipher
          penOutput.printf(CipherUtils.caesarEncrypt(programFlags.get("param_stringToEncode"),programFlags.get("param_encodingKey").charAt(0)));
        } else { // we know the '-vigenere' flag must be present
          // encrypt text with vigenere cipher
          penOutput.printf(CipherUtils.vigenereEncrypt(programFlags.get("param_stringToEncode"),programFlags.get("param_encodingKey")));
        }
      } else { // we know the '-decode' flag must be present, begin decoding
        if (programFlags.containsKey("-caesar")) {
          // decrypt text with caesar cipher
          penOutput.printf(CipherUtils.caesarDecrypt(programFlags.get("param_stringToEncode"),programFlags.get("param_encodingKey").charAt(0)));
        } else { // we know the '-vigenere' flag must be present
          // decrypt text with vigenere cipher
          penOutput.printf(CipherUtils.vigenereDecrypt(programFlags.get("param_stringToEncode"),programFlags.get("param_encodingKey")));
        }
      }
      
      penOutput.close();
    } else {
      System.err.println("Error: Invalid parameters");
    }
  }
}
