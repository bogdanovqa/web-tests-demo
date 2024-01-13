package wrappers;

import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.DefaultElementLocatorFactory;
import org.openqa.selenium.support.pagefactory.DefaultFieldDecorator;
import org.openqa.selenium.support.pagefactory.ElementLocator;

import java.lang.reflect.Field;

public class ExtendedFieldDecorator extends DefaultFieldDecorator {
    private final ContainerFactory containerFactory = new ContainerFactory();

    public ExtendedFieldDecorator(SearchContext searchContext) {
        super(new DefaultElementLocatorFactory(searchContext));
    }

    @Override
    public Object decorate(ClassLoader loader, Field field) {
        if (BaseContainer.class.isAssignableFrom(field.getType())) {
            return decorateContainer(loader, field);
        }
        return super.decorate(loader, field);
    }

    private ElementLocator createLocator(Field field) {
        return factory.createLocator(field);
    }

    private Object decorateContainer(ClassLoader loader, Field field) {
        WebElement wrappedElement = proxyForLocator(loader, createLocator(field));
        BaseContainer container = containerFactory.create((Class<? extends BaseContainer>) field.getType(), wrappedElement);
        PageFactory.initElements(new ExtendedFieldDecorator(wrappedElement), container);
        return container;
    }
}
