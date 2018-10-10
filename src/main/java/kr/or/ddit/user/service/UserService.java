package kr.or.ddit.user.service;

import java.util.List;

import kr.or.ddit.user.dao.UserDao;
import kr.or.ddit.user.model.UserVo;

public class UserService implements UserServiceInf {

	UserDao userDao = new UserDao();
	

	@Override
	public List<UserVo> getJspUser() {
		// TODO Auto-generated method stub
		return userDao.getJspUser();
	}

	@Override
	public UserVo selectUser(String userId) {
		// TODO Auto-generated method stub
		return userDao.selectUser(userId);
	}

	@Override
	public UserVo selectUser(UserVo userVo) {
		// TODO Auto-generated method stub
		return userDao.selectUser(userVo);
	}

}
