package proC3;
import org.apache.hadoop.mapreduce.*;

import java.io.IOException;

import org.apache.hadoop.io.*;
public class MyReducer extends Reducer<Text,Text,Text,Text>{
	
	@Override
	protected void reduce(Text key, Iterable<Text> value, Reducer<Text, Text, Text, Text>.Context op)
			throws IOException, InterruptedException {
		// TODO Auto-generated method stub
		String [] ar1 = new String[1000000];
		int [] ar2 = new int[1000000];
		String vt = "";
		int a = 0,b = 0,c = 0,k = 0;
		for(Text data : value) {
			String k1 = data.toString();
			String [] ak = k1.split("[,]");
			ar1[b]= ak[0];
			a = Integer.parseInt(ak[1]);
			ar2[c] = a;
			++ b;
			++ c;
		}
		for(int i =0 ;i< b;++i) {
			for(int j=0 ;j< b-1;++j) {
				if(ar2[j]<ar2[j+1]) {
					k = ar2[j];
					ar2[j] = ar2[j+1];
					ar2[j+1] = k;
					vt = ar1[j];
					ar1[j]=ar1[j+1];
					ar1[j+1]=vt;
				}
			}
		}
		Text oa = new Text(ar1[0]);
		Text ob = new Text(Integer.toString(ar2[0]));
		op.write(oa, ob);
		Text oc = new Text(ar1[1]);
		Text od = new Text(Integer.toString(ar2[1]));
		op.write(oc, od);
		Text oe = new Text(ar1[2]);
		Text of = new Text(Integer.toString(ar2[2]));
		op.write(oe, of);
	}

}
