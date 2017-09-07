package ru.job4j;
/**
 * Test for Profession "1. Реализация профессий в коде [#6837]".
 *
 * @author Wladyslaw Lazin (wladislaw.lazin@gmail.com)
 * @version $Id$
 * @since 0.1
 */

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
public class ProfessionTest {

    @Test
    public void whenDoctorHealsPacient() {
        Profession.Doctor doctor = new Profession.Doctor("Healer", 45, 20, "doctor");
        Profession.Task pacient = new Profession.Task("Smith");
        String result = doctor.heal(pacient);
        String expectation = "Doctor Healer heals Smith";
        assertThat(result, is(expectation));
    }

    @Test
    public void whenTeacherTeachesStudent() {
        Profession.Teacher teacher = new Profession.Teacher("Guru", 38, 12, "nothing");
        Profession.Task student = new Profession.Task("Idler");
        String result = teacher.giveKnowleges(student);
        String expectation = "Teacher Guru give knowleges to Idler";
        assertThat(result, is(expectation));
    }

    @Test
    public void whenEngeneerDevelopsProject() {
        Profession.Engineer  engeneer = new Profession.Engineer("Garin", 35, 10, 3);
        Profession.Task project = new Profession.Task("hyperboloid");
        String result = engeneer.design(project);
        String expectation = "Engineer Garin develops hyperboloid";
        assertThat(result, is(expectation));
    }
}
