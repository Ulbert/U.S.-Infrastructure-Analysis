# Output the result (assuming 1 reducer)
echo original count
hdfs dfs -cat /user/ma4759/infrastructure/tax/tax_data/original_count/part-r-00000
echo cleaned count
hdfs dfs -cat /user/ma4759/infrastructure/tax/tax_data/cleaned_count/part-r-00000
