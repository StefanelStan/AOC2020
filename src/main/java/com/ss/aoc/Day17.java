package com.ss.aoc;

import java.util.List;

public class Day17 extends AOCDay {
    private static final int MAX_SIZE = 30;
    private static final int ORIGIN = 11;


    public Day17() {
        this.testDataFilename = "day17test.txt";
        this.dataFileName = "day17.txt";
    }

    @Override
    long task1(boolean isTest) {
        List<String> lines = getDataAsStringLines(isTest);
        char[][][] hyperCube = new char[MAX_SIZE][MAX_SIZE][MAX_SIZE];
        initializeHyperCube(hyperCube);
        insertDataIntoCube(hyperCube, lines);

        // printActiveCubes(hyperCube);
        long activeCubes = simulateCycles(hyperCube, 6, lines.size());

        return activeCubes;
    }

    private void printActiveCubes(char[][][] hyperCube) {
        for (int i = 0; i < 30; i++) {
            for (int j = 0; j < 30; j++) {
                for (int k = 0; k < 30; k++) {
                    if (hyperCube[i][j][k] == '#')
                        System.out.println(i + ", " + j + ", " + k);
                }
            }
        }
    }

    private void initializeHyperCube(char[][][] hyperCube) {
        for (int i = 0; i < MAX_SIZE; i++) {
            for (int j = 0; j < MAX_SIZE; j++) {
                for (int k = 0; k < MAX_SIZE; k++) {
                    hyperCube[i][j][k] = '.';
                }
            }
        }
    }

    private void insertDataIntoCube(char[][][] hyperCube, List<String> lines) {
        for (int lineCursor = 0; lineCursor < lines.size(); lineCursor++) {
            for (int y = ORIGIN, c = 0; y < ORIGIN + lines.get(lineCursor).length(); y++, c++) {
                hyperCube[ORIGIN + lineCursor][y][ORIGIN] = lines.get(lineCursor).charAt(c);
            }
        }
    }

    private long simulateCycles(char[][][] hyperCube, int times, int originalSpreadSize) {
        char[][][] tempHyperCube = new char[MAX_SIZE][MAX_SIZE][MAX_SIZE];
        cloneCube(hyperCube, tempHyperCube);
        for (int cycle = 0; cycle < times; cycle++) {
            // logic goes here. start from a resonable distance.
            for (int x = ORIGIN - (cycle + 1); x <= ORIGIN + originalSpreadSize + cycle; x++) {
                for (int y = ORIGIN - (cycle + 1); y <= ORIGIN + originalSpreadSize + cycle; y++) {
                    for (int z = ORIGIN - (cycle + 1); z <= ORIGIN + cycle + 1; z++) {
                        if (hyperCube[x][y][z] == '#' && !hasActiveNeighbours(x, y, z, hyperCube)) {
                            tempHyperCube[x][y][z] = '.';
                        } else if (hyperCube[x][y][z] == '.' && has3ActiveNeighbours(x, y, z, hyperCube)) {
                            tempHyperCube[x][y][z] = '#';
                        }
                    }
                }
            }
            cloneCube(tempHyperCube, hyperCube);
        }
        return countActiveCubes(hyperCube);
    }

    private boolean has3ActiveNeighbours(int x, int y, int z, char[][][] hyperCube) {
        int activeNearbyCubes = 0;
        for (int xp = x - 1; xp <= x + 1; xp++) {
            for (int yp = y - 1; yp <= y + 1; yp++) {
                for (int zp = z - 1; zp <= z + 1; zp++) {
                    // you count the middle as well, so deduce it at the end
                    if (hyperCube[xp][yp][zp] == '#' && ++activeNearbyCubes > 3) {
                        return false;
                    }
                }
            }
        }
        return activeNearbyCubes == 3;
    }

    // has only 2 OR 3 active neighbours. Not more not less
    private boolean hasActiveNeighbours(int x, int y, int z, char[][][] hyperCube) {
        int activeNearbyCubes = 0;
        for (int xp = x - 1; xp <= x + 1; xp++) {
            for (int yp = y - 1; yp <= y + 1; yp++) {
                for (int zp = z - 1; zp <= z + 1; zp++) {
                    // you count the middle as well, so deduce it at the end
                    if (hyperCube[xp][yp][zp] == '#' && ++activeNearbyCubes > 4) {
                        return false;
                    }
                }
            }
        }
        return activeNearbyCubes == 3 || activeNearbyCubes == 4;
    }

    private int countActiveCubes(char[][][] tempHyperCube) {
        int sum = 0;
        for (int i = 0; i < 30; i++) {
            for (int j = 0; j < 30; j++) {
                for (int k = 0; k < 30; k++) {
                    if (tempHyperCube[i][j][k] == '#')
                        sum++;
                }
            }
        }
        return sum;
    }

    private void cloneCube(char[][][] source, char[][][] destination) {
        for (int i = 0; i < source.length; i++) {
            for (int j = 0; j < source.length; j++) {
                System.arraycopy(source[i][j], 0, destination[i][j], 0, source[i][j].length);
            }
        }
    }

    /* ---------------- Part 2 ---------------------------------------------------------- */

