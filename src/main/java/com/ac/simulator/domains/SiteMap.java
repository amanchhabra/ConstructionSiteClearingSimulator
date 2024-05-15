package com.ac.simulator.domains;

import com.ac.simulator.constants.LandType;
import com.ac.simulator.domains.lands.Land;
import com.ac.simulator.domains.lands.LandBuilder;
import com.ac.simulator.exceptions.InvalidLandTypeException;
import com.ac.simulator.exceptions.InvalidSitemapException;
import com.ac.simulator.exceptions.LandNotFoundException;

import java.util.List;

/**
 * Sitemap class to store the complete map of various type of land
 */
public class SiteMap {

    private Land[][] sitemapData = null;

    public SiteMap(List<String> data) throws InvalidLandTypeException, InvalidSitemapException {
        load(data);
    }

    private void load(List<String> data) throws InvalidLandTypeException, InvalidSitemapException {
        int size = data.size();
        sitemapData = new Land[size][size];
        for (int i = 0; i < size; i++) {
            String line = data.get(i);
            if (i != 0 && line.length() != data.get(i - 1).length()) {
                throw new InvalidSitemapException();
            }
            Land[] landsList = new Land[line.length()];
            String[] symbols = line.split("");
            for (int j = 0; j < line.length(); j++) {
                landsList[j] = LandBuilder.createLand(symbols[j]);
            }
            sitemapData[i] = landsList;
        }
    }

    public Land getLand(int posX, int posY) throws LandNotFoundException {
        if (
                0 <= posX
                        && posX < sitemapData.length
                        && 0 <= posY
                        && posY < sitemapData[0].length
        ) {
            return sitemapData[posX][posY];
        } else {
            throw new LandNotFoundException();
        }
    }

    public int getUnclearedNonReservedTreeLandCount() {
        int count = 0;
        for (Land[] lands : sitemapData) {
            for (int i = 0; i < sitemapData[0].length; i++) {
                if (lands[i].isUncleared() && lands[i].getLandType() != LandType.RESERVED_TREE) {
                    count++;
                }
            }
        }
        return count;
    }

    @Override
    public String toString() {
        StringBuilder stringFormat = new StringBuilder();
        for (Land[] lands : sitemapData) {
            for (int i = 0; i < sitemapData[0].length; i++) {
                stringFormat.append(lands[i].getLandType().getSymbol());
                stringFormat.append(" ");
            }
            stringFormat.append("\n");
        }
        return stringFormat.toString();
    }
}
