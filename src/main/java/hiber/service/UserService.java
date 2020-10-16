package hiber.service;

import hiber.model.Car;
import hiber.model.User;

import java.util.List;

public interface UserService {
    void add(User user);
    List<User> listUsers();
    User findUserByCarName(String name);
    User findUserByCarNumberAndSeries(int number, int series);
    void update(User user);
    void updateCar(Car car);
    User readUserById (Long id);
    void printInfo(User user);

}
