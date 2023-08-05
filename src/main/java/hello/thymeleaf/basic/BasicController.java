package hello.thymeleaf.basic;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Getter;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Map;

@RequestMapping("/basic")
@Controller
public class BasicController {

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
        User userA = User.builder()
                .username("userA")
                .age(10)
                .build();
        User userB = User.builder()
                .username("userB")
                .age(20)
                .build();

        List<User> users = List.of(userA, userB);

        Map<String, User> userMap = Map.of(
                "userA", userA,
                "userB", userB
        );

        model.addAttribute("user", userA);
        model.addAttribute("users", users);
        model.addAttribute("userMap", userMap);

        return "basic/variable";
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
