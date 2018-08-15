package proC1;
import org.apache.hadoop.mapreduce.*;

import java.io.IOException;

import org.apache.hadoop.io.*;
public class MyReducer extends Reducer<Text,IntWritable,Text,IntWritable>{
	@Override
	protected void reduce(Text key, Iterable<IntWritable> values,
			Reducer<Text, IntWritable, Text, IntWritable>.Context op) throws IOException, InterruptedException {
		// TODO Auto-generated method stub
		int sum =0;
		for(IntWritable data : values) {
			int b = data.get();
			sum = sum + b;
		}
		Text key1 = key;
		IntWritable ov = new IntWritable(sum);
		op.write(key1, ov);
		
	}

}
