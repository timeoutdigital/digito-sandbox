package setup;

import com.thoughtworks.xstream.XStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.apache.commons.io.IOUtils;


public class readXML {

    protected XStream xstream = new XStream();

    protected void loadObjectFromXML(String filename, Object object) throws IOException {
        InputStream resource = Thread.currentThread().getContextClassLoader().getResourceAsStream(filename);
        String xml = IOUtils.toString(resource, "UTF-8");

        Pattern propertyPattern = Pattern.compile("%([\\w\\.]*)%", Pattern.MULTILINE);
        Matcher matcher = propertyPattern.matcher(xml);
        StringBuffer sb = new StringBuffer();
        while (matcher.find()) {
            matcher.appendReplacement(sb, getProperty(matcher.group(1)));
        }
        matcher.appendTail(sb);
        
        xstream.processAnnotations(object.getClass());
        xstream.fromXML(sb.toString(), object);
    }

    protected String getProperty(String name) {
        return System.getProperty(name);
    }
}