package jdbc.dao3;

import java.sql.ResultSet;
import java.sql.SQLException;

import jdbc.model.BoardUser;

import org.springframework.jdbc.core.RowMapper;

public class BoardUserRowMapper implements RowMapper<BoardUser> {

	@Override
	public BoardUser mapRow(ResultSet rs, int rowNum) throws SQLException {
		BoardUser user = new BoardUser();
		
		user.setId(rs.getString("id"));
		user.setPasswd(rs.getString("passwd"));
		user.setUserName(rs.getString("user_name"));
		user.setAge(rs.getInt("age"));
		user.setRole(rs.getString("role"));
		
		return user;
	}

}
