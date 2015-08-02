package home.main.java.html.builders;

import home.main.java.Actions.Actions;
import home.main.java.html.Attribute;
import home.main.java.html.HtmlNode;

/**
 * Created by Alexej on 01.08.2015.
 */
public class IndexBuilder extends DocumentBuilder {
	@Override
	public void buildBody() {
		HtmlNode body = new HtmlNode.Builder("body").build();
		HtmlNode div = new HtmlNode.Builder("div")
				.addAttribute(new Attribute("class", "calc"))
				.build();
		div.addChild(getTable());
		body.addChild(div);
		document.setBody(body);
	}
	protected HtmlNode getTable(){
		HtmlNode table = new HtmlNode.Builder("table").build();
		table.addChild(new HtmlNode.Builder("tr")
				.addChild(new HtmlNode.Builder("td")
						.addAttribute(new Attribute("class", "display"))
						.addAttribute(new Attribute("colspan", "4"))
						.build())
				.build());

		table.addChild(new HtmlNode.Builder("tr")
				.addChild(new HtmlNode.Builder("td")
						.addAttribute(new Attribute("class", "button"))
						.addAttribute(new Attribute("colspan", "4"))
						.addAttribute(new Attribute("action", "reset"))
						.setInnerText(resourceButtons.getString("Calc.reset"))
						.build())
				.build());

		table.addChild(new HtmlNode.Builder("tr")
				.addChild(new HtmlNode.Builder("td")
						.addAttribute(new Attribute("class", "button"))
						.addAttribute(new Attribute("action", Actions.ADDED.toString()))
						.setInnerText(resourceButtons.getString("Calc.seven"))
						.build())
				.addChild(new HtmlNode.Builder("td")
						.addAttribute(new Attribute("class", "button"))
						.addAttribute(new Attribute("action", Actions.ADDED.toString()))
						.setInnerText(resourceButtons.getString("Calc.eight"))
						.build())
				.addChild(new HtmlNode.Builder("td")
						.addAttribute(new Attribute("class", "button"))
						.addAttribute(new Attribute("action", Actions.ADDED.toString()))
						.setInnerText(resourceButtons.getString("Calc.nine"))
						.build())
				.addChild(new HtmlNode.Builder("td")
						.addAttribute(new Attribute("class", "button"))
						.addAttribute(new Attribute("action", Actions.OPERATOR.toString()))
						.setInnerText(resourceButtons.getString("Calc.seven"))
						.build())
				.build());

		table.addChild(new HtmlNode.Builder("tr")
				.addChild(new HtmlNode.Builder("td")
						.addAttribute(new Attribute("class", "button"))
						.addAttribute(new Attribute("action", Actions.ADDED.toString()))
						.setInnerText(resourceButtons.getString("Calc.four"))
						.build())
				.addChild(new HtmlNode.Builder("td")
						.addAttribute(new Attribute("class", "button"))
						.addAttribute(new Attribute("action", Actions.ADDED.toString()))
						.setInnerText(resourceButtons.getString("Calc.five"))
						.build())
				.addChild(new HtmlNode.Builder("td")
						.addAttribute(new Attribute("class", "button"))
						.addAttribute(new Attribute("action", Actions.ADDED.toString()))
						.setInnerText(resourceButtons.getString("Calc.six"))
						.build())
				.addChild(new HtmlNode.Builder("td")
						.addAttribute(new Attribute("class", "button"))
						.addAttribute(new Attribute("action", Actions.OPERATOR.toString()))
						.setInnerText(resourceButtons.getString("Calc.division"))
						.build())
				.build());

		table.addChild(new HtmlNode.Builder("tr")
				.addChild(new HtmlNode.Builder("td")
						.addAttribute(new Attribute("class", "button"))
						.addAttribute(new Attribute("action", Actions.ADDED.toString()))
						.setInnerText(resourceButtons.getString("Calc.one"))
						.build())
				.addChild(new HtmlNode.Builder("td")
						.addAttribute(new Attribute("class", "button"))
						.addAttribute(new Attribute("action", Actions.ADDED.toString()))
						.setInnerText(resourceButtons.getString("Calc.two"))
						.build())
				.addChild(new HtmlNode.Builder("td")
						.addAttribute(new Attribute("class", "button"))
						.addAttribute(new Attribute("action", Actions.ADDED.toString()))
						.setInnerText(resourceButtons.getString("Calc.three"))
						.build())
				.addChild(new HtmlNode.Builder("td")
						.addAttribute(new Attribute("class", "button"))
						.addAttribute(new Attribute("rowspan", "2"))
						.addAttribute(new Attribute("action", Actions.RUN.toString()))
						.setInnerText(resourceButtons.getString("Calc.run"))
						.build())
				.build());

		table.addChild(new HtmlNode.Builder("tr")
				.addChild(new HtmlNode.Builder("td")
						.addAttribute(new Attribute("class", "button"))
						.addAttribute(new Attribute("action", Actions.ADDED.toString()))
						.setInnerText(resourceButtons.getString("Calc.zero"))
						.build())
				.addChild(new HtmlNode.Builder("td")
						.addAttribute(new Attribute("class", "button"))
						.addAttribute(new Attribute("action", Actions.OPERATOR.toString()))
						.setInnerText(resourceButtons.getString("Calc.sum"))
						.build())
				.addChild(new HtmlNode.Builder("td")
						.addAttribute(new Attribute("class", "button"))
						.addAttribute(new Attribute("action", Actions.OPERATOR.toString()))
						.setInnerText(resourceButtons.getString("Calc.rasn"))
						.build())
				.build());
		return table;
	}
}
