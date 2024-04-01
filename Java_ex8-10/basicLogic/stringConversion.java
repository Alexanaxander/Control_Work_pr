package basicLogic;

import java.util.ArrayList;

public class stringConversion {
    public static ArrayList<String> StringConversion(String string){
        ArrayList<String> arrayList = new ArrayList<>();
        int j = 0;
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < string.length(); i++){
            char s = string.charAt(i);
            if ((s == ' ' || i == string.length() - 1) && j != 0){
                if (i == string.length() - 1){
                    stringBuilder.append(string.charAt(i));
                }
                arrayList.add(stringBuilder.toString());
                stringBuilder = new StringBuilder();
                j = 0;
            } else{
                if (s == '.' || s == '/' || s == ':' || s == ';' || s == '"' || s == '{'
                        || s == '}' || s == '[' || s == ']' || s == '+' || s == '='
                        || s == '*' || s == '&' || s == '?' || s == ' '
                        || s == '^' || s == '%' || s == '$' || s == '#' || s == '№' || s == '@'
                        || s == '!' || s == '~' || s == '\\' || s == '|') {
                } else {
                    stringBuilder.append(string.charAt(i));
                    j++;
                }
            }
        }
        return arrayList;
    }
    public static ArrayList<String> StringConversionCommands(String string){
        ArrayList<String> arrayList = new ArrayList<>();
        int j = 0;
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < string.length(); i++){
            char s = string.charAt(i);
            if ((s == ',' || i == string.length() - 1) && j != 0){
                if (i == string.length() - 1){
                    stringBuilder.append(string.charAt(i));
                }
                arrayList.add(stringBuilder.toString());
                stringBuilder = new StringBuilder();
                j = 0;
            } else{
                stringBuilder.append(string.charAt(i));
                j++;
            }
        }
        return arrayList;
    }

}
