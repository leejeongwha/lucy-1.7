package transaction.dao2;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.springframework.stereotype.Repository;

import transaction.model.BoardUser;

@Repository
public class UserDAOImpl implements UserDAO {
	private Logger logger = LoggerFactory.getLogger(getClass());
	
	@Autowired
	private SimpleJdbcTemplate simpleJdbcTemplate;
	
	@Override
	public List<BoardUser> getBoardUserList(int st, int ed) throws Exception {
		String sql = "SELECT * FROM board_user LIMIT " + st + ", " + ed;
		return simpleJdbcTemplate.query(sql, new BoardUserRowMapper());
	}

	@Override
	public BoardUser getBoardUserById(String id) throws Exception {
		String sql = "SELECT * FROM board_user WHERE id = '" + id + "'";
		return simpleJdbcTemplate.queryForObject(sql, new BoardUserRowMapper());
	}

	@Override
	public boolean addBoardUser(final BoardUser user) throws Exception {
		String sql = "INSERT INTO board_user (id, passwd, user_name, age, role) VALUES (?, ?, ?, ?, ?)";
		int insertCount = simpleJdbcTemplate.update(sql, user.getId(), user.getPasswd(), user.getUserName(), user.getAge(), user.getRole());
		
		logger.info("" +insertCount);
		
		throw new RuntimeException();
	}

	@Override
	public boolean removeBoardUser(BoardUser user) throws Exception {
		return removeBoardUserById(user.getId());
	}

	@Override
	public boolean removeBoardUserById(String id) throws Exception {
		String sql = "DELETE FROM board_user WHERE id = :id";
		
		Map<String, String> params = new HashMap<String, String>();
		params.put("id", id);
		
		int removeCount = simpleJdbcTemplate.update(sql, params);

		if(removeCount > 0) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public boolean updateBoardUser(BoardUser user) throws Exception {
		String sql = "UPDATE board_user SET passwd = ?, user_name = ?, age = ?, role = ? WHERE id = ?";
		int updateCount = simpleJdbcTemplate.update(sql, user.getPasswd(), user.getUserName(), user.getAge(), user.getRole(), user.getId());

		if(updateCount > 0) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public int getUserCountById(String id) throws Exception {
		String sql = "SELECT COUNT(*) FROM board_user WHERE id = ?";
		return simpleJdbcTemplate.queryForInt(sql, id);
	}

}
