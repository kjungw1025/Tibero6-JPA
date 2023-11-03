package taba.tibero6jpa.user.domain;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="member")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Member {
    @Id
    @GeneratedValue
    @Column(name = "member_id")
    private Long id;

    @NotNull
    @Column(length = 20)
    private String name;

    @NotNull
    private String phone;

    @Builder
    private Member(@NotNull String name,
                   @NotNull String phone) {
        this.name = name;
        this.phone = phone;
    }
}
