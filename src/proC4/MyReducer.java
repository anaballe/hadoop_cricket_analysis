package proC4;
import java.io.IOException;

import org.apache.hadoop.io.*;
import org.apache.hadoop.mapreduce.*;
public class MyReducer extends Reducer<Text,Text,Text,Text>{
	@Override
	protected void reduce(Text key, Iterable<Text> value, Reducer<Text, Text, Text, Text>.Context op)
			throws IOException, InterruptedException {
		// TODO Auto-generated method stub
		String ar1[] = new String[10000];
		String ar2[] = new String[10000];
		int ar3[] = new int[10000];
		String br1[] = new String[10000];
		String br2[] = new String[10000];
		int br3[] = new int[10000];
		int a =0,b = 0;
		for(Text data : value) {
			String v = data.toString();
			String [] k = v.split("[,]");
			if(k[1].equals("Australia")) {
			ar1[a] = k[0];
			ar2[a] = k[1];
			ar3[a] = Integer.parseInt(k[2]);
			++a;
			}
			else {
				br1[b] = k[0];
				br2[b] = k[1];
				br3[b] = Integer.parseInt(k[2]);
				++b;
			}
		}
		String ss ="";
		int t =0;
		for(int i =0 ;i<a;++i) {
			for(int j=0;j<a-1;++j) {
				if(ar3[j]<ar3[j+1]) {
					ss = ar1[j];
					ar1[j] = ar1[j+1];
					ar1[j+1] = ss;
					ss= ar2[j];
					ar2[j]= ar2[j+1];
					ar2[j+1] = ss;
					t = ar3[j];
					ar3[j] = ar3[j+1];
					ar3[j+1] = t;
				}
			}
		}
		for(int i =0 ;i<b;++i) {
			for(int j=0;j<b-1;++j) {
				if(br3[j]<br3[j+1]) {
					ss = br1[j];
					br1[j] = br1[j+1];
					br1[j+1] = ss;
					ss= br2[j];
					br2[j]= br2[j+1];
					br2[j+1] = ss;
					t = br3[j];
					br3[j] = br3[j+1];
					br3[j+1] = t;
				}
			}
		}
		Text oa = new Text(ar1[0]+","+ar2[0]);
		Text ob = new Text(Integer.toString(ar3[0]));
		op.write(oa, ob);
		Text oc = new Text(ar1[1]+","+ar2[1]);
		Text od = new Text(Integer.toString(ar3[1]));
		op.write(oc, od);
		Text oe = new Text(ar1[2]+","+ar2[2]);
		Text of = new Text(Integer.toString(ar3[2]));
		op.write(oe, of);
		
		Text og = new Text(br1[0]+","+br2[0]);
		Text oh = new Text(Integer.toString(br3[0]));
		op.write(og, oh);
		Text oi = new Text(br1[1]+","+br2[1]);
		Text oj = new Text(Integer.toString(br3[1]));
		op.write(oi, oj);
		Text ok = new Text(br1[2]+","+br2[2]);
		Text ol = new Text(Integer.toString(br3[2]));
		op.write(ok, ol);
		
	}

}
