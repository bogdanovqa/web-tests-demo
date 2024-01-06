package wrappers;

import org.openqa.selenium.WebElement;

public class ContainerFactory {
    public <C extends BaseContainer> C create(Class<C> containerClass, WebElement wrappedElement) {
        final C container = createInstanceOf(containerClass);
        container.wrap(wrappedElement);
        return container;
    }

    private <C extends BaseContainer> C createInstanceOf(Class<C> containerClass) {
        try {
            return containerClass.newInstance();
        } catch (InstantiationException | IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }
}