package basicLogic;

import animals.animal;

import java.util.ArrayList;

public class stringConversion {
    public static ArrayList<String> StringConversion(String string){
        ArrayList<String> arrayList = new ArrayList<>();
        int j = 0;
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < string.length(); i++){
            char s = string.charAt(i);
            if (s == ' ' && j != 0){
                arrayList.add(stringBuilder.toString());
                stringBuilder = new StringBuilder();
                j = 0;
            } else{
                if (s == '.' || s == '/' || s == ':' || s == ';' || s == '"' || s == '{'
                        || s == '}' || s == '[' || s == ']' || s == '+' || s == '='
                        || s == '_' || s == ')' || s == '(' || s == '*' || s == '&' || s == '?'
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
}
