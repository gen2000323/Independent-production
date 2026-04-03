package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.repository.PhraseRepository;

@Controller
public class PhraseController {

    @Autowired
    private PhraseRepository phraseRepository;

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("phraseText", "レコードをタップしてフレーズを出す");
        return "index";
    }
    @GetMapping("/scratch/left")
    @ResponseBody
    public String scratchLeft() {
        return phraseRepository.findRandomPhrase()
                .orElseThrow(() -> new RuntimeException("データがありません"))
                .getPhrase();
    }

    @GetMapping("/scratch/right")
    @ResponseBody
    public String scratchRight() {
        return phraseRepository.findRandomPhrase()
                .orElseThrow(() -> new RuntimeException("データがありません"))
                .getPhrase();
    }
}