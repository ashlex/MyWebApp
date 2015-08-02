package home.main.java.html;

/**
 * Created by Alexej on 01.08.2015.
 */
public interface HtmlComponent {
	String getName();
	String getHtml(String linePrefix);
	String getHtml();
}
