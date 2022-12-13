package com.jojoldu.book.freelecspringboot2webservice.domain.posts;

import com.jojoldu.book.freelecspringboot2webservice.domain.BaseTimeEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter // lombok 롬복은 코드를 단순화시켜 주지만 필수 어노테이션은 아니다. // Entity클래스에는 절대 Setter 메소드를 만들지 않는다.
@NoArgsConstructor // lombok 기본 생성자 자동 추가
@Entity // JPA의 어노테이션, 테이블과 링크될 클래스임을 나타낸다.
public class Posts extends BaseTimeEntity {
    @Id // PK 필드를 나타낸다.
    @GeneratedValue(strategy = GenerationType.IDENTITY) // 생성 규칙, auto_increment, 웬만하면 pk는 long타입의 auto_increment를 추천한다. p.91
    private Long id;

    @Column(length = 500, nullable = false) // 기본 길이는 255
    private String title;
    @Column(columnDefinition = "TEXT", nullable = false) // type을 text로 변경
    private String content;
    private String author;

    @Builder // lombok 해당 클래스의 빌더 패턴 클래스를 생성, 생성자 상단에 선언 시 생성자에 포함된 필드만 빌더에 포함. , 생성 시점에 값을 채워주는 역할 , 빌더를 사용하게 되면 어느 필드에 어떤 값을 채워야할지 명확하게 인지할 수 있다.
    public Posts(String title, String content, String author) {
        this.title = title;
        this.content = content;
        this.author = author;
    }

    public void update(String title, String content) {
        this.title = title;
        this.content = content;
    }
}
