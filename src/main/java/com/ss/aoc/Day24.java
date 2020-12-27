package com.ss.aoc;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import java.awt.Point;
import java.util.EnumMap;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Day24 extends AOCDay {

    public Day24() {
        this.dataFileName = "day24.txt";
        this.testDataFilename = "day24test.txt";
    }

    @Override
    long task1(boolean isTest) {
        List<String> lines = getDataAsStringLines(isTest);
        Map<Integer, Tile> tiles = new HashMap<>();
        traverseTiles(tiles, lines);
        // for each line, get list odf direction enums and move the reference tile till last of them
        return tiles.values().stream().filter(Tile::isBlack).count();
    }

    private void traverseTiles(Map<Integer, Tile> tiles, List<String> directionInputs) {
        for (String directionInput : directionInputs) {
            List<DIRECTION> directions = getDirectionsFromLine(directionInput);
            Tile newTile = new Tile();
            directions.forEach(newTile::moveTile);
            newTile.flipTile();
            Tile existingTile = tiles.get(newTile.hashCode());
            if (existingTile != null) {
                existingTile.flipTile();
//                System.out.println("Existing tile :" + existingTile.toString());
            } else {
                tiles.put(newTile.hashCode(), newTile);
//                System.out.println("New tile :" + newTile.toString());
            }
        }
    }

    private List<DIRECTION> getDirectionsFromLine(String directionInput) {
        List<DIRECTION> directions = new LinkedList<>();

        directionInput = directionInput.replace("swne", "");
        directionInput = directionInput.replace("nesw", "");

        directionInput = directionInput.replace("nwse", "");

        directionInput = directionInput.replace("senw", "");

        for (int i = 0; i < directionInput.length(); i++) {
            DIRECTION possibleDirection = null;
            if (i + 1 < directionInput.length()) {
                possibleDirection = DIRECTION.valueOfDirection(directionInput.substring(i, i + 2));
                if (possibleDirection != null) {
                    i++;
                }
            }
            if (possibleDirection == null) {
                possibleDirection = DIRECTION.valueOfDirection(String.valueOf(directionInput.charAt(i)));
            }
            directions.add(possibleDirection);


        }
        return directions;
    }

    @Override
    long task2(boolean isTest) {
        List<String> lines = getDataAsStringLines(isTest);
        Map<Integer, Tile> tiles = new HashMap<>();
        traverseTiles(tiles, lines);
        flipTilesForNumberOfDays(tiles, 70);
        return tiles.values().stream().filter(Tile::isBlack).count();
    }

    private void flipTilesForNumberOfDays(Map<Integer, Tile> tiles, int times) {
        Map<Integer, Tile> tempTiles = new HashMap<>();
        // copyMap(tiles, tempTiles); // check day 17 on how to copy them before iterating then.
        for (int i = 0; i < times; i++) {
            Map<Integer, Tile> mapWithClosestNeighbours = getWithClosestNeighbours(tiles);
            for (Map.Entry<Integer, Tile> entry : mapWithClosestNeighbours.entrySet()) {
                if ((entry.getValue().isBlack() && hasAdjacentBlackTiles(entry.getValue(), mapWithClosestNeighbours))
                    || (!entry.getValue().isBlack() && hasTwoBlackTiles(entry.getValue(), mapWithClosestNeighbours))) {
                    Tile tile = entry.getValue().clone();
                    tile.flipTile();
                    tempTiles.put(tile.hashCode(), tile);
                } else {
                    tempTiles.put(entry.getKey(), entry.getValue().clone());
                }
            }
            copyMap(tempTiles, tiles);
        }
    }

    private boolean hasAdjacentBlackTiles(Tile value, Map<Integer, Tile> mapWithClosestNeighbours) {
        final int[] adjacentBlackTiles = { 0 };
        List<Tile> neighbours = value.getNeighbours();
        neighbours.forEach(neighbourTile -> {
            Tile existingTile = mapWithClosestNeighbours.get(neighbourTile.hashCode());
            if (existingTile != null && existingTile.isBlack()) {
                adjacentBlackTiles[0]++;
            }
        });
        return adjacentBlackTiles[0] == 0 || adjacentBlackTiles[0] > 2;
    }

    private boolean hasTwoBlackTiles(Tile value, Map<Integer, Tile> mapWithClosestNeighbours) {
        final int[] adjacentBlackTiles = { 0 };
        List<Tile> neighbours = value.getNeighbours();
        neighbours.forEach(neighbourTile -> {
            Tile existingTile = mapWithClosestNeighbours.get(neighbourTile.hashCode());
            if (existingTile != null && existingTile.isBlack()) {
                adjacentBlackTiles[0]++;
            }
        });
        return adjacentBlackTiles[0] == 2;
    }

    private Map<Integer, Tile> getWithClosestNeighbours(Map<Integer, Tile> tiles) {
        Map<Integer, Tile> mapWithClosestNeighbours = new HashMap<>(tiles);
        tiles.forEach((key, value) -> {
            List<Tile> adjacentNeighbours = value.getNeighbours();
            adjacentNeighbours.forEach(neighbourTile -> {
                if (tiles.containsKey(neighbourTile.hashCode())) {
                    mapWithClosestNeighbours.putIfAbsent(neighbourTile.hashCode(), tiles.get(neighbourTile.hashCode()).clone());
                } else {
                    mapWithClosestNeighbours.putIfAbsent(neighbourTile.hashCode(), neighbourTile.clone());
                }
            });
        });
        return mapWithClosestNeighbours;
    }

    private void copyMap(Map<Integer, Tile> source, Map<Integer, Tile> destination) {
        destination.clear();
        source.forEach((key, value) -> destination.put(key, value.clone()));
    }

    private static class Tile implements Cloneable {
        private static final EnumMap<DIRECTION, List<Integer>> directionMoves = new EnumMap<>(DIRECTION.class);
        private final List<TilePoint> tilePoints;
        private boolean isBlack = false;

        static {
            directionMoves.put(DIRECTION.E, List.of(2, 0));
            directionMoves.put(DIRECTION.W, List.of(-2, 0));
            directionMoves.put(DIRECTION.NE, List.of(1, 2));
            directionMoves.put(DIRECTION.NW, List.of(-1, 2));
            directionMoves.put(DIRECTION.SE, List.of(1, -2));
            directionMoves.put(DIRECTION.SW, List.of(-1, -2));
        }

        public Tile() {
            tilePoints = List.of(new TilePoint(0, 3), new TilePoint(1, 2), new TilePoint(1, 1),
                    new TilePoint(0, 0), new TilePoint(-1, 1), new TilePoint(-1, 2));

        }

        public Tile(TilePoint corner1, TilePoint corner2, TilePoint corner3, TilePoint corner4, TilePoint corner5, TilePoint corner6, boolean isBlack) {
            tilePoints = List.of(corner1.clone(), corner2.clone(), corner3.clone(), corner4.clone(), corner5.clone(), corner6.clone());
            this.isBlack = isBlack;
        }

        public TilePoint getCorner1() {
            return tilePoints.get(0);
        }

        public TilePoint getCorner2() {
            return tilePoints.get(1);
        }

        public TilePoint getCorner3() {
            return tilePoints.get(2);
        }

        public TilePoint getCorner4() {
            return tilePoints.get(3);
        }


        public TilePoint getCorner5() {
            return tilePoints.get(4);
        }

        public TilePoint getCorner6() {
            return tilePoints.get(5);
        }

        public void moveTile(DIRECTION direction) {
            List<Integer> offsets = directionMoves.get(direction);
            for (TilePoint tilePoint : tilePoints) {
                tilePoint.x = tilePoint.x + offsets.get(0);
                tilePoint.y = tilePoint.y + offsets.get(1);
            }
        }

        public boolean isBlack() {
            return isBlack;
        }

        public void flipTile() {
            isBlack = !isBlack;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Tile tile = (Tile) o;
            return new EqualsBuilder().append(getCorner1(), tile.getCorner1()).append(getCorner2(), tile.getCorner2())
                    .append(getCorner3(), tile.getCorner3()).append(getCorner4(), tile.getCorner4())
                    .append(getCorner5(), tile.getCorner5()).append(getCorner6(), tile.getCorner6())
                    .isEquals();
        }

        @Override
        public int hashCode() {
            return new HashCodeBuilder().append(getCorner1()).append(getCorner2())
                    .append(getCorner3()).append(getCorner4())
                    .append(getCorner5()).append(getCorner6())
                    .toHashCode();
        }

        @Override
        public String toString() {
            StringBuilder stb = new StringBuilder();
            for (TilePoint tp : tilePoints) {
                stb.append("[x=" + tp.x + ",y=" + tp.y + "]-");
            }
            stb.append(isBlack());
            return stb.toString();
        }

        @Override
        protected Tile clone() {
            return new Tile(getCorner1().clone(), getCorner2().clone(), getCorner3().clone(),
                    getCorner4().clone(), getCorner5().clone(), getCorner6().clone(), isBlack);
        }

        public List<Tile> getNeighbours() {
            List<Tile> nearbyTiles = new LinkedList<>();
            // NE, E, SE, SW, W, NW
            nearbyTiles.add(getCoordinatesOfTile(directionMoves.get(DIRECTION.NE)));
            nearbyTiles.add(getCoordinatesOfTile(directionMoves.get(DIRECTION.E)));
            nearbyTiles.add(getCoordinatesOfTile(directionMoves.get(DIRECTION.SE)));
            nearbyTiles.add(getCoordinatesOfTile(directionMoves.get(DIRECTION.SW)));
            nearbyTiles.add(getCoordinatesOfTile(directionMoves.get(DIRECTION.W)));
            nearbyTiles.add(getCoordinatesOfTile(directionMoves.get(DIRECTION.NW)));
            return nearbyTiles;
        }

        private Tile getCoordinatesOfTile(List<Integer> offset) {
            TilePoint corner1 = new TilePoint(getCorner1().x + offset.get(0), getCorner1().y + offset.get(1));
            TilePoint corner2 = new TilePoint(getCorner2().x + offset.get(0), getCorner2().y + offset.get(1));
            TilePoint corner3 = new TilePoint(getCorner3().x + offset.get(0), getCorner3().y + offset.get(1));
            TilePoint corner4 = new TilePoint(getCorner4().x + offset.get(0), getCorner4().y + offset.get(1));
            TilePoint corner5 = new TilePoint(getCorner5().x + offset.get(0), getCorner5().y + offset.get(1));
            TilePoint corner6 = new TilePoint(getCorner6().x + offset.get(0), getCorner6().y + offset.get(1));
            return new Tile(corner1, corner2, corner3, corner4, corner5, corner6, false);
        }
    }

    private static class TilePoint extends Point implements Cloneable {

        public TilePoint(int x, int y) {
            super(x, y);
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }

            TilePoint other = (TilePoint) obj;
            return new EqualsBuilder().append(this.x, other.x).append(this.y, other.y).isEquals();
        }

        @Override
        public int hashCode() {
            return new HashCodeBuilder().append(x).append(y).toHashCode();
        }

        @Override
        public TilePoint clone() {
            return new TilePoint(x, y);
        }
    }

    private static enum DIRECTION {
        E("e"),
        SE("se"),
        SW("sw"),
        W("w"),
        NW("nw"),
        NE("ne");

        private static final Map<String, DIRECTION> BY_LABEL = new HashMap<>();

        static {
            for (DIRECTION enumName : values()) {
                BY_LABEL.put(enumName.direction, enumName);
            }
        }

        private final String direction;

        private DIRECTION(String direction) {
            this.direction = direction;
        }

        public String getDirection() {
            return direction;
        }


        public static DIRECTION valueOfDirection(String direction) {
            return BY_LABEL.get(direction);
        }
    }
}
