# Setup the HDFS directory stucture and populate it. 

# Create new directory structure in HDFS
hdfs dfs -rm -r /user/ma4759/infrastructure/tax
hdfs dfs -mkdir /user/ma4759/infrastructure/tax
hdfs dfs -mkdir /user/ma4759/infrastructure/tax/tax_data
hdfs dfs -mkdir /user/ma4759/infrastructure/tax/tax_data/original
# Populate the input directory in HDFS with the input file
hdfs dfs -put ../data/18incyallnoagi.csv /user/ma4759/infrastructure/tax/tax_data/original
         

# Verify what is in the input data directory

