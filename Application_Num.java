package SAMPLE;

import java.security.SecureRandom;

public class Application_Num {
	public static String generateRandomPassword(int len)
    {
        final String chars ="ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
      
    	SecureRandom random = new SecureRandom();
       // StringBuilder sb = new StringBuilder();
        StringBuilder sb1 = new StringBuilder("VAC19");
        for (int i = 0; i < len; i++)
        {
            int randomIndex = random.nextInt(chars.length());
            sb1.append(chars.charAt(randomIndex));
           // sb1.append(sb);
        }
       
        return sb1.toString();
    }
public static void app()  {
	String app= generateRandomPassword(8);
    System.out.println("Your Application number :"+app);
	//generateRandomPassword(8);
	}
public static void main(String[] args) {
	app();
}
}
