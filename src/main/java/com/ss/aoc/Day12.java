package com.ss.aoc;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Day12 {
    private final String inputTestData = "F10\n" +
            "N3\n" +
            "F7\n" +
            "R90\n" +
            "F11";
    private final String inputTestData2 = "F10\n" +
            "N3\n" +
            "F7\n" +
            "R90\n" +
            "R180\n" +
            "R270\n" +
            "F11";
    private final String inputData = "S2\n" +
            "W4\n" +
            "F31\n" +
            "N2\n" +
            "E4\n" +
            "F98\n" +
            "R180\n" +
            "W2\n" +
            "N4\n" +
            "E1\n" +
            "L180\n" +
            "W2\n" +
            "S5\n" +
            "F69\n" +
            "W5\n" +
            "F12\n" +
            "E3\n" +
            "F91\n" +
            "R90\n" +
            "E1\n" +
            "L90\n" +
            "F73\n" +
            "W4\n" +
            "N3\n" +
            "R90\n" +
            "F76\n" +
            "R90\n" +
            "F33\n" +
            "W2\n" +
            "L90\n" +
            "F51\n" +
            "E1\n" +
            "S3\n" +
            "L180\n" +
            "F62\n" +
            "N5\n" +
            "L180\n" +
            "N3\n" +
            "E1\n" +
            "L90\n" +
            "F83\n" +
            "R180\n" +
            "W4\n" +
            "F29\n" +
            "E2\n" +
            "L90\n" +
            "L90\n" +
            "N3\n" +
            "W1\n" +
            "S1\n" +
            "E2\n" +
            "L270\n" +
            "L180\n" +
            "N2\n" +
            "E1\n" +
            "F77\n" +
            "N2\n" +
            "F11\n" +
            "L180\n" +
            "E2\n" +
            "F45\n" +
            "N4\n" +
            "W5\n" +
            "S2\n" +
            "L90\n" +
            "N2\n" +
            "F14\n" +
            "L90\n" +
            "W3\n" +
            "F6\n" +
            "N5\n" +
            "E2\n" +
            "R90\n" +
            "E2\n" +
            "L90\n" +
            "F39\n" +
            "L90\n" +
            "F45\n" +
            "W2\n" +
            "F67\n" +
            "W4\n" +
            "F50\n" +
            "E1\n" +
            "F92\n" +
            "W5\n" +
            "F75\n" +
            "N2\n" +
            "W1\n" +
            "S3\n" +
            "R90\n" +
            "W5\n" +
            "F51\n" +
            "L90\n" +
            "E3\n" +
            "F71\n" +
            "N3\n" +
            "E3\n" +
            "F74\n" +
            "E4\n" +
            "S3\n" +
            "W2\n" +
            "L180\n" +
            "E2\n" +
            "S5\n" +
            "L270\n" +
            "R90\n" +
            "N2\n" +
            "R90\n" +
            "E4\n" +
            "L270\n" +
            "S5\n" +
            "E4\n" +
            "W3\n" +
            "L90\n" +
            "N2\n" +
            "F32\n" +
            "E3\n" +
            "N5\n" +
            "E2\n" +
            "R180\n" +
            "F27\n" +
            "S1\n" +
            "R90\n" +
            "F94\n" +
            "E2\n" +
            "F82\n" +
            "N3\n" +
            "L90\n" +
            "F100\n" +
            "W4\n" +
            "L90\n" +
            "S1\n" +
            "E4\n" +
            "F26\n" +
            "R90\n" +
            "R90\n" +
            "F12\n" +
            "W4\n" +
            "F70\n" +
            "L90\n" +
            "F100\n" +
            "W4\n" +
            "S2\n" +
            "R90\n" +
            "E3\n" +
            "F11\n" +
            "L90\n" +
            "F32\n" +
            "L180\n" +
            "S2\n" +
            "F11\n" +
            "S2\n" +
            "L90\n" +
            "S3\n" +
            "E4\n" +
            "F93\n" +
            "S1\n" +
            "R90\n" +
            "S2\n" +
            "F20\n" +
            "E2\n" +
            "F9\n" +
            "S5\n" +
            "F23\n" +
            "E4\n" +
            "S2\n" +
            "F38\n" +
            "L90\n" +
            "N3\n" +
            "F3\n" +
            "E2\n" +
            "F37\n" +
            "N2\n" +
            "F89\n" +
            "E5\n" +
            "F43\n" +
            "R90\n" +
            "F88\n" +
            "N5\n" +
            "F52\n" +
            "W5\n" +
            "F24\n" +
            "E4\n" +
            "L180\n" +
            "S4\n" +
            "E3\n" +
            "F14\n" +
            "L90\n" +
            "S2\n" +
            "E5\n" +
            "L180\n" +
            "N4\n" +
            "F98\n" +
            "N4\n" +
            "W2\n" +
            "S2\n" +
            "W1\n" +
            "S3\n" +
            "R90\n" +
            "F98\n" +
            "E4\n" +
            "R270\n" +
            "E2\n" +
            "F45\n" +
            "L90\n" +
            "F75\n" +
            "R180\n" +
            "W3\n" +
            "L180\n" +
            "F42\n" +
            "E2\n" +
            "N4\n" +
            "L90\n" +
            "F2\n" +
            "R180\n" +
            "W5\n" +
            "E5\n" +
            "N5\n" +
            "R180\n" +
            "F92\n" +
            "L90\n" +
            "F95\n" +
            "E3\n" +
            "F61\n" +
            "S5\n" +
            "E2\n" +
            "L180\n" +
            "E1\n" +
            "E2\n" +
            "F27\n" +
            "S3\n" +
            "W2\n" +
            "S1\n" +
            "F86\n" +
            "R270\n" +
            "S1\n" +
            "L90\n" +
            "R90\n" +
            "E5\n" +
            "S2\n" +
            "S2\n" +
            "F93\n" +
            "E2\n" +
            "R270\n" +
            "N3\n" +
            "W3\n" +
            "F74\n" +
            "R90\n" +
            "F94\n" +
            "E2\n" +
            "F88\n" +
            "S1\n" +
            "R90\n" +
            "W4\n" +
            "L90\n" +
            "N5\n" +
            "F59\n" +
            "R90\n" +
            "N1\n" +
            "F24\n" +
            "S2\n" +
            "F10\n" +
            "L90\n" +
            "F72\n" +
            "L90\n" +
            "F55\n" +
            "N2\n" +
            "E1\n" +
            "R90\n" +
            "N1\n" +
            "E1\n" +
            "F12\n" +
            "L90\n" +
            "S5\n" +
            "E5\n" +
            "F44\n" +
            "L180\n" +
            "S4\n" +
            "E2\n" +
            "E5\n" +
            "S1\n" +
            "E5\n" +
            "R180\n" +
            "S1\n" +
            "R90\n" +
            "N3\n" +
            "L90\n" +
            "E2\n" +
            "S4\n" +
            "L90\n" +
            "R90\n" +
            "W1\n" +
            "R90\n" +
            "E5\n" +
            "N1\n" +
            "L90\n" +
            "N1\n" +
            "E3\n" +
            "S5\n" +
            "W1\n" +
            "S1\n" +
            "L270\n" +
            "E2\n" +
            "E4\n" +
            "F31\n" +
            "S2\n" +
            "E4\n" +
            "N2\n" +
            "W3\n" +
            "L90\n" +
            "F7\n" +
            "S3\n" +
            "F23\n" +
            "S3\n" +
            "E1\n" +
            "F15\n" +
            "S1\n" +
            "L90\n" +
            "E4\n" +
            "S1\n" +
            "L90\n" +
            "N3\n" +
            "W1\n" +
            "F13\n" +
            "R180\n" +
            "S3\n" +
            "F37\n" +
            "N3\n" +
            "W5\n" +
            "S5\n" +
            "L90\n" +
            "F55\n" +
            "F54\n" +
            "R90\n" +
            "E1\n" +
            "N4\n" +
            "F68\n" +
            "S5\n" +
            "F3\n" +
            "L180\n" +
            "F75\n" +
            "N3\n" +
            "R90\n" +
            "W4\n" +
            "F78\n" +
            "S4\n" +
            "S3\n" +
            "R180\n" +
            "N2\n" +
            "R90\n" +
            "N1\n" +
            "F20\n" +
            "L180\n" +
            "F12\n" +
            "S4\n" +
            "E4\n" +
            "L180\n" +
            "F10\n" +
            "E2\n" +
            "N5\n" +
            "E3\n" +
            "F13\n" +
            "E3\n" +
            "L90\n" +
            "F55\n" +
            "E5\n" +
            "F96\n" +
            "W1\n" +
            "F100\n" +
            "R90\n" +
            "F97\n" +
            "W4\n" +
            "W2\n" +
            "N4\n" +
            "W4\n" +
            "N3\n" +
            "E4\n" +
            "R90\n" +
            "S1\n" +
            "W4\n" +
            "F80\n" +
            "W2\n" +
            "L90\n" +
            "F64\n" +
            "W5\n" +
            "S2\n" +
            "W3\n" +
            "R180\n" +
            "W1\n" +
            "S2\n" +
            "F83\n" +
            "R180\n" +
            "F37\n" +
            "W4\n" +
            "N4\n" +
            "F57\n" +
            "E3\n" +
            "R90\n" +
            "F37\n" +
            "S4\n" +
            "R180\n" +
            "F62\n" +
            "R90\n" +
            "S5\n" +
            "F9\n" +
            "E3\n" +
            "N4\n" +
            "L90\n" +
            "W4\n" +
            "R90\n" +
            "F97\n" +
            "W4\n" +
            "R180\n" +
            "F2\n" +
            "W4\n" +
            "S1\n" +
            "F77\n" +
            "L180\n" +
            "R90\n" +
            "E4\n" +
            "F58\n" +
            "S2\n" +
            "L90\n" +
            "E1\n" +
            "N3\n" +
            "L90\n" +
            "N2\n" +
            "W4\n" +
            "N1\n" +
            "L90\n" +
            "F94\n" +
            "E1\n" +
            "R90\n" +
            "F29\n" +
            "S3\n" +
            "L180\n" +
            "E2\n" +
            "R180\n" +
            "S5\n" +
            "F62\n" +
            "L90\n" +
            "N2\n" +
            "R90\n" +
            "E4\n" +
            "F93\n" +
            "L90\n" +
            "E5\n" +
            "N4\n" +
            "L180\n" +
            "N3\n" +
            "F20\n" +
            "R90\n" +
            "E3\n" +
            "L90\n" +
            "S3\n" +
            "F24\n" +
            "E4\n" +
            "R90\n" +
            "E4\n" +
            "F89\n" +
            "N1\n" +
            "F13\n" +
            "R180\n" +
            "W1\n" +
            "L90\n" +
            "S3\n" +
            "W5\n" +
            "S4\n" +
            "L180\n" +
            "W3\n" +
            "F90\n" +
            "S4\n" +
            "E3\n" +
            "F36\n" +
            "S3\n" +
            "E2\n" +
            "F37\n" +
            "E5\n" +
            "F31\n" +
            "L90\n" +
            "F68\n" +
            "S5\n" +
            "F74\n" +
            "L90\n" +
            "F59\n" +
            "R180\n" +
            "F20\n" +
            "N1\n" +
            "L180\n" +
            "N5\n" +
            "L90\n" +
            "E3\n" +
            "N2\n" +
            "W4\n" +
            "F54\n" +
            "L90\n" +
            "F77\n" +
            "R270\n" +
            "S5\n" +
            "F82\n" +
            "R90\n" +
            "E2\n" +
            "L180\n" +
            "F59\n" +
            "R90\n" +
            "E5\n" +
            "R90\n" +
            "F26\n" +
            "E4\n" +
            "F91\n" +
            "R90\n" +
            "W4\n" +
            "F6\n" +
            "W5\n" +
            "F34\n" +
            "S4\n" +
            "F61\n" +
            "W2\n" +
            "S2\n" +
            "R270\n" +
            "F45\n" +
            "R180\n" +
            "N5\n" +
            "L90\n" +
            "F26\n" +
            "L90\n" +
            "R90\n" +
            "S1\n" +
            "W3\n" +
            "N5\n" +
            "W5\n" +
            "L90\n" +
            "N3\n" +
            "L90\n" +
            "N3\n" +
            "E3\n" +
            "L90\n" +
            "F1\n" +
            "E4\n" +
            "L90\n" +
            "F60\n" +
            "N3\n" +
            "F7\n" +
            "S1\n" +
            "E1\n" +
            "F68\n" +
            "L90\n" +
            "N5\n" +
            "E5\n" +
            "F36\n" +
            "W3\n" +
            "S5\n" +
            "L270\n" +
            "N2\n" +
            "E1\n" +
            "R90\n" +
            "F8\n" +
            "S3\n" +
            "E1\n" +
            "R90\n" +
            "N1\n" +
            "E2\n" +
            "R90\n" +
            "N1\n" +
            "F90\n" +
            "E2\n" +
            "F63\n" +
            "S2\n" +
            "F17\n" +
            "S1\n" +
            "E3\n" +
            "L90\n" +
            "E4\n" +
            "L180\n" +
            "N4\n" +
            "W1\n" +
            "S4\n" +
            "L90\n" +
            "S5\n" +
            "F15\n" +
            "W1\n" +
            "N5\n" +
            "W3\n" +
            "F97\n" +
            "S3\n" +
            "L90\n" +
            "S2\n" +
            "F78\n" +
            "N3\n" +
            "W5\n" +
            "L90\n" +
            "F68\n" +
            "E3\n" +
            "F24\n" +
            "S3\n" +
            "L90\n" +
            "W2\n" +
            "L90\n" +
            "F49\n" +
            "W4\n" +
            "R90\n" +
            "F82\n" +
            "R270\n" +
            "S1\n" +
            "N3\n" +
            "L90\n" +
            "S4\n" +
            "R90\n" +
            "S2\n" +
            "F46\n" +
            "L180\n" +
            "E4\n" +
            "L180\n" +
            "W2\n" +
            "R90\n" +
            "L90\n" +
            "N1\n" +
            "F88\n" +
            "L180\n" +
            "S5\n" +
            "R90\n" +
            "S4\n" +
            "L90\n" +
            "F68\n" +
            "W5\n" +
            "F13\n" +
            "E4\n" +
            "S3\n" +
            "F91\n" +
            "W3\n" +
            "F85\n" +
            "L180\n" +
            "N4\n" +
            "W5\n" +
            "S3\n" +
            "F89\n" +
            "W1\n" +
            "L180\n" +
            "S2\n" +
            "E3\n" +
            "F82\n" +
            "L90\n" +
            "S4\n" +
            "W5\n" +
            "N5\n" +
            "W2\n" +
            "S4\n" +
            "S2\n" +
            "F82\n" +
            "E2\n" +
            "N4\n" +
            "L90\n" +
            "F80\n" +
            "E2\n" +
            "F49\n" +
            "W5\n" +
            "S3\n" +
            "F76\n" +
            "L90\n" +
            "S1\n" +
            "F41\n" +
            "S3\n" +
            "E1\n" +
            "F26\n" +
            "E3\n" +
            "F53\n" +
            "E2\n" +
            "F73\n" +
            "W3\n" +
            "R180\n" +
            "N2\n" +
            "R90\n" +
            "N3\n" +
            "R90\n" +
            "F16\n" +
            "L90\n" +
            "N3\n" +
            "N1\n" +
            "W5\n" +
            "F19\n" +
            "R90\n" +
            "N4\n" +
            "W5\n" +
            "F6\n" +
            "E3\n" +
            "N5\n" +
            "W2\n" +
            "N3\n" +
            "E4\n" +
            "S4\n" +
            "L90\n" +
            "E3\n" +
            "S2\n" +
            "F9\n" +
            "L180\n" +
            "F70\n" +
            "N5\n" +
            "S4\n" +
            "F63\n" +
            "N3\n" +
            "E1\n" +
            "R180\n" +
            "S3\n" +
            "L90\n" +
            "E5\n" +
            "L90\n" +
            "F76\n" +
            "R180\n" +
            "E2\n" +
            "L180\n" +
            "L90\n" +
            "F24\n" +
            "E5\n" +
            "S5\n" +
            "F98\n" +
            "S3\n" +
            "F97\n" +
            "N5\n" +
            "R90\n" +
            "N5\n" +
            "F43\n" +
            "W1\n" +
            "R180\n" +
            "F38\n" +
            "R180\n" +
            "F13\n" +
            "W2\n" +
            "F16\n" +
            "R90\n" +
            "F6\n" +
            "N1\n" +
            "F98\n" +
            "R180\n" +
            "N2\n" +
            "E1\n" +
            "F19\n" +
            "L90\n" +
            "S1\n" +
            "F33\n" +
            "R90\n" +
            "N3\n" +
            "F75\n" +
            "N4\n" +
            "L180\n" +
            "F35\n" +
            "W1\n" +
            "F61\n";

    private static final Character FRONT = 'F';
    private static final Character EAST = 'E';
    private static final Character WEST = 'W';
    private static final Character NORTH = 'N';
    private static final Character SOUTH = 'S';
    private static final Character LEFT = 'L';
    private static final Character RIGHT = 'R';
    private static final Map<Character, Character> OPPOSITES = new HashMap<>();

    static {
        OPPOSITES.put(EAST, WEST);
        OPPOSITES.put(WEST, EAST);
        OPPOSITES.put(NORTH, SOUTH);
        OPPOSITES.put(SOUTH, NORTH);
    }

    private static final Map<Character, List<Character>> LEFT_ROTATIONS = new HashMap<>();

    static {
        LEFT_ROTATIONS.put(EAST, Arrays.asList(EAST, NORTH, WEST, SOUTH));
        LEFT_ROTATIONS.put(SOUTH, Arrays.asList(SOUTH, EAST, NORTH, WEST));
        LEFT_ROTATIONS.put(WEST, Arrays.asList(WEST, SOUTH, EAST, NORTH));
        LEFT_ROTATIONS.put(NORTH, Arrays.asList(NORTH, WEST, SOUTH, EAST));
    }

    private static final Map<Character, List<Character>> RIGHT_ROTATIONS = new HashMap<>();

    static {
        RIGHT_ROTATIONS.put(EAST, Arrays.asList(EAST, SOUTH, WEST, NORTH));
        RIGHT_ROTATIONS.put(SOUTH, Arrays.asList(SOUTH, WEST, NORTH, EAST));
        RIGHT_ROTATIONS.put(WEST, Arrays.asList(WEST, NORTH, EAST, SOUTH));
        RIGHT_ROTATIONS.put(NORTH, Arrays.asList(NORTH, EAST, SOUTH, WEST));
    }

    public int getManhattanDistance() {
        return getManhattanDistance(this.inputData);
    }

    public int getManhattanWaypointDistance() {
        return getManhattanWaypointDistance(inputData);
    }

    private int getManhattanDistance(String data) {
        List<Instruction> instructions = getInstructionsFromData(data);
        Map<Character, Integer> directionScore = new HashMap<>();
        directionScore.put(EAST, 0);
        directionScore.put(WEST, 0);
        directionScore.put(NORTH, 0);
        directionScore.put(SOUTH, 0);
        char orientation = 'E';
        for (Instruction instruction : instructions) {
            if (instruction.isOrientationInstruction()) {
                if (instruction.isLeftInstruction()) {
                    orientation = LEFT_ROTATIONS.get(orientation).get(instruction.getValue() / 90);
                } else {
                    orientation = RIGHT_ROTATIONS.get(orientation).get(instruction.getValue() / 90);
                }
            } else if (instruction.isFrontInstruction()) {
                directionScore.merge(orientation, instruction.getValue(), Integer::sum);
            } else {
                directionScore.merge(instruction.getDirection(), instruction.getValue(), Integer::sum);
            }
        }
        return Math.abs(directionScore.get(EAST) - directionScore.get(WEST)) + Math.abs(directionScore.get(NORTH) - directionScore.get(SOUTH));
    }

    private List<Instruction> getInstructionsFromData(String data) {
        String[] chunks = data.split("\n");
        List<Instruction> instructions = new LinkedList<>();
        for (String chunk : chunks) {
            instructions.add(new Instruction(chunk.charAt(0), Integer.parseInt(chunk.substring(1))));
        }
        return instructions;
    }

    private int getManhattanWaypointDistance(String data) {
        List<Instruction> instructions = getInstructionsFromData(data);
        final Coordinate waypointCoordinate = new Coordinate(new Instruction(EAST, 10), new Instruction(NORTH, 1));
        final Coordinate shipCoordinate = new Coordinate(new Instruction(EAST, 0), new Instruction(SOUTH, 0));
        char rotatedHorizontalCoord;
        char rotatedVerticalCoord;
        int tempVerticalValue;
        for (Instruction instruction : instructions) {
            if (instruction.isOrientationInstruction()) {
                int rotationTimes = instruction.getValue() / 90;

                if (instruction.isLeftInstruction()) {
                    rotatedHorizontalCoord = LEFT_ROTATIONS.get(waypointCoordinate.getHorizontalCoordinate().getDirection()).get(rotationTimes);
                    rotatedVerticalCoord = LEFT_ROTATIONS.get(waypointCoordinate.getVerticalCoordinate().getDirection()).get(rotationTimes);
                } else {
                    rotatedHorizontalCoord = RIGHT_ROTATIONS.get(waypointCoordinate.getHorizontalCoordinate().getDirection()).get(rotationTimes);
                    rotatedVerticalCoord = RIGHT_ROTATIONS.get(waypointCoordinate.getVerticalCoordinate().getDirection()).get(rotationTimes);
                }
                waypointCoordinate.getVerticalCoordinate().getValue();
                if (rotationTimes % 2 == 0) {// N becomes S, E becomes E etc so horizontal stays horzontal
                    waypointCoordinate.getHorizontalCoordinate().setDirection(rotatedHorizontalCoord);
                    waypointCoordinate.getVerticalCoordinate().setDirection(rotatedVerticalCoord);
                } else { // waypoints N, E rotated 1,3 times becomes E and S so horizontal becomes veritcal
                    tempVerticalValue = waypointCoordinate.getVerticalCoordinate().getValue();
                    waypointCoordinate.getVerticalCoordinate().setDirection(rotatedHorizontalCoord);
                    waypointCoordinate.getVerticalCoordinate().setValue(waypointCoordinate.getHorizontalCoordinate().getValue());
                    waypointCoordinate.getHorizontalCoordinate().setDirection(rotatedVerticalCoord);
                    waypointCoordinate.getHorizontalCoordinate().setValue(tempVerticalValue);
                }

            } else if (instruction.isFrontInstruction()) {
                // move ship X times according to the waypoint distance! ship can cross from [E, N] to [W, S].
                if (shipCoordinate.getHorizontalCoordinate().getValue() == 0) {
                    shipCoordinate.getHorizontalCoordinate().setDirection(waypointCoordinate.getHorizontalCoordinate().getDirection());
                }
                if (shipCoordinate.getVerticalCoordinate().getValue() == 0) {
                    shipCoordinate.getVerticalCoordinate().setDirection(waypointCoordinate.getVerticalCoordinate().getDirection());
                }
                // sort horizontal Jumps
                if (waypointCoordinate.getHorizontalCoordinate().getDirection() == shipCoordinate.getHorizontalCoordinate().getDirection()) {
                    // happy path: south becomes south, north becomes even norther
                    shipCoordinate.getHorizontalCoordinate().setValue(shipCoordinate.getHorizontalCoordinate().getValue()
                            + instruction.getValue() * waypointCoordinate.getHorizontalCoordinate().getValue());
                } else {
                    int distanceToMove = instruction.getValue() * waypointCoordinate.getHorizontalCoordinate().getValue();
                    int difference = shipCoordinate.getHorizontalCoordinate().getValue() - distanceToMove;
                    if (difference > 0) {
                        shipCoordinate.getHorizontalCoordinate().setValue(difference);
                    } else {
                        shipCoordinate.getHorizontalCoordinate().setDirection(OPPOSITES.get(shipCoordinate.getHorizontalCoordinate().getDirection()));
                        shipCoordinate.getHorizontalCoordinate().setValue(-difference);
                    }
                }
                // sort vertical
                if (waypointCoordinate.getVerticalCoordinate().getDirection() == shipCoordinate.getVerticalCoordinate().getDirection()) {
                    shipCoordinate.getVerticalCoordinate().setValue(shipCoordinate.getVerticalCoordinate().getValue()
                            + instruction.getValue() * waypointCoordinate.getVerticalCoordinate().getValue());
                } else {
                    // bad path! might become negative or E could become W and way around
                    int distanceToMove = instruction.getValue() * waypointCoordinate.getVerticalCoordinate().getValue();
                    int difference = shipCoordinate.getVerticalCoordinate().getValue() - distanceToMove;
                    if (difference > 0) {
                        shipCoordinate.getVerticalCoordinate().setValue(difference);
                    } else {
                        shipCoordinate.getVerticalCoordinate().setDirection(OPPOSITES.get(shipCoordinate.getVerticalCoordinate().getDirection()));
                        shipCoordinate.getVerticalCoordinate().setValue(-difference);
                    }
                }
            } else { // jump waypoint to new coordonates
                // decide if you jump E or W
                if (instruction.isEastInstruction() || instruction.isWestInstruction()) {
                    if (instruction.getDirection() == waypointCoordinate.getHorizontalCoordinate().getDirection()) {
                        waypointCoordinate.getHorizontalCoordinate().setValue(waypointCoordinate.getHorizontalCoordinate().getValue() + instruction.getValue());
                    } else {
                        int difference = waypointCoordinate.getHorizontalCoordinate().getValue() - instruction.getValue();
                        if (difference > 0) {
                            waypointCoordinate.getHorizontalCoordinate().setValue(difference);
                        } else {
                            // set new difference and change orientation
                            waypointCoordinate.getHorizontalCoordinate().setValue(-difference);
                            waypointCoordinate.getHorizontalCoordinate().setDirection(OPPOSITES.get(waypointCoordinate.getHorizontalCoordinate().getDirection()));
                        }
                    }
                } else { //is is S or N
                    if (instruction.getDirection() == waypointCoordinate.getVerticalCoordinate().getDirection()) {
                        waypointCoordinate.getVerticalCoordinate().setValue(waypointCoordinate.getVerticalCoordinate().getValue() + instruction.getValue());
                    } else {
                        // bad path. decide if E becomes W
                        int difference = waypointCoordinate.getVerticalCoordinate().getValue() - instruction.getValue();
                        if (difference > 0) {
                            waypointCoordinate.getVerticalCoordinate().setValue(difference);
                        } else {
                            // set new difference and change orientation
                            waypointCoordinate.getVerticalCoordinate().setValue(-difference);
                            waypointCoordinate.getVerticalCoordinate().setDirection(OPPOSITES.get(waypointCoordinate.getVerticalCoordinate().getDirection()));
                        }
                    }
                }

            }
//            System.out.println(instruction.getDirection() +""+ instruction.getValue() + " => ["
//                    + waypointCoordinate.getHorizontalCoordinate().getDirection()+""+ waypointCoordinate.getHorizontalCoordinate().getValue() +", "
//                    + waypointCoordinate.getVerticalCoordinate().getDirection()+"" + waypointCoordinate.getVerticalCoordinate().getValue() + "] : ["
//                    + shipCoordinate.getHorizontalCoordinate().getDirection()+""+ shipCoordinate.getHorizontalCoordinate().getValue() + ", "
//                    + shipCoordinate.getVerticalCoordinate().getDirection()+"" + shipCoordinate.getVerticalCoordinate().getValue() +"]");
        }
        return shipCoordinate.getHorizontalCoordinate().getValue() + shipCoordinate.getVerticalCoordinate().getValue();
    }


    private static class Instruction {
        private char direction;
        private int value;

        public Instruction(char direction, int value) {
            this.direction = direction;
            this.value = value;
        }

        public char getDirection() {
            return direction;
        }

        public void setDirection(char direction) {
            this.direction = direction;
        }

        public int getValue() {
            return value;
        }

        public void setValue(int value) {
            this.value = value;
        }

        public boolean isFrontInstruction() {
            return direction == FRONT;
        }

        public boolean isEastInstruction() {
            return direction == EAST;
        }

        public boolean isWestInstruction() {
            return direction == WEST;
        }

        public boolean isNorthInstruction() {
            return direction == NORTH;
        }

        public boolean isSouthInstruction() {
            return direction == SOUTH;
        }

        public boolean isLeftInstruction() {
            return direction == LEFT;
        }

        public boolean isRightInstruction() {
            return direction == RIGHT;
        }

        public boolean isMovingInstruction() {
            return isEastInstruction() || isWestInstruction() || isNorthInstruction() || isSouthInstruction();
        }

        public boolean isOrientationInstruction() {
            return isLeftInstruction() || isRightInstruction();
        }
    }

    private static class Coordinate {
        private Instruction horizontalCoordinate;
        private Instruction verticalCoordinate;

        public Coordinate(Instruction horizontalCoordinate, Instruction verticalCoordinate) {
            this.horizontalCoordinate = horizontalCoordinate;
            this.verticalCoordinate = verticalCoordinate;
        }

        public Instruction getHorizontalCoordinate() {
            return horizontalCoordinate;
        }

        public Instruction getVerticalCoordinate() {
            return verticalCoordinate;
        }
    }

//
//    // meat goes here
//    private char moveShip(char orientation, Instruction instruction, Map<Character, Integer> directionScore) {
//        if (instruction.isOrientationInstruction()) {
//            return orientateShip(orientation, instruction);
//        } else if (instruction.isMovingInstruction()) {
//            return moveShipToNewCoodinates(orientation, instruction, directionScore);
//        } else return moveShipForward(orientation, instruction, directionScore);
//    }

//    private char orientateShip(char currentOrientation, Instruction instruction) {
//        if (instruction.getValue() == 180) {
//            return OPPOSITES.get(currentOrientation);
//        }
//        if (instruction.getValue() == 360) {
//            return currentOrientation;
//        }
//        if (instruction.isLeftInstruction()) {
//            return LEFT_ROTATIONS.get(currentOrientation).get(instruction.getValue() / 90);
//        } else {
//            return RIGHT_ROTATIONS.get(currentOrientation).get(instruction.getValue() / 90);
//        }
//    }
//
//    private char rotateShipLeft(char currentOrientation, int steps) {
//        return LEFT_ROTATIONS.get(currentOrientation).get(steps);
//    }
//
//    private char moveShipToNewCoodinates(char orientation, Instruction instruction, Map<Character, Integer> directionScore) {
//        int indicationScore = directionScore.get(instruction.getDirection());
//        int oppositeIndicationScore = directionScore.get(OPPOSITES.get(instruction.getDirection()));
//        if (indicationScore == 0 && oppositeIndicationScore == 0) {
//            directionScore.merge(instruction.getDirection(), instruction.getValue(), Integer::sum);
//        } else if (indicationScore > oppositeIndicationScore) {
//            directionScore.merge(instruction.getDirection(), instruction.getValue(), Integer::sum);
//        } else {
//            int difference = instruction.getValue() - oppositeIndicationScore;
//            if (difference >= 0) {
//                directionScore.put(OPPOSITES.get(instruction.getDirection()), 0);
//                directionScore.merge(instruction.getDirection(), difference, Integer::sum);
//            }
//        }
//        return orientation;
//    }
//
//    private char moveShipForward(char orientation, Instruction instruction, Map<Character, Integer> directionScore) {
//        int orientationScore = directionScore.get(orientation);
//        int oppositeOrientationScore = directionScore.get(OPPOSITES.get(orientation));
//        if (orientationScore >= oppositeOrientationScore) {
//            directionScore.merge(orientation, instruction.getValue(), Integer::sum);
//        } else {
//            int difference = instruction.getValue() - oppositeOrientationScore;
//            if (difference >= 0) {
//                directionScore.merge(orientation, difference, Integer::sum);
//                directionScore.put(OPPOSITES.get(orientation), 0);
//            } else {
//                directionScore.put(OPPOSITES.get(orientation), -difference);
//            }
//        }
//
//        return orientation;
//    }

}
