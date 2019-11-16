package sda.mvc.Twitter.model.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;
import sda.mvc.Twitter.model.dto.LoginUserDTO;
import sda.mvc.Twitter.model.entity.LoginUser;
import sda.mvc.Twitter.repository.LoginUserRepository;

@Service
public class LoginUserService {

//    @Autowired
//    private PasswordEncoder bCryptPasswordEndcoder;

    @Autowired
    private LoginUserRepository loginUserRepository;

    @Autowired
    private ModelMapper mapper;

//    public void addLoginUser(LoginUserDTO loginUserDto, BindingResult result) {
//        BindingValidator.validate(result);
//        System.out.println(loginUserDto.getLogin() + " "
//                + loginUserDto.getPassword() + " "
//                + loginUserDto.getRole());

//        if (!CheckAuthorities(loginUserDto)) {
//            throw new RuntimeException("Wrong role!");
//
//        }
//        System.out.println("Mogę dodać użytkownika");
//        String hash = bCryptPasswordEndcoder.encode(loginUserDto.getPassword());
//        System.out.println("Hasło: " + loginUserDto.getPassword()
//                + " " + "Hash: " + hash
//                + " " + "Matches: " + bCryptPasswordEndcoder.matches("test", hash));
//
//        LoginUser loginUser = mapper.map(loginUserDto, LoginUser.class);
//        loginUser.setPassword(hash);
//        loginUserRepository.save(loginUser);

//    }

    private void validateLoginUser(LoginUserDTO loginUserDto) {
        if (loginExist(loginUserDto)){
            throw new RuntimeException("Login already exist!");
        }
    }

    private boolean loginExist(LoginUserDTO loginUserDto) {
        return loginUserRepository.countByLogin(loginUserDto.getLogin()) > 0;
    }

//    private boolean CheckAuthorities(LoginUserDTO loginUserDto) {
//        return SecurityContextHolder
//                .getContext()
//                .getAuthentication()
//                .getAuthorities()
//                .toArray()[0]
//                .toString()
//                .equals(loginUserDto.getRole());
//    }
}