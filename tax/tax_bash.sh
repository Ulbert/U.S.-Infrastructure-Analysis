cd cleaning
bash go.sh
cd ..
cd profiling
bash go.sh
cd ..

hdfs dfs -copyToLocal /user/ma4759/infrastructure/tax/tax_data/cleaned/part-r-00000 ./
mv ./part-r-00000 ./tax
#cp ./tax ../hive/input
