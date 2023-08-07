package member;

import com.bit.shop.domain.Member;
import com.bit.shop.service.MemberService;
import com.bit.shop.service.MemberServiceImpl;
import java.util.logging.Logger;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

public class MemberSelectTest {

    Logger log = Logger.getLogger("MemberInsertTest");

    MemberService service;

    @BeforeEach
    void before() throws Exception {
        service = new MemberServiceImpl();
    }

    @DisplayName("Member Select Test")
    @Test
    @Order(1)
    void select() throws Exception {

        // given
        long id = 1L;
        String email = "email";

        // when
        Member member = service.findMember(id);

        // then
        Assertions.assertEquals(email, member.getEmail());


    }

}
