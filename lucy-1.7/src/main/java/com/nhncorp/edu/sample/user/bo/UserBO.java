package com.nhncorp.edu.sample.user.bo;

import java.util.List;

import com.nhncorp.edu.sample.user.model.BoardUser;

public interface UserBO {
	public BoardUser login(String id, String passwd) throws Exception;

	public boolean join(BoardUser user) throws Exception;

	public int getUserCount() throws Exception;

	public List<BoardUser> getUserList(int from, int to) throws Exception;

	public boolean deleteUser(String userId) throws Exception;
}
