package ru.andrey_merkulov.trader;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/trader")
@AllArgsConstructor
public class TraderController {

    private final TraderService service;

    @GetMapping("stop")
    public String stop() {
        return service.stop();
    }

    @GetMapping("start")
    public String start() {
        return service.start();
    }

}
