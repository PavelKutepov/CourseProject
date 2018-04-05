package test_dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import pkutepv.dao.employer_dao.EmployeeService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:WEB-INF/applicationContext.xml")
public class TestEmployeeDao {
    EmployeeService employeeService;

    @Test
    public void employeeDaoTest(){
        System.out.println("employeeDaoTest");

    }
}
