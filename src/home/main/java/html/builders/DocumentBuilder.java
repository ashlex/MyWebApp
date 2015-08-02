package home.main.java.html.builders;

import home.main.java.html.*;

import java.util.ResourceBundle;

/**
 * Created by Alexej on 01.08.2015.
 */
public abstract class DocumentBuilder {
	Document document;
	ResourceBundle resourceWebLib;
	ResourceBundle resourceButtons;
	protected DocumentBuilder(){
		resourceWebLib=ResourceBundle.getBundle("home.main.resources.web");
		resourceButtons=ResourceBundle.getBundle("home.main.resources.Buttons");
	}
	public void createNewDocument(){
		document=new Document();
	}
	public Document getDocument(){
		return this.document;
	}

	public void buildHeader(){
		HtmlNode head=new HtmlNode.Builder("head")
				.addChild(new HtmlNode.Builder("title").setInnerText("MyWebApp").build())
				.build();
		head.addChild(new HtmlNode.Builder("script")
				.addAttribute(new Attribute("src", resourceWebLib.getString("js.jquery")))
				.build());
		head.addChild(new HtmlNode.Builder("script")
				.addAttribute(new Attribute("src", resourceWebLib.getString("js.for_index")))
				.build());
		head.addChild(new HtmlNode.Builder("link")
				.addAttribute(new Attribute("href", resourceWebLib.getString("css.calc")))
				.addAttribute(new Attribute("rel", "stylesheet"))
				.build());
		this.document.setHeader(head);
	}
	public abstract void buildBody();
}
