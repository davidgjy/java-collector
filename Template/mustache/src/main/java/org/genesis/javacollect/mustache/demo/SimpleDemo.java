package org.genesis.javacollect.mustache.demo;

import com.github.mustachejava.DefaultMustacheFactory;
import com.github.mustachejava.Mustache;
import com.github.mustachejava.MustacheFactory;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.List;

/**
 * @author KG(Kelvin Gu)
 * @ClassName: SimpleDemo
 * @Package org.genesis.javacollect.mustache.demo
 * @Description: simple demo of mustache
 * @date 2018/8/6 14:06
 */
public class SimpleDemo {
    List<Example.Item> items() {
        return Arrays.asList(
                new Example.Item("Item 1", "$19.99", Arrays.asList(new Example.Feature("New!"), new Example.Feature("Awesome!"))),
                new Example.Item("Item 2", "$29.99", Arrays.asList(new Example.Feature("Old."), new Example.Feature("Ugly.")))
        );
    }

    public static void main(String[] args) throws IOException {
        MustacheFactory mf = new DefaultMustacheFactory();
        Mustache mustache = mf.compile("template/simple_template.mustache");
        mustache.execute(new PrintWriter(System.out), new Example()).flush();
    }
}
