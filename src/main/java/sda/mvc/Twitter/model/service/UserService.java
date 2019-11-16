package sda.mvc.Twitter.model.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sda.mvc.Twitter.model.dto.UserDTO;
import sda.mvc.Twitter.model.entity.User;
import sda.mvc.Twitter.repository.UserRepository;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
@Service
public class UserService {

    @Autowired
    private ModelMapper mapper;

    @Autowired
    private UserRepository userRepository;


    public void addUser(UserDTO userDTO) {
        User user = mapper.map(userDTO, User.class);
        System.out.println("Zmapowany user: " + user.getId()
                + " " + user.getName()
                + " " + user.getJoinDate()
                + " " + user.getSurname());
        user.setJoinDate(new Date());
        userRepository.save(user);
    }

    public List<UserDTO> getAllUsers() {
        List<User> users = userRepository.findAll();
        for (User u : users) {
            System.out.println("User: " + u.getId()
                    + " " + u.getName()
                    + " " + u.getJoinDate()
                    + " " + u.getSurname());
        }
        return users.stream()
                .map(u -> mapper.map(u, UserDTO.class))
                .collect(Collectors.toList());
    }
    public void deleteUser(UserDTO userDto){
        userRepository.deleteById(userDto.getId());
    }

}
