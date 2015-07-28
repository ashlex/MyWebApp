package home.main;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;

public class MyServlet extends HttpServlet {
	private final String ATTRIBUTE = "CURRENT_OPERATION";
	IFacade facade;
	public final Logger LOG= LogManager.getLogger(this.getClass().getName());

	public MyServlet() {
		super();
		facade=new IFacade() {
			@Override
			public void verificationUser() {

			}

			@Override
			public IPageDocument getPage(PagesName page) {
				return null;
			}

			@Override
			public void pocessReqest(HttpServletRequest request) {

			}
		};

	}

	@Override
	public void init(ServletConfig config) throws ServletException {

		super.init(config);
	}

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ServletConfig f=getServletConfig();

		Enumeration<String> str = f.getInitParameterNames();
		String s="";
		while((s=str.nextElement())!="")
			System.out.println(s);
		LOG.info("test");
		return;
//		facade.pocessReqest(request);
//		HttpSession session = request.getSession(true);
//		CurrentOperation currentOperation = (CurrentOperation) session.getAttribute(ATTRIBUTE);
//		if (request.getParameterMap().size() == 0) {
//			response.setContentType("text/html;charset=UTF-8");
//			ServletContext sc = request.getServletContext();
//			request.setAttribute("test", "test");
//			RequestDispatcher rd = sc.getRequestDispatcher("/index.jsp");
//			rd.forward(request, response);
//		}





		/*
		String action = request.getParameter("action");
		String value = request.getParameter("value");
		String responseString = "";
		CurrentOperation currentOperation1 = null;

		if (currentOperation == null) {
			currentOperation = new CurrentOperation.Builder(0).build();
		}
		if ("added".equals(action)) {
			int position = currentOperation.getPosition();
			int val = Integer.parseInt(value);
			if ("".equals(currentOperation.getOperator())) {
				int a = (int) (currentOperation.getA()* 10 + val );
				currentOperation1 = new CurrentOperation.Builder(++position).setA(a).build();
				responseString = String.valueOf(currentOperation1.getA());
			} else {
				int b = (int) (currentOperation.getB() * 10 + val);
				currentOperation1 = new CurrentOperation.Builder(position++)
						.setA(currentOperation.getA())
						.setOperator(currentOperation.getOperator())
						.setB(b)
						.build();

				responseString = currentOperation1.getA() + " " + currentOperation1.getOperator() + " " + currentOperation1.getB();
			}
		} else if ("operation".equals(action)) {
			int a = currentOperation.getA();
			int position = 0;
			if ("+".equals(value) || "-".equals(value) || "/".equals(value) || "*".equals(value)) {
				currentOperation1 = new CurrentOperation.Builder(position)
						.setA(a)
						.setOperator(value)
						.build();
				responseString=currentOperation1.getA()+ " "+ currentOperation1.getOperator();
			} else {
				currentOperation1 = currentOperation;
				responseString=String.valueOf(currentOperation1.getA());
			}
		} else if ("run".equals(action)) {
			try {
				responseString=String.valueOf(currentOperation.execOperation());
			}catch (ArithmeticException ae){
				responseString=ae.getMessage();
				System.out.print(ae);
			}
			currentOperation1=new CurrentOperation.Builder(0).build();
		}else if("reset".equals(action)){
			responseString="";
			currentOperation1=new CurrentOperation.Builder(0).build();
		}

		if (currentOperation1 != null) {
			session.setAttribute(ATTRIBUTE, currentOperation1);
		}
		JSONObject jsonObject = new JSONObject();

		jsonObject.append("display", responseString);
		jsonObject.append("position", currentOperation1.getPosition()+"");
		response.setContentType("application/json;UTF-8");
		response.getWriter().print(jsonObject.toJSONString());
		*/

		/*
		{action:added ,value: [1,2,3,4,5,6,7,8,9,0]}
		{action:operator ,value: [+, -, /, *]}
		{action:run ,value: =}
		 */

//		CurrentOperation currentOperation= new CurrentOperation.Builder(2).build();


	}

}
