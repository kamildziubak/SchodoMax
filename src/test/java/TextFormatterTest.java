import TextFormatterModule.TextFormatter;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class TextFormatterTest {
    @Test
    public void formatTextTest()
    {
        assertTrue(TextFormatter.formatText("12").equals("12"));
        assertTrue(TextFormatter.formatText("12.0").equals("12.0"));
        assertTrue(TextFormatter.formatText("12,0").equals("12.0"));
        assertTrue(TextFormatter.formatText("12a").equals("12"));
        assertTrue(TextFormatter.formatText(",.").equals(".."));
        assertTrue(TextFormatter.formatText("{}").equals(""));
    }
}
