import com.tngtech.archunit.core.domain.JavaClasses;
import com.tngtech.archunit.core.importer.ClassFileImporter;

import java.util.logging.Logger;
import org.junit.jupiter.api.Test;

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.fields;
import static com.tngtech.archunit.library.GeneralCodingRules.*;

public class CodingRulesTest {
    JavaClasses importedClasses = new ClassFileImporter().importPackages("com.example.demo");

    @Test
    public void exceptions() {
        NO_CLASSES_SHOULD_THROW_GENERIC_EXCEPTIONS.check(importedClasses);
    }

    // We want to use field injection in DogControllerTest.java to get a randomly assigned port.
    //@Test
    //public void fieldInjection() {
    //    NO_CLASSES_SHOULD_USE_FIELD_INJECTION.check(importedClasses);
    //}

    @Test
    public void jodaTime() {
        NO_CLASSES_SHOULD_USE_JODATIME.check(importedClasses);
    }

    @Test
    public void logging() {
        NO_CLASSES_SHOULD_USE_JAVA_UTIL_LOGGING.check(importedClasses);
    }

    @Test
    public void streams() {
        NO_CLASSES_SHOULD_ACCESS_STANDARD_STREAMS.check(importedClasses);
    }

    // This rule incorrectly flags Loggers that are private, static, and final!
    @Test
    public void loggers() {
        fields().that().haveRawType(Logger.class)
                .should().bePrivate()
                .andShould().beStatic()
                .andShould().beFinal()
                .because("we agreed on this convention");
    }
}