package kr.or.ddit.sum;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class MulCalculation
 */
@WebServlet("/mulCalculation")
public class MulCalculation extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int param1 = Integer.parseInt(request.getParameter("param1"));
		int param2 = Integer.parseInt(request.getParameter("param2"));
		
		int mulResult = 0;
		
		for(int i=param1;i<=param2;i++){
			
			mulResult = param1 *factorial(param2-1);
			
		}
		
		System.out.println(mulResult);
		
		request.getSession().setAttribute("mulResult", mulResult);
		
		
		//dispatch
		RequestDispatcher rd = request.getRequestDispatcher("mulResult.jsp");
		rd.forward(request, response);
	}

	public int factorial(int number){
		int result = 0;
		
		if(number == 1){
			result = 1;
		}else{
			result = number *factorial(number-1);
		}
		
		return result;
}
}
