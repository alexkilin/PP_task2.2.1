package hiber.dao;
import hiber.model.Car;
import hiber.model.User;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class UserDaoImp implements UserDao {

   @Autowired
   private SessionFactory sessionFactory;

   @Override
   public void add(User user) {
      sessionFactory.getCurrentSession().save(user);
   }

   @Override
   public void update(User user) {
      sessionFactory.getCurrentSession().update(user);
   }

   @Override
   public void updateCar (Car car){
      sessionFactory.getCurrentSession().update(car);
   }

   @Override
   @SuppressWarnings("unchecked")
   public List<User> listUsers() {
      TypedQuery<User> query=sessionFactory.getCurrentSession().createQuery("from User");
      return query.getResultList();
   }

    @Override
    @SuppressWarnings("unchecked")
    public User findUserByCarName(String name) {
        String hql = "from Car a where a.name = :name";
        Query query = sessionFactory.getCurrentSession().createQuery(hql);
        query.setParameter("name", name);
        Car tempResult = (Car) query.uniqueResult();
        return tempResult.getUser();
    }

   @Override
   @SuppressWarnings("unchecked")
   public User findUserByCarNumberAndSeries(int number, int series) {
      String hql = "from Car c where c.number = :number and c.series = :series";
      Query query = sessionFactory.getCurrentSession().createQuery(hql);
      query.setParameter ("number",number);
      query.setParameter ("series",series);
      Car tempResult = (Car) query.uniqueResult();
      return tempResult.getUser();
   }

   @Override
      public User readUserById (Long id) {
      User result;
      result = sessionFactory.openSession().get(User.class,id);
      return result;
      }

}
