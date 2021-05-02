package TextFormatterModule;

public class TextFormatter {
    public static String formatText(String unformattedText)
    {
        String formattedText="";
        for (int i=0; i<unformattedText.length(); i++)
        {
            char testedChar = unformattedText.charAt(i);
            if (Character.isDigit(testedChar))
                formattedText=formattedText+testedChar;
            else if(testedChar==','||testedChar=='.')
                formattedText=formattedText+'.';
        }

        return formattedText;
    }
}