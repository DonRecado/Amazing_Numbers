class Army {

    public static void createArmy() {
        Unit firstUnit = new Unit("first");
        Unit secondUnit = new Unit("second");
        Unit thirdUnit = new Unit("third");
        Unit fourthUnit = new Unit("fourth");
        Unit fifthUnit = new Unit("fifth");

        Knight firstKnight = new Knight("first");
        Knight secondKnight = new Knight("second");
        Knight thirdKnight = new Knight("third");

        General general = new General("general");
        Doctor doctor = new Doctor("doctor");
    }


    // Don't change the code below
    static class Unit {
        static String nameUnit;
        static int countUnit;

        public Unit(String name) {
            countUnit++;
            nameUnit = name;

        }
    }

    static class Knight {
        static String nameKnight;
        static int countKnight;

        public Knight(String name) {
            countKnight++;
            nameKnight = name;

        }
    }

    static class General {
        static String nameGeneral;
        static int countGeneral;

        public General(String name) {
            countGeneral++;
            nameGeneral = name;

        }
    }

    static class Doctor {
        static String nameDoctor;
        static int countDoctor;

        public Doctor(String name) {
            countDoctor++;
            nameDoctor = name;

        }
    }

    public static void main(String[] args) {
        createArmy();
        System.out.println(Unit.countUnit);
        System.out.println(Knight.countKnight);
        System.out.println(General.countGeneral);
        System.out.println(Doctor.countDoctor);
    }

}