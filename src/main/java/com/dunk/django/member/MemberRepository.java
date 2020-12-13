package com.dunk.django.member;

import com.dunk.django.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Transactional(readOnly = true)
public interface MemberRepository extends JpaRepository<Member, Long> {
    boolean existsByAccount(String account);

    Optional<Member> findByAccount(String account);
}