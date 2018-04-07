package pkutepv.controller;

import org.springframework.web.bind.annotation.*;

import pkutepv.dao.user_dao.UserInfo;
import pkutepv.dao.user_dao.UserService;

import javax.inject.Inject;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/")
public class ApplicationController {


    private UserService userService;


    /**
     * Сохрение задачи в базу данных и вывод копии сохраненной задачи
     * @param login
     * @param password
     * @param lastname
     * @param firstname
     * @param patronymic
     * @param phoneNumber
     * @return копия сохраненных значений
     */
    @RequestMapping(value = "add/user",method = RequestMethod.POST )
    public @ResponseBody Map addUser(
            @RequestParam("login") String login,
            @RequestParam("password") String password,
            @RequestParam("lastname") String lastname,
            @RequestParam("firstname") String firstname,
            @RequestParam("patronymic") String patronymic,
            @RequestParam("phoneNumber") String phoneNumber)

    {
       UserInfo userInfo= userService.addUserInfo(lastname,firstname,patronymic,phoneNumber);
        userService.addUser(login,password,userInfo);
        Map<String, UserInfo> map = new HashMap<>();
        map.put("login", userInfo);
        return map;
    }

    public void setUserService(UserService userService) {
        this.userService = userService;
    }
}
