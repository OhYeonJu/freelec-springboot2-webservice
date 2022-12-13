package com.jojoldu.book.freelecspringboot2webservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing // JPA Auditing 어노테이션들을 모두 활성화할 수 있도록 설정
@SpringBootApplication // 스프링 부트의 자동 설정, 스프링 Bean 읽기와 생성을 모두 자동으로 설정된다. 이 부분부터 설정을 읽어가기 때문에 이 클래스는 항상 프로젝트 최상단에 위치해야한다.
public class FreelecSpringboot2WebserviceApplication {

    public static void main(String[] args) {
        SpringApplication.run(FreelecSpringboot2WebserviceApplication.class, args); // SpringAllication.run으로 인해 내장 WAS를 실행한다.
        // WAS란 별도로 외부에 WAS를 두지 않고 애플리케이션을 실행할 때 내부에서 WAS를 실행하는 것을 이야기한다.
        // Saring boot에서는 내장 WAS를 사용하는 것을 권장한다. 이유는 언제 어디서나 같은 환경에서 스프링 부트를 배포할 수 있기 때문이다.
    }

}
