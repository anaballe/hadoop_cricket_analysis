package proC3;
import java.io.IOException;

import org.apache.hadoop.io.*;
import org.apache.hadoop.mapreduce.*;

public class MyMapper extends Mapper<LongWritable,Text,Text,Text>{
	@Override
	protected void map(LongWritable key, Text value, Mapper<LongWritable, Text, Text, Text>.Context context)
			throws IOException, InterruptedException {
		// TODO Auto-generated method stub
		String data = value.toString();
		String [] k =data.split("[,]");
		//int runs = Integer.parseInt(k[8]);
		String v = k[5];
		Text oa = new Text(v);
		Text ob = new Text(k[8]);
		context.write(oa, ob);
	}
    
}
