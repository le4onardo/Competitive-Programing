import java.awt.Point;
import java.text.DecimalFormat;
import java.util.*;
import java.util.Map.Entry;
public class _10034_Freckles{
	// No aceptado por runtime error -_- 
	public static void main(String[] args){
		Scanner leer = new Scanner(System.in);
		int t =leer.nextInt();
		for (int xd = 0; xd < t; xd++){
			int n = leer.nextInt();
			TreeMap<Double, LinkedList<Point>> T= new TreeMap<Double, LinkedList<Point>>();
			double x[]= new double[n];
			double y[]= new double[n+1];
			int [] P= new int[n];
			int [] C= new int[n+1];
			LinkedList<Point> aux;
			for (int i = 0; i < n; i++){
				P[i]=-1;
				x[i]= Double.parseDouble(leer.next());
				y[i]= Double.parseDouble(leer.next());
				for (int j = i-1; j >=0; j--){
					double d=Math.sqrt((x[i]-x[j])*(x[i]-x[j])+(y[i]-y[j])*(y[i]-y[j]));
					if(T.containsKey(d))aux=T.get(d);
					else aux=new LinkedList<Point>();
					Point E= new Point(i,j);
					aux.add(E);
					T.put(d,aux);
				}
			}
		    double res=0;
		    int c=0;
			while(!T.isEmpty()&&n>1){
				Entry<Double, LinkedList<Point>> A = T.pollFirstEntry();
				aux=A.getValue();
				double d = A.getKey();
				while(!aux.isEmpty()&&n>1){
					Point E = aux.remove();
				    int i=(int) E.getX(),j=(int)E.getY();
				    if(P[i]>-1||P[j]>-1){
				    	if(P[i]>-1&&P[j]>-1){
				    		if(P[i]!=P[j]){
				    			int g,l;
				    			if(C[P[i]]!=C[P[j]]){
				    				if(C[P[i]]<C[P[j]]){g=C[P[i]];l=C[P[j]];}
				    				else {g=C[P[j]];l=C[P[i]];}
				    				for (int k = 0; k < c;k++){
										if(C[k]==l)C[k]=g;
									}
				    			    res+=d;
				    			    n--;
				    			}
				    		}
				    	}else{
				    		if(P[j]==-1)P[j]=P[i];
				    		else
				    		P[i]=P[j];  	
				    		res+=d;n--;
				    	}
				    }else{
				    	C[c]=c;
				    	P[i]=c;P[j]=c;
				    	c++;n--;res+=d;
				    }
				}
			}
			DecimalFormat r= new DecimalFormat("0.00");
			String cad = r.format(res);
			int h = cad.indexOf(',');
			System.out.println(cad.substring(0,h)+"."+cad.substring(h+1,cad.length()) );
			System.out.println();
		}
	}
}

