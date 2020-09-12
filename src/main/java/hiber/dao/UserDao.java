package hiber.dao;

import hiber.model.Car;
import hiber.model.User;

import java.util.List;

public interface UserDao {
   void add(User user);

   User findUserByCarName(String name);
   User findUserByCarNumberAndSeries(int number, int series);
   List<User> listUsers();
   void update(User user);
   void updateCar (Car car);
   User readUserById (Long id);
}
