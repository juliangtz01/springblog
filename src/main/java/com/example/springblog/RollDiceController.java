package com.example.springblog;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Random;

@Controller
public class RollDiceController
{
    @GetMapping("/roll-dice")
    public String rollDice()
    {
        return "roll-dice";
    }
    @GetMapping("/roll-dice/{n}")
    public String guessRoll(@PathVariable int n, Model model)
    {
        Random random = new Random();
        int randomNum = 1 + random.nextInt(6);

        boolean correctGuess = false;

        if(randomNum == n)
        {
            correctGuess = true;
        }
        model.addAttribute("correctGuess", correctGuess);
        model.addAttribute("randomNum", randomNum);
        model.addAttribute("n", n);
        return "roll-dice";
    }
}
