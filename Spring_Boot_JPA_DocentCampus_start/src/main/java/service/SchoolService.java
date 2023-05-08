package service;

import jakarta.transaction.Transactional;

public interface SchoolService {

	@Transactional
	public void changeWerkruimte(String lokaalCode, String campusNaam1, String campusNaam2);
}
