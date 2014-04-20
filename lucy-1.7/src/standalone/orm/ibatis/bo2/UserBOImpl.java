package orm.ibatis.bo2;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import orm.ibatis.dao2.UserDAO;
import orm.ibatis.model.BoardUser;

@Service
public class UserBOImpl implements UserBO {
	
	@Autowired
	private UserDAO dao;

	@Override
	public List<BoardUser> getBoardUserList(int st, int ed) throws Exception {
		return dao.getBoardUserList(st, ed);
	}

	@Override
	public BoardUser getBoardUserById(String id) throws Exception {
		return dao.getBoardUserById(id);
	}

	@Override
	public boolean addBoardUser(BoardUser user) throws Exception {
		return dao.addBoardUser(user);
	}

	@Override
	public boolean removeBoardUser(BoardUser user) throws Exception {
		return dao.removeBoardUser(user);
	}

	@Override
	public boolean removeBoardUserById(String id) throws Exception {
		return dao.removeBoardUserById(id);
	}

	@Override
	public boolean updateBoardUser(BoardUser user) throws Exception {
		return dao.updateBoardUser(user);
	}

	@Override
	public int getUserCountById(String id) throws Exception {
		return dao.getUserCountById(id);
	}

}
