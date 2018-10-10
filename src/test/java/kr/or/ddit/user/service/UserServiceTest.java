package kr.or.ddit.user.service;

import static org.junit.Assert.*;

import java.util.List;

import kr.or.ddit.user.model.UserVo;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;


public class UserServiceTest {

	//Junit 실행주기
	//@BeforeClass 이 적용된 메소드 실행(최초 1회), 단 static  메소드로 선언
	//@Before 어노테이션이 적용된 메소드 실행(테스트 메소드 실행전 실행)
	//@Test
	//@After 어노테이션이 적용된 메소드 실행(테스트 메소드 실행 후 실행)
	//@AfterClass 어노테이션이 적용된 메소드 실행(최초 1회), 단 static  메소드로 선언
	
	//beforeClass 
	//before - getjspUser -> after 
	//before - selectUser(String) -> after 
	//before - selectUser(UserVo) -> after 
	//afterClass
	
	private UserServiceInf userService ;
	
	@BeforeClass
	public static void beforeClass(){
		System.out.println("beforeClass");
	}
	@AfterClass
	public static void afterClass(){
		System.out.println("afterClass");
	}
	
	@Before
	public void before(){
		System.out.println("before");
		userService = new UserService();
	}
	
	@After
	public void after(){
		System.out.println("after");
	}
	
	@Test
	public void getJspUserTest() {
		
		/***Given***/
		

		/***When***/
		 List<UserVo> userList =  userService.getJspUser();
		
		/***Then***/
		 assertEquals(5, userList.size());
	}
	
	@Test
	public void selectUserTest() {
		
		/***Given***/
		

		/***When : 어떤 동작 수행(메소드 호출)***/
		UserVo userVo = userService.selectUser("brown");
		System.out.println("userVo: "+userVo);
		
		
		/***Then : 결과가 어떠해야하는지 정의***/
		assertNotNull(userVo);
		assertEquals("brown", userVo.getUserId());
		assertEquals("브라운", userVo.getName());
		
	}
	
	@Test
	public void selectUserTestByVoTest() {
		
		/***Given***/
		

		/***When : 어떤 동작 수행(메소드 호출)***/
		UserVo userVo = new UserVo();
		userVo.setUserId("brown");
		
				
		System.out.println("userVo: "+userVo);
		
		UserVo userVo1 = userService.selectUser(userVo);
		//select 'X' as result from dual
		//result : X
		
		/***Then : 결과가 어떠해야하는지 정의***/
		assertNotNull(userVo1);
		assertEquals("brown", userVo1.getUserId());
		assertEquals("브라운", userVo1.getName());
	}

}
