package com.dy.minispringMvc.test;

import com.dy.minispringMvc.beans.CustomBean;

@CustomBean
public class A implements Ainte {
    String sss="hello";

    @Override
    public String getA(){
        return "hello A";
    }

    public String getSss(){
        return "hello sss";
    }
}
