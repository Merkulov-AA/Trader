package ru.andreymerkulov.trader;

import org.springframework.stereotype.Service;

@Service
public class TraderService {

    public String stop() {
        return "stopped";
    }


    public String start() {
        return "started";
    }
}
