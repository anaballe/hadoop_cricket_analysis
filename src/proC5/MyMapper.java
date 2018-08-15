package proC5;
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
		int year = Integer.parseInt(k[2]);
		if(year >=1950 && year <= 1960) {
			Text oa = new Text("number_of_movies");
			IntWritable ob = new IntWritable(1);
			context.write(oa, ob);
		}
	}

}
