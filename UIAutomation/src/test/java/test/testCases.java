package test;

import org.testng.annotations.Test;

import objects.Locators;
import testComponents.BaseTest;

public class testCases extends BaseTest{


//	@Test
//	public void testWorldPopulation() {
//		System.out.println("Current World Population = "+locators.getcurrentWorldPopulation());
//		System.out.println("Births Today = "+locators.getBirthsToday());
//		System.out.println("Deaths Today = "+locators.getdeathsToday());
//		System.out.println("Population Growth Today = "+locators.getpopulationGrowthToday());
//		System.out.println("Births This Year = "+locators.getbirthsThisYear());
//		System.out.println("Deaths This Year = "+locators.getdeathsThisYear());
//		System.out.println("Population Growth This Year = "+locators.getpopulationGrowthThisYear());
//	}
	
	@Test
	public void testWorldPopulation1() {
		long endTime = System.currentTimeMillis() + 20000;
		while (System.currentTimeMillis() < endTime) {
			
			System.out.println("Current World Population = "+locators.getcurrentWorldPopulation());
			System.out.println("Births Today = "+locators.getBirthsToday());
			System.out.println("Deaths Today = "+locators.getdeathsToday());
			System.out.println("Population Growth Today = "+locators.getpopulationGrowthToday());
			System.out.println("Births This Year = "+locators.getbirthsThisYear());
			System.out.println("Deaths This Year = "+locators.getdeathsThisYear());
			System.out.println("Population Growth This Year = "+locators.getpopulationGrowthThisYear());
			System.out.println();
		} 
	}

	}
