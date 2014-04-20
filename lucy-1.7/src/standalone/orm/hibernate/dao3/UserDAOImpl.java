package orm.hibernate.dao3;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import orm.hibernate.model.BoardUser;

@Repository
public class UserDAOImpl implements UserDAO {
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	@SuppressWarnings("unchecked")
	@Transactional(readOnly=true)
	public List<BoardUser> getBoardUserList(int st, int ed) throws Exception {
		return sessionFactory.getCurrentSession().createCriteria(BoardUser.class).list();
	}

	@Override
	@Transactional(readOnly=true)
	public BoardUser getBoardUserById(String id) throws Exception {
		return (BoardUser) sessionFactory.getCurrentSession().createCriteria(BoardUser.class).add(Restrictions.eq("id", id)).uniqueResult();
	}

	@Override
	@Transactional
	public boolean addBoardUser(BoardUser user) throws Exception {
		sessionFactory.getCurrentSession().save(user);
		return true;
	}

	@Override
	@Transactional
	public boolean removeBoardUser(BoardUser user) throws Exception {
		sessionFactory.getCurrentSession().delete(user);
		return true;
	}

	@Override
	@Transactional
	public boolean removeBoardUserById(String id) throws Exception {
		sessionFactory.getCurrentSession().delete(sessionFactory.getCurrentSession().get(BoardUser.class, id));
		return true;
	}

	@Override
	@Transactional
	public boolean updateBoardUser(BoardUser user) throws Exception {
		sessionFactory.getCurrentSession().update(user);
		return true;
	}

	@Override
	@Transactional(readOnly=true)
	public int getUserCountById(String id) throws Exception {
		return sessionFactory.getCurrentSession().createCriteria(BoardUser.class).add(Restrictions.eq("id", id)).list().size();
	}

}
