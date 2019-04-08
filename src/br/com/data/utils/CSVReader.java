package br.com.data.utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import br.com.data.entities.Line;
import br.com.data.entities.Route;
import br.com.data.entities.Station;

public class CSVReader {

	private File file;

	public CSVReader(String fileUrl) {
		this.file = new File(fileUrl);
	}

	public HashMap<Station, ArrayList<Route>> readStations() {
		HashMap<Station, ArrayList<Route>> stations = null;
		try {
			FileReader fr = new FileReader(file);
			BufferedReader br = new BufferedReader(fr);
			String currentLine = br.readLine();

			String lastStationName = null;
			Station lastStation = null;
			stations = new HashMap<Station, ArrayList<Route>>();
			Integer stationNumber = null;
			
			while ((currentLine = br.readLine()) != null) {
				String[] data = currentLine.split(",");
				
				lastStationName = data[0];
				stationNumber = stationNameToInteger(lastStationName);
				
				if (lastStation != null) {
					if (lastStation.getName().equals(lastStationName)) {
						stations.get(lastStation).add(new Route(lastStation, new Station(stationNameToInteger(data[1])), new Line(data[2])));
						continue;
					}
				}
				
				lastStation = new Station(stationNumber);
				ArrayList<Route> routes = new ArrayList<Route>();
				routes.add(new Route(lastStation, new Station(stationNameToInteger(data[1])), new Line(data[2])));
				
				stations.put(lastStation, routes);
			}

			br.close();
			fr.close();

			return stations;
		} catch (IOException e) {

		}

		return null;
	}
	
	private int stationNameToInteger(String stationName) {
		return Integer.parseInt(stationName.substring(1));
	}
}
