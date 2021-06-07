public class StringManipulator{
    public String trimAndConcat(String s, String s1){
        String newStr = s.trim() + s1.trim();
        return newStr;
    }

    public Integer getIndexOrNull(String str, char c){
        int res = str.indexOf(c);
        return res == -1 ? null : res;
    }

    public Integer getIndexOrNull(String word, String subString){
        int res = word.indexOf(subString);
        return res == -1 ? null : res;
    }

    public String concatSubstring(String stringOne, int indexOne, int indexTwo, String stringTwo){
        return stringOne.substring(indexOne,indexTwo) + stringTwo;
    }
}