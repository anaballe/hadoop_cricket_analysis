package proC1;
import org.apache.hadoop.mapreduce.*;

import java.io.IOException;

import org.apache.hadoop.io.*;
public class MyMapper extends Mapper<LongWritable,Text,Text,IntWritable>{
	@Override
	protected void map(LongWritable key, Text value, Mapper<LongWritable, Text, Text, IntWritable>.Context context)
			throws IOException, InterruptedException {
		// TODO Auto-generated method stub
		String data = value.toString();
		String [] k = data.split("[,]");
		String team = k[4];
		int runs = Integer.parseInt(k[8]);
		int wides = Integer.parseInt(k[9]);
		Text oa = new Text(team);
		IntWritable ob = new IntWritable(runs);
		context.write(oa, ob);
		Text oc = new Text(team);
		IntWritable od = new IntWritable(wides);
		context.write(oc, od);
		
		
	}
	
}
