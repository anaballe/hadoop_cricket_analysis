package proC4;
import org.apache.hadoop.mapreduce.*;

import java.io.IOException;

import org.apache.hadoop.io.*;
public class MyCombiner extends Reducer<Text,Text,Text,Text>{
	@Override
	protected void reduce(Text key, Iterable<Text> value, Reducer<Text, Text, Text, Text>.Context op)
			throws IOException, InterruptedException {
		// TODO Auto-generated method stub
		int sum = 0;
		for(Text data : value) {
			String v = data.toString();
			int a = Integer.parseInt(v);
			sum = sum + a;
		}
		Text oa = new Text("wicket");
		String k = key.toString();
		String ss = Integer.toString(sum);
		k = k +","+ ss;
		Text ob = new Text(k);
		op.write(oa, ob);
		
	}

}
