import java.io.*; 
import java.util.*; 
  
class Hamel{
	public static int ar[];
	public static ArrayList<ArrayList<Integer>> listOfLists = new ArrayList<ArrayList<Integer>>();
	public static void main(String args[]){
		int grp[][]={{0, 1, 0, 0, 0}, 
					{1, 0, 1, 1, 1}, 
					{0, 1, 0, 1, 0}, 
					{0, 1, 1, 0, 1}, 
					{0, 1, 0, 1, 0}, 
				}; 
		ar=new int[grp.length];
		Arrays.fill(ar,0);
		ar[0]=0;
		for(int i=0;i<grp.length;i++){
			ArrayList<Integer> l1=new ArrayList<Integer>();
			for(int j=0;j<grp[i].length;j++){
				if(grp[i][j]==1){
						l1.add(j);
				}
			}
			listOfLists.add(l1);
		}
		Iterator i=listOfLists.iterator();
		while(i.hasNext()){
			ArrayList<Integer> l1=(ArrayList<Integer>)i.next();
			Iterator itr=l1.iterator();
			System.out.println("list of list");
			while(itr.hasNext()){
				Integer num=(Integer)itr.next();
				System.out.print(num+"\t");
			}
			System.out.println();
		}
		hamel(1);
//		System.out.print(ar.length);
	}
	public static boolean contain(int value,int k){
		for(int i=0;i<k;i++){
			if(ar[i]==value)
				return false;
		}
		return true;
	}
	public static boolean checkConnection(int value,int k){
		//System.out.println(value+" k "+k+"aaa");
		ArrayList<Integer> l1=(ArrayList<Integer>)listOfLists.get(ar[k-1]);
		if(l1.contains(value))
			return true;
		else 
			return false;
	}
	public static boolean checkConnectionNext(int value,int k){
		ArrayList<Integer> l1=(ArrayList<Integer>)listOfLists.get(ar[k]);
		if(l1.contains(0))
			return true;
		else 
			return false;
	}
	public static void hamel(int k){
		do{
			for(int i=0;i<ar.length;i++){
				//System.out.print(ar[i]+"\t chk \t");
			}
			//System.out.println();
			calc(k);
			if(ar[k]==-1)
				return;
		    if(k==ar.length-1){
				for(int i=0;i<ar.length;i++){
					System.out.print(ar[i]+"\t");
				}
				System.out.println();
			}
			else
				hamel(k+1);
		}while(true);	
	}
	public static void calc(int k){
		int value=ar[k];
		do{
	//		System.out.println("K "+k+"and value"+value);
			if(ar[k]==-1)
				ar[k]=0;
			ar[k]=((ar[k]+1)%ar.length);
			//System.out.println("K "+k+"and ar[k]"+ar[k]);
			//ar[k]=ar[k]-1;
			if(ar[k]==0){
				ar[k]=-1;
				return ;
			}
			else if(contain(ar[k],k)){
				if(k==ar.length-1){
			//		System.out.println(ar[k]+" k "+k+"zzzzzzzzzzzzzzz");
					if(checkConnection(ar[k],k) && checkConnectionNext(ar[k],k)){
						System.out.println(ar[k]+"zzzzzzzzzzzzzzz");
						//ar[k]=ar[k];
						return ;
					}
				}
				else if(checkConnection(ar[k],k)){
					//System.out.println(ar[k]+"value");
					return ;
				}
			}
		}while(true);
	}  
}