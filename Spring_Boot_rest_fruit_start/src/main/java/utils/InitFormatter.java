package utils;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;

public interface InitFormatter {

    DecimalFormat FORMATTER =
            new DecimalFormat("#.#", DecimalFormatSymbols.getInstance(Locale.FRANCE));
}