package cliquemaximal;

public class BitMatrix {
	private int[][] data;
	public  int Dim;
	int row, col;
	public BitMatrix(int n) {
		this.row = n;
		this.col = n;
		this.data = new int[n][n];
		this.Dim = n;
		for(int i= 0;i<n;i++)
			this.data[i][i] = 1;
	}
	
	public int GetValue(int row, int col) {
		return data[row][col];
	}
	// xet dung sai
	public void SetValue(int row , int col, boolean value) {
		if(value == true)
			this.data[row][col] = 1;
		else
			this.data[row][col] =0;
	}
	//set gia tri
	public void SetValue(int row , int col, int a) {
		this.data[row][col] = a;
	}
	public void Out(){
		for(int i =0; i<row;i++) {
			for(int j =0; j<col; j++) {
				System.out.print(data[i][j]+" ");
			}
			System.out.print("\n");
		}
	}
	
	public static void main(String[] args) {
		BitMatrix n = new BitMatrix(9);
		n.SetValue(1, 1, true);
		System.out.print(n.GetValue(0, 1)+"\n");
		n.Out();
	}
}