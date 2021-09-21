import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class LandAreaMapper1 extends Mapper<LongWritable, Text, Text, Text> {
    @Override
    public void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
        String[] split_line = value.toString().split(",");
        if(split_line[0].equals("State_Name")) return;

        String[] split_county = split_line[1].split(" ");
        StringBuilder revised_county = new StringBuilder();

        for(String token : split_county) {
            if(token.equals("County")
                || token.equals("Municipality")
                || token.equals("Borough")
                || token.toLowerCase().equals("city")
                || token.equals("Parish")
                || token.equals("Census")) {
                break;
            } else {
                revised_county.append(token).append(" ");
            }
        }
        revised_county.deleteCharAt(revised_county.length() - 1);
        split_line[1] = revised_county.toString();
        StringBuilder revised_columns = new StringBuilder();
        int[] arr = {1, 1, 1, 1, 1, 1, 0, 1, 0, 1};
        for(int i = 0; i < split_line.length; i++) {
           if(arr[i] == 1) {
               if(!split_line[i].isEmpty()) {
                   revised_columns.append(split_line[i]).append(",");
               }
               else {
                   revised_columns.append("0").append(",");
               }
           }
        }
        revised_columns.deleteCharAt(revised_columns.length() - 1);

        String state = split_line[0];
        String combined = revised_county.toString() + state;
        combined = combined.replaceAll(" ", "").toLowerCase();
        context.write(new Text(combined),
                new Text(revised_columns.toString()));
    }

//    public String countyFormat(String county){
//        String newCounty = county;
//        if (county.indexOf("County") > 0){
//            newCounty = newCounty.replace("County", "");
//        }
//        if (county.indexOf("Parish") > 0){
//            newCounty = newCounty.replace("Parish", "");
//        }
//        if (county.indexOf("Borough") > 0){
//            newCounty = newCounty.replace("Borough", "");
//        }
//        if (county.indexOf("Census Area") > 0){
//            newCounty = newCounty.replace("Census Area", "");
//        }
//        if (county.indexOf("Municipality") > 0){
//            newCounty = newCounty.replace("Municipality", "");
//        }
//        if (county.indexOf("City and") > 0){
//            newCounty = newCounty.replace("City and", "");
//        }
//        newCounty = newCounty.trim();
//        newCounty = newCounty.replace("\t", "");
//
//        return newCounty;
//
//    }
}
