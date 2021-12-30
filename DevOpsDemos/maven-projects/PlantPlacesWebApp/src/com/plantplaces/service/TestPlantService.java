package com.plantplaces.service;

import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.plantplaces.dao.IPlantDAO;
import com.plantplaces.dto.Plant;

import junit.framework.TestCase;

public class TestPlantService extends TestCase {

	private PlantService plantService;
	private List<Plant> filterPlants;
	private IPlantDAO plantDAO;

	@Test
	public void testFilterPlants() {
		givenThatPlantServiceIsPopulatedWithPlantDAO();
		whenFilterWithRed();
		thenVerifyTwoResults();
	}

	private void thenVerifyTwoResults() {
		assertEquals(2, filterPlants.size());
	}

	private void whenFilterWithRed() {
		filterPlants = plantService.filterPlants("Red");
		verify(plantDAO, times(1)).fetchPlants();

	}

	private void givenThatPlantServiceIsPopulatedWithPlantDAO() {
		plantService = new PlantService();

		plantDAO = mock(IPlantDAO.class);
		
		// A known set of hard-coded plants.
		List<Plant> plantList = constructPlantList();
		
		//Tell the mock object to return our known set of hardcoded plants, when requested.
		when(plantDAO.fetchPlants()).thenReturn(plantList);
		
		//Associate the mock object with the object we are testing
		plantService.setPlantDAO(plantDAO);
	}

	private List<Plant> constructPlantList() {
		List<Plant> allPlants = new ArrayList<Plant>();

		// Create plants and add them to the collection.
		Plant redbud = new Plant();
		redbud.setName("Eastern Redbud");
		redbud.setGenus("Cercis");
		redbud.setSpecies("canadensis");
		redbud.setCommon("Redbubd");
		allPlants.add(redbud);

		Plant pawpaw = new Plant();
		pawpaw.setCommon("Paw Paw");
		pawpaw.setGenus("Asimina");
		pawpaw.setSpecies("triloba");
		allPlants.add(pawpaw);

		Plant nasturtium = new Plant();
		nasturtium.setCommon("nasturtium");
		nasturtium.setGenus("Trapoleanum");
		nasturtium.setSpecies("spp.");
		allPlants.add(nasturtium);

		Plant redMaple = new Plant();
		redMaple.setGenus("Acer");
		redMaple.setSpecies("rubrum");
		redMaple.setCommon("Red Maple");
		allPlants.add(redMaple);

		return allPlants;
	}

}
