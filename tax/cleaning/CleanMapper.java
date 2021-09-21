import java.io.IOException;
import org.apache.hadoop.io.IntWritable; import org.apache.hadoop.io.LongWritable; import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;
import java.lang.StringBuilder;

public class CleanMapper
        extends Mapper<LongWritable, Text, Text, IntWritable> {

public String countyFormat(String county){
  String newCounty = county;
  if (county.indexOf("County") > 0){
    newCounty = newCounty.replace("County", "");
  }
  if (county.indexOf("Parish") > 0){
    newCounty = newCounty.replace("Parish", "");
  }
  if (county.indexOf("Borough") > 0){
    newCounty = newCounty.replace("Borough", "");
  }
  if (county.indexOf("Census Area") > 0){
    newCounty = newCounty.replace("Census Area", "");
  }
  if (county.indexOf("Municipality") > 0){
    newCounty = newCounty.replace("Municipality", "");
  }
  if (county.indexOf("City and") > 0){
    newCounty = newCounty.replace("City and", "");
  }
  newCounty = newCounty.trim();
  newCounty = newCounty.replace("\t", "");

  return newCounty;

}

@Override
public void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {

String line = value.toString();
        StringBuilder output = new  StringBuilder();
        String cols[] = line.split(",");
        System.out.println(cols[2]);
        if(cols[2].charAt(0) == '0'){
          return; //state code
        }
        for (int i = 0; i < cols.length; i++){
          if(i == 1 ||
             i == 3 ||
             i == 5 ||
             i == 71 ||
             i == 75
             ){
               if (i == 1){
                 if(cols[i].equals("AL")){
                 output.append("Alabama");
                 }else if(cols[i].equals("AK")){
                 output.append("Alaska");
                 }else if(cols[i].equals("AZ")){
                 output.append("Arizona");
                 }else if(cols[i].equals("AR")){
                 output.append("Arkansas");
                 }else if(cols[i].equals("CA")){
                 output.append("California");
                 }else if(cols[i].equals("CO")){
                 output.append("Colorado");
                 }else if(cols[i].equals("CT")){
                 output.append("Connecticut");
                 }else if(cols[i].equals("DE")){
                 output.append("Delaware");
                 }else if(cols[i].equals("FL")){
                 output.append("Florida");
                 }else if(cols[i].equals("GA")){
                 output.append("Georgia");
                 }else if(cols[i].equals("HI")){
                 output.append("Hawaii");
                 }else if(cols[i].equals("ID")){
                 output.append("Idaho");
                 }else if(cols[i].equals("IL")){
                 output.append("Illinois");
                 }else if(cols[i].equals("IN")){
                 output.append("Indiana");
                 }else if(cols[i].equals("IA")){
                 output.append("Iowa");
                 }else if(cols[i].equals("KS")){
                 output.append("Kansas");
                 }else if(cols[i].equals("KY")){
                 output.append("Kentucky");
                 }else if(cols[i].equals("LA")){
                 output.append("Louisiana");
                 }else if(cols[i].equals("ME")){
                 output.append("Maine");
                 }else if(cols[i].equals("MD")){
                 output.append("Maryland");
                 }else if(cols[i].equals("MA")){
                 output.append("Massachusetts");
                 }else if(cols[i].equals("MI")){
                 output.append("Michigan");
                 }else if(cols[i].equals("MN")){
                 output.append("Minnesota");
                 }else if(cols[i].equals("MS")){
                 output.append("Mississippi");
                 }else if(cols[i].equals("MO")){
                 output.append("Missouri");
                 }else if(cols[i].equals("MT")){
                 output.append("Montana");
                 }else if(cols[i].equals("NE")){
                 output.append("Nebraska");
                 }else if(cols[i].equals("NV")){
                 output.append("Nevada");
                 }else if(cols[i].equals("NH")){
                 output.append("New Hampshire");
                 }else if(cols[i].equals("NJ")){
                 output.append("New Jersey");
                 }else if(cols[i].equals("NM")){
                 output.append("New Mexico");
                 }else if(cols[i].equals("NY")){
                 output.append("New York");
                 }else if(cols[i].equals("NC")){
                 output.append("North Carolina");
                 }else if(cols[i].equals("ND")){
                 output.append("North Dakota");
                 }else if(cols[i].equals("OH")){
                 output.append("Ohio");
                 }else if(cols[i].equals("OK")){
                 output.append("Oklahoma");
                 }else if(cols[i].equals("OR")){
                 output.append("Oregon");
                 }else if(cols[i].equals("PA")){
                 output.append("Pennsylvania");
                 }else if(cols[i].equals("RI")){
                 output.append("Rhode Island");
                 }else if(cols[i].equals("SC")){
                 output.append("South Carolina");
                 }else if(cols[i].equals("SD")){
                 output.append("South Dakota");
                 }else if(cols[i].equals("TN")){
                 output.append("Tennessee");
                 }else if(cols[i].equals("TX")){
                 output.append("Texas");
                 }else if(cols[i].equals("UT")){
                 output.append("Utah");
                 }else if(cols[i].equals("VT")){
                 output.append("Vermont");
                 }else if(cols[i].equals("VA")){
                 output.append("Virginia");
                 }else if(cols[i].equals("WA")){
                 output.append("Washington");
                 }else if(cols[i].equals("WV")){
                 output.append("West Virginia");
                 }else if(cols[i].equals("WI")){
                 output.append("Wisconsin");
                 }else if(cols[i].equals("WY")){
                 output.append("Wyoming");
                 }else if(cols[i].equals("DC")){
                 output.append("District of Columbia");
                 }
               }
               else if (i==3){
                 output.append(countyFormat(cols[i]));

               } else {
                 output.append(cols[i]);
               }
               output.append(",");

             }
        }
        context.write(new Text(output.toString()), new IntWritable(0));
}}

