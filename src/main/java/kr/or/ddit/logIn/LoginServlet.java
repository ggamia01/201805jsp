package kr.or.ddit.logIn;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.encrypt.sha.KISA_SHA256;
import kr.or.ddit.user.model.UserVo;
import kr.or.ddit.user.service.UserService;
import kr.or.ddit.user.service.UserServiceInf;

public class LoginServlet extends HttpServlet{
	
/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

//	private final String USERID = "brown";
//	private final String PASSWORD = "pass1234";
	
	
	//service  --> request.getMethod() : "POST", "GET" --> doGet, doPost
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
//		Map<String, String[]> reqMap =  req.getParameterMap();
//		reqMap.put("newParameter", new String[] {"newValue"});
		
		String newParameter = req.getParameter("newParameter");
		System.out.println("newParameter : " +newParameter);
		
		// 1. 사용자 id, 비밀번호를 request객체에서 받아온다.
		// 2. db에서 조회해온 아이디, 비밀번호를 체크를 한다.
		// 3-1. 일치할 경우  main.jsp로 이동
		// 3-2. 불일치할 경우 login.jsp로 이동
		
		//1
		String userId=req.getParameter("userId");
		String password=req.getParameter("password");
		//remember-me 파라미터 받아서 sysout으로 출력
		String remember_me = req.getParameter("remember-me");
		System.out.println("remember-me:"+remember_me);
		
		//remember_me == null : 아이디 기억 사용 안함
		if(remember_me == null){
			Cookie[] cookies = req.getCookies();
			for(Cookie cookie : cookies){
				//cookie 이름이 rememer, userId 일 경우 maxage를 -1설정하여 쿠키를 유효하지 않도록 설정
				System.out.println(cookie.getName());
				if(cookie.getName().equals("remember")||cookie.getName().equals("userId")){
					cookie.setMaxAge(0);
					resp.addCookie(cookie);
				}
			}
		//remember_me != null : 아이디 기억 사용 
		}else{
			//respons 객체에 쿠키를 저장
			Cookie cookie = new Cookie("remember", "Y");
			Cookie userIdCookie = new Cookie("userId",userId);
			//cookie.setMaxAge(60*60*24); //하루동안 적용
			resp.addCookie(cookie);
			resp.addCookie(userIdCookie);
			
		}
		
		//2 --> db대신 상수로 대체 --> db로 대체
		// 1.사용자가 전송한 userId파라미터로 사용자 정보조회
		UserServiceInf userService = new UserService();
		UserVo selectUser = userService.selectUser(userId);
		// 2.db에서 조회한 사용자 비밀번호가 파라미터로 전송된 비밀번호와 동일한지 비교
		
		// 3.session에 사용자 정보등록(as-is : 임의의 userVo 등록 / to-be : db에서 조회한 userVo)
		
		//3-1
//		if(selectUser !=null && selectUser.getPass().equals(password)){
		String encryptPass = KISA_SHA256.encrypt(password);
//		if(selectUser !=null && selectUser.getPass().equals(encryptPass)){
		if(selectUser !=null && selectUser.authPass(encryptPass)){
			
			req.getSession().setAttribute("S_user", selectUser);;
			
			
			//dispatch
			RequestDispatcher rd = req.getRequestDispatcher("main.jsp");
			rd.forward(req, resp);
		}
//		if(USERID.equals(userId) && PASSWORD.equals(password)){
//			//redirect.... (db상에서 변경이 있을때 사용한다..)
//			//resp.sendRedirect("main.jsp?userId="+userId+"&password="+password);
//			
//			//session
//			UserVo userVo= new UserVo();
//			
//			//1.session에 사용자 정보 설정
//			userVo.setUserId(userId);
//			userVo.setName("브라운");
//			userVo.setAlias("곰");
//			userVo.setBirth(new Date());
//			
//			//2.main.jsp
//			//body 영역에
//			//이름[별명]님 안녕하세요
//			
//			req.getSession().setAttribute("userVo", userVo);;
//			
//			
//			//dispatch
//			RequestDispatcher rd = req.getRequestDispatcher("main.jsp");
//			rd.forward(req, resp);
//		}
		
		//3-2
		else{
			resp.sendRedirect("logIn/logIn.jsp");
		}
		
		
		
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		//post방식에서 인코딩
				req.setCharacterEncoding("utf-8");
				
				resp.setContentType("text/html; charset=utf-8");
				PrintWriter pw =resp.getWriter();
				
				pw.println("<!DOCTYPE html>");
				pw.println("	<html>");
				pw.println("		<head>");
				pw.println("			<meta charset=\"UTF-8\">");
				pw.println("			<title>Insert title here</title>");
				pw.println("		</head>");
				pw.println("		<body>");
				
				//userId : brwon / sally
				String[] userIds = req.getParameterValues("userId");
				for(String userId : userIds)
					pw.println("		userId : " + userId + "<br>");
				pw.println("		password : " + req.getParameter("password") + "<br>");
				pw.println("		</body>");
				pw.println("	</html>");
	}
}







