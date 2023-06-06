package com.blog;

import org.junit.jupiter.api.Test;

public class TestApp {


    @Test
    public void test(){
        for (int i=0 ; i< 100 ; i++){
            System.out.println(i);
            if (i== 27) {
                System.out.println("断点调试。。。");
            }
        }
    }
}
