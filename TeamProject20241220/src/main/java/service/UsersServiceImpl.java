package service;

import domain.Users;
import dto.UsersDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.UsersRepository;

import java.util.Optional;
@Service
public class UsersServiceImpl implements UsersService {

    @Autowired
    UsersRepository usersRepository;

    @Override
    public UsersDTO createUser(UsersDTO usersDTO) {
        Users user = Users.builder()
                .email(usersDTO.getEmail())
                .password(usersDTO.getPassword())
                .name(usersDTO.getName())
                .age(usersDTO.getAge())
                .gender(usersDTO.isGender())
                .address(usersDTO.getAddress())
                .profilePicture(usersDTO.getProfilePicture())
                .phoneNumber(usersDTO.getPhoneNumber())
                .isVerified(usersDTO.isVerified())
                .build();

        Users savedUser = usersRepository.save(user);
        return convertToDTO(savedUser);
    }

    @Override
    public Optional<UsersDTO> getUserById(Long userId) {
        return  usersRepository.findById(userId).map(this::convertToDTO);
    }


    private UsersDTO convertToDTO(Users user) {
        if (user == null) {
            return null; // null 체크 (필요에 따라)
        }

        return UsersDTO.builder()
                .userid(user.getUserId())
                .email(user.getEmail())
                // 비밀번호는 반환하지 않음 (보안상 이유)
                .name(user.getName())
                .age(user.getAge())
                .gender(user.isGender())
                .address(user.getAddress())
                .profilePicture(user.getProfilePicture())
                .phoneNumber(user.getPhoneNumber())
                .isVerified(user.isVerified())
                .build();
    }
}
