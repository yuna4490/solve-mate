package com.solvemate.solvemate.domain.problem;

import com.solvemate.solvemate.domain.BaseTimeEntity;
import com.solvemate.solvemate.domain.review.Review;
import com.solvemate.solvemate.domain.member.Member;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor(access= AccessLevel.PROTECTED)
@AllArgsConstructor
@Entity
@Getter
@Builder
public class Problem extends BaseTimeEntity {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "problem_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id") // 연관관계 주인
    private Member member;

    private String link;

    @Enumerated(EnumType.STRING)
    private Status status;

    //warning: @Builder will ignore the initializing expression entirely. If you want the initializing expression to serve as default, add @Builder.Default. If it is not supposed to be settable during building, make the field final.
    // @Builder.Default로 해결
    @Builder.Default
    @OneToMany(mappedBy = "problem", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Review> reviews = new ArrayList<>();

    @Builder.Default
    @OneToMany(mappedBy = "problem", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<ProblemTag> problemTags = new ArrayList<>();

    private LocalDateTime notificationDate;

    // 문제 수정할 때
    void updateNotificationDate(LocalDateTime notificationDate) {
        this.notificationDate = notificationDate;
    }

}
