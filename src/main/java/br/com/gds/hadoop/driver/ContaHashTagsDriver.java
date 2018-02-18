package br.com.gds.hadoop.driver;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

import br.com.gds.hadoop.map.ContaHashTagsMapper;
import br.com.gds.hadoop.reducer.ContaHashTagsReducer;

public class ContaHashTagsDriver {

	public static void main(String[] args) throws Exception {
		
		Configuration conf = new Configuration();
		Job job = Job.getInstance(conf,"conta HashTags");
		
		job.setJarByClass(ContaHashTagsDriver.class);
		job.setMapperClass(ContaHashTagsMapper.class);
		job.setReducerClass(ContaHashTagsReducer.class);
		job.setOutputKeyClass(Text.class);
		job.setOutputValueClass(IntWritable.class);
		
		FileInputFormat.addInputPath(job, new Path(args[0]));
		FileOutputFormat.setOutputPath(job, new Path(args[1]));
		
		System.exit(job.waitForCompletion(true) ? 0 : 1);
	}
	
}
