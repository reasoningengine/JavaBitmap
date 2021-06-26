//Made by the ArsCyber software trademark

package JavaBitmap;

import java.io.File;
import java.io.IOException;
import java.math.BigInteger;
import java.nio.file.Files;
import java.util.ArrayList;


public class JavaBitmap {

    public static void main(String[] args) throws IOException {

        File file = new File("test.txt");

        byte[] fileContent = Files.readAllBytes(file.toPath());
        ArrayList<String> hexArray = new ArrayList<String>();
        ArrayList<String> bitValues = new ArrayList<String>();
        
        int maxLength = 25;
        String bitValueString = "";
        for(int i = 0; i < fileContent.length; i++)
        {
            String hexValue = String.format("%02X", fileContent[i]);
            
            hexArray.add(hexValue);
            bitValueString = bitValueString + new BigInteger(hexValue, 16).toString(2);
            
            if (bitValueString.length() >= maxLength)
            {
                System.out.println(bitValueString);
                bitValues.add(bitValueString);
                bitValueString = "";
            }
        }
    }
    
}
