package de.tom;

import java.util.Date;
import java.util.ArrayList;
import java.util.List;

public class ResidentRepositoryStub implements ResidentRepository {
	List<Resident> residents = new ArrayList<Resident>();

	ResidentRepositoryStub() {
		residents.add(new Resident("Name1", "Familie1", "Straﬂe1", "Stadt1",
				new Date()));
		residents.add(new Resident("Name2", "Familie2", "Straﬂe2", "Stadt2",
				new Date()));
		residents.add(new Resident("Name3", "Familie3", "Straﬂe3", "Stadt3",
				new Date()));
		residents.add(new Resident("Name4", "Familie4", "Straﬂe4", "Stadt4",
				new Date()));
	}

	public List<Resident> getResidents() {
		// TODO Auto-generated method stub
		return residents;
	}

}