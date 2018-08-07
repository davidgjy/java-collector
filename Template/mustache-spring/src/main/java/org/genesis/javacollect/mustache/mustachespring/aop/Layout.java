package org.genesis.javacollect.mustache.mustachespring.aop;

import com.samskivert.mustache.Mustache;
import com.samskivert.mustache.Template;

import java.io.IOException;
import java.io.Writer;

/**
 * @author KG(Kelvin Gu)
 * @ClassName: Layout
 * @Package org.genesis.javacollect.mustache.mustachespring.aop
 * @Description: layout
 * @date 2018/8/6 20:42
 */
public class Layout implements Mustache.Lambda {
    String title = "Demo Application";

    String body;

    private Mustache.Compiler compiler;

    public Layout(Mustache.Compiler compiler) {
        this.compiler = compiler;
    }

    @Override
    public void execute(Template.Fragment frag, Writer out) throws IOException {
        body = frag.execute();
        compiler.compile("{{>layout}}").execute(frag.context(), out);
    }
}
