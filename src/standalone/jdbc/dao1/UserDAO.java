package jdbc.dao1;

import java.util.List;

import jdbc.model.BoardUser;

public interface UserDAO {
	public List<BoardUser> getBoardUserList(int st, int ed) throws Exception;

	public BoardUser getBoardUserById(String id) throws Exception;

	public boolean addBoardUser(BoardUser user) throws Exception;

	public boolean removeBoardUser(BoardUser user) throws Exception;

	public boolean removeBoardUserById(String id) throws Exception;

	public boolean updateBoardUser(BoardUser user) throws Exception;
	
	public int getUserCountById(String id) throws Exception;
}
