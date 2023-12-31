package hello.thymeleaf.basic;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import lombok.Builder;
import lombok.Getter;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

@RequestMapping("/basic")
@Controller
public class BasicController {

    public static final String SPRING_BANG = "Spring!";

    @GetMapping("/text-basic")
    public String textBasic(Model model) {
        model.addAttribute("data", "Hello Spring!");
        return "basic/text-basic";
    }

    @GetMapping("/text-unescaped")
    public String textUnescaped(Model model) {
        model.addAttribute("data", "Hello <b>Spring!</b>");
        return "basic/text-unescaped";
    }

    @GetMapping("/variable")
    public String variable(Model model) {
        String usernameA = "userA";
        String usernameB = "userB";

        User userA = User.builder()
                .username(usernameA)
                .age(10)
                .build();
        User userB = User.builder()
                .username(usernameB)
                .age(20)
                .build();

        List<User> users = List.of(userA, userB);

        Map<String, User> userMap = Map.of(
                usernameA, userA,
                usernameB, userB
        );

        model.addAttribute("user", userA);
        model.addAttribute("users", users);
        model.addAttribute("userMap", userMap);

        return "basic/variable";
    }

    @GetMapping("/basic-objects")
    public String basicObjects(Model model, HttpServletRequest request,
                               HttpServletResponse response, HttpSession session) {
        session.setAttribute("sessionData", "Hello Session");
        model.addAttribute("request", request);
        model.addAttribute("response", response);
        model.addAttribute("servletContext", request.getServletContext());

        return "basic/basic-objects";
    }

    @GetMapping("/date")
    public String date(Model model) {
        model.addAttribute("localDateTime", LocalDateTime.now());
        return "basic/date";
    }

    @GetMapping("/link")
    public String link(Model model) {
        model.addAttribute("param1", "data1");
        model.addAttribute("param2", "data2");
        return "basic/link";
    }

    @GetMapping("/literal")
    public String literal(Model model) {
        model.addAttribute("data", SPRING_BANG);
        return "basic/literal";
    }

    @GetMapping("/operation")
    public String operation(Model model) {
        model.addAttribute("nullData", null);
        model.addAttribute("data", SPRING_BANG);
        return "basic/operation";
    }

    @GetMapping("/attribute")
    public String attribute() {
        return "basic/attribute";
    }

    @GetMapping("/each")
    public String each(Model model) {
        this.addUsers(model);
        return "basic/each";
    }

    @GetMapping("/condition")
    public String condition(Model model) {
        this.addUsers(model);
        return "basic/condition";
    }

    @GetMapping("/comments")
    public String comments(Model model) {
        model.addAttribute("data", SPRING_BANG);
        return "basic/comments";
    }

    @GetMapping("/block")
    public String block(Model model) {
        this.addUsers(model);
        return "basic/block";
    }

    @GetMapping("/javascript")
    public String javascript(Model model) {
        model.addAttribute("user",
                User.builder()
                        .username("userA")
                        .age(10)
                        .build()
        );
        this.addUsers(model);

        return "basic/javascript";
    }

    private void addUsers(Model model) {
        List<User> users = List.of(
                User.builder().username("userA").age(10).build(),
                User.builder().username("userB").age(20).build(),
                User.builder().username("userC").age(30).build()
        );

        model.addAttribute("users", users);
    }


    @Component("helloBean")
    static class HelloBean {
        public String hello(String data) {
            return "Hello " + data;
        }
    }

    @Getter
    static class User {
        @JsonProperty(value = "username")
        private String username;
        @JsonProperty(value = "age")
        private int age;

        @Builder
        private User(String username, int age) {
            this.username = username;
            this.age = age;
        }
    }
}
