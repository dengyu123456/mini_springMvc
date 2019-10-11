package com.dy.minispringMvc.test;

import com.dy.minispringMvc.beans.CustomAutoWired;
import com.dy.minispringMvc.mvc.CustomController;
import com.dy.minispringMvc.mvc.CustomRequestMapping;
import com.dy.minispringMvc.mvc.CustomResqusetParam;

@CustomController
public class test {
    @CustomAutoWired
    private A a;

    @CustomRequestMapping("/A")
    public String A(@CustomResqusetParam("b") String b){
        return a.sss+b;
    }
}
