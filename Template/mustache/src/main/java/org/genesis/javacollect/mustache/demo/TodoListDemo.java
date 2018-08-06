package org.genesis.javacollect.mustache.demo;

import com.github.mustachejava.DefaultMustacheFactory;
import com.github.mustachejava.Mustache;
import com.github.mustachejava.MustacheFactory;
import org.genesis.javacollect.mustache.pojo.Todo;

import java.io.IOException;
import java.io.StringWriter;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author KG(Kelvin Gu)
 * @ClassName: TodoListDemo
 * @Package org.genesis.javacollect.mustache.demo
 * @Description: todo list demo
 * @date 2018/8/6 16:05
 */
public class TodoListDemo {
    public static void main(String[] args) throws IOException {
        MustacheFactory mf = new DefaultMustacheFactory();
        Mustache m = mf.compile("template/todo_list.mustache");

        List<Todo> todos = Arrays.asList(
                new Todo("Todo 1", "Todo description"),
                new Todo("Todo 2", "Todo description another"),
                new Todo("Todo 3", "Todo description another")
        );
        Map<String, Object> context = new HashMap<>();
        context.put("todo", todos);

        StringWriter writer = new StringWriter();
        m.execute(writer, context).flush();
        String html = writer.toString();

        System.out.println("html output: ");
        System.out.println(html);
    }
}
