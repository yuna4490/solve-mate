package com.solvemate.solvemate.domain;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor(access= AccessLevel.PROTECTED)
@AllArgsConstructor
@Entity
@Getter
@Builder
public class Problem extends BaseTimeEntity{

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "problem_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id") // 연관관계 주인
    private Member member;

    private String link;

    @Enumerated(EnumType.STRING)
    private Status status;

    @OneToMany(mappedBy = "problem", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Review> reviews = new ArrayList<>();

    @OneToMany(mappedBy = "problem", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<ProblemTag> problemTags = new ArrayList<>();

    private LocalDateTime notificationDate;

    // 문제 수정할 때
    void updateNotificationDate(LocalDateTime notificationDate) {
        this.notificationDate = notificationDate;
    }

}