    @Override
    long task2(boolean isTest) {
        List<String> lines = getDataAsStringLines(isTest);
        char[][][][] hyperCube = new char[MAX_SIZE][MAX_SIZE][MAX_SIZE][MAX_SIZE];
        initializeHyperCube(hyperCube);
        insertDataIntoCube(hyperCube, lines);

        // printActiveCubes(hyperCube);
        long activeCubes = simulateCycles(hyperCube, 6, lines.size());

        return activeCubes;
    }

    private void printActiveCubes(char[][][][] hyperCube) {
        for (int i = 0; i < MAX_SIZE; i++) {
            for (int j = 0; j < 30; j++) {
                for (int k = 0; k < MAX_SIZE; k++) {
                    for (int l = 0; l < MAX_SIZE; l++) {
                        if (hyperCube[i][j][k][l] == '#')
                            System.out.println(i + ", " + j + ", " + k + ", " + l);
                    }
                }
            }
        }
    }

    private void initializeHyperCube(char[][][][] hyperCube) {
        for (int i = 0; i < MAX_SIZE; i++) {
            for (int j = 0; j < MAX_SIZE; j++) {
                for (int k = 0; k < MAX_SIZE; k++) {
                    for (int l = 0; l < MAX_SIZE; l++) {
                        hyperCube[i][j][k][l] = '.';
                    }
                }
            }
        }
    }

    private void insertDataIntoCube(char[][][][] hyperCube, List<String> lines) {
        for (int lineCursor = 0; lineCursor < lines.size(); lineCursor++) {
            for (int y = ORIGIN, c = 0; y < ORIGIN + lines.get(lineCursor).length(); y++, c++) {
                hyperCube[ORIGIN + lineCursor][y][ORIGIN][ORIGIN] = lines.get(lineCursor).charAt(c);
            }
        }
    }

    private long simulateCycles(char[][][][] hyperCube, int times, int originalSpreadSize) {
        char[][][][] tempHyperCube = new char[MAX_SIZE][MAX_SIZE][MAX_SIZE][MAX_SIZE];
        cloneCube(hyperCube, tempHyperCube);
        for (int cycle = 0; cycle < times; cycle++) {
            // logic goes here. start from a resonable distance.
            for (int x = ORIGIN - (cycle + 1); x <= ORIGIN + originalSpreadSize + cycle; x++) {
                for (int y = ORIGIN - (cycle + 1); y <= ORIGIN + originalSpreadSize + cycle; y++) {
                    for (int z = ORIGIN - (cycle + 1); z <= ORIGIN + cycle + 1; z++) {
                        if (hyperCube[x][y][z] == '#' && !hasActiveNeighbours(x, y, z, hyperCube)) {
                            tempHyperCube[x][y][z] = '.';
                        } else if (hyperCube[x][y][z] == '.' && has3ActiveNeighbours(x, y, z, hyperCube)) {
                            tempHyperCube[x][y][z] = '#';
                        }
                    }
                }
            }
            cloneCube(tempHyperCube, hyperCube);
        }
        return countActiveCubes(hyperCube);
    }

    private boolean has3ActiveNeighbours(int x, int y, int z, int w, char[][][][] hyperCube) {
        int activeNearbyCubes = 0;
        for (int xp = x - 1; xp <= x + 1; xp++) {
            for (int yp = y - 1; yp <= y + 1; yp++) {
                for (int zp = z - 1; zp <= z + 1; zp++) {
                    for (int wp = w - 1; wp <= w + 1; wp++) {
                        // you count the middle as well, so deduce it at the end
                        if (hyperCube[xp][yp][zp][wp] == '#' && ++activeNearbyCubes > 3) {
                            return false;
                        }
                    }
                }
            }
        }
        return activeNearbyCubes == 3;
    }

    // has only 2 OR 3 active neighbours. Not more not less
    private boolean hasActiveNeighbours(int x, int y, int z, int w, char[][][][] hyperCube) {
        int activeNearbyCubes = 0;
        for (int xp = x - 1; xp <= x + 1; xp++) {
            for (int yp = y - 1; yp <= y + 1; yp++) {
                for (int zp = z - 1; zp <= z + 1; zp++) {
                    for (int wp = w - 1; wp <= w + 1; wp++) {
                        // you count the middle as well, so deduce it at the end
                        if (hyperCube[xp][yp][zp][wp] == '#' && ++activeNearbyCubes > 4) {
                            return false;
                        }
                    }
                }
            }
        }
        return activeNearbyCubes == 3 || activeNearbyCubes == 4;
    }

    private int countActiveCubes(char[][][][] tempHyperCube) {
        int sum = 0;
        for (int i = 0; i < MAX_SIZE; i++) {
            for (int j = 0; j < MAX_SIZE; j++) {
                for (int k = 0; k < MAX_SIZE; k++) {
                    for (int l = 0; l < MAX_SIZE; l++) {
                        if (tempHyperCube[i][j][k][l] == '#')
                            sum++;
                    }
                }
            }
        }
        return sum;
    }

    private void cloneCube(char[][][][] source, char[][][][] destination) {
        for (int i = 0; i < source.length; i++) {
            for (int j = 0; j < source.length; j++) {
                for (int k = 0; k < source.length; k++) {
                    System.arraycopy(source[i][j][k], 0, destination[i][j][k], 0, source[i][j][k].length);
                }
            }
        }
    }
}
