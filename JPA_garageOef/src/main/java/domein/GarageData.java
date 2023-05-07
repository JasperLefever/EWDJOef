package domein;

import java.time.LocalDate;

class GarageData {

    private final GarageBeheerder gb;

    GarageData(GarageBeheerder garageBeheerder) {
        gb = garageBeheerder;
    }

    void populeerData() {
        gb.addVervoermiddel(new Auto("auto100"));
        gb.addVervoermiddel(new Auto("auto200"));
        gb.addVervoermiddel(new Auto("auto300"));
        gb.addVervoermiddel(new LichteVracht(1500, "vracht100"));
        gb.addVervoermiddel(new LichteVracht(1600, "vracht200"));
        gb.addVervoermiddel(new LichteVracht(1700, "vracht300"));

        gb.addOnderhoudsbeurt("auto100", LocalDate.of(2023, 3, 20), LocalDate.of(2023, 3, 22));
        gb.addOnderhoudsbeurt("auto100", LocalDate.of(2023, 5, 20), LocalDate.of(2023, 5, 22));
        gb.addOnderhoudsbeurt("auto100", LocalDate.of(2023, 9, 20), LocalDate.of(2023, 9, 22));

        gb.addOnderhoudsbeurt("auto200", LocalDate.of(2023, 4, 1), LocalDate.of(2023, 4, 1));
        gb.addOnderhoudsbeurt("auto200", LocalDate.of(2023, 6, 10), LocalDate.of(2023, 6, 14));
        gb.addOnderhoudsbeurt("auto200", LocalDate.of(2023, 11, 25), LocalDate.of(2023, 11, 25));

        gb.addOnderhoudsbeurt("vracht100", LocalDate.of(2023, 3, 20), LocalDate.of(2023, 3, 22));
        gb.addOnderhoudsbeurt("vracht100", LocalDate.of(2023, 5, 20), LocalDate.of(2023, 5, 22));
        gb.addOnderhoudsbeurt("vracht100", LocalDate.of(2023, 9, 20), LocalDate.of(2023, 9, 22));

        gb.addOnderhoudsbeurt("vracht200", LocalDate.of(2023, 4, 1), LocalDate.of(2023, 4, 1));
        gb.addOnderhoudsbeurt("vracht200", LocalDate.of(2023, 6, 10), LocalDate.of(2023, 6, 14));
        gb.addOnderhoudsbeurt("vracht200", LocalDate.of(2023, 11, 25), LocalDate.of(2023, 11, 25));
    }
}