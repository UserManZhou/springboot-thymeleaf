package com.springboot.web.controller;

import com.springboot.web.entity.User;
import com.springboot.web.exception.CustomException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Arrays;

@Controller
public class TableController {

    @GetMapping("/basic_table")
    public String basic_table(){
       try {
           int i = 1/0;
       }catch (Exception e){
           throw new CustomException(e.getMessage());
       }
        return "table/basic_table";
    }

    @GetMapping("/dynamic_table")
    public String dynamic_table(Model model){
        model.addAttribute("userAL", Arrays.asList(
                new User("xiaozhang","1223243543"),
                new User("xiaotian","123423423534"),
                new User("xiaohong","dyuiawghduiaw"),
                new User("xiaofei","dwadawdaw")
        ));
        return "table/dynamic_table";
    }

    @GetMapping("/editable_table")
    public String editable_table(){
        return "table/editable_table";
    }

    @GetMapping("/pricing_table")
    public String pricint_table(){
        return "table/pricing_table";
    }

    @GetMapping("/responsive_table")
    public String responsive_table(){
        return "table/responsive_table";
    }
}
