package orm.ibatis.dao1;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ibatis.sqlmap.client.SqlMapClient;

import orm.ibatis.model.BoardUser;

@Repository
public class UserDAOImpl extends SqlMapClientDaoSupport implements UserDAO {
	@Autowired
	public UserDAOImpl(SqlMapClient sqlMapClient) {
		this.setSqlMapClient(sqlMapClient);
	}

	@Override
	@SuppressWarnings("unchecked")
	@Transactional(readOnly=true)
	public List<BoardUser> getBoardUserList(int st, int ed) throws Exception {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("st", st);
		params.put("ed", ed);
		return getSqlMapClientTemplate().queryForList("boardUser.getBoardUserList", params);
	}

	@Override
	@Transactional(readOnly=true)
	public BoardUser getBoardUserById(String id) throws Exception {
		return (BoardUser) getSqlMapClientTemplate().queryForObject("boardUser.getBoardUserById", id);
	}

	@Override
	@Transactional
	public boolean addBoardUser(BoardUser user) throws Exception {
		getSqlMapClientTemplate().insert("boardUser.addBoardUser", user);
		return true;
	}

	@Override
	@Transactional
	public boolean removeBoardUser(BoardUser user) throws Exception {
		getSqlMapClientTemplate().delete("boardUser.removeBoardUserById", user.getId());
		return true;
	}

	@Override
	@Transactional
	public boolean removeBoardUserById(String id) throws Exception {
		getSqlMapClientTemplate().delete("boardUser.removeBoardUserById", id);
		return true;
	}

	@Override
	@Transactional
	public boolean updateBoardUser(BoardUser user) throws Exception {
		getSqlMapClientTemplate().update("boardUser.updateBoardUser", user);
		return true;
	}

	@Override
	@Transactional(readOnly=true)
	public int getUserCountById(String id) throws Exception {
		return (Integer) getSqlMapClientTemplate().queryForObject("boardUser.getUserCountById", id);
	}


}
