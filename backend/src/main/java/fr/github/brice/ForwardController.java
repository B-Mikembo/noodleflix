package fr.github.brice;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class ForwardController {
    @RequestMapping(value = "/{[path:[^\\.]*}")
    public String forward() {
        return "forward:/index.html";
    }
}
