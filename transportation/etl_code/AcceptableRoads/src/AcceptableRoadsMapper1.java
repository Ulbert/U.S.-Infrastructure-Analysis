import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class AcceptableRoadsMapper1 extends Mapper<LongWritable, Text, Text, Text> {
    @Override
    public void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
        String[] split_line = value.toString().split(",");
        if(split_line[0].equals("State_Name")) return;

        // maps all entries by their state
        context.write(new Text(split_line[0].toLowerCase().replaceAll(" ", "")),
                new Text(value.toString()));
    }
}
