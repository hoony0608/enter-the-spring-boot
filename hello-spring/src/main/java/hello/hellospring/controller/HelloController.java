package hello.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HelloController {

    @GetMapping("hello")
    public String hello(Model model) {
        // hello url에 들어가면 스프링에서 model을 할당해 메소드 실행
        model.addAttribute("data", "nemo!!!");
        // hello.html 문서에서 받아온 model에 th:text data라는 키에 "hello!"를 할당한다.
        return "hello";
        // hello 문서를 보여줌
    }
}

// 빌드하고 실행하는 법: 터미널 -> 프로젝트 폴더 -> ./gradlew build -> build 폴더 -> libs 폴더 -> java -jar spring...