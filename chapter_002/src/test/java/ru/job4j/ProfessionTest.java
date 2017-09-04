package ru.job4j;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
public class ProfessionTest {

    @Test
    public void whenDoctorHealsPacient() {
        Profession.Doctor doctor = new Profession.Doctor("Healer", 45, 20, "doctor");
        Profession.Task pacient = new Profession.Task("Smith");
    }
}
