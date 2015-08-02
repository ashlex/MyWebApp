package home.main.java.html;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Created by Alexej on 01.08.2015.
 */
public class HtmlNode implements HtmlComposite {
	private List<HtmlComponent> children;
	private String name;
	private String innerText;
	private List<Attribute> attributes;

	private HtmlNode(Builder builder) {
		this.children = builder.children;
		this.name = builder.name;
		this.innerText = builder.innerText;
		this.attributes = builder.attributes;
	}

	@Override
	public boolean addChild(HtmlComponent node) {
		if (node == null) return false;
		return this.children.add(node);
	}

	@Override
	public boolean removeChild(HtmlComponent node) {
		if (node == null) return false;
		return this.children.remove(node);
	}

	@Override
	public HtmlComponent getChild(int id) {
		return this.children.get(id);
	}

	public boolean addAttribute(Attribute attribute) {
		if (attribute == null) return false;
		return this.attributes.add(attribute);
	}

	public boolean addAllAttribute(Collection<? extends Attribute> attributes) {
		if (attributes == null) return false;
		return this.attributes.addAll(attributes);
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
		for (Attribute attr : attributes) {
			sb.append(" ");
			sb.append(attr.toString());
		}
		sb.append(">");
		if (!innerText.isEmpty()) {
			sb.append("\r\n\t").append(linePrefix);
			sb.append(innerText);
		}
		for (HtmlComponent node : children) {
			sb.append("\r\n");
			sb.append(node.getHtml(linePrefix + "\t"));
		}
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

	public static class Builder {
		private String name;
		private String innerText = "";
		private List<Attribute> attributes;
		private List<HtmlComponent> children;

		public Builder(String name) {
			this.name = name;
			this.attributes = new ArrayList<Attribute>();
			this.children = new ArrayList<HtmlComponent>();
		}

		public Builder setInnerText(String innerText) {
			this.innerText = innerText;
			return this;
		}

		public Builder addAttribute(Attribute attribute) {
			this.attributes.add(attribute);
			return this;
		}

		public Builder addChild(HtmlComponent node) {
			this.children.add(node);
			return this;
		}

		public HtmlNode build() {
			return new HtmlNode(this);
		}
	}
}
