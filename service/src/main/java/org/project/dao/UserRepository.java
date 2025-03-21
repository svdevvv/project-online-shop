package org.project.dao;


import jakarta.persistence.EntityManager;
import org.project.entity.UserEntity;

import static org.project.entity.QUserEntity.userEntity;


public class UserRepository extends RepositoryBase<Long, UserEntity> {

    public UserRepository(EntityManager entityManager) {
        super(UserEntity.class, userEntity, entityManager);
    }

//    public List<UserEntity> findAll(Session session) {
//////        return session.createQuery("select u from UserEntity u",UserEntity.class)
//////                .list();
////        HibernateCriteriaBuilder cb = session.getCriteriaBuilder();
////
////        var criteria = cb.createQuery(UserEntity.class);
////        var user = criteria.from(UserEntity.class);
////        criteria.select(user);
////        return session.createQuery(criteria)
////                .list();
//        return new JPAQuery<UserEntity>(session)
//                .select(userEntity)
//                .from(userEntity)
//                .fetch();
//    }

//    public UserEntity findById(Session session, Long id) {
////        return session.createQuery("select u from UserEntity u where u.id = :id", UserEntity.class)
////                .setParameter("id", id)
////                .getSingleResult();
////        var cb = session.getCriteriaBuilder();
////
////        var criteria = cb.createQuery(UserEntity.class);
////        var user = criteria.from(UserEntity.class);
////        criteria.select(user).where(cb.equal(user.get("id"),id));
////        return session.createQuery(criteria)
////                .uniqueResult();
//        return new JPAQuery<UserEntity>(session)
//                .select(userEntity)
//                .from(userEntity)
//                .where(userEntity.id.eq(id))
//                .fetchFirst();
//    }

//    public List<UserEntity> findAllByRole(Session session, UserFilter filter) {
////        return session.createQuery("select u from UserEntity u where u.role = :role", UserEntity.class)
////                .setParameter("role", role)
////                .list();
////        var cb = session.getCriteriaBuilder();
////        var criteria = cb.createQuery(UserEntity.class);
////        var user = criteria.from(UserEntity.class);
////        criteria.select(user).where(cb.equal(user.get("role"),role));
////        return session.createQuery(criteria)
////                .list();
////
////        List<Predicate> predicates = new ArrayList<>();
////        if(filter.getLogin() != null){
////            predicates.add(userEntity.login.eq(filter.getLogin()));
////        }if(filter.getRole() != null){
////            predicates.add(userEntity.role.eq(filter.getRole()));
////
//
//        Predicate predicate = QPredicate.builder()
//                .add(filter.getLogin(), userEntity.login::eq)
//                .add(filter.getRole(), userEntity.role::eq)
//                .buildAnd();
//
//        return new JPAQuery<UserEntity>(session)
//                 .select(userEntity)
//                 .from(userEntity)
//                 .where(predicate)
//                 .fetch();
//    }

}
