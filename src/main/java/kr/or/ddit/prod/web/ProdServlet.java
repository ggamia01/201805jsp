package kr.or.ddit.prod.web;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.prod.model.ProdVo;
import kr.or.ddit.prod.service.ProdService;
import kr.or.ddit.prod.service.ProdServiceInf;
import kr.or.ddit.user.model.UserVo;
import kr.or.ddit.user.service.UserService;
import kr.or.ddit.user.service.UserServiceInf;
import kr.or.ddit.util.model.PageVo;

/**
 * Servlet implementation class ProdServlet
 */
@WebServlet(urlPatterns = {"/prodList","/prodDetail"})
public class ProdServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//요청 uri로 로직분기
		//uri == userAllList
		String uri = request.getRequestURI();
		System.out.println("userServlet doGet" + uri);
		
		//사용자 전체 조회
		if(uri.equals("/prodList")){
			prodList(request, response);
			//사용자 페이징 조회
		}else if(uri.equals("/prodDetail")){
			prodDetail(request,response);
		}
		
		
	}

	
	
	
	private void prodDetail(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		//사용자 아이디가 파라미터로 넘어옴
				String prodId = request.getParameter("prodId");
				
				//사용자아이디에 해당하는 사용자 정보 조회
				ProdServiceInf prodService = new ProdService();
				ProdVo prodVo = prodService.selectProd(prodId);
				
				
				//jsp로 위임하기 이해 사용자 정보를 request에 저장
				request.setAttribute("prodVo", prodVo);
				//사용자 상세 수정화면으로 위임
				RequestDispatcher rd = request.getRequestDispatcher("/prod/prodDetail.jsp");
				rd.forward(request, response);
		
	}




	private void prodList(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		//prodservice 생성
	      ProdServiceInf prodService = new ProdService();
	      //prodPageList 호출 : 메소드 인자 - pageVo : page, pageSize
	      PageVo pageVo = new PageVo();
	      pageVo.setPage(Integer.parseInt((request.getParameter("page"))));
	      pageVo.setPageSize(Integer.parseInt((request.getParameter("pageSize"))));
	      
	      //페이지 리스트
	      Map<String, Object> resultMap = prodService.selectProdPageList(pageVo);
	      List<PageVo> prodpageList = (List<PageVo>) resultMap.get("prodList");
	      
	      //페이지 건수
	      int prodpageCnt = (int) resultMap.get("pageCnt");
	      
	      //request 객체에 저장
	      request.setAttribute("prodpageList", prodpageList);
	      request.setAttribute("prodpageCnt", prodpageCnt);
	      
	      //forward (userAllList.jsp --> userPagingList.jsp)
	      RequestDispatcher rd = request.getRequestDispatcher("/prod/prodPagingList.jsp");
			rd.forward(request, response);
		
	}




	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
