package mc.apps.spring.controller;

import mc.apps.spring.model.User;
import mc.apps.spring.model.UserRepository;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins="http://localhost:4200") //  Angular frontend url : http://localhost:4200
public class MainRestController {
    private static final Logger logger = LogManager.getLogger(MainRestController.class);

    private final UserRepository userRepository;
    public MainRestController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping("/" )
    public String index(){
        return "<a href='/list'>Users</a>";
    }

    @GetMapping("/list" )
    public List<User> list(){
        return (List<User>) userRepository.findAll();
    }

    @PostMapping("/add")
    public void add(@RequestBody User user){
        logger.log(Level.INFO, "********************************");
        logger.log(Level.INFO, "user to add : "+user);
        logger.log(Level.INFO, "********************************");
        userRepository.save(user);
    }

}
