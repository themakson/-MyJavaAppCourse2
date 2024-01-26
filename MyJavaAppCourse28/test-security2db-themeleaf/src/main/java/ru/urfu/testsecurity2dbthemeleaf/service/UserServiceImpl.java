package ru.urfu.testsecurity2dbthemeleaf.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import ru.urfu.testsecurity2dbthemeleaf.dto.UserDto;
import ru.urfu.testsecurity2dbthemeleaf.entity.Role;
import ru.urfu.testsecurity2dbthemeleaf.entity.User;
import ru.urfu.testsecurity2dbthemeleaf.repository.RoleRepository;
import ru.urfu.testsecurity2dbthemeleaf.repository.UserRepository;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;



@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder;



    @Autowired
    public UserServiceImpl(UserRepository userRepository,
                           RoleRepository roleRepository,
                           PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.passwordEncoder = passwordEncoder;
    }

//    @Override
//    public void makeAdmin(User user){
//        user.setRoles(Arrays.asList(role.set);
//
//    }

    @Override
    public void saveUser(UserDto userDto) {
        User user = new User();
        user.setName(userDto.getFirstName() + " " + userDto.getLastName());
        user.setEmail(userDto.getEmail());
        //ENCRYPT THE PASSWORD
        user.setPassword(passwordEncoder.encode(userDto.getPassword()));



//        //Role role = roleRepository.findByName("ROLE_ADMIN");
//        if(role == null){
//            role = checkRoleExist();
//        }
//        user.setRoles(Arrays.asList(role));
//        Role role = new Role();
//        role.setName("ROLE_USER");

        user.setRoles(Arrays.asList(setPermission(user)));
        userRepository.save(user);
    }

    @Override
    public User findUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }



    @Override
    public List<UserDto> findAllUsers() {
        List<User> users = userRepository.findAll();
        return users.stream()
                .map((user)->mapToUserDto(user))
                .collect(Collectors.toList());
    }

    private UserDto mapToUserDto(User user) {
        UserDto userDto = new UserDto();
        String[] str = user.getName().split(" ");
        userDto.setFirstName(str[0]);
        userDto.setLastName(str[1]);
        userDto.setEmail(user.getEmail());
        return userDto;

    }

    private Role setPermission(User user) {
        Role role = new Role();

        if(Objects.equals(user.getEmail(), "admin@mail.ru")){
            role.setName("ROLE_ADMIN");
        } else {
            role.setName("ROLE_USER");
        }


        return role;
    }
    private Role checkRoleExist() {
        Role role = new Role();
        role.setName("ROLE_USER");
        return roleRepository.save(role);
    }
}
