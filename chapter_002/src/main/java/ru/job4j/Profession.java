package ru.job4j;

public class Profession {
    private String name;
    private int age;
    private int experience;

    public String getName() {
        return name;
    }

    Profession(String name, int age, int experience) {
        this.name = name;
        this.age = age;
        this.experience = experience;

    }
    // доктор и пациент
    public class Doctor extends Profession {
        private String degree;

        Doctor(String name, int age, int experience, String degree) {
            super(name, age, experience);
            this.degree = degree;
        }

        public String heal (Task pacient) {
            return "Doctor " + this.getName() + " heals " + pacient.getName();
        }
    }



    public class Teacher extends Profession {
        private String rank;

        Teacher(String name, int age, int experience, String rank) {
            super(name, age, experience);
            this.rank = rank;
        }
        public String giveKnowleges(Task student) {
            return "Teacher " + this.getName() + " give knowleges to " + student.getName();
        }
    }



    public class Engeneer extends Profession {
        private int patents;
        Engeneer(String name, int age, int experience, int patents) {
            super(name, age, experience);
            this.patents = patents;
        }
        public String design(Task project) {
            return "Teacher " + this.getName() + " give knowleges to " + project.getName();
        }
    }

    public class Task {
        private String name;

        Task(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }
    }
}