package hello.hellospring.service;

import hello.hellospring.domain.Member;
import hello.hellospring.repository.MemberRepository;
import hello.hellospring.repository.MemoryMemberRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


public class MemberService {
    private final MemberRepository memberRepository;

    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    /**
     * 회원가입
     */
    public Long join(Member member) {
        // 이름이 같은 중복회원 처리
        validateDuplicateMember(member);

        memberRepository.save(member);
        return member.getId();
    }

    private void validateDuplicateMember(Member member) {
        Optional<Member> result = memberRepository.findByName(member.getName());
        result.ifPresent(mem -> {
            throw new IllegalStateException("이미 존재하는 회원입니다.");
        }); // null이 아닌 값이 있으면 예외로 처리
    }

    /**
     * 전체 회원 조회
     */
    public List<Member> findMembers() {
        return memberRepository.findAll();
    } // 서비스 메소드는 비즈니스적인 용어를 사용하고 레포지토리 메소드는 기계적인 용어를 사용한다.

    public Optional<Member> findOne(Long id) {
        return memberRepository.findById(id);
    }
}
