package ru.lozovoi.pdffinder.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.lozovoi.pdffinder.service.RecordService;

import java.io.IOException;

@Slf4j
@Controller("/")
public class ViewController {

    RecordService recordService;

    public ViewController(RecordService recordService) {
        this.recordService = recordService;
    }

    @GetMapping
    public String view() {
        return "index";
    }

    @PostMapping
    public String convert(Model model, @RequestParam String inputPath) throws IOException {
        log.info(inputPath);
        if (!inputPath.isEmpty()) {
            recordService.getResult(inputPath);
            model.addAttribute("done", "done");
        } else {
            model.addAttribute("done", "please enter path");
        }
        return "index";
    }
}
