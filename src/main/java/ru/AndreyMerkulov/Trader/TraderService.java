package ru.AndreyMerkulov.Trader;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

@Service
public class TraderService {

    public String stop() {
        return "stopped";
    }


    public String start() {
        return "started";
    }
}
