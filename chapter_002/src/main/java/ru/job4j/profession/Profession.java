package ru.job4j.profession;
/**
 * Profession for task "1. Реализация профессий в коде [#6837]".
 *
 * @author Wladyslaw Lazin (wladislaw.lazin@gmail.com)
 * @version $Id$
 * @since 07.09.17
 */
public class Profession {
    private String name;
    private int age;
    private int experience;


    /**
     * @return String.
     */
    public String getName() {
        return name;
    }

    Profession(String name, int age, int experience) {
        this.name = name;
        this.age = age;
        this.experience = experience;

    }


    /**
     * Doctor.
     */
    public static class Doctor extends Profession {
        private String degree;

        Doctor(String name, int age, int experience, String degree) {
            super(name, age, experience);
            this.degree = degree;
        }

        /**
         * Heal.
         * @param pacient - Task.
         * @return String.
         */
        public String heal(Task pacient) {
            return "Doctor " + this.getName() + " heals " + pacient.getName();
        }
    }

    /**
     * Teacher.
     */
    public static class Teacher extends Profession {
        private String rank;

        Teacher(String name, int age, int experience, String rank) {
            super(name, age, experience);
            this.rank = rank;
        }
        /**
         * giveKnowleges.
         * @param student - Task.
         * @return String.
         */
        public String giveKnowleges(Task student) {
            return "Teacher " + this.getName() + " give knowleges to " + student.getName();
        }
    }

    /**
     * Engineer.
     */
    public static class Engineer extends Profession {
        private int patents;
        Engineer(String name, int age, int experience, int patents) {
            super(name, age, experience);
            this.patents = patents;
        }
        /**
         * Design.
         * @param project - Task.
         * @return String.
         */
        public String design(Task project) {

            return "Engineer " + this.getName() + " develops " + project.getName();
        }
    }

    /**
     * Task.
     */

    public static class Task {
        private String name;

        Task(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }
    }
}