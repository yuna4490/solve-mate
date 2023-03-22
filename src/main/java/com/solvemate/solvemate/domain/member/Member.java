package com.solvemate.solvemate.domain.member;

import com.solvemate.solvemate.domain.BaseTimeEntity;
import lombok.*;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
// 기본 생성자의 생성을 방지하고 지정한 생성자를 사용하도록 강제하여
// 무조건 완전한 상태의 객체를 생성할 수 있도록 도움
@Entity
@Getter
@Builder // 객체 생성시 유연성 확보
public class Member extends BaseTimeEntity {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "member_id")
    private Long id;

    private String email;

    private String nickname;

    private String password;
}
