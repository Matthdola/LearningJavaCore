import java.lang.annotation.ElementType;
import java.lang.annotation.Repeatable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface RepeatableAnnotations {
    RepeatableAnnotation[] value();
}

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Repeatable(RepeatableAnnotations.class)
@interface RepeatableAnnotation {
    String value();
}

abstract class TestRepeatableAnnotation {
    @RepeatableAnnotation("repeatition 1")
    @RepeatableAnnotation("repeatition 1")
    public abstract void performAction();
}