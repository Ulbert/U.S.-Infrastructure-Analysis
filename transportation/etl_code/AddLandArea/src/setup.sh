# Setup the HDFS directory stucture and populate it. 

# Create new directory structure in HDFS
hdfs dfs -mkdir -p /user/ma4759/infrastructure/transportation/addLandColumn

# Populate the input directory in HDFS with the input file
hdfs dfs -put ../lib/land_data.csv /user/ma4759/infrastructure/transportation/addLandColumn
hdfs dfs -put ../../AcceptableRoads/output/output.csv /user/ma4759/infrastructure/transportation/addLandColumn/acceptableRoads.csv

# Verify what is in the input data directory
hdfs dfs -ls infrastructure/transportation/addLandColumn
