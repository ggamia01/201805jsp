package kr.or.ddit.user.web;

import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import jdk.nashorn.internal.runtime.RewriteException;
import kr.or.ddit.user.model.UserVo;
import kr.or.ddit.user.service.UserService;
import kr.or.ddit.user.service.UserServiceInf;
import kr.or.ddit.util.model.PageVo;
import kr.or.ddit.util.model.StringUtil;

/**
 * Servlet implementation class UserServlet
 */
@MultipartConfig(maxFileSize=1024*1024*5,maxRequestSize=1024*1024*5*5)
@WebServlet(urlPatterns = {"/userAllList","/userPageList","/userDetail","/userDetailUpdate","/usernewPagingList"})
public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//요청 uri로 로직분기
				//uri == userAllList
				String uri = request.getRequestURI();
				System.out.println("userServlet doGet" + uri);
				
				//사용자 전체 조회
				if(uri.equals("/userAllList")){
					userAllList(request, response);
					//사용자 페이징 조회
				}else if(uri.equals("/userPageList")){
					userPageList(request,response);
				}else if(uri.equals("/userDetail")){
					userDetail(request,response);
				}else if(uri.equals("/userDetailUpdate")){
					userDetailUpdate(request,response);
				}
				
				
				
	}
	
	 /** 
		 * Method : userDetailUpdate
		 * 작성자 : ASUS
		 * 변경이력 : 
		 * @param request
		 * @param response 
		 * Method 설명 : 사용자 상세 정보 수정하기
		 * @throws IOException 
		 * @throws ServletException 
		 */
		private void userDetailUpdate(HttpServletRequest request,
				HttpServletResponse response) throws ServletException, IOException {
			// TODO Auto-generated method stub
			String userId = request.getParameter("userId");
			System.out.println("userId:"+userId);
			//사용자아이디에 해당하는 사용자 정보 조회
			UserServiceInf userService = new UserService();
			UserVo userVo = userService.selectUser(userId);
			System.out.println("useVoName : "+userVo.getName());
			//jsp로 위임하기 이해 사용자 정보를 request에 저장
			request.setAttribute("userVo", userVo);
			//사용자 상세 화면으로 위임
			RequestDispatcher rd = request.getRequestDispatcher("/user/userDetailUpdate.jsp");
			rd.forward(request, response);
		}

	/** 
	 * Method : userDetail
	 * 작성자 : ASUS
	 * 변경이력 : 
	 * @param request
	 * @param response 
	 * Method 설명 : 
	 * @throws IOException 
	 * @throws ServletException 
	 */
	private void userDetail(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		//사용자 아이디가 파라미터로 넘어옴
		String userId = request.getParameter("userId");
		System.out.println("detailuserId :" + userId);
		
		//사용자아이디에 해당하는 사용자 정보 조회
		UserServiceInf userService = new UserService();
		UserVo userVo = userService.selectUser(userId);
		System.out.println("userservlet vo : "+userVo);
		
		//jsp로 위임하기 이해 사용자 정보를 request에 저장
		request.setAttribute("userVo", userVo);
		//사용자 상세 수정화면으로 위임
		RequestDispatcher rd = request.getRequestDispatcher("/user/userDetail.jsp");
		rd.forward(request, response);
	}

	/** 
	 * Method : userPageList
	 * 작성자 : ASUS
	 * 변경이력 : 
	 * @param request
	 * @param response 
	 * Method 설명 : 사용자 페이지 리스트 조회
	 * @throws IOException 
	 * @throws ServletException 
	 */
	private void userPageList(HttpServletRequest request ,
	         HttpServletResponse response) throws ServletException, IOException{
	      System.out.println("userPageList");
	      
	      //userservice 생성
	      UserServiceInf userService = new UserService();
	      //userPageList 호출 : 메소드 인자 - pageVo : page, pageSize
	      PageVo pageVo = new PageVo();
	      pageVo.setPage(Integer.parseInt((request.getParameter("page"))));
	      pageVo.setPageSize(Integer.parseInt((request.getParameter("pageSize"))));
	      
	      //페이지 리스트
	      Map<String, Object> resultMap = userService.selectUserPageList(pageVo);
	      List<UserVo> pageList = (List<UserVo>) resultMap.get("userList");
	      
	      //페이지 건수
	      int pageCnt = (int) resultMap.get("pageCnt");
	      
	      //request 객체에 저장
	      request.setAttribute("pageList", pageList);
	      request.setAttribute("pageCnt", pageCnt);
	      
	      //forward (userAllList.jsp --> userPagingList.jsp)
	      RequestDispatcher rd = request.getRequestDispatcher("/user/userPagingList.jsp");
			rd.forward(request, response);
	   }


	private void userAllList(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		//전체 사용자 정보조회
		UserServiceInf userService = new UserService();
		List<UserVo> userList = userService.getJspUser();
		
		//조회된 사용자 정보를 userAllList.jsp를 통해 화면처리
		//userAllList.jsp에서 userList를 참조하려면??
		//attribute
		//session, application, request
		//session : 해당 사용자만 접근이 가능(사용자 전용 공간) --> 자주 참조하는 데이터, 너무 많은 데이터를 저장할 경우-OOM 유발 가능성(과부하)
		//application : 모든 사용자가 접근 가능(서버당 하나만 생성) --> 일반적으로 설정과 관련된 값을 저장
		//request : 해당 요청의 응답이 끝날때까지
		
		//getServletContext().setAttribute("userList", userList);
		request.setAttribute("userList", userList);
		
		//화면으로 위임 : 2가지
		//1.request dispatch : 보통/일반적으로 사용(예:조회만 했을 때)
		//2.sendRedirect : 서버에 데이터가 변경되었을 때
		
		//dispatch
		RequestDispatcher rd = request.getRequestDispatcher("/user/userAllList.jsp");
		rd.forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		//post 한글 파라미터 인코딩 처리
				request.setCharacterEncoding("utf-8");
				
				//일반 text 파라미터 : request.getParameter("파라미터명")
						
				//profile part
				Part profilePart = request.getPart("profile");
				System.out.println("profile part : " + profilePart.getContentType());
				
				//Content-disposition 헤더 정보
				//파일과 관련된 부가정보
				System.out.println("Content-disposition : "+profilePart.getHeader("Content-disposition"));
				
				String contentDisposition = profilePart.getHeader("Content-disposition");
				String fileName = StringUtil.getFileNameFormHeader(contentDisposition);
				
				String profile;
				if(fileName.equals("")){
					profile = null;
				}else{
					profile ="/profile/"+fileName;
				
					//파일쓰기
					//url정보를 실제 파일 경로로 변경
					String path = getServletContext().getRealPath("/profile");
					profilePart.write(path+File.separator + fileName);
					//파일 업로드 과정에서 사용한 디스크 임시 영역을 정리
					profilePart.delete();
				}
				//파라미터 받아오기
				//userId, name, pass, addr1, addr2, birth, zipcd, email,tel
				String userId = request.getParameter("userId");
				String name = request.getParameter("name");
				String pass = request.getParameter("pass");
				String addr1 = request.getParameter("addr1");
				String addr2 = request.getParameter("addr2");
				String birth = request.getParameter("birth"); // type
				String zipcd = request.getParameter("zipcd");
				String email = request.getParameter("email");
				String tel = request.getParameter("tel");
			    
				
				System.out.println(userId+"/"+name+"/"+pass+"/"+addr1+"/"+addr2+"/"+birth+"/"+zipcd+"/"+email+"/"+tel+"/"+profile);
				
				//파라미터를 userVo
				UserVo userVo = new UserVo();
				userVo.setUserId(userId);
				userVo.setName(name);
				userVo.setAddr1(addr1);
				userVo.setAddr2(addr2);
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy년 MM월 dd일");
				try {
					//yyyy-MM-dd
					userVo.setBirth(sdf.parse(birth));
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				userVo.setZipcd(zipcd);
				userVo.setPass(pass);
				userVo.setEmail(email);
				userVo.setTel(tel);
				userVo.setProfile(profile);
				
				//사용자 등록 서비스 호출
				UserServiceInf userService = new UserService();
				int insertCnt = userService.updateUser(userVo);
				
				//사용자 리스트로 이동(redirect : 서버 상태가 변경되므로 사용자가 새로고침을 통해 재요청시 중복 등록되는 현상을 막는다)
				response.sendRedirect("/userPageList?page=1&pageSize=10");
	}
	
	
}
