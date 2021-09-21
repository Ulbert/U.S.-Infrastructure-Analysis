import org.apache.hadoop.io.DoubleWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class RemoveColumnsReducer
        extends Reducer<Text, Text, Text, Text> {
    @Override
    public void reduce(Text key, Iterable<Text> values, Context context) throws IOException, InterruptedException {
        String stateValue = "";
        ArrayList<String> cache = new ArrayList<>();

        for(Text value: values) {
            // if the value is the corresponding state's data point from the road condition column
            if(value.toString().split(",")[0].equals(value.toString())) {
                stateValue = value.toString();
            } else {
                cache.add(value.toString());
            }
        }

        // adds a road condition column corresponding to the entry's state
        for (String value : cache) {
            context.write(new Text(), new Text(value + "," + stateValue));
        }
    }
}
