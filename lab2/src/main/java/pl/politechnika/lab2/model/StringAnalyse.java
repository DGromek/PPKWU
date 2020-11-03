package pl.politechnika.lab2.model;

public class StringAnalyse {

    public int uppercaseLettersCount;
    public int lowercaseLettersCount;
    public int numbersCount;
    public int specialCharactersCount;

    public StringAnalyse() {
    }

    public static StringAnalyse analyseString(String string) {
        StringAnalyse result = new StringAnalyse();
        char[] stringIntoChars = string.toCharArray();

        for (char iter : stringIntoChars) {
            if (iter >= 'A' && iter <= 'Z') {
                result.uppercaseLettersCount++;
            }
            else if (iter >= 'a' && iter <= 'z') {
                result.lowercaseLettersCount++;
            }
            else if (iter >= '0' && iter <= '9') {
                result.numbersCount++;
            }
            else {
                result.specialCharactersCount++;
            }
        }
        return result;
    }
}
