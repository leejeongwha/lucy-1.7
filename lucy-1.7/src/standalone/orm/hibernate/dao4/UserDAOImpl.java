package orm.hibernate.dao4;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import orm.hibernate.model.BoardUser;

@Repository
public class UserDAOImpl implements UserDAO {
	@Autowired
	private HibernateTemplate hibernateTemplate;

	@Override
	@SuppressWarnings("unchecked")
	@Transactional(readOnly=true)
	public List<BoardUser> getBoardUserList(int st, int ed) throws Exception {
		return hibernateTemplate.find("FROM board_user");
	}

	@Override
	@Transactional(readOnly=true)
	public BoardUser getBoardUserById(String id) throws Exception {
		return hibernateTemplate.get(BoardUser.class, id);
	}

	@Override
	@Transactional
	public boolean addBoardUser(BoardUser user) throws Exception {
		hibernateTemplate.persist(user);
		throw new RuntimeException();
	}

	@Override
	@Transactional
	public boolean removeBoardUser(BoardUser user) throws Exception {
		hibernateTemplate.delete(user);
		return true;
	}

	@Override
	@Transactional
	public boolean removeBoardUserById(String id) throws Exception {
		hibernateTemplate.delete(hibernateTemplate.get(BoardUser.class, id));
		return true;
	}

	@Override
	@Transactional
	public boolean updateBoardUser(BoardUser user) throws Exception {
		hibernateTemplate.update(user);
		return true;
	}

	@Override
	@Transactional(readOnly=true)
	public int getUserCountById(String id) throws Exception {
		return hibernateTemplate.find("FROM board_user WHERE id = '" + id + "'").size();
	}

}
