import hiber.config.AppConfig;
import hiber.model.Car;
import hiber.model.User;
import hiber.service.CarService;
import hiber.service.UserService;
import hiber.service.UserServiceImp;
import org.junit.Assert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;

@Component
public class UserServiceTest {

    @Autowired
    private UserService service;

    @org.junit.Before
    public void setUp() throws Exception {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(AppConfig.class);

        service = context.getBean(UserService.class);
        //CarService carService = context.getBean(CarService.class);
    }

    @org.junit.After
    public void tearDown() throws Exception {
    }

    @org.junit.Test
    public void findUserByCar() {
        String model = "model123";
        int series = 123;
        User user = new User("first_Name", "last_Name", "user@domen.ru");
        Car car = new Car(model, series);
        user.setCar(car);
        service.add(user);
        User user2 = service.findUserByCar(model, series);
        Assert.assertTrue("User by car model and series not found.", user.equals(user2) );
    }
}