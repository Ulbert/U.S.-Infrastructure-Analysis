# Setup the HDFS directory stucture and populate it. 

# Create new directory structure in HDFS
hdfs dfs -mkdir -p infrastructure/transportation/addRoadColumn

# Populate the input directory in HDFS with the input file
hdfs dfs -put ../lib/road_condition.csv infrastructure/transportation/addRoadColumn
hdfs dfs -put ../lib/transport_data.csv infrastructure/transportation/addRoadColumn

# Verify what is in the input data directory
hdfs dfs -ls infrastructure/transportation/addRoadColumn
