package home.main.java.html;

/**
 * Created by Alexej on 01.08.2015.
 */
public class Document implements HtmlComposite {
	private String name;
	private HtmlComponent header;
	private HtmlComponent body;

	public Document(){
		this.name="html";
	}

	public HtmlComponent getHeader() {
		return header;
	}

	public void setHeader(HtmlComposite header) {
		addChild(header);
	}

	public HtmlComponent getBody() {
		return body;
	}

	public void setBody(HtmlComposite body) {
		addChild(body);
	}

	@Override
	public String getName() {
		return this.name;
	}

	@Override
	public String getHtml(String linePrefix) {
		if (linePrefix == null) linePrefix = "";
		StringBuilder sb = new StringBuilder();
		sb.append(linePrefix);
		sb.append("<");
		sb.append(name);
		sb.append(">");
			sb.append("\r\n");
			sb.append(header.getHtml(linePrefix + "\t"));
			sb.append("\r\n");
			sb.append(body.getHtml(linePrefix + "\t"));
		sb.append("\r\n").append(linePrefix);
		sb.append("</");
		sb.append(name);
		sb.append(">");
		return sb.toString();
	}

	@Override
	public String getHtml() {
		return getHtml("");
	}

	@Override
	public boolean addChild(HtmlComponent component) {
		if(component==null)throw new NullPointerException("The component can not be null");
		if ("head".equalsIgnoreCase(component.getName())) {
			this.header = component;
			return true;
		}
		if ("body".equalsIgnoreCase(component.getName())) {
			this.body = component;
			return true;
		}
		return false;
	}

	@Override
	public boolean removeChild(HtmlComponent component) {
		return false;
	}

	@Override
	public HtmlComponent getChild(int id) {
		if(id==0)return header;
		if(id==1)return body;
		return null;
	}
}
