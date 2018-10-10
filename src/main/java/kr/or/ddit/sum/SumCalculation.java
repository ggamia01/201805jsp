package kr.or.ddit.sum;

import implicit.CalculationLogic;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SumCalculation
 */
@WebServlet("/sumCalculation")
public class SumCalculation extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//get localhost:8081/sumCalculation
		//sumInput.jsp forward
		
		request.getRequestDispatcher("/jsp/sumInput.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int start = Integer.parseInt(request.getParameter("start")) ;
		int end = Integer.parseInt(request.getParameter("end"));
		
		CalculationLogic logic = new CalculationLogic();
		
		int sumResult = logic.sumBetweenTwoNumbers(start,end);
		
		System.out.println(sumResult);
		
		request.getSession().setAttribute("sumResult", sumResult);;
		
		
		//dispatch
		RequestDispatcher rd = request.getRequestDispatcher("/jsp/sumResult.jsp");
		rd.forward(request, response);
		
	}

}
