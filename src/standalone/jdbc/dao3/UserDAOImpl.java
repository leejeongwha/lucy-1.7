package jdbc.dao3;

import java.util.List;

import javax.sql.DataSource;

import jdbc.model.BoardUser;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

@Repository
public class UserDAOImpl extends JdbcDaoSupport implements UserDAO {
	
	@Autowired
	public UserDAOImpl(DataSource dataSource) {
		this.setDataSource(dataSource);
	}
	
	@Override
	public List<BoardUser> getBoardUserList(int st, int ed) throws Exception {
		String sql = "SELECT * FROM board_user LIMIT " + st + ", " + ed;
		return getJdbcTemplate().query(sql, new BoardUserRowMapper());
	}

	@Override
	public BoardUser getBoardUserById(String id) throws Exception {
		String sql = "SELECT * FROM board_user WHERE id = '" + id + "'";
		return getJdbcTemplate().queryForObject(sql, new BoardUserRowMapper());
	}

	@Override
	public boolean addBoardUser(BoardUser user) throws Exception {
		String sql = "INSERT INTO board_user (id, passwd, user_name, age, role) VALUES (?, ?, ?, ?, ?)";
		int insertCount = getJdbcTemplate().update(sql, user.getId(), user.getPasswd(), user.getUserName(), user.getAge(), user.getRole());
		
		if(insertCount > 0) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public boolean removeBoardUser(BoardUser user) throws Exception {
		return removeBoardUserById(user.getId());
	}

	@Override
	public boolean removeBoardUserById(String id) throws Exception {
		String sql = "DELETE FROM board_user WHERE id = ?";
		int removeCount = getJdbcTemplate().update(sql, id);

		if(removeCount > 0) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public boolean updateBoardUser(BoardUser user) throws Exception {
		String sql = "UPDATE board_user SET passwd = ?, user_name = ?, age = ?, role = ? WHERE id = ?";
		int updateCount = getJdbcTemplate().update(sql, user.getPasswd(), user.getUserName(), user.getAge(), user.getRole(), user.getId());

		if(updateCount > 0) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public int getUserCountById(String id) throws Exception {
		String sql = "SELECT COUNT(*) FROM board_user WHERE id = ?";
		return getJdbcTemplate().queryForInt(sql, id);
	}

}
