package application;

import application.database.*;
import application.model.*;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Random;

@RestController
public class UserController extends Controller {

    @GetMapping("user")
    public User getUser(@RequestParam("userID") int userID) throws DatabaseConnectException, DatabaseQueryException, DatabaseUpdateException, DatabaseInsertException {

        System.out.println("Inside getUser()");
        DBProvider dbProvider = new Db2();
        User user = dbProvider.getUser(userID);


        dbProvider.close();
        return user;
    }

}
