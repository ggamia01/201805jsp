package kr.or.ddit.user.dao;

import static org.junit.Assert.*;

import java.util.List;

import kr.or.ddit.user.model.PageVo;
import kr.or.ddit.user.model.UserVo;

import org.junit.Before;
import org.junit.Test;

public class JspUserDaoTest {

	private UserDaoInf jspDao ;
	
	@Before
	public void setUp(){
		jspDao = new UserDao();
	}
	//테스트 메소드명명 규칙(회사 마다 다름)
	//운영코드 메소드 이름 +  Test
	//getTemp + Test : getTempTest
	@Test
	public void getJspUserTest() {
		/***Given : 주어진 상황***/
		

		/***When : 어떤 동작 수행(메소드 호출)***/
		List<UserVo> list = jspDao.getJspUser();
		System.out.println("list: "+list);
		
		int listSize = list.size();
		System.out.println(listSize);
		//select 'X' as result from dual
		//result : X
		
		/***Then : 결과가 어떠해야하는지 정의***/
		assertEquals(105, list.size());
		
	}
	
	@Test
	public void selectUserTest() {
		/***Given : 주어진 상황***/

		/***When : 어떤 동작 수행(메소드 호출)***/
		UserVo userVo = jspDao.selectUser("brown");
		System.out.println("userVo: "+userVo);
		
		//select 'X' as result from dual
		//result : X
		
		/***Then : 결과가 어떠해야하는지 정의***/
		assertNotNull(userVo);
		assertEquals("brown", userVo.getUserId());
		assertEquals("브라운", userVo.getName());
		
	}

	@Test
	public void selectUserTestByVoTest() {
		/***Given : 주어진 상황***/

		/***When : 어떤 동작 수행(메소드 호출)***/
		UserVo userVo = new UserVo();
		userVo.setUserId("brown");
		
				
		System.out.println("userVo: "+userVo);
		
		UserVo userVo1 = jspDao.selectUser(userVo);
		//select 'X' as result from dual
		//result : X
		
		/***Then : 결과가 어떠해야하는지 정의***/
		assertNotNull(userVo1);
		assertEquals("brown", userVo1.getUserId());
		assertEquals("브라운", userVo1.getName());
		
	}

	
	@Test
	public void selectUserPageListTest() {
		/***Given : 주어진 상황***/
		PageVo pageVo = new PageVo();
		pageVo.setPage(1);
		pageVo.setPageSize(10);

		/***When : 어떤 동작 수행(메소드 호출)***/
		List<UserVo> userList = jspDao.selectUserPageList(pageVo);
				
		System.out.println("pageVo: "+pageVo);
		
		
		/***Then : 결과가 어떠해야하는지 정의***/
		assertNotNull(pageVo);
		assertEquals(10, userList.size());
		
	}

	/** 
	 * Method : getUserCntTest
	 * 작성자 : ASUS
	 * 변경이력 :  
	 * Method 설명 : 사용자 전체 건수 조회 테스트
	 */
	@Test
	public void getUserCntTest(){
		/***Given***/
		

		/***When***/
		int totalUserCnt = jspDao.getUserCnt();
		
		/***Then***/
		assertEquals(105, totalUserCnt);
	}
}
