package de.tom;

import static org.junit.Assert.assertEquals;
import static org.easymock.EasyMock.*;
import org.junit.Before;
import org.junit.Test;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ResidentRepositoryTest {
	List<Resident> residents = new ArrayList<Resident>();
	ResidentRepository rep;
	BaseResidentService service = new BaseResidentService();

	@Before
	public void bedingung() {
		List<Resident> residents = new ArrayList<Resident>();
		residents.add(new Resident("Name1", "Familie1", "Straﬂe1", "Stadt1",
				new Date()));
		residents.add(new Resident("Name2", "Familie2", "Straﬂe2", "Stadt2",
				new Date()));
		residents.add(new Resident("Name3", "Familie3", "Straﬂe3", "Stadt3",
				new Date()));
		residents.add(new Resident("Name4", "Familie4", "Straﬂe4", "Stadt4",
				new Date()));
		rep = createMock(ResidentRepository.class);
		expect(rep.getResidents()).andReturn(residents);
		service.setResidentRepository(rep);
		replay(rep);
	}

	@Test(expected = ResidentServiceException.class)
	public void uniqueResidentExceptionTest() throws ResidentServiceException {
		// service.setResidentRepository(rep);
		service.getUniqueResident(new Resident(null, null, null, null, null));
	}

	@Test(expected = ResidentServiceException.class)
	public void uniqueResidentWildcardsTest() throws ResidentServiceException {
		// service.setResidentRepository(rep);
		service.getUniqueResident(new Resident("*", null, null, null, null));
	}

	@Test(expected = ResidentServiceException.class)
	public void uniqueResidentWildcardsTest2() throws ResidentServiceException {
		// service.setResidentRepository(rep);
		service.getUniqueResident(new Resident("Name1", "*", null, null, null));
	}

	@Test(expected = ResidentServiceException.class)
	public void uniqueResidentWildcardsTest3() throws ResidentServiceException {
		// service.setResidentRepository(rep);
		service.getUniqueResident(new Resident("Name1", "Familie1", "*", null,
				null));
	}

	@Test
	public void uniqueResidentTest() throws ResidentServiceException {
		// service.setResidentRepository(rep);
		Resident r = service.getUniqueResident(new Resident("Name1", null,
				null, null, null));
		assertEquals(r.getGivenName(), "Name1");
		assertEquals(r.getFamilyName(), "Familie1");
		assertEquals(r.getStreet(), "Straﬂe1");
		assertEquals(r.getCity(), "Stadt1");
		verify(rep);
	}

	@Test
	public void getFilteredResidentsWildcardTest() {
		int size = service.getFilteredResidentsList(
				new Resident("N*", "F*", "S*", "*", null)).size();
		assertEquals(size, 4);
		verify(rep);
	}

	@Test
	public void getFilteredResidentsEmptyListTest() {
		int size = service.getFilteredResidentsList(
				new Resident("Test", null, null, null, null)).size();
		assertEquals(size, 0);
		verify(rep);
	}

	@Test
	public void getFilteredResidentsEmptyList2Test() {
		int size = service.getFilteredResidentsList(
				new Resident("N*", "F*", "Test", null, null)).size();
		assertEquals(size, 0);
		verify(rep);
	}

	@Test
	public void getFilteredResidentsEmptyList3Test() {
		int size = service.getFilteredResidentsList(
				new Resident("N*", "F", "Test", null, null)).size();
		assertEquals(size, 0);
		verify(rep);
	}

	@Test
	public void getFilteredResidentsListIsNullTest() {
		int size = service.getFilteredResidentsList(
				new Resident(null, null, null, null, null)).size();
		assertEquals(size, 4);
		verify(rep);
	}
}