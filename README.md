# dependency injection with constructor and field


- You can find the framework itself under "com.depinject.framework" package.
- You can find sample application under tests.

### How you can use

##### 1. You have to define how you want to map interfaces to their implementations.

```java
public class DependencyInjectionConfig extends DependencyInjectionImpl {
    
    @Override
    public void configure() {
        createMapping(CalculatorService.class, AdditionCalculatorServiceImpl.class);
        createMapping(TextFormatterService.class, SimpleTextFormatterServiceImpl.class);
    }
}
```

##### 2. Add **@InjectAnnotation** annotation to constructor or field.

```java
public class ConstructorInjectionExample {
    
    private final CalculatorService calculatorService;
    private final TextFormatterService textFormatterService;
    
    @InjectAnnotation
    public ConstructorInjectionExample(final CalculatorService calculatorService, final TextFormatterService textFormatterService) {
        this.calculatorService = calculatorService;
        this.textFormatterService = textFormatterService;
    }
}


##### 3. Use **DependencyInjection** to get your injected class.

```java
public class SampleAppToTryDependencyInjection {
    
    public static void main(final String[] args) throws Exception {
        final DependencyInjectionFramework dependencyInjectionFramework = DependencyInjection.getFramework(new DependencyInjectionConfig());
        final ConstructorInjectionExample constructorInjectionExample = (ConstructorInjectionExample) DependencyInjection.inject(ConstructorInjectionExample.class);
    }

}
