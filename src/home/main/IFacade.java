package home.main;

import javax.servlet.http.HttpServletRequest;

public interface IFacade {
	void verificationUser();
	IPageDocument getPage(PagesName page);
	void pocessReqest(HttpServletRequest request);
}
