package main;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

public class MyServlet extends HttpServlet {
	private final String ATTRIBUTE = "CURRENT_OPERATION";

	public MyServlet() {
		super();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(true);
		CurrentOperation currentOperation = (CurrentOperation) session.getAttribute(ATTRIBUTE);
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
				responseString=String.valueOf(currentOperation.runOperation());
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


		/*
		{action:added ,value: [1,2,3,4,5,6,7,8,9,0]}
		{action:operator ,value: [+, -, /, *]}
		{action:run ,value: =}
		 */

//		CurrentOperation currentOperation= new CurrentOperation.Builder(2).build();


	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<body>");
		out.println("<h1>Hello Servlet Get GET</h1>");
		out.println("</body>");
		out.println("</html>");
	}

}
