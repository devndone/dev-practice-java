package practice.dev.problemsolving;

/**
 * 
 * @author dev
 *

Objec­tive: Print all the paths from left top cor­ner to right bot­tom cor­ner in two dimen­sional array.

Input: Two Dimen­sional array

Out­put: Print all the paths.

Approach:

As we need to explore all the paths from top left cor­ner to bot­tom right cor­ner, we will either travel down OR travel right. so every time either we increase the row or column.

Recur­sion is the key here.
Take the rows count and col­umn counts say row­Count and col­Count respectively
Take cur­ren­tRow =0 and cur­rent­Col­umn =0 and path =””
Call printAll(currentRow, currentcolumn,path)
Add array[0][0] to the path.
Call recur­sively printAll(currentRow+1, currentcolumn,path)
Call recur­sively printAll(currentRow, currentcolumn+1,path)
Base Case 1: when cur­ren­tRow = rowCount-1(because array index starts with 0) , print the rest of the columns, return
Base Case 2: when cur­rent­col­umn = colCount-1(because array index starts with 0) , print the rest of the rows, return


Out­put:
–1–4-7–8-9
–1–4-5–8-9
–1–4-5–6-9
–1–2-5–8-9
–1–2-5–6-9
–1–2-3–6-9

 */
public class PrintAllPathIn2DArray {

	int rowCount;
	int colCount;
	int[][] arrA;

	public PrintAllPathIn2DArray(int arrA[][]) {
		this.arrA = arrA;
		rowCount = arrA.length;
		colCount = arrA[0].length;
	}

	public void printAll(int currentRow, int currentColumn, String path) {
		if (currentRow == rowCount - 1) {
			for (int i = currentColumn; i < colCount; i++) {
				path += "-" + arrA[currentRow][i];
			}
			System.out.println(path);
			return;
		}
		if (currentColumn == colCount - 1) {
			for (int i = currentRow; i <= rowCount - 1; i++) {
				path += "-" + arrA[i][currentColumn];
			}
			System.out.println(path);
			return;
		}
		path = path + "-" + arrA[currentRow][currentColumn];
		printAll(currentRow + 1, currentColumn, path);
		printAll(currentRow, currentColumn + 1, path);
		printAll(currentRow + 1, currentColumn + 1, path);
	}

	public static void main(String args[]) {
		int[][] a = { { 1, 2, 3 }, { 4, 5, 6 } };
		PrintAllPathIn2DArray p = new PrintAllPathIn2DArray(a);
		p.printAll(0, 0, "");
	}

}
