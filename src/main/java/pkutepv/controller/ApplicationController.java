package pkutepv.controller;

import org.springframework.web.bind.annotation.*;

import pkutepv.dao.user_dao.UserServices;

import javax.inject.Inject;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/")
public class ApplicationController {

    @Inject
    private UserServices userServices;
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

    public @ResponseBody
    Map addUser(
            @RequestParam("login") String login,
            @RequestParam("password") String password,
            @RequestParam("lastname") String lastname,
            @RequestParam("firstname") String firstname,
            @RequestParam("patronymic") String patronymic,
            @RequestParam("phoneNumber") String phoneNumber)

    {
        userServices.addUser(login,password,lastname,firstname,patronymic,phoneNumber);
        Map<String, Object> map = new HashMap<>();
        map.put("login", login);
        map.put("password", password);
        map.put("lastname", lastname);
        map.put("firstname", firstname);
        map.put("patronymic", patronymic);
        map.put("phoneNumber", phoneNumber);
        return map;
    }

}
