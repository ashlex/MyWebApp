package home.main.java.html;

import junit.framework.TestCase;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class HtmlNodeTest extends TestCase {
	
	@Test
	public void testAddChild() throws Exception {
		HtmlNode node=new HtmlNode.Builder("div").build();
		assertTrue(node.addChild(new HtmlNode.Builder("span").build()));
		assertTrue(node.addChild(new HtmlNode.Builder("span").build()));
		HtmlNode child=new HtmlNode.Builder("div").build();
		assertTrue(child.addChild(new HtmlNode.Builder("span").build()));
		assertTrue(node.addChild(child));
		assertTrue(node.addChild(new HtmlNode.Builder("span").build()));
		assertFalse(node.addChild(null));
		String result=node.getHtml();

	}

	@Test
	public void testAddAttribute() throws Exception {

	}

	@Test
	public void testAddAllAttribute() throws Exception {

	}

	@Test
	public void testGetHtml() throws Exception {

	}
}