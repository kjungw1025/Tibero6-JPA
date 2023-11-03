package taba.tibero6jpa.user.controller;

import javax.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import taba.tibero6jpa.user.domain.Member;
import taba.tibero6jpa.user.domain.RequestMemberDto;
import taba.tibero6jpa.user.service.MemberService;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class MemberController {
    private final MemberService memberService;

    @GetMapping("/members/new")
    public String createForm(Model model) {
        model.addAttribute("requestMemberDto", new RequestMemberDto());
        return "createMember";
    }

    @PostMapping("/members/new")
    public String create(@Valid RequestMemberDto dto, BindingResult result) {
        if (result.hasErrors()) {
            return "createMember";
        }
        System.out.println("출력"+dto);
        memberService.join(dto);
        return "redirect:/members";
    }

    @GetMapping("/members")
    public String list(Model model) {
        List<Member> members = memberService.findMembers();
        model.addAttribute("members", members);
        return "memberList";
    }
}