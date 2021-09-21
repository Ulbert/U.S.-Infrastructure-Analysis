# Build the jar file and run

# Remove class and jar files
rm *.class
rm *.jar

# Compile
javac -classpath `yarn classpath` -d . CleanMapper.java
javac -classpath `yarn classpath` -d . CleanReducer.java
javac -classpath `yarn classpath`:. -d . Clean.java

# Create jar file
jar -cvf dataClean.jar *.class

# Run the program
hadoop jar dataClean.jar Clean /user/ma4759/infrastructure/transportation/initialCleaning/Table_data-2.csv /user/ma4759/infrastructure/transportation/initialCleaning/output
hdfs dfs -getmerge /user/ma4759/infrastructure/transportation/initialCleaning/output ../output/output.csv
