import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
//load data from the txt file and save into a array of arraylist

public static void main(String[] arg)throws IOException{
		String s="";
		ArrayList<Integer> [] data=new ArrayList[vertexnumber];
		b = new BufferedReader(new FileReader("C:\\inputfile.txt"));
		
		for(n=0;n<vertexnumber;n++){
			data[n]=new ArrayList<Integer>();
		}

		while((s=b.readLine())!=null){
			String s1[]=s.split(" ");
			while(j<s1.length){
				data[currentLine].add(Integer.parseInt(s1[j]));	
				j++;
			}
			currentLine++;
			j=0;
		}
	/*
	 * check the data load in 
	 	 
		System.out.println("The number of data: "+data.length);
		
		for(int i =0; i<vertexnumber;i++){
			System.out.print("The vertex "+(i+1)+":");
			for(int k=0;k<data[i].size();k++){
				System.out.print(" "+data[i].get(k));
			}
			System.out.println("");
		}
	*/