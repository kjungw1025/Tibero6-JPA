package taba.tibero6jpa.user.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import taba.tibero6jpa.user.domain.Member;
import taba.tibero6jpa.user.domain.RequestMemberDto;
import taba.tibero6jpa.user.repository.MemberRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MemberService {
    private final MemberRepository memberRepository;

    @Transactional
    public Long join(RequestMemberDto dto) {
        validateDuplicateMember(dto);

        Member member = Member.builder()
                .name(dto.getName())
                .phone(dto.getPhone())
                .build();
        memberRepository.save(member);

        return member.getId();
    }

    private void validateDuplicateMember(RequestMemberDto dto) {
        List<Member> findMembers = memberRepository.findByName(dto.getName());
        if (!findMembers.isEmpty()) {
            throw new IllegalStateException("이미 존재하는 회원입니다.");
        }
    }

    @Transactional(readOnly = true)
    public List<Member> findMembers() {
        return memberRepository.findAll();
    }

    @Transactional(readOnly = true)
    public List<Member> findByName(String name) {
        return memberRepository.findByName(name);
    }
}
