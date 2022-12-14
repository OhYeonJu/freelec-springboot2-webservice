package com.jojoldu.book.freelecspringboot2webservice.web.dto;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class HelloResponseDtoTest {
    @Test
    public void 롬복_기능_테스트() {
        // given
        String name = "test";
        int amount = 1000;

        // when
        HelloResponseDto dto = new HelloResponseDto(name, amount);

        // then
        assertThat(dto.getName()).isEqualTo(name); // assertThat assertj라는 검증 라이브러리의 검증 메소드이다. 검증하고 싶은 대상을 메소드 인자로 받는다. 메소드 체이닝이 지원되어 isEqualTo와 같이 메소드를 이어서 사용할 수 있다.
        assertThat(dto.getAmount()).isEqualTo(amount);

    }
}
