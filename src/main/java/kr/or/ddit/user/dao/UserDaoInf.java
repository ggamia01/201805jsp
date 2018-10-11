package kr.or.ddit.user.dao;

import java.util.List;

import kr.or.ddit.user.model.PageVo;
import kr.or.ddit.user.model.UserVo;

public interface UserDaoInf {
	public List<UserVo> getJspUser();
	
	public UserVo selectUser(String userId);
	
	public UserVo selectUser(UserVo userVo);
	
	public List<UserVo> selectUserPageList(PageVo pageVo);
	
	/** 
	 * Method : getUserCnt
	 * 작성자 : ASUS
	 * 변경이력 : 
	 * @return 
	 * Method 설명 : 사용자 전체 건수 조회
	 */
	public int getUserCnt();
}
