package com.ntuzy.springcloud.member.repository;

import com.ntuzy.springcloud.member.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MemberRepository extends JpaRepository<Member, Long> {
    public List findByMobile (String mobile);
}
