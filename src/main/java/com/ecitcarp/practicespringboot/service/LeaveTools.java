package com.ecitcarp.practicespringboot.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.ai.tool.annotation.Tool;
import java.util.Map;

@Slf4j
public class LeaveTools {

    private final Map<String, Integer> balances = Map.of(
            "ravi", 12,
            "anita", 5,
            "tharun", 18
    );

    @Tool(description = "Returns remaining leave days for one employee. Use ONLY when the user asks about a specific person's leave balance.")
    public int getLeaveBalance(String name) {
        log.info(">>> Tool called for: {}" ,name);
        return balances.getOrDefault(name.toLowerCase(), 0);
    }
}