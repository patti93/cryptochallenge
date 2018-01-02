package src;

import java.io.IOException;
import java.util.Arrays;

public class Crypto_attack {

   public static void main(String[] args) throws IOException {
	// TODO Auto-generated method stub
       
      int[] message = { 0, 1, 1, 0, 0, 1, 1, 1, 1, 1, 0, 0, 0, 1, 0, 1, 1, 0, 0, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0,
		    0, 0, 0, 1, 1, 0, 1, 1, 0, 0, 1 };
      int[] message1 = { 0, 1, 1, 0, 0, 1, 1, 1, 1, 1, 0, 0, 0, 1, 0, 1, 1, 0, 0, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0,
		    0, 0, 0, 1, 1, 0, 1, 1, 0, 0, 0 };
      int[] message2 = { 0, 1, 1, 0, 0, 1, 1, 1, 1, 1, 0, 0, 0, 1, 0, 1, 1, 0, 0, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0,
		    0, 0, 0, 1, 1, 0, 1, 1, 0, 1, 1 };
      int[] chitext;
      Encrypt.setKey("kryptochallengegruppe10.txt");
      Encrypt.setMessage(message);

       chitext= Encrypt.runEncryption();
       System.out.println("Klar1" +Arrays.toString(message));
       System.out.println("Chi1" +Arrays.toString(chitext));
       
      Encrypt.setMessage(message1);

       chitext= Encrypt.runEncryption();
       System.out.println("Klar2" +Arrays.toString(message1));
       System.out.println("Chi2" +Arrays.toString(chitext));
       
      Encrypt.setMessage(message2);

       chitext= Encrypt.runEncryption();
       System.out.println("Klar3" +Arrays.toString(message2));
       System.out.println("Chi3" +Arrays.toString(chitext));
       
       
       
       Encrypt.create(43);
       
       
       
       
       
       
       
    }

}
