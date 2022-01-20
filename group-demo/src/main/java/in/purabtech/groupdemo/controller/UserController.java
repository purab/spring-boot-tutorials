package in.purabtech.groupdemo.controller;

import in.purabtech.groupdemo.entity.User;
import in.purabtech.groupdemo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import javax.xml.bind.annotation.XmlType;
import java.security.Principal;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/user")
public class UserController {

    public static final String DEFAULT_ROLE="ROLE_USER";
    public static final String[] ADMIN_ACCESS={"ROLE_ADMIN","ROLE_MODERATOR"};
    public static final String[] MODERATOR_ACCESS={"ROLE_MODERATOR"};

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @PostMapping("/join")
    public String joinGroup(@RequestBody User user) {
        user.setRoles(DEFAULT_ROLE);
        String encryptedPassword = passwordEncoder.encode(user.getPassword());
        user.setPassword(encryptedPassword);
        userRepository.save(user);
        return "Hi "+user.getUsername()+" welcome to gorup";
    }

    //if loggedin user is ADMIN -> ADMIN or MODERATOR
    //
    @GetMapping("/access/{userId}/{userRole}")
    public String giveAccessToUser(@PathVariable int userId,@PathVariable String userRole, Principal principal) {
        User user = userRepository.findById(userId).get();
        List<String> activeRoles = getRolesByLoggedInUser(principal);
        String newRole="";
        if(activeRoles.contains(userRole)) {
            newRole = user.getRoles()+","+userRole;
            user.setRoles(newRole);
        }
        userRepository.save(user);
        return "Hi "+user.getUsername()+ " New Role assign to you by "+principal.getName();
    }

    private List<String> getRolesByLoggedInUser(Principal principal) {
        String roles = getLoggedInUser(principal).getRoles();
        List<String> assignRoles= Arrays.stream(roles.split(",")).collect(Collectors.toList());
        if(assignRoles.contains("ROLE_ADMIN")) {
            return Arrays.stream(ADMIN_ACCESS).collect(Collectors.toList());
        }
        if(assignRoles.contains("ROLE_MODERATOR")) {
            return Arrays.stream(MODERATOR_ACCESS).collect(Collectors.toList());
        }
        return Collections.emptyList();
    }

    private User getLoggedInUser(Principal principal){
        return userRepository.findByUserName(principal.getName()).get();
    }
}
