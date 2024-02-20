package nogari.system.member.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.test.context.SpringBootTest;

@RequiredArgsConstructor
@SpringBootTest
@Slf4j
class MemberServiceImplTest {

    private final MemberServiceImpl memberService;
//    @Test
//    void findMemberById() {
//        String id = "handmade";
//        MemberDTO memberById = memberService.findMemberById(id);
//
//        log.info(memberById.toString());
//
//    }
}