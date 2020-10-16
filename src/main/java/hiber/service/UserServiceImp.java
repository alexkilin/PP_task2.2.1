package hiber.service;
import hiber.dao.UserDao;
import hiber.model.Car;
import hiber.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
@Transactional (readOnly = true)
public class UserServiceImp implements UserService {

   @Autowired
   private UserDao userDao;

   @Transactional
   @Override
   public void add(User user) {
      userDao.add(user);
   }


   @Override
   public List<User> listUsers() {
      return userDao.listUsers();
   }



   @Override
   public User findUserByCarName(String name) {
      return userDao.findUserByCarName(name);
   }


   @Override
   public User findUserByCarNumberAndSeries(int number, int series){
      return userDao.findUserByCarNumberAndSeries(number, series);
   }

   @Transactional
   @Override
   public void update (User user) {
      userDao.update(user);
   }

   @Transactional
   @Override
   public void updateCar (Car car) {
      userDao.updateCar(car);
   }

   @Override
   public User readUserById (Long id){
    return userDao.readUserById(id);
   }

   @Override
   public void printInfo(User user) {
      System.out.println("Id = " + user.getId());
      System.out.println("First Name = " + user.getFirstName());
      System.out.println("Last Name = " + user.getLastName());
      System.out.println("Email = " + user.getEmail());
      System.out.println("Car = " + user.getCar().getName() + " " + user.getCar().getSeries());
   }
}
