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
      
      int[] array = {1,1,1,0,0};
      //Encrypt.setKey("Beispielangriff.txt");
      Encrypt.setKey("kryptochallengegruppe10.txt");
      
      Encrypt.gaussianElimination(Encrypt.create(43));
      
      
      //Encrypt.setMessage(array);
      //chitext = Encrypt.runEncryption();
      
      //Encrypt.printPk();
      //System.out.println("Klar1" +Arrays.toString(array));
      //System.out.println("Chi1" +Arrays.toString(chitext));
      
      //Encrypt.createMatrixLine(array, chitext);
    
/*
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
       
       */
       
       //Encrypt.create(43);
       
       
       int[][] test = {
    		  
    		   {1,0,1,1,0},
    		   {1,0,1,0,0},
    		   {1,0,0,1,0},
    		   {1,0,0,0,1},
    		   {0,0,1,0,1},
    		  
       };
       
       
       int[][] test2 = {
    		   			
    		   			{1,1,1,0,0,1,1,1,0,0,0,0,0,0,0,1,1,1,0,0,1,1,1,0 ,0},
    		   			{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
    		   			{1,0,0,0,1,1,0,0,0,1,1,0,0,0,1,0,0,0,0,0,0,0,0,0,0},
    		   		   {1, 1, 1, 0, 1, 0, 0, 0, 0, 0, 1, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,},
    				   {0 ,0 , 0 ,0 , 0 , 0 , 0 , 0 , 1 , 0 , 0 , 0 , 0,0,0,0,0,0,1,0,0,0, 0, 0,0},
    				   {0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0},
    				   {0 ,0 ,0 ,0 ,0 ,0 ,0 ,0 ,1 ,1 ,0 ,0 ,0 ,1 ,1 ,0 ,0 ,0, 1, 1, 0, 0, 0, 1, 1},
    				   {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 1},
    				   {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 1},
    				   {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 ,0, 0, 0, 0, 0, 0, 0, 0, 0},
    				   {0, 0, 0, 0 ,0 ,1, 1, 1, 1, 0, 1, 1, 1, 1, 0 ,0, 0, 0, 0, 0, 1, 1, 1, 1, 0},
    				   {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
    				   {1, 0, 0, 1, 0, 1, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
    				   {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
    				   {0,0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 1, 1, 1, 0, 0, 1, 1, 1, 0},
    				   {1, 1, 0, 1, 0, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0},
    				   {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
    				   {1, 0, 0, 0, 0, 0, 0, 0 ,0 ,0, 0, 0 ,0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
    				   {0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 1, 1, 0 ,0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
    				   {0 ,0, 1, 1, 0 ,0, 0, 0, 0, 0, 0 ,0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0, 0, 0},
    				   {0, 0, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0, 0, 0},
    				   {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 1, 1, 0 ,1, 0, 1, 1},
    				   {0, 0, 0, 0, 0, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 ,0, 1, 0, 1 ,0, 0},
    				   {1, 1, 0, 0, 0, 1, 1, 0, 0, 0, 1, 1, 0, 0, 0, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0},
    				   {0, 0, 1 ,0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1 ,0, 0, 0, 0, 1, 0, 0},
    				   {1, 1, 0, 1 ,0 ,1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0},
    				   {0, 0, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0, 0, 0},
    				   {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
    				   {1, 0, 1, 1, 1, 0, 0, 0, 0, 0, 1, 0, 1, 1, 1, 1, 0, 1, 1, 1, 1, 0, 1 ,1, 1},
    				   {1, 1, 0, 1, 0, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0},
    				   {0,0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 1, 1, 0, 0, 0, 1, 1, 0, 0, 0, 1, 1},
    				   {0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0},
    				   {0, 0, 0, 0, 0, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 1, 0, 0},
    				   {0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0},
    				   {0 ,0 ,0 ,0 ,0 ,0 ,0 ,0 ,1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0},
    				   {1, 0, 0, 1, 1, 1, 0, 0, 1, 1, 0 ,0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 1, 1},
    				   {1, 0, 0, 0, 1, 1, 0, 0, 0, 1, 1, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
    				   {1, 0, 0, 1, 1, 1, 0 ,0 ,1 ,1 ,0 ,0 ,0 ,0 ,0 ,0 ,0 ,0 ,0 ,0 ,1, 0, 0, 1, 1},
    				   {0, 0, 0, 0, 0, 1, 0, 1, 1, 0, 1, 0, 1, 1, 0, 1, 0, 1, 1, 0, 0, 0, 0, 0, 0},
    				   {0, 0, 0, 0, 1, 1, 0, 0 ,1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
    				   {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 1, 1, 0, 0, 0, 0, 0 ,0 ,0 ,0, 0, 0},
    				   {0, 0, 0, 0, 0, 1, 1, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
    				   {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 1, 0, 0, 0, 0, 0},
    				   {1, 0, 0, 0, 1, 1, 0, 0, 0, 1, 1, 0 ,0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
    				   {1, 1, 1, 0, 1, 0, 0, 0, 0, 0, 1, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
    				   {0, 0, 1, 1, 1, 0 ,0, 0, 0, 0, 0, 0, 1, 1, 1, 0 ,0 ,0 ,0, 0, 0, 0, 1, 1, 1},
    				   {0, 0, 0, 0, 0, 1, 1, 1, 1, 0, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 0},
    				   {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
    				   {0, 0, 0, 0, 0, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 1, 0, 0},
    				   {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 ,0 ,0 ,0 ,0 ,0 ,0 ,1 ,0 ,0 ,1},
       };
       
       
       
       
       
       
       
       
       
       String test1 = "x_4*x_15";
       String test3 = "x_7*x_8";
       String test4 = "x_43*x_42";
       
       //Encrypt.getValueFromArray("x_1");
       
      // System.out.println(Encrypt.doShit(test1));
       //System.out.println(Encrypt.doShit(test4));
     //  System.out.println(Encrypt.doShit(test3));
       
       //Encrypt.gaussianElimination(test);
       //Encrypt.gaussianElimination(test2);
       
       
       //Encrypt.printPk();
       
     
       
       
       
       
       
       
       
       
       
       
    }

}
