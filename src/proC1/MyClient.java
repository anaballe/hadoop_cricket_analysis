package proC1;
import org.apache.hadoop.conf.*;
import org.apache.hadoop.fs.*;
import org.apache.hadoop.mapreduce.*;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.input.TextInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;
import org.apache.hadoop.mapreduce.lib.output.TextOutputFormat;
import org.apache.hadoop.io.*;

public class MyClient {
	public static void main(String [] arg)throws Exception{
		Configuration conf = new Configuration();
		Job job = new Job(conf);
		job.setJarByClass(MyClient.class);
		job.setMapperClass(MyMapper.class);
		job.setOutputKeyClass(Text.class);
		job.setOutputValueClass(IntWritable.class);
		job.setReducerClass(MyReducer.class);
		Path input_path = new Path(arg[0]);
		Path output_path = new Path(arg[1]);
		FileInputFormat.addInputPath(job, input_path);
		FileOutputFormat.setOutputPath(job, output_path);
		job.setInputFormatClass(TextInputFormat.class);
		job.setOutputFormatClass(TextOutputFormat.class);
		job.waitForCompletion(true);
		
	}

}
