package com.jojoldu.book.freelecspringboot2webservice.web.dto;

import com.jojoldu.book.freelecspringboot2webservice.domain.posts.Posts;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class PostsSaveRequestDto { // 절대로 Entity클래스를 Request/Response 클래스로 사용해서는 안된다. Entity클래스는 데이터베이스와 맞닿은 핵심 클래스이다. Entity클래스를 기준으로 테이블이 생성되고, 스키마가 변경된다.
    private String title;
    private String content;
    private String author;

    @Builder
    public PostsSaveRequestDto(String title, String content, String author) {
        this.title = title;
        this.content = content;
        this.author = author;
    }

    public Posts toEntity() {
        return Posts.builder()
                .title(title)
                .content(content)
                .author(author)
                .build();
    }
}
