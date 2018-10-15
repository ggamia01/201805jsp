package kr.or.ddit.user.web;

import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import kr.or.ddit.user.model.UserVo;
import kr.or.ddit.user.service.UserService;
import kr.or.ddit.user.service.UserServiceInf;
import kr.or.ddit.util.model.StringUtil;

/**
 * Servlet implementation class UserFormServlet
 */
@MultipartConfig(maxFileSize=1024*1024*5,maxRequestSize=1024*1024*5*5)
@WebServlet("/userForm")
public class UserFormServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    //사용자 등록 화면
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//userForm.jsp로 위임
		request.getRequestDispatcher("/user/userForm.jsp").forward(request, response);
	}

	//사용자 등록
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
				
				//파일쓰기
				//url정보를 실제 파일 경로로 변경
				String path = getServletContext().getRealPath("/profile");
				profilePart.write(path+File.separator + fileName);
				//파일 업로드 과정에서 사용한 디스크 임시 영역을 정리
				profilePart.delete();
		
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
		String profile ="/profile/"+fileName;
		
		System.out.println(userId+"/"+name+"/"+pass+"/"+addr1+"/"+addr2+"/"+birth+"/"+zipcd+"/"+email+"/"+tel+"/"+"/"+profile);
		
		//파라미터를 userVo
		UserVo userVo = new UserVo();
		userVo.setUserId(userId);
		userVo.setName(name);
		userVo.setAddr1(addr1);
		userVo.setAddr2(addr2);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
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
		int insertCnt = userService.insertUser(userVo);
		
		//사용자 리스트로 이동(redirect : 서버 상태가 변경되므로 사용자가 새로고침을 통해 재요청시 중복 등록되는 현상을 막는다)
		response.sendRedirect("/userPageList?page=1&pageSize=10");
	}

}
