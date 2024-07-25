import com.tngtech.archunit.core.domain.JavaClasses;
import com.tngtech.archunit.core.importer.ClassFileImporter;
import org.junit.jupiter.api.Test;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RestController;

import static com.tngtech.archunit.library.GeneralCodingRules.NO_CLASSES_SHOULD_THROW_GENERIC_EXCEPTIONS;

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.classes;

public class ArchitectureTest {
    JavaClasses importedClasses = new ClassFileImporter().importPackages("com.example.demo");

    @Test
    public void controllerNaming() {
        classes()
                .that().areAnnotatedWith(Controller.class)
                .or()
                .areAnnotatedWith(RestController.class)
                .should().haveSimpleNameEndingWith("Controller")
                .check(importedClasses);
    }

    @Test
    public void serviceNaming() {
        classes()
                .that().areAnnotatedWith(Service.class)
                .should().haveSimpleNameEndingWith("Service")
                .check(importedClasses);
    }

    @Test
    public void exceptions() {
        NO_CLASSES_SHOULD_THROW_GENERIC_EXCEPTIONS.check(importedClasses);
    }
}