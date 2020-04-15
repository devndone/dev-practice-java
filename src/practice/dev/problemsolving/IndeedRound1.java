package practice.dev.problemsolving;

// Write a function that takes in the image and returns the coordinates of the rectangle of 0's -- either top-left and bottom-right; or top-left, width, and height.

import java.util.*;

// Sample output:
// x: 3, y: 2, width: 3, height: 2
// 2,3 3,5
// 3,2 5,3 -- it's ok to reverse columns/rows as long as you're consistent
public class IndeedRound1 {

        public static void main(String[] args) {
            int[][] image = {
                    {1, 1, 1, 1, 1, 1, 1},
                    {1, 1, 1, 1, 1, 1, 1},
                    {1, 1, 1, 0, 0, 0, 1},
                    {1, 1, 1, 0, 0, 0, 1},
                    {1, 1, 1, 1, 1, 1, 1}
            };

            List<Point> res = new IndeedRound1().findRectangleOfZeroes(image);
            System.out.println("Top-Left Point: " + res.get(0).getRow() + ", " + res.get(0).getColumn());
            System.out.println("Top-Right Point: " + res.get(1).getRow() + ", " + res.get(1).getColumn());
        }

        public List<Point> findRectangleOfZeroes(int[][] image) {
            List<Point> result = new ArrayList<>();
            int startRow = -1, startColumn = -1, prevStartRow = -1, prevStartColumn = -1, maxRow = 0, maxColumn = 0;
            boolean isZero = false;
            for(int i = 0; i < image.length; i++) {
                for(int j = 0; j < image.length; j++) {
                    if(image[i][j] == 1) {
                        startRow = -1; startColumn = -1;
                        isZero = false;
                        continue;
                    }
                    isZero = true;
                    //assuming here it'll be only zero
                    if(startRow == -1 && startColumn == -1) {
                        startRow = i;
                        startColumn = j;
                    } else {
                        if(j - startColumn > maxColumn) {
                            prevStartColumn = startColumn;
                            maxColumn = j - startColumn;
                        } else {
                            ++maxColumn;
                        }
                    }
                }
                if(isZero) {
                    if(i - startRow > maxRow) {
                        prevStartRow = startRow;
                        maxRow = i - startRow;
                    } else {
                        ++maxRow;
                    }
                }
            }
            Point p = new Point(prevStartRow, prevStartColumn);
            result.add(p);
            p = new Point(prevStartRow+maxRow, prevStartColumn+maxColumn);
            result.add(p);
            return result;
        }


        class Point {

            private int row;
            private int column;

            public Point(int row, int column) {
                this.row = row;
                this.column = column;
            }

            public void setRow(int row) {
                this.row = row;
            }

            public void setColumn(int column) {
                this.column = column;
            }

            public int getRow() {
                return this.row;
            }

            public int getColumn() {
                return this.column;
            }
        }


}
