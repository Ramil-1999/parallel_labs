package lab_2;

import org.apache.hadoop.mapreduce.Mapper;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;

import java.io.IOException;

public class MapperFlight extends Mapper<LongWritable, Text, AirportWritableComparable, Text> {

    private static  final  String UNO = "1";

    @Override
    protected void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {

        String values[] = value.toString().split(",");
        context.write(new AirportWritableComparable(Integer.valueOf(values[14]), UNO), new Text(values[18]));

    }
}
