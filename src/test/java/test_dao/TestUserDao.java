package test_dao;

import org.eclipse.jetty.server.Authentication;
import org.junit.Test;
import org.junit.Assert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
import pkutepv.dao.user_dao.User;
import pkutepv.dao.user_dao.UserDao;
import pkutepv.dao.user_dao.UserInfoService;
import pkutepv.dao.user_dao.UserServices;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import java.util.ArrayList;
import java.util.List;

@ContextConfiguration("classpath:WEB-INF/applicationContext.xml")
public class TestUserDao extends AbstractJUnit4SpringContextTests {
    @Autowired
 private UserServices userServices;
//    @Autowired
// private UserInfoService userInfoService;
//
@Test
public void testUserDao(){
 List<User> userstest= new ArrayList<>();

    List<User> users = userServices.getAllUsers();
    assertEquals(userstest,userstest);
}
}
