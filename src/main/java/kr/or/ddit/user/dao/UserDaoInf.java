package kr.or.ddit.user.dao;

import java.util.List;

import kr.or.ddit.user.model.PageVo;
import kr.or.ddit.user.model.UserVo;

public interface UserDaoInf {
	public List<UserVo> getJspUser();
	
	public UserVo selectUser(String userId);
	
	public UserVo selectUser(UserVo userVo);
	
	public List<UserVo> selectUserPageList(PageVo pageVo);
}