/*
20

17
-2.28 7.23
-2.32 -7.84
-7.21 7.11
-9.76 -8.79
-0.70 7.84
2.42 7.73
-6.86 7.28
-5.75 1.60
8.05 5.41
6.76 4.76
6.11 -9.99
-2.47 -3.22
-8.75 -3.88
0.40 -7.16
-8.34 1.03
-1.75 8.39
6.12 -5.04

20
4.48 7.64
7.88 -1.71
7.59 2.32
-5.27 5.60
4.31 4.87
4.69 1.91
-0.05 -0.29
-3.53 -0.56
-4.45 -4.47
3.06 -1.18
-4.36 -2.76
7.64 1.48
3.14 6.67
-9.52 1.59
-2.29 3.67
1.30 1.99
-9.73 -7.82
0.07 -0.82
-9.66 7.87
-1.70 4.81

9
-7.02 -7.72
2.23 9.94
-3.60 2.42
3.54 7.77
-3.61 0.79
6.43 -9.23
8.41 7.87
-3.42 -1.34
-0.85 0.00

20
6.71 3.28
1.03 1.55
6.30 6.99
0.42 -8.90
1.48 2.21
-3.14 8.72
-8.31 -0.67
-8.45 -7.63
-1.23 4.11
-2.35 4.89
6.86 5.14
-2.87 -6.01
-7.60 4.72
6.87 1.37
-9.49 -2.03
6.82 7.12
-5.77 2.79
-4.66 -6.59
-9.92 6.10
-1.70 5.76

15
0.74 4.47
1.73 6.46
8.02 3.11
7.45 -8.59
-5.37 -1.53
-4.68 2.58
9.72 -1.38
-3.41 5.62
-1.95 1.08
-2.84 4.56
-3.06 -4.84
-5.04 5.52
-9.14 -4.07
-3.99 -8.95
-0.64 6.62

19
-9.91 -3.34
3.96 -4.83
8.76 3.20
-3.79 5.37
10.00 -2.77
-1.88 8.80
4.08 -5.81
0.78 9.31
-2.64 -9.28
-6.55 -4.66
-2.15 -1.91
3.06 8.97
9.83 3.78
9.80 -0.32
4.61 2.02
4.25 -1.49
3.68 0.27
9.04 -1.80
-6.43 2.44

14
9.14 5.24
-6.65 -5.96
8.12 -6.68
4.11 8.24
-4.41 4.41
7.86 5.02
8.44 3.68
-7.70 6.82
2.22 2.22
-2.42 1.99
-3.41 -5.77
8.48 1.66
-4.67 6.87
5.90 -7.76

10
-8.86 -8.62
-9.48 -1.43
-2.50 -9.25
4.44 9.42
-0.91 -4.27
-3.11 -1.16
-3.31 9.68
8.12 -9.44
8.45 9.09
1.30 -4.10

20
1.10 3.48
-9.30 2.59
-4.98 -0.43
1.81 -8.40
4.95 6.50
3.21 -1.23
-5.14 9.09
-7.85 3.97
-6.03 -5.73
-1.06 -2.12
4.77 -1.61
0.65 -1.39
-7.71 0.91
-0.65 -0.27
6.60 -1.81
7.24 5.35
-2.07 -2.31
2.83 7.94
9.55 -1.47
-4.98 -9.79

4
8.23 -1.02
3.84 -5.29
-3.13 -2.24
-2.69 3.68

15
5.70 -7.39
1.23 -4.91
1.57 -3.66
1.65 -0.91
7.29 -9.09
1.83 -1.76
5.94 4.52
-1.97 5.33
-6.15 -1.24
-5.46 -6.86
3.20 -1.13
-7.33 3.52
-2.65 3.48
-9.66 -4.00
3.31 -8.97

17
-5.43 9.22
-3.99 1.33
-7.11 0.92
8.14 5.11
2.39 9.38
1.20 -3.63
7.88 -7.53
-3.93 -3.48
0.38 -7.79
-3.25 -0.79
7.98 4.82
3.06 -9.73
-6.81 1.46
-2.63 4.64
-6.49 9.80
9.02 8.04
-0.64 -1.91

7
2.25 4.58
2.71 5.70
-1.92 -2.81
8.39 9.08
6.96 -3.87
2.20 -5.09
0.86 4.74

7
-8.76 -8.52
7.33 0.53
7.56 -0.12
-5.49 -9.48
5.89 -5.07
-7.04 -1.98
6.11 0.47

15
-3.75 1.07
-3.24 -9.86
-2.66 8.96
3.61 0.42
6.55 -8.71
-8.23 0.56
-9.14 -5.69
6.87 -1.80
-0.55 -7.66
9.68 -7.03
-9.48 9.33
9.41 5.77
1.65 -4.55
-6.01 -2.58
9.11 7.70

7
-9.08 -1.24
5.52 -2.40
4.94 9.89
3.49 -4.07
8.05 1.81
3.58 9.62
-9.53 7.94

5
8.39 4.80
7.77 -3.20
-8.31 8.06
-0.61 3.87
9.32 -8.91

9
-6.70 -5.92
8.76 4.31
-6.94 0.76
8.37 9.69
5.14 4.15
-9.92 -1.13
-9.33 -1.38
-6.20 3.70
1.63 -0.17

9
-8.00 1.61
3.98 8.23
1.86 5.34
-0.80 5.67
2.33 -8.76
7.86 -5.91
-7.04 6.41
0.74 2.16
0.79 3.73

20
-5.06 -2.34
6.53 -8.88
-4.69 -4.98
4.29 2.78
-7.40 -0.89
-5.48 -8.51
-6.51 -0.22
-6.25 -7.26
4.60 4.40
9.18 4.99
-2.69 5.85
-0.73 -6.74
-8.21 9.29
0.02 -8.57
2.22 1.09
8.75 6.01
2.70 7.16
7.75 5.28
-6.38 8.01
-7.32 -2.39
*/