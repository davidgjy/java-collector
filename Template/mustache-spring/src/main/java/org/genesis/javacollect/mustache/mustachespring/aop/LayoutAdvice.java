package org.genesis.javacollect.mustache.mustachespring.aop;

import com.samskivert.mustache.Mustache;
import org.genesis.javacollect.mustache.mustachespring.Application;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.util.Map;

/**
 * @author KG(Kelvin Gu)
 * @ClassName: LayoutAdvice
 * @Package org.genesis.javacollect.mustache.mustachespring.aop
 * @Description: aop advice for layout
 * @date 2018/8/6 20:40
 */

@ControllerAdvice
public class LayoutAdvice {
    private final Mustache.Compiler compiler;

    private Application application;

    @Autowired
    public LayoutAdvice(Mustache.Compiler compiler, Application application) {
        this.compiler = compiler;
        this.application = application;
    }

    @ModelAttribute("menus")
    public Iterable<Application.Menu> menus(@ModelAttribute Layout layout) {
        for (Application.Menu menu : application.getMenus()) {
            menu.setActive(false);
        }
        return application.getMenus();
    }

    @ModelAttribute("menu")
    public Mustache.Lambda menu(@ModelAttribute Layout layout) {
        return (frag, out) -> {
            Application.Menu menu = application.getMenu(frag.execute());
            menu.setActive(true);
            layout.title = menu.getTitle();
        };
    }

    @ModelAttribute("layout")
    public Mustache.Lambda layout(Map<String, Object> model) {
        return new Layout(compiler);
    }
}
