package orm.jpa.dao2;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.jpa.JpaTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import orm.jpa.model.BoardUser;

@Repository
public class UserDAOImpl implements UserDAO {
	@Autowired
	private JpaTemplate jpaTemplate;

	@Override
	@Transactional(readOnly=true)
	@SuppressWarnings("unchecked")
	public List<BoardUser> getBoardUserList(int st, int ed) throws Exception {
		return jpaTemplate.find("FROM board_user");
	}

	@Override
	@Transactional(readOnly=true)
	public BoardUser getBoardUserById(String id) throws Exception {
		return jpaTemplate.find(BoardUser.class, id);
	}

	@Override
	@Transactional
	public boolean addBoardUser(BoardUser user) throws Exception {
		jpaTemplate.persist(user);
		return true;
	}

	@Override
	@Transactional
	public boolean removeBoardUser(BoardUser user) throws Exception {
		BoardUser entity = jpaTemplate.find(BoardUser.class, user.getId());
		jpaTemplate.remove(entity);
		return true;
	}

	@Override
	@Transactional
	public boolean removeBoardUserById(String id) throws Exception {
		BoardUser entity = jpaTemplate.find(BoardUser.class, id);
		jpaTemplate.remove(entity);
		return true;
	}

	@Override
	@Transactional
	public boolean updateBoardUser(BoardUser user) throws Exception {
		BoardUser entity = jpaTemplate.find(BoardUser.class, user.getId());
		entity.setPasswd(user.getPasswd());
		entity.setUserName(user.getUserName());
		entity.setAge(user.getAge());
		entity.setRole(user.getRole());
		jpaTemplate.persist(entity);
		return true;
	}

	@Override
	@Transactional(readOnly=true)
	public int getUserCountById(String id) throws Exception {
		return jpaTemplate.find("FROM board_user WHERE id = '" + id + "'").size();
	}

}
