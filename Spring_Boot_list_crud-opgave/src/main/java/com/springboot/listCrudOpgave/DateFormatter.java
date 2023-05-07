package com.springboot.listCrudOpgave;

import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.format.Formatter;

public class DateFormatter implements Formatter<LocalDate> {

    @Autowired
    private MessageSource messageSource;

    public DateFormatter() {
        super();
    }

	@Override
	public String print(LocalDate object, Locale locale) {
      return object.format(formatter(locale));
	}

	@Override
	public LocalDate parse(String text, Locale locale) throws ParseException {
		return LocalDate.parse(text, formatter(locale));
	}
	
	private DateTimeFormatter formatter(Locale locale) {
		return DateTimeFormatter.ofPattern(
				messageSource.getMessage("date.format.pattern", null, locale), 
				locale);
	}
}