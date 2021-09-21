# Setup the HDFS directory stucture and populate it. 

# Create new directory structure in HDFS
hdfs dfs -mkdir -p /user/ma4759/infrastructure/transportation/addRoadColumn

# Populate the input directory in HDFS with the input file
hdfs dfs -put ../lib/road_condition.csv /user/ma4759/infrastructure/transportation/addRoadColumn
hdfs dfs -put ../../DataCleaning/output/output.csv /user/ma4759/infrastructure/transportation/addRoadColumn/cleanedData.csv

# Verify what is in the input data directory
hdfs dfs -ls /user/ma4759/infrastructure/transportation/addRoadColumn
