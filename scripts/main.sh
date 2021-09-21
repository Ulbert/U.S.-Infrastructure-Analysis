hdfs dfs -mkdir /user/ma4759/infrastructure/tax
hdfs dfs -mkdir /user/ma4759/infrastructure/transportation
hdfs dfs -mkdir /user/ma4759/infrastructure/water_quality

cd ..
cd tax
bash tax_bash.sh
cd ..
cd water_quality
bash run_water_quality.bash
cd ..
cd transportation
cd etl_code
bash etl.sh
cd ../..

# Delete directories
hdfs dfs -rm -r /user/ma4759/infrastructure/tax
hdfs dfs -rm -r /user/ma4759/infrastructure/transportation
hdfs dfs -rm -r /user/ma4759/infrastructure/water_quality