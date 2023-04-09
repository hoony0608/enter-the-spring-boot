package hello.hellospring.controller;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

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

    @GetMapping("hello-mvc")
    public String helloMVC(@RequestParam("name") String name, Model model) {
        model.addAttribute("name", name);
        return "hello-template";
    }

    @GetMapping("test-mvc")
    public String practice(@RequestParam("test") String test, @RequestParam("test2") String test2, Model model) {
        model.addAttribute("test", test);
        model.addAttribute("test2", test2);
        return "test-template";
    }

    @GetMapping("hello-string")
    @ResponseBody // http에서 body부에 이하의 데이터를 직접 넣겠다.
    public String helloString(@RequestParam("name") String name) {
        return "hello " + name; // name=spring => "hello spring" , view가 없다.
    }

    @GetMapping("hello-api")
    @ResponseBody
    public Hello helloApi(@RequestParam("name") String name) {
        Hello hello = new Hello();
        hello.setName(name);
        return hello;
    } // 객체를 HttpMessageConvert에서 JSON 형식으로 변환하여 브라우저에 출력

    @Getter
    @Setter
    static class Hello {
        private String name;
    }
}

// 빌드하고 실행하는 법: 터미널 -> 프로젝트 폴더 -> ./gradlew build -> build 폴더 -> libs 폴더 -> java -jar spring...