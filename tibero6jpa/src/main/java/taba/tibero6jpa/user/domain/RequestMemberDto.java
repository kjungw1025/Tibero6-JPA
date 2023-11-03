package taba.tibero6jpa.user.domain;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
@RequiredArgsConstructor
public class RequestMemberDto {
    @NotBlank
    private String name;
    @NotBlank
    private String phone;
}
