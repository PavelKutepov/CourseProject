package test_dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import pkutepv.dao.employer_dao.Departament;
import pkutepv.dao.employer_dao.DepartamentDao;
import pkutepv.dao.employer_dao.EmployeeService;
import pkutepv.dao.user_dao.User;
import pkutepv.dao.user_dao.UserService;

import java.util.List;

import static org.junit.Assert.assertNotNull;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:WEB-INF/applicationContext.xml")
public class TestEmployeeDao {
    @Autowired
     private   EmployeeService employeeService;
    @Autowired
    private UserService userService;
    @Autowired
    DepartamentDao departamentDao;

    @Test
    public void employeeDaoTest(){
        System.out.println("employeeDaoTest");
   //  User user= userService.getUserById(1);
   //  Departament departament=   new Departament(1,"dfs","sdfsdf");
       // employeeService.addEmployee(user,departament);
        employeeService.getEmployeeById(1);
    }
    @Test
    public void departamentDaoTest(){
        System.out.println("departamentDaoTest");
        //departamentDao.addDepartament("deb","sdf");
       List<Departament> allDepartaments= departamentDao.getAllDepartament();
        assertNotNull(allDepartaments);
    Departament departament = departamentDao.getDepartamentById(1);

        assertNotNull(departament);
    }
}
