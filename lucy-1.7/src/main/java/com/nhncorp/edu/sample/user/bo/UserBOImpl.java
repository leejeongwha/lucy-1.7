package com.nhncorp.edu.sample.user.bo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nhncorp.edu.sample.user.dao.UserDAO;
import com.nhncorp.edu.sample.user.model.BoardUser;

@Service
public class UserBOImpl implements UserBO {
	@Autowired
	private UserDAO dao;

	@Override
	public BoardUser login(String id, String passwd) throws Exception {
		return dao.login(id, passwd);
	}

	@Override
	public boolean join(BoardUser user) throws Exception {
		return dao.join(user);
	}

	@Override
	public List<BoardUser> getUserList(int from, int to) throws Exception {
		return dao.getUserList(from, to);
	}

	@Override
	public boolean deleteUser(String userId) throws Exception {
		return dao.deleteUser(userId);
	}

	@Override
	public int getUserCount() throws Exception {
		return dao.getUserCount();
	}

}
