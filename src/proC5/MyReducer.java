package proC5;
import org.apache.hadoop.mapreduce.*;

import java.io.IOException;

import org.apache.hadoop.io.*;
public class MyReducer extends Reducer<Text,IntWritable,Text,IntWritable>{
	@Override
	protected void reduce(Text arg0, Iterable<IntWritable> arg1,
			Reducer<Text, IntWritable, Text, IntWritable>.Context arg2) throws IOException, InterruptedException {
		// TODO Auto-generated method stub
		int sum = 0;
		for(IntWritable data : arg1) {
			int a = data.get();
			sum = sum + a ;
		}
		Text oa = arg0;
		IntWritable ob = new IntWritable(sum);
		arg2.write(oa, ob);
	}

}
