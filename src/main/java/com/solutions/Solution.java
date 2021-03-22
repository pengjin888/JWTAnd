package com.solutions;

import java.util.HashMap;
import java.util.Set;
import java.util.TreeSet;

public class Solution {
    public int robotSim(int[] commands, int[][] obstacles) {
        int x = 0;
        int y = 0;
        int result=0;
        int dir = 0;//0代表北，y增，1代表东，2代表南，3代表西
        HashMap<Integer, TreeSet<Integer>> xOb = new HashMap<>();
        HashMap<Integer, TreeSet<Integer>> yOb = new HashMap<>();
        for (int[] ints : obstacles) {
            if (xOb.get(ints[0]) != null) {
                TreeSet<Integer> set = xOb.get(ints[0]);
                set.add(ints[1]);
                xOb.put(ints[0], set);
            } else {
                TreeSet<Integer> set = new TreeSet<>();
                set.add(ints[1]);
                xOb.put(ints[0], set);
            }
            if (yOb.get(ints[1]) != null) {
                TreeSet<Integer> set = yOb.get(ints[1]);
                set.add(ints[0]);
                yOb.put(ints[1], set);
            } else {
                TreeSet<Integer> set = new TreeSet<>();
                set.add(ints[0]);
                yOb.put(ints[1], set);
            }
        }
        for (int command : commands) {
            if (command > 0) {
                switch (dir) {
                    case 0:
                        y = getY(y, command, xOb.get(x));
                        break;
                    case 1:
                        x = getY(x, command, yOb.get(y));
                        break;
                    case 2:
                        y = getY(y, -command, xOb.get(x));
                        break;
                    case 3:
                        x = getY(x, -command, yOb.get(y));
                        break;
                    default:
                        return -1;
                }
                int times = x*x+y*y;
                if (times>result) result=times;
            } else if (command == -1) {
                if (dir == 3) {
                    dir = 0;
                } else {
                    dir += 1;
                }
            } else if (command == -2) {
                if (dir == 0) {
                    dir = 3;
                } else {
                    dir -= 1;
                }
            } else {
                return -1;
            }
        }
        return result;
    }

    private int getY(int y, int command, TreeSet<Integer> integers2) {
        if (integers2 != null) {
            Set<Integer> integers = integers2;
            for (Integer i : integers) {
                if (command > 0) {
                    if (i <= y + command && i > y) {
                        return i-1;
                    }
                } else {
                    if (i >= y + command && i < y) {
                        return i + 1;
                    }
                }
            }
        }
        y += command;
        return y;
    }

}

