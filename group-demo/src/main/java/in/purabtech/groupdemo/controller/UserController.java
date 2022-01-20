package in.purabtech.groupdemo.controller;

import in.purabtech.groupdemo.common.UserConstants;
import in.purabtech.groupdemo.entity.User;
import in.purabtech.groupdemo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
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

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @PostMapping("/join")
    public String joinGroup(@RequestBody User user) {
        user.setRoles(UserConstants.DEFAULT_ROLE);
        String encryptedPassword = passwordEncoder.encode(user.getPassword());
        user.setPassword(encryptedPassword);
        userRepository.save(user);
        return "Hi "+user.getUsername()+" welcome to gorup";
    }

    //if loggedin user is ADMIN -> ADMIN or MODERATOR
    //
    @GetMapping("/access/{userId}/{userRole}")
    //@Secured("ROLE_ADMIN")
    @PreAuthorize("hasAuthority('ROLE_ADMIN') or hasAuthority('ROLE_MODERATOR')")
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
            return Arrays.stream(UserConstants.ADMIN_ACCESS).collect(Collectors.toList());
        }
        if(assignRoles.contains("ROLE_MODERATOR")) {
            return Arrays.stream(UserConstants.MODERATOR_ACCESS).collect(Collectors.toList());
        }
        return Collections.emptyList();
    }

    private User getLoggedInUser(Principal principal){
        return userRepository.findByUserName(principal.getName()).get();
    }

    @GetMapping
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public List<User> loadUsers() {
        return userRepository.findAll();
    }

    @GetMapping("/test")
    @PreAuthorize("hasAuthority('ROLE_USER')")
    public String testUserAcess(){
        return "user can only access this!";
    }

}
