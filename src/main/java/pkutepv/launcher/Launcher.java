package pkutepv.launcher;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.webapp.WebAppContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import pkutepv.dao.user_dao.UserService;
import pkutepv.dao.user_dao.UserServiceImpl;

import java.net.URL;
import java.security.ProtectionDomain;

/**
 * Starts jetty-server on the specified port
 */
@Configuration

@ComponentScan
public class Launcher {

    public static void main(String[] args) throws Exception {

        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("WEB-INF/applicationContext.xml");
        UserService userService = context.getBean("userService",UserService.class);
//         MedicineService medicineServices = context.getBean(MedicineService.class);

        int port = 12135;
        try {
            if (args.length > 0) {
                port = Integer.parseInt(args[0]);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        Server server = new Server(port);

        ProtectionDomain domain = Launcher.class.getProtectionDomain();
        URL location = domain.getCodeSource().getLocation();

        WebAppContext webapp = new WebAppContext();
        webapp.setContextPath("/");
        webapp.setWar(location.toExternalForm());

        server.setHandler(webapp);
        server.start();

        server.join();


    }
}