package kr.soft.study;

import kr.soft.study.entity.Member;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@Slf4j
public class MemberController {

    private MemberRepository memberRepository;

    @GetMapping("/regist")
    public void regist(@RequestParam(name = "name", defaultValue = "Superman") String name) {
        log.info("regist");

        Member member = new Member();
        member.setName(name);
        memberRepository.save(member);

    }
}
