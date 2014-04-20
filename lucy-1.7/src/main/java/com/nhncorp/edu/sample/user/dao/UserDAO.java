package com.nhncorp.edu.sample.user.dao;

import java.util.List;

import com.nhncorp.edu.sample.user.model.BoardUser;

public interface UserDAO {
	public BoardUser login(String id, String passwd) throws Exception;

	public boolean join(BoardUser user) throws Exception;

	public List<BoardUser> getUserList(int from, int to) throws Exception;

	public boolean deleteUser(String userId) throws Exception;

	public int getUserCount() throws Exception;
}
