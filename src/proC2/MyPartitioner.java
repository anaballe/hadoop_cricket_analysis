package proC2;
import org.apache.hadoop.io.*;
import org.apache.hadoop.mapreduce.*;
public class MyPartitioner extends Partitioner<Text,IntWritable>{

	@Override
	public int getPartition(Text arg0, IntWritable arg1, int arg2) {
		// TODO Auto-generated method stub
		String key = arg0.toString();
		String [] k = key.split("[,]");
		String c = k[1];
		if(c.equals("Australia")) {
			return 0;
		}
		else {
			return 1;
		}
	}
	

}
