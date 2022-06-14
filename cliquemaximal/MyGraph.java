package cliquemaximal;

import java.util.Collections;
import java.util.Vector;

public class MyGraph {
	BitMatrix data;
	int Nodes;//dinh
	int[][] Neighbors;// hang xom
	int temp;
	int[] numNodes;// tap cac dinh
	Vector<Integer> numMax = new Vector<Integer>();// tap cac bac cua dinh
	Vector<Integer> arrmaximalclique = new Vector<Integer>();// tap cac clique
	

	public MyGraph() {
	}
	// khoi tao mang bit
	public MyGraph(int Nodes, int[][] neighbors) {
		temp = Nodes;
		int a,b;
		this.data = new BitMatrix(Nodes);
		try {
			for(int i = 0;i<Nodes;i++) {
				this.numNodes[i] =i;
			}
		}catch (Exception e) {
			// TODO: handle exception
		}
		try {
			
			for(int i = 0;i<neighbors.length;i++) {
				a = neighbors[i][0];
				b = neighbors[i][1];
				data.SetValue(a, b, true);
				data.SetValue(b, a, true);
			}
		}catch (Exception e) {
			// TODO: handle exception
			System.out.print("loi\n");
		}
	}
	public void getData() {
		this.data.Out();
	}
	public int getNodes() {
		return Nodes;
	}
	public void setNumNodes(int Nodes) {
		this.Nodes = Nodes;
	}
	
	// check a clique
	public boolean isclique(int b,BitMatrix data) {
		try {
			for(int i = 0;i<b;i++)
				for(int j= i; j<b ; j++) {
					if(data.GetValue(i, j)== 0)
						return false;
				}
		}catch (Exception e) {
			// TODO: handle exception
		}
		return true;
	}
	
	//
	public void nummax(int Nodes,BitMatrix data) {
		int max = 0,temp =0;
		//tim canh co bac lon nhat
		for(int i= 0;i<Nodes;i++) {
			for(int j=0;j<Nodes;j++) {
				if(data.GetValue(i, j) == 1)
					temp++;
			}
			max =temp;
			temp=0;
			numMax.add(max);
		}
	}
	
	//
	public void maximalclique(int Nodes,BitMatrix data,int max) {
		Vector<Integer> arrNodesFind = new Vector<Integer>();
		
		int temp =0;
		//tim canh co bac lon nhat
		for(int i =0;i<numMax.size();i++)
			System.out.print(numMax.get(i)+ " ");
		System.out.print("\n");
		
		try {
			// max =5;tim cac dinh co max = 5
			try {
				for(int i= 0;i<Nodes;i++) {
					for(int j=0;j<Nodes;j++) {
						if(data.GetValue(i, j) == 1)
							temp++;
					}
					if(temp == max) {
						arrNodesFind.add(i);//add(2,4) max =5;
					}
					temp=0;
				}
			}catch (ArrayIndexOutOfBoundsException e) {
				// TODO: handle exception
				System.out.print("loi");
			}
			//out tesst arrnodefind---------------------------------
//			for(int i =0;i<arrNodesFind.size();i++)
//				System.out.print(arrNodesFind.get(i) + " ");
//			System.out.print("\n");
			
			// aarrnodesfind = 2,4
			// xet mang cac dinh ke voi cac dinh 2;4
			for(int i=0;i< arrNodesFind.size();i++) {
				//vector chua dinh ke cua 2;4
				Vector<Integer> neighBors = new Vector<Integer>();
				int a = arrNodesFind.get(i);// l1: a =2;
				
				//xet trong mang 2 chieu data, lay hang xom
				for(int j =0;j<Nodes;j++)
					if(data.GetValue(a,j) == 1)
						neighBors.add(j);
				
				//tao bitmatrix dinh ke
				int k = neighBors.size();
				int c=0;
				BitMatrix testNode = new BitMatrix(k);
				for(int d=0;d<k;d++) {
					for(int j=0;j<k;j++) {
						c= data.GetValue(neighBors.get(d),neighBors.get(j));
						testNode.SetValue(d, j, c);
					}
						
				}
				
				//test hang xom-----------------------------------------------------
//				System.out.print("hang xom"+a+"\t");
//				for(int f =0;f<neighBors.size();f++)
//					System.out.print(neighBors.get(f) + " ");
//				System.out.print("\n");
//				testNode.Out();	
				//System.out.print("\n");
				
				// kiem tra clique
				if(isclique(k, testNode) == true) {
					for(int j =0;j<k;j++) {
						arrmaximalclique.add(neighBors.get(j));
					}
					arrmaximalclique.add(-1);
				}
			}
		}catch (Exception e) {
			System.out.print("loi\n");
			// TODO: handle exception
		}
		if(arrmaximalclique.isEmpty())
			System.out.print("rong");
	}
	
	
	public static void main(String[] args) {
		int a = 5;
		int[][] b = {{0,2},{4,0},{1,2},{1,3},{1,4},{2,3},{3,4},{2,4}};
		MyGraph m = new MyGraph(a,b);
		m.getData();
		System.out.print("\n");

		m.nummax(a, m.data);


		while(m.arrmaximalclique.isEmpty()) {
			int max = Collections.max(m.numMax);
			m.maximalclique(a, m.data,max);
			if(m.arrmaximalclique.size() == 0) {
				for(int i=0;i<m.numMax.size();i++)
					if(m.numMax.get(i) == max)
						m.numMax.remove(i);
			}
		}
		for(int i =0;i<m.numMax.size();i++)
			System.out.print(m.numMax.get(i)+ " ");
		System.out.print("\n");
		for(int i=0;i<m.arrmaximalclique.size();i++)
			System.out.print(m.arrmaximalclique.get(i)+" ");
	}
}
