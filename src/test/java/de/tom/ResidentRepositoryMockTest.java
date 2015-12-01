package de.tom;

import static org.junit.Assert.assertEquals;
import static org.easymock.EasyMock.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class ResidentRepositoryMockTest {
	List<Resident> residents = new ArrayList<Resident>();
	ResidentRepository rep;
	BaseResidentService service = new BaseResidentService();
	
	@Before
	public void vorher(){
		List<Resident> residents = new ArrayList<Resident>();
		residents.add(new Resident("Name1","Familie1","Straﬂe1","Stadt1",new Date()));
		residents.add(new Resident("Name2","Familie2","Straﬂe2","Stadt2",new Date()));
		residents.add(new Resident("Name3","Familie3","Straﬂe3","Stadt3",new Date()));
		residents.add(new Resident("Name4","Familie4","Straﬂe4","Stadt4",new Date()));
		rep = createMock(ResidentRepository.class);
		expect(rep.getResidents()).andReturn(residents);
		service.setResidentRepository(rep);
		replay(rep);
	}
	
	
	@Test(expected=ResidentServiceException.class)
	public void uniqueResidentExceptionTest() throws ResidentServiceException{
		//service.setResidentRepository(rep);
		service.getUniqueResident(new Resident(null,null,null,null,null));
	}
	
	@Test(expected=ResidentServiceException.class)
	public void uniqueResidentWildcarsTest() throws ResidentServiceException{
		//service.setResidentRepository(rep);
		service.getUniqueResident(new Resident("*",null,null,null,null));
	}
	
	@Test(expected=ResidentServiceException.class)
	public void uniqueResidentWildcarsTest2() throws ResidentServiceException{
		//service.setResidentRepository(rep);
		service.getUniqueResident(new Resident("Name1","*",null,null,null));
	}
	
	@Test(expected=ResidentServiceException.class)
	public void uniqueResidentWildcarsTest3() throws ResidentServiceException{
		//service.setResidentRepository(rep);
		service.getUniqueResident(new Resident("Name1","Familie1","*",null,null));
	}
	
	@Test
	public void uniqueResidentErfolgTest() throws ResidentServiceException{
		//service.setResidentRepository(rep);
		Resident r = service.getUniqueResident(new Resident("Name1",null,null,null,null));
		assertEquals(r.getGivenName(),"Name1");
		assertEquals(r.getFamilyName(),"Familie1");
		assertEquals(r.getStreet(),"Straﬂe1");
		assertEquals(r.getCity(),"Stadt1");
		verify(rep);
	}
	
	@Test
	public void getFilteredResidentsListWildcardTest(){
		int size = service.getFilteredResidentsList(new Resident("N*","F*","S*","S*",null)).size();
		assertEquals(size,4);
		verify(rep);
	}
	
	@Test
	public void getFilteredResidentsListLeerTest(){
		int size = service.getFilteredResidentsList(new Resident("Test",null,null,null,null)).size(); 
		assertEquals(size,0);
		verify(rep);
	}
	
	@Test
	public void getFilteredResidentsListLeer2Test(){
		int size = service.getFilteredResidentsList(new Resident("N*","F*","Test",null,null)).size(); 
		assertEquals(size,0);
		verify(rep);
	}
	
	@Test
	public void getFilteredResidentsListLeer3Test(){
		int size = service.getFilteredResidentsList(new Resident("N*","F","Test",null,null)).size(); 
		assertEquals(size,0);
		verify(rep);
	}
	
	@Test
	public void getFilteredResidentsListNullTest(){
		int size = service.getFilteredResidentsList(new Resident(null,null,null,null,null)).size(); 
		assertEquals(size,4);
		verify(rep);
	}
}