package org.genesis.javacollect.mustache.demo;

import com.github.mustachejava.DefaultMustacheFactory;
import com.github.mustachejava.Mustache;
import com.github.mustachejava.MustacheFactory;
import org.genesis.javacollect.mustache.pojo.Todo;

import java.io.IOException;
import java.io.StringWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author KG(Kelvin Gu)
 * @ClassName: SimpleTodoDemo
 * @Package org.genesis.javacollect.mustache.demo
 * @Description: simple todo demo
 * @date 2018/8/6 15:26
 */
public class SimpleTodoDemo {
    public static void main(String[] args) throws IOException {
        MustacheFactory mf = new DefaultMustacheFactory();
        Mustache m = mf.compile("template/todo.mustache");
        Todo todo = new Todo("Todo 1", "Description");
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String strCreatedOn = sdf.format(new Date());
        todo.setCreatedOn(strCreatedOn);

        StringWriter writer = new StringWriter();
        m.execute(writer, todo).flush();
        String html = writer.toString();

        System.out.println("html output: ");
        System.out.println(html);
    }
}
