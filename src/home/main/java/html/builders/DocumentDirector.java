package home.main.java.html.builders;


import home.main.java.html.Document;

/**
 * Created by Alexej on 01.08.2015.
 */
public class DocumentDirector {
	public static Document create(DocumentBuilder builder){
		builder.createNewDocument();
		builder.buildHeader();
		builder.buildBody();
		return builder.getDocument();
	}
}
