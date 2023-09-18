package hiber;

import hiber.config.AppConfig;
import hiber.model.Car;
import hiber.model.User;
import hiber.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.SQLException;
import java.util.List;

public class MainApp {
   public static void main(String[] args) throws SQLException {
      AnnotationConfigApplicationContext context = 
            new AnnotationConfigApplicationContext(AppConfig.class);

      UserService userService = context.getBean(UserService.class);

      User user1 = new User("User1", "Lastname1", "user1@mail.ru");
      User user2 = new User("User2", "Lastname2", "user2@mail.ru");

      userService.add(user1.setCar(new Car("nissan", 2000)).setUser(user1));
      userService.add(user2.setCar(new Car("toyota", 2001)).setUser(user2));

      List<User> users = userService.listUsers();
      for (User user : users) {
         System.out.println(user + " " + user.getCar());
      }
      System.out.println(userService.getUserWithCar("toyota", 2001));
      try {
         User user = userService.getUserWithCar("bmw", 2002);
         System.out.println(user);
      } catch (Exception e) {
         System.out.println("not found");
      }
      context.close();
   }
}
