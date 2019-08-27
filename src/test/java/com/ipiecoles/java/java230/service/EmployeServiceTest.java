package com.ipiecoles.java.java230.service;

import com.ipiecoles.java.java230.model.Commercial;
import com.ipiecoles.java.java230.model.Employe;
import com.ipiecoles.java.java230.repository.EmployeRepository;
import com.ipiecoles.java.java230.utils.TestUtils;
import org.assertj.core.api.Assertions;
import org.joda.time.LocalDate;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import java.lang.reflect.Field;

@RunWith(SpringRunner.class)
@SpringBootTest
public class EmployeServiceTest {

    @Autowired
    private EmployeService employeService;

    @Autowired
    private EmployeRepository employeRepository;

    @Test
    public void exo301testInit() throws Exception {
        TestUtils.checkNotAbstractClass("EmployeService");
        Field field = TestUtils.checkPrivateField("EmployeService", "employeRepository", TestUtils.PACKAGE_REPOSITORY + "EmployeRepository");
        Assertions.assertThat(field.isAnnotationPresent(Autowired.class)).isTrue();
    }

    @Test
    public void exo302testFindById() {
        Employe e = employeService.findById(2L);
        Assertions.assertThat(e).isNotNull();
        Assertions.assertThat(e.getMatricule()).isEqualTo("M11109");
    }

    @Test
    public void exo303TestNbEmploye() {
        Long c = employeService.countAllEmploye();
        Assertions.assertThat(c).isNotNull();
        Assertions.assertThat(c).isEqualTo(2502L);
    }

    @Test
    public void exo304testCreateEmploye() {

        Employe c = new Commercial("test", "test", "test", LocalDate.now(), 500d, 0d);
        c = employeService.createEmp(c);
        Assertions.assertThat(c.getId()).isNotNull();
        employeRepository.delete(c.getId());

    }

    @Test
    public void exo305testDeleteEmploye() {
        Commercial comTest = new Commercial("test", "test", "test", LocalDate.now(), 500d, 0d);
        comTest = employeRepository.save(comTest);
        employeService.deleteEmploye(comTest.getId());
        Assertions.assertThat(employeService.findById(comTest.getId())).isNull();

    }

}
