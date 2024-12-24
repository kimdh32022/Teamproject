package ServiceTest;

import dto.UsersDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import service.UsersService;

@SpringBootTest
@Log4j2
@RequiredArgsConstructor
public class UsersServiceTest {


    private final UsersService usersService;

    @Test
    public void Logintest() {
        UsersDTO usersDTO = UsersDTO.builder()
                .userid(1)
                .email("ehgus@gamil.com")
                .password("1234")
                .name("도현")
                .age(26)
                .gender(true)
                .address("부산")
                .profilePicture("/사진 경로")
                .phoneNumber("010-1234-5678")
                .isVerified(true)
                .build();

        UsersDTO createdUser = usersService.createUser(usersDTO);
        log.info(createdUser);
    }
}
