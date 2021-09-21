import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.DoubleWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.input.MultipleInputs;
import org.apache.hadoop.mapreduce.lib.input.TextInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

public class AcceptableRoads {
    public static void main(String[] args) throws Exception {
        if (args.length != 3) {
            System.err.println("Format: AcceptableRoads <input path> <output path>");
            System.exit(-1);
        }
        Job job = new Job();
        job.setJar("acceptableRoads.jar");
        job.setJobName("Acceptable Roads");
        MultipleInputs.addInputPath(job,new Path(args[0]), TextInputFormat.class, AcceptableRoadsMapper1.class);
        MultipleInputs.addInputPath(job,new Path(args[1]), TextInputFormat.class, AcceptableRoadsMapper2.class);
//        FileInputFormat.addInputPath(job, new Path(args[0]));
        FileOutputFormat.setOutputPath(job, new Path(args[2]));
        job.setReducerClass(AcceptableRoadsReducer.class);
        job.setOutputKeyClass(Text.class);
        job.setOutputValueClass(Text.class);
        System.exit(job.waitForCompletion(true) ? 0 : 1); }
}
