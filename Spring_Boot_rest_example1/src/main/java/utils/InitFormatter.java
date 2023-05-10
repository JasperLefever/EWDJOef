package utils;

import java.time.format.DateTimeFormatter;

public interface InitFormatter {

	DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
}