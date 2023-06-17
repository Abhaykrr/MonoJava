package com.tsm.StreamsApi;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;


public class CountryRegionManager {


	public static void main(String[] args) throws IOException {
		
		List<Country> countrys= setDefaultCountry();
		List<Region> regions = setDefaultRegion();
		
		showAccordingToRegion(countrys,regions);
		showAccordingToRegionUsingSorted(countrys,regions);
		
		int regionId = 2;
		showAccordingToRegionId(countrys,regions,regionId);
		
		countRegions(countrys,regions);
		
					 
	
		
	}

	private static void countRegions(List<Country> countrys, List<Region> regions) {
	
	System.out.println("\n_____________COUNT REGIONS IN EACH REGION_____________________________________________________\n");
		
	regions.stream().forEach((currRegion)->{
		System.out.print(currRegion.getRegionName()+" has ");
		System.out.print(countrys.stream().filter((obj)->obj.getRegionId()==currRegion.getRegionId()).count());
		System.out.println(" Countries");
		
	});	
	
	}
	
	
	private static void showAccordingToRegionId(List<Country> countrys, List<Region> regions, int regionId) {
		 System.out.println("\n____________PARTICULAR REGION ID_____________________________________________________\n");
		 
	 
		 countrys.stream()
			.filter((obj)->obj.getRegionId()==regionId)
			.forEach(System.out::println);
		 
		 
	}

	private static void showAccordingToRegion(List<Country> countrys, List<Region> regions) {
	
		
		System.out.println("\n____________ACCORDING TO REGION ID_____________________________________________________\n");
		
		regions.stream().forEach((currRegion)->{
			System.out.println();
			System.out.println(currRegion.getRegionName());
			countrys.stream()
			.filter((obj)->obj.getRegionId()==currRegion.getRegionId())
			.forEach(System.out::println);
		});
	
		
	}

	private static void showAccordingToRegionUsingSorted(List<Country> countrys, List<Region> regions) {

	
		
		System.out.println("\n____________ACCORDING TO REGION ID USING SORTED_____________________________________________________\n");
		
			 countrys.stream()
			.sorted((obj1,obj2)->Integer.compare(obj1.getRegionId(), obj2.getRegionId()))
			.forEach(System.out::println);
			
		
	}

	private static List<Country> setDefaultCountry() throws IOException {
		
		List<Country> data = new ArrayList<>();
		
		Files.lines(Paths.get("D:/Monocept/TSM/src/com/tsm/StreamsApi/Country.txt"))
		.forEach((eachLine)->{
			List<String> temp  =new ArrayList<>();
			for(String s:eachLine.split("/"))
				temp.add(s);
			
			data.add(new Country(Integer.parseInt(temp.get(2)),temp.get(0),temp.get(1)));
			
		});

		
		
		
		return data;
	}
	
	private static List<Region> setDefaultRegion() throws IOException {
		
		List<Region> data = new ArrayList<>();
		
		Files.lines(Paths.get("D:/Monocept/TSM/src/com/tsm/StreamsApi/Region.txt"))
		.forEach((eachLine)->{
			List<String> temp  =new ArrayList<>();
			for(String s:eachLine.split("/"))
				temp.add(s);
			
			data.add(new Region(Integer.parseInt(temp.get(0)),temp.get(1)));
			
		});

		
		return data;
	}
	
	
}
/*__________ACCORDING TO REGION ID_____________________________________________________


Europe
Country [regionId=1, countryCode=IT, countryName=Italy]
Country [regionId=1, countryCode=UK, countryName=United Kingdom]
Country [regionId=1, countryCode=FR, countryName=France]
Country [regionId=1, countryCode=DE, countryName=Germany]
Country [regionId=1, countryCode=CH, countryName=Switzerland]
Country [regionId=1, countryCode=NL, countryName=Netherlands]
Country [regionId=1, countryCode=DK, countryName=Denmark]
Country [regionId=1, countryCode=BE, countryName=Belgium]

Americas
Country [regionId=2, countryCode=US, countryName=United States of America]
Country [regionId=2, countryCode=CA, countryName=Canada]
Country [regionId=2, countryCode=BR, countryName=Brazil]
Country [regionId=2, countryCode=MX, countryName=Mexico]
Country [regionId=2, countryCode=AR, countryName=Argentina]

Asia
Country [regionId=3, countryCode=JP, countryName=Japan]
Country [regionId=3, countryCode=CN, countryName=China]
Country [regionId=3, countryCode=IN, countryName=India]
Country [regionId=3, countryCode=AU, countryName=Australia]
Country [regionId=3, countryCode=SG, countryName=Singapore]
Country [regionId=3, countryCode=HK, countryName=HongKong]

Middle East and Africa
Country [regionId=4, countryCode=ZW, countryName=Zimbabwe]
Country [regionId=4, countryCode=ZM, countryName=Zambia]
Country [regionId=4, countryCode=EG, countryName=Egypt]
Country [regionId=4, countryCode=KW, countryName=Kuwait]
Country [regionId=4, countryCode=IL, countryName=Israel]
Country [regionId=4, countryCode=NG, countryName=Nigeria]

Others
Country [regionId=5, countryCode=AK, countryName=Abhay]

____________ACCORDING TO REGION ID USING SORTED_____________________________________________________

Country [regionId=1, countryCode=IT, countryName=Italy]
Country [regionId=1, countryCode=UK, countryName=United Kingdom]
Country [regionId=1, countryCode=FR, countryName=France]
Country [regionId=1, countryCode=DE, countryName=Germany]
Country [regionId=1, countryCode=CH, countryName=Switzerland]
Country [regionId=1, countryCode=NL, countryName=Netherlands]
Country [regionId=1, countryCode=DK, countryName=Denmark]
Country [regionId=1, countryCode=BE, countryName=Belgium]
Country [regionId=2, countryCode=US, countryName=United States of America]
Country [regionId=2, countryCode=CA, countryName=Canada]
Country [regionId=2, countryCode=BR, countryName=Brazil]
Country [regionId=2, countryCode=MX, countryName=Mexico]
Country [regionId=2, countryCode=AR, countryName=Argentina]
Country [regionId=3, countryCode=JP, countryName=Japan]
Country [regionId=3, countryCode=CN, countryName=China]
Country [regionId=3, countryCode=IN, countryName=India]
Country [regionId=3, countryCode=AU, countryName=Australia]
Country [regionId=3, countryCode=SG, countryName=Singapore]
Country [regionId=3, countryCode=HK, countryName=HongKong]
Country [regionId=4, countryCode=ZW, countryName=Zimbabwe]
Country [regionId=4, countryCode=ZM, countryName=Zambia]
Country [regionId=4, countryCode=EG, countryName=Egypt]
Country [regionId=4, countryCode=KW, countryName=Kuwait]
Country [regionId=4, countryCode=IL, countryName=Israel]
Country [regionId=4, countryCode=NG, countryName=Nigeria]
Country [regionId=5, countryCode=AK, countryName=Abhay]

____________PARTICULAR REGION ID_____________________________________________________

Country [regionId=2, countryCode=US, countryName=United States of America]
Country [regionId=2, countryCode=CA, countryName=Canada]
Country [regionId=2, countryCode=BR, countryName=Brazil]
Country [regionId=2, countryCode=MX, countryName=Mexico]
Country [regionId=2, countryCode=AR, countryName=Argentina]

_____________COUNT REGIONS IN EACH REGION_____________________________________________________

Europe has 8 Countries
Americas has 5 Countries
Asia has 6 Countries
Middle East and Africa has 6 Countries
Others has 1 Countries

*/
