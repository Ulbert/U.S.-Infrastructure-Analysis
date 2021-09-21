import org.apache.hadoop.io.DoubleWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.IntStream;

public class LandAreaReducer
        extends Reducer<Text, Text, Text, Text> {
    @Override
    public void reduce(Text key, Iterable<Text> values, Context context) throws IOException, InterruptedException {
        String stateValue = "";
        ArrayList<String> cache = new ArrayList<>();

        String sqmi = null;
        String main = null;
        for(Text value : values) {
            String[] tmp = value.toString().split(",");
            if (tmp.length == 3) {
                sqmi = tmp[2];
            }
            else {
                main = value.toString();
            }
        }

        if(main != null && sqmi != null) {
            context.write(null, new Text(main + "," + sqmi));
        }
    }
}
