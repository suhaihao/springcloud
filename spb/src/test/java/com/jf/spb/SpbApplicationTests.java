package com.jf.spb;

import com.jf.spb.tool.MD5Util;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpbApplicationTests {
    @Autowired
    MD5Util mD5Util;

    @Test
    public void contextLoads() {
        String s = mD5Util.stringMD5("12345678");
        System.out.println(s);
    }

}
