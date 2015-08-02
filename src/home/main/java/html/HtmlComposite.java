package home.main.java.html;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Alexej on 01.08.2015.
 */
public interface HtmlComposite extends HtmlComponent {
	boolean addChild(HtmlComponent component);
	boolean removeChild(HtmlComponent component);
	HtmlComponent getChild(int id);

}
