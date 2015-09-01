package orm.ibatis.dao3;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import orm.ibatis.model.BoardUser;

import com.ibatis.sqlmap.client.SqlMapClient;

@Repository
public class UserDAOImpl implements UserDAO {
	@Autowired
	private SqlMapClient sqlMapClient;

	@Override
	@SuppressWarnings("unchecked")
	@Transactional(readOnly=true)
	public List<BoardUser> getBoardUserList(int st, int ed) throws Exception {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("st", st);
		params.put("ed", ed);
		return sqlMapClient.queryForList("boardUser.getBoardUserList", params);
	}

	@Override
	@Transactional(readOnly=true)
	public BoardUser getBoardUserById(String id) throws Exception {
		return (BoardUser) sqlMapClient.queryForObject("boardUser.getBoardUserById", id);
	}

	@Override
	@Transactional
	public boolean addBoardUser(BoardUser user) throws Exception {
		sqlMapClient.insert("boardUser.addBoardUser", user);
		return true;
	}

	@Override
	@Transactional
	public boolean removeBoardUser(BoardUser user) throws Exception {
		sqlMapClient.delete("boardUser.removeBoardUserById", user.getId());
		return true;
	}

	@Override
	@Transactional
	public boolean removeBoardUserById(String id) throws Exception {
		sqlMapClient.delete("boardUser.removeBoardUserById", id);
		return true;
	}

	@Override
	@Transactional
	public boolean updateBoardUser(BoardUser user) throws Exception {
		sqlMapClient.update("boardUser.updateBoardUser", user);
		return true;
	}

	@Override
	@Transactional(readOnly=true)
	public int getUserCountById(String id) throws Exception {
		return (Integer) sqlMapClient.queryForObject("boardUser.getUserCountById", id);
	}


}
