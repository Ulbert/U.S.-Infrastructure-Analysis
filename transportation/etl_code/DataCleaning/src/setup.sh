# Setup the HDFS directory stucture and populate it. 

# Create new directory structure in HDFS
hdfs dfs -mkdir /user/ma4759/infrastructure/transportation/initialCleaning

# Populate the input directory in HDFS with the input file
hdfs dfs -put Table_data-2.csv /user/ma4759/infrastructure/transportation/initialCleaning

# Verify what is in the input data directory
hdfs dfs -ls /user/ma4759/infrastructure/transportation/initialCleaning