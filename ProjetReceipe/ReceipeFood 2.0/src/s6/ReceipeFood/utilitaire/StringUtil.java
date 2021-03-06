package s6.ReceipeFood.utilitaire;
import java.security.Key;
import java.text.DateFormat;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Date;
import java.util.Locale;

import javax.crypto.*;
import javax.crypto.spec.SecretKeySpec;

import sun.misc.*;
public class StringUtil {
	
	public static boolean fullLetter(String string){
		boolean isLetter=true;
		int i=0;
		while(isLetter&&i<string.length()){
			isLetter = Character.isLetter(string.charAt(i));
			if(Character.isSpaceChar(string.charAt(i)))isLetter = true;
			i++;
		}
		return isLetter;
	}
	public static boolean fullNumber(String string){
		boolean isNumber=true;
		int i=0;
		while(isNumber&&i<string.length()){
			isNumber = Character.isDigit(string.charAt(i));
			i++;
		}
		return isNumber;
	}
	public static boolean isEmail(String string){
		String [] split1 = string.split("@");
		if(split1.length != 2){
			return false;
		}
		String [] split2 = split1[1].split("\\.");
		if(split2.length != 2){
			return false;
		}
		return true;
	}
	public static boolean isTelephone(String string){
		if(string.startsWith("\\+")){
			return fullNumber(string.substring(1));
		}
		return fullNumber(string.substring(1));
	}
	public static boolean correctMdp(String string){
		
		int compteurMaj = 0;
		int compteurDigit = 0;
		int compteurSpec = 0;
		int i = 0;
		while(i<string.length()){
			char c = string.charAt(i);
			int cint = (int)c;
			if(Character.isDigit(c)){
				compteurDigit ++;
			}
			if(Character.isUpperCase(c)){
				compteurMaj ++;
			}
			if(cint <48 || (cint > 57 && cint < 65) || (cint > 90 && cint < 97) || cint > 122)
		    {
				compteurSpec ++;
		    }
		}
		return compteurMaj>0&&compteurDigit>0&&compteurSpec>0&&string.length()>=8;
	}
	
	
//	 static final String ALGO = "AES";
//	 static final byte[] keyValue = new byte[] { 'T', 'h', 'e', 'B', 'e', 's', 't',
//	'S', 'e', 'c', 'r','e', 't', 'K', 'e', 'y' };
//	public static String encrypt(String Data) throws Exception {
//        Key key = generateKey();
//        Cipher c = Cipher.getInstance(ALGO);
//        c.init(Cipher.ENCRYPT_MODE, key);
//        byte[] encVal = c.doFinal(Data.getBytes());
//        String encryptedValue = new BASE64Encoder().encode(encVal);
//        return encryptedValue;
//    }
//
//    public static String decrypt(String encryptedData) throws Exception {
//        Key key = generateKey();
//        Cipher c = Cipher.getInstance(ALGO);
//        c.init(Cipher.DECRYPT_MODE, key);
//        byte[] decordedValue = new BASE64Decoder().decodeBuffer(encryptedData);
//        byte[] decValue = c.doFinal(decordedValue);
//        String decryptedValue = new String(decValue);
//        return decryptedValue;
//    }
//    public static Key generateKey() throws Exception {
//        Key key = new SecretKeySpec(keyValue, ALGO);
//        return key;
//    }
    public static LocalTime stringToTime(String heure, String minute){
    	return LocalTime.of(Integer.valueOf(heure), Integer.valueOf(minute));
    }
    public static String formatISO(String iso){
    	return formatDateTime(LocalDateTime.parse(iso, DateTimeFormatter.RFC_1123_DATE_TIME));
    }
    public static String formatDateTime(LocalDateTime local){
    	return DateTimeFormatter.ofLocalizedDate(FormatStyle.FULL).format(local.toLocalDate())+" \u00e0 "+
    			DateTimeFormatter.ofLocalizedTime(FormatStyle.MEDIUM).format(local.toLocalTime());
    }
    public static String formatDateSimple(Date local){
    	return DateFormat.getDateTimeInstance(DateFormat.FULL, DateFormat.SHORT, Locale.FRANCE).format(local);
    }
}
