package pkutepv.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import pkutepv.dao.user_dao.User;
import pkutepv.dao.user_dao.UserInfo;
import pkutepv.dao.user_dao.UserService;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/")
public class ApplicationController {

@Autowired
    private UserService userService;

    @Value("${value:none}")
    public String value;


    @RequestMapping(method = RequestMethod.GET)
    public String printWelcome(ModelMap model) {
        model.addAttribute("message", "Hello world!");
        model.addAttribute("property_value", value);
        return "index";
    }
    /**
     * Добавление в базу данных и вывод копии сохраненной задачи
     * @param login
     * @param password
     * @param lastname
     * @param firstname
     * @param patronymic
     * @param phoneNumber
     * @return копия сохраненных значений
     */
    @RequestMapping(value = "add/user",method = RequestMethod.POST )
    public @ResponseBody User addUser(
            @RequestParam("login") String login,
            @RequestParam("password") String password,
            @RequestParam("lastname") String lastname,
            @RequestParam("firstname") String firstname,
            @RequestParam("patronymic") String patronymic,
            @RequestParam("phoneNumber") String phoneNumber)

    {
       UserInfo userInfo=new  UserInfo(lastname,firstname,patronymic,phoneNumber);
      User user=  userService.addUser(login,password,userInfo);
        Map<String, UserInfo> map = new HashMap<>();
        map.put("login", userInfo);
        return user;
    }




      public void setUserService(UserService userService) {
        this.userService = userService;
    }
}
