package orm.ibatis.dao4;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.ibatis.SqlMapClientTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import orm.ibatis.model.BoardUser;

@Repository
public class UserDAOImpl implements UserDAO {
	@Autowired
	private SqlMapClientTemplate sqlMapClientTemplate;

	@Override
	@SuppressWarnings("unchecked")
	@Transactional(readOnly=true)
	public List<BoardUser> getBoardUserList(int st, int ed) throws Exception {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("st", st);
		params.put("ed", ed);
		return sqlMapClientTemplate.queryForList("boardUser.getBoardUserList", params);
	}

	@Override
	@Transactional(readOnly=true)
	public BoardUser getBoardUserById(String id) throws Exception {
		return (BoardUser) sqlMapClientTemplate.queryForObject("boardUser.getBoardUserById", id);
	}

	@Override
	@Transactional
	public boolean addBoardUser(BoardUser user) throws Exception {
		sqlMapClientTemplate.insert("boardUser.addBoardUser", user);
		throw new RuntimeException();
	}
	
	@Override
	@Transactional
	public boolean removeBoardUser(BoardUser user) throws Exception {
		sqlMapClientTemplate.delete("boardUser.removeBoardUserById", user.getId());
		return true;
	}

	@Override
	@Transactional
	public boolean removeBoardUserById(String id) throws Exception {
		sqlMapClientTemplate.delete("boardUser.removeBoardUserById", id);
		return true;
	}

	@Override
	@Transactional
	public boolean updateBoardUser(BoardUser user) throws Exception {
		sqlMapClientTemplate.update("boardUser.updateBoardUser", user);
		return true;
	}

	@Override
	@Transactional(readOnly=true)
	public int getUserCountById(String id) throws Exception {
		return (Integer) sqlMapClientTemplate.queryForObject("boardUser.getUserCountById", id);
	}


}
