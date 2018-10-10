package kr.or.ddit.user.dao;

import java.util.List;

import kr.or.ddit.dd.SqlFactoryBuilder;
import kr.or.ddit.user.model.PageVo;
import kr.or.ddit.user.model.UserVo;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

public class UserDao implements UserDaoInf{
	
	public List<UserVo> getJspUser(){
		
		
		SqlSessionFactory factory = SqlFactoryBuilder.getSqlSessionFactory();
		SqlSession session =  factory.openSession();
		
		//selectOne : 데이터가 한건일때
		//selectList : 여러건의 데이터를 조회
		//메소드 인자 : 문자열 = 네임스페이스(모듈명).쿼리아이디
		return session.selectList("jspuser.selectUserAll");
	}
	
	public UserVo selectUser(String userId){
		SqlSessionFactory factory = SqlFactoryBuilder.getSqlSessionFactory();
		SqlSession session =  factory.openSession();
		
		return session.selectOne("jspuser.selectUser",userId);
	}
	
	public UserVo selectUser(UserVo userVo){
		SqlSessionFactory factory = SqlFactoryBuilder.getSqlSessionFactory();
		SqlSession session =  factory.openSession();
		
		return session.selectOne("jspuser.selectUserByVo",userVo);
	}

	@Override
	public List<UserVo> selectUserPageList(PageVo pageVo) {
		SqlSessionFactory factory = SqlFactoryBuilder.getSqlSessionFactory();
		SqlSession session =  factory.openSession();
		
		return session.selectList("jspuser.selectUserPageList",pageVo);
	}
}
