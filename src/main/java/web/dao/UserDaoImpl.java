package web.dao;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import web.exception.UserNotFoundException;
import web.model.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;
import java.util.Optional;

@Repository
public class UserDaoImpl implements UserDao{

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    @Transactional
    public User addUser(User user) {
        entityManager.persist(user);
        return entityManager.find(User.class, user.getId());
    }

    @Override
    public User findUser(Long id) {
        return Optional.of(entityManager.find(User.class, id)).orElseThrow(UserNotFoundException::new);
    }

    @Transactional
    @Override
    public User updateUser(User user) {
        return Optional.of(entityManager.merge(user)).orElseThrow(UserNotFoundException::new);
    }

    @Override
    public void deleteUser(Long id) {
        findUser(id);
        Query query = entityManager.createQuery("DELETE FROM User WHERE id = :id");
        query.setParameter("id", id);
        query.executeUpdate();
    }

    @Override
    public List<User> getAllUsers() {
        return entityManager.createQuery("FROM User", User.class).getResultList();
    }
}
