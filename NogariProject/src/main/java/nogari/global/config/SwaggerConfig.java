package nogari.global.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.Server;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

import java.util.*;

@Configuration
public class SwaggerConfig {



    // CONTACT
    private static final Contact DEFAULT_CONTACT = new Contact("CSPI", "http://www.cspi.co.kr","cspi@cspi.co.kr" ); //Contact Us  이름, 연락할 홈페이지, 연락할 email주소

    // API INFO
    private static final ApiInfo DEFAULT_API_INFO = new ApiInfo("Nogari RestAPI Project",
            "Nogari RestApi Project 입니다. 참여자(iknowahra,Reading-Snail,Yseolcoding,KOTAEU,wlsdnd221,hana210810,C18009)",
            "1.0",
            "urn:tos", //이용약관동의에 해당되는 url을 넣어야됨 현재는 없음
            DEFAULT_CONTACT,
            "Apache License Version 2.0",
            "http://www.apache.org/licenses/LICENSE-2.0",
            new ArrayList<>());


    // PRODUCES AND CONSUMES  --> application.yml
    private static final Set<String> DEFAULT_PRODUCES = new HashSet<>(
            Arrays.asList("application/json","application/x-www-form-urlencoded")

    );
    private static final Set<String> DEFAULT_CONSUMES = new HashSet<>(
            Arrays.asList("application/json")

    );

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.OAS_30)
                .select()
                .apis(RequestHandlerSelectors.basePackage("nogari"))
                .paths(PathSelectors.any())
                .build()
                .apiInfo(DEFAULT_API_INFO)
                .produces(DEFAULT_PRODUCES)
                .consumes(DEFAULT_CONSUMES);

    }

}