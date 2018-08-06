package org.genesis.javacollect.mustache.demo;

import com.github.mustachejava.DefaultMustacheFactory;
import com.github.mustachejava.Mustache;
import com.github.mustachejava.MustacheFactory;

import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author KG(Kelvin Gu)
 * @ClassName: simple_demo
 * @Package org.genesis.javacollect.mustache.demo
 * @Description: simple demo of mustache
 * @date 2018/8/6 14:06
 */
public class simple_demo {
    public static void main(String[] args) throws IOException {
        MustacheFactory mf = new DefaultMustacheFactory();
        Mustache mustache = mf.compile("template/simple_template.mustache");
        mustache.execute(new PrintWriter(System.out), new Example()).flush();
    }
}
