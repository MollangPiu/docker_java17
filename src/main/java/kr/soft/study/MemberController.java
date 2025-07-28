package kr.soft.study;

import kr.soft.study.entity.Member;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

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

    @GetMapping("/list")
    public List<MemberRes> list() {
        log.info("list");
        List<Member> members = memberRepository.findAll();
        List<MemberRes> memberResList = new ArrayList<>();
        for (Member member : members) {
            memberResList.add(new MemberRes(member));
        }

        return memberResList;
    }

    @Data
    private static class MemberRes {
        public MemberRes(Member member) {
            this.idx = member.getIdx();
            this.name = member.getName();
        }
        private long idx;
        private String name;
    }
}
