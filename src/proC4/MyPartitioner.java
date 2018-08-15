package proC4;
import org.apache.hadoop.io.*;
import org.apache.hadoop.mapreduce.*;
public class MyPartitioner extends Partitioner<Text,Text>{

	@Override
	public int getPartition(Text arg0, Text arg1, int arg2) {
		// TODO Auto-generated method stub
		String key = arg0.toString();
		String [] k = key.split("[,]");
		if(k[1].equals("Australia")) {
			return 0;
		}
		else {
			return 1;
		}
		
	}

}
