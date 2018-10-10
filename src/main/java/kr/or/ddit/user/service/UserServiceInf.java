package kr.or.ddit.user.service;

import java.util.List;

import kr.or.ddit.user.model.UserVo;

public interface UserServiceInf {
	public List<UserVo> getJspUser();
	
	public UserVo selectUser(String userId);
	
	public UserVo selectUser(UserVo userVo);
}
