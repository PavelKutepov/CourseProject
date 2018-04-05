package test_dao;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import pkutepv.dao.user_dao.User;
import pkutepv.dao.user_dao.UserServices;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.util.ArrayList;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:WEB-INF/applicationContext.xml")
public class TestUserDao {
    @Autowired
    private UserServices userServices;

    @Before
    public void setUp() throws Exception {

    }


    @Test
    public void testUserDao() {
        List<User> userstest = new ArrayList<>();
        System.out.println("testUserDao");
        List<User> users = userServices.getAllUsers();
        assertNotNull(users);
        for (User us : users) {
            System.out.println(us.getLogin());
            System.out.println(us.getUserInfo().getFirstName());
        }

    }

    @Test
    public void testGetUserById() {
        System.out.println("testGetUserById");

        User user = userServices.getUserById(1);
        assertNotNull(user);


    }
}
