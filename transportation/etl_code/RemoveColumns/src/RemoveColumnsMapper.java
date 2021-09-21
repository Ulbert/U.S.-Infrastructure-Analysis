import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class RemoveColumnsMapper extends Mapper<LongWritable, Text, Text, Text> {
    @Override
    public void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
        String[] split_line = value.toString().split(",");
        if(split_line[0].equals("State_Name")) return;

        // 1's signify columns to keep
        int[] arr = {1, 1, 0, 1, 1, 1, 0, 1, 0, 1, 1};

        StringBuilder revised_line = new StringBuilder();

        for(int i = 0,j = 0; i < arr.length; i++) {
            if(arr[i] == 1 && i != arr.length - 1) {
                revised_line.append(split_line[i]).append(",");
            } else if(arr[i] == 1){
                revised_line.append(split_line[i]);
            }
        }
        context.write(null,
                new Text(revised_line.toString()));
    }
}
