package annotation_samples;

import java.lang.annotation.*;

@Retention (RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD, ElementType.CONSTRUCTOR})
public @interface MyAnnotation {
	int valueInSequence();
}
