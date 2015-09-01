package com.nhncorp.edu.sample.user.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.ibatis.SqlMapClientTemplate;
import org.springframework.stereotype.Repository;

import com.nhncorp.edu.sample.user.model.BoardUser;

@Repository
public class UserDAOImpl implements UserDAO {
	private static final String NAMESPACE = "user.";
	
	@Autowired
	private SqlMapClientTemplate template;

	@Override
	public BoardUser login(String id, String passwd) throws Exception {
		Map<String, String> params = new HashMap<String, String>();
		params.put("id", id);
		params.put("passwd", passwd);
		return (BoardUser) template.queryForObject(NAMESPACE + "login", params);
	}

	@Override
	public boolean join(BoardUser user) throws Exception {
		template.insert(NAMESPACE + "join", user);
		return true;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<BoardUser> getUserList(int from, int to) throws Exception {
		Map<String, Integer> params = new HashMap<String, Integer>();
		params.put("from", from);
		params.put("to", to);
		return template.queryForList(NAMESPACE + "getUserList", params);
	}

	@Override
	public boolean deleteUser(String userId) throws Exception {
		template.delete(NAMESPACE + "deleteUser", userId);
		return true;
	}

	@Override
	public int getUserCount() throws Exception {
		return (Integer) template.queryForObject(NAMESPACE + "getUserCount");
	}

}
