import java.io.IOException;
import java.util.Arrays;
import java.util.stream.Stream;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;
public class CleanMapper extends Mapper<LongWritable, Text, Text, Text> {
    @Override
    public void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
        String[] split_line = value.toString().split("\\t");
        if(split_line[0].equals("County_State")) {
            return;
        }

        int[] toBeAdded = {0, 1, 0, 0, 1, 0, 0, 0, 0, 0, 1, 0, 1, 1, 0, 1, 1, 1, 1, 0, 0};

//        split_line = Arrays.stream(split_line).filter(token -> !token.isEmpty()).toArray(String[]::new);

        String[] correct_line = new String[9];
        for(int i = 0, j = 0; i < split_line.length; i++) {
            if (toBeAdded[i] == 1) {
                correct_line[j++] = !split_line[i].isEmpty() ? split_line[i] : "0";
            }
        }

        String[] state = {correct_line[correct_line.length - 1]};
        String[] result = Stream.concat(Arrays.stream(state), Arrays.stream(Arrays.copyOfRange(correct_line, 0, correct_line.length - 1))).toArray(String[]::new);
	if(result[0] != null)
        	context.write(new Text(String.join(",", result)), null);
    }
}
