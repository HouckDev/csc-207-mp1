package edu.grinnell.csc207.main;

import java.io.PrintWriter;
import java.util.HashMap; // Import hash maps

import edu.grinnell.csc207.util.CipherUtils;

public class AllCaesar {
  public static void main(String[] args) {
    //initialize program flags
    HashMap<String, String> programFlags = new HashMap<String, String>();

    for (int i = 0; i < args.length; i++) {
      if (args[i].equals("encode")) { // check if this arguement is a flag "encode"
        programFlags.put(args[i],"true");
      } else if (args[i].equals("decode")) { // check if this arguement is a flag "decode"
          programFlags.put(args[i],"true");
      } else if(!programFlags.containsKey("param_stringToEncode")) { // if the arguement is not a flag, and we haven't set the encoding parameter, set the encoding parameter
        programFlags.put("param_stringToEncode",args[i]);
      } else { // throw an error for too many arguements
        System.err.println("Error: Too many parameters");
      }
    }
    // validate program flags
    if (
      programFlags.containsKey("param_stringToEncode") && // check parameters
      (programFlags.containsKey("encode") ^ programFlags.containsKey("decode")) // check desired result
    ) {
      PrintWriter pen = new PrintWriter(System.out, true);
      String str = programFlags.get("param_stringToEncode");
      if (programFlags.containsKey("encode")) {
        for (char ch = 'a'; ch <= 'z'; ch++) {
          pen.printf("n = %c: %s\n", ch, CipherUtils.caesarEncrypt(str, ch));
        }
      } else { // assume we are decoding instead
        for (char ch = 'a'; ch <= 'z'; ch++) {
          pen.printf("n = %c: %s\n", ch, CipherUtils.caesarDecrypt(str, ch));
        }
      }
      pen.close();
    } else {
      System.err.println("Error: Invalid parameters");
    }
  }
}
