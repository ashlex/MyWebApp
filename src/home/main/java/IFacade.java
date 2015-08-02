package home.main.java;

import home.main.java.html.IPageDocument;
import home.main.java.html.PagesName;

import javax.servlet.http.HttpServletRequest;

public interface IFacade {
	void verificationUser();
	IPageDocument getPage(PagesName page);
	void pocessReqest(HttpServletRequest request);
}
