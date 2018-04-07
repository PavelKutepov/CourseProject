package test_dao;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import pkutepv.dao.user_dao.User;
import pkutepv.dao.user_dao.UserInfo;
import pkutepv.dao.user_dao.UserService;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.util.ArrayList;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:WEB-INF/applicationContext.xml")
public class TestUserDao {
    @Autowired
    private UserService userService;

    @Before
    public void setUp() throws Exception {

    }


    @Test
    public void testUserDao() {
        List<User> userstest = new ArrayList<>();
        System.out.println("testUserDao");
        List<User> users = userService.getAllUsers();
        assertNotNull(users);
        for (User us : users) {
            System.out.println(us.getLogin());
            System.out.println(us.getUserInfo().getFirstName());
        }

    }

    @Test
    public void testGetUserById() {
        System.out.println("testGetUserById");

        User user = userService.getUserById(1);
        assertNotNull(user);


    }
    @Test
    public void testAddUserInfo() {
        System.out.println("testAddUserInfo");
        UserInfo userInfo= userService.addUserInfo("Кутепов","Павел","Леонидович","2323223");

        assertNotNull(userInfo);
        System.out.println("testAddUser");
         userService.addUser("ppppp","Пsdfsdf",userInfo);



    }
    @Test
    public void testAddUser() {



    }
}
