package shop.dangstargram.dto;

import lombok.*;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

public class JoinRequireDto {

    @Getter
    @ToString
    @RequiredArgsConstructor
    public static class Request {

        @NotEmpty(message = "아이디를 입력해주세요")
        @Size(min=4, max=20, message = "아이디를 4자이상 20자이하로 작성해주세요")
        private final String id;

        @NotEmpty(message = "패스워드를 입력해주세요")
        @Size(min=4, max=20, message = "비밀번호를 4자이상 20자이하로 작성해주세요")
        private final String password;

        @Email(message = "이메일 형식으로 작성해주세요")
        @NotEmpty(message = "이메일을 입력해주세요")
        private final String email;
    }

    @Getter
    @RequiredArgsConstructor
    public static class Response {
        private final String result;
        private final String desc;
    }
}
