package orm.jpa.dao1;

import java.util.List;

import javax.persistence.EntityManagerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.jpa.support.JpaDaoSupport;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import orm.jpa.model.BoardUser;

@Repository
public class UserDAOImpl extends JpaDaoSupport implements UserDAO {
	@Autowired
	public UserDAOImpl(EntityManagerFactory entityManagerFactory) {
		this.setEntityManagerFactory(entityManagerFactory);
	}

	@Override
	@Transactional(readOnly=true)
	@SuppressWarnings("unchecked")
	public List<BoardUser> getBoardUserList(int st, int ed) throws Exception {
		return getJpaTemplate().find("FROM board_user");
	}

	@Override
	@Transactional(readOnly=true)
	public BoardUser getBoardUserById(String id) throws Exception {
		return getJpaTemplate().find(BoardUser.class, id);
	}

	@Override
	@Transactional
	public boolean addBoardUser(BoardUser user) throws Exception {
		getJpaTemplate().persist(user);
		return true;
	}

	@Override
	@Transactional
	public boolean removeBoardUser(BoardUser user) throws Exception {
		BoardUser entity = getJpaTemplate().find(BoardUser.class, user.getId());
		getJpaTemplate().remove(entity);
		return true;
	}

	@Override
	@Transactional
	public boolean removeBoardUserById(String id) throws Exception {
		BoardUser entity = getJpaTemplate().find(BoardUser.class, id);
		getJpaTemplate().remove(entity);
		return true;
	}

	@Override
	@Transactional
	public boolean updateBoardUser(BoardUser user) throws Exception {
		BoardUser entity = getJpaTemplate().find(BoardUser.class, user.getId());
		entity.setPasswd(user.getPasswd());
		entity.setUserName(user.getUserName());
		entity.setAge(user.getAge());
		entity.setRole(user.getRole());
		getJpaTemplate().persist(entity);
		return true;
	}

	@Override
	@Transactional(readOnly=true)
	public int getUserCountById(String id) throws Exception {
		return getJpaTemplate().find("FROM board_user WHERE id = '" + id + "'").size();
	}

}
