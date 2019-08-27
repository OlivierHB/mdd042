package com.ipiecoles.java.java230.model;

import com.ipiecoles.java.java230.utils.TestUtils;
import org.assertj.core.api.Assertions;
import org.junit.Test;

import javax.persistence.*;
import java.lang.reflect.Field;

public class EmployeTest {
    @Test
    public void exo101testEntity() throws Exception {
        TestUtils.checkAnnotation("Employe", Entity.class);
    }

    @Test
    public void exo102testEntity() throws Exception {
        Field field = TestUtils.checkPrivateField("Employe", "id", TestUtils.LONG);
        Assertions.assertThat(field.isAnnotationPresent(Id.class)).isTrue();
        Assertions.assertThat(field.isAnnotationPresent(GeneratedValue.class)).isTrue();
        Assertions.assertThat(field.getAnnotation(GeneratedValue.class).strategy()).isEqualTo(GenerationType.AUTO);
    }

    @Test
    public void exo501testEntity() throws Exception {
        TestUtils.checkAnnotation("Employe", Entity.class);
        TestUtils.checkAnnotation("Employe", Inheritance.class);
        Assertions.assertThat(TestUtils.getClasse("Employe").getAnnotation(Inheritance.class).strategy()).isEqualTo(InheritanceType.JOINED);
    }
}
