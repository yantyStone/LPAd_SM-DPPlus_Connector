package com.truphone.util;


public class ToTLV {
	public static String toTLV(String tag,String input){
		if("".equals(tag))return toTLV(input);
		return tag+toTLV(input);
	}
	
    public static String toTLV(String input) {
    	int inputLen = input.length()/2;
    	String strInputLenString = toHex(String.valueOf(inputLen));
    	if (inputLen > 65535) {
			input = "83" + strInputLenString + input;
		} else if (inputLen > 255) {
			input = "82" + strInputLenString + input;
		} else if(inputLen > 127) {
			input = "81" + strInputLenString + input;
		} else {
			input = strInputLenString + input;
		}

    	return input;
    }

	private static String toHex(String num) {
		String hex = Integer.toHexString(Integer.valueOf(num));
		if (hex.length() % 2 != 0) {
			hex = "0" + hex;
		}
		return hex.toUpperCase();
	}
}
