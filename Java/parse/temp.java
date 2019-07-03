//import java.math.BigInteger;
//
//public class temp {
//
//    public static String performBitPermutation(String string)
//    {
//        String ret = "";
//
//        if (string.length() != 16)
//        {
//            throw new Error("ERROR IN BIT PERMUTATION: STRING IS NOT LENGTH 16");
//        }
//
//        else
//        {
//            for (int i = 0; i < 4; i++)
//            {
//                ret +=
//                        Character.toString(string.charAt(i))
//                                + Character.toString(string.charAt(i + 4))
//                                + Character.toString(string.charAt(i + 8))
//                                + Character.toString(string.charAt(i + 12));
//            }
//        }
//        return ret;
//    }
//
//    public static String sBox(String hexadecimalString)
//    {
//        String ret = "";
//
//        for (int i = 0; i < 4; i++)
//        {
//            switch (hexadecimalString.charAt(i))
//            {
//                case '0':
//                    ret += "E";
//                    break;
//
//                case '1':
//                    ret += "4";
//                    break;
//
//                case '2':
//                    ret += "D";
//                    break;
//
//                case '3':
//                    ret += "1";
//                    break;
//
//                case '4':
//                    ret += "2";
//                    break;
//
//                case '5':
//                    ret += "F";
//                    break;
//
//                case '6':
//                    ret += "B";
//                    break;
//
//                case '7':
//                    ret += "8";
//                    break;
//
//                case '8':
//                    ret += "3";
//                    break;
//
//                case '9':
//                    ret += "A";
//                    break;
//
//                case 'A':
//                    ret += "6";
//                    break;
//
//                case 'B':
//                    ret += "C";
//                    break;
//
//                case 'C':
//                    ret += "5";
//                    break;
//
//                case 'D':
//                    ret += "9";
//                    break;
//
//                case 'E':
//                    ret += "0";
//                    break;
//
//                case 'F':
//                    ret += "7";
//                    break;
//            }
//
//        }
//
//        return ret;
//    }
//
//    public static String performXOR(String string1, String string2)
//    {
//        String ret = "";
//
//        for (int i = 0; i < 16; i++)
//            ret += string1.charAt(i) ^ string2.charAt(i);
//
//        return ret;
//    }
//
//    public static String binaryToHexadecimal(String binaryString)
//    {
//        String ret = "";
//        String hexadecimalString =
//                new BigInteger(binaryString, 2).toString(16).toUpperCase();
//        int length = hexadecimalString.length();
//
//        while (length < 4)
//        {
//            ret += "0";
//            length++;
//        }
//        ret += hexadecimalString;
//        return ret;
//    }
//
//    public static String hexadecimalToBinary(String[] hexStringArray)
//    {
//        String ret = "";
//
//        for (String s : hexStringArray)
//            ret += hexToBin(s);
//
//        return ret;
//    }
//    public static String hexToBin(String hexadecimalString)
//    {
//        String ret = "";
//        String binaryString = new BigInteger(hexadecimalString, 16).toString(2);
//        int length = binaryString.length();
//
//        while (length < 4)
//        {
//            ret += "0";
//            length++;
//        }
//
//        ret += binaryString;
//        return ret;
//    }
//
//    public static String stringArrayToString(String[] array)
//    {
//        String ret = "";
//
//        for (String s : array)
//            ret += s;
//
//        return ret;
//    }
//
//    public static String[] stringToStringArray(String string)
//    {
//        String[] ret = new String[string.length()];
//
//        for (int i = 0; i < string.length(); i++)
//            ret[i] = Character.toString(string.charAt(i));
//
//        return ret;
//    }
//
//}
//}
