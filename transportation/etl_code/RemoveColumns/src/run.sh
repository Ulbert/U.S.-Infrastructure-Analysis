# Build the jar file and run

# Remove class and jar files
rm *.class
rm *.jar

# Compile
javac -classpath `yarn classpath` -d . RemoveColumnsMapper.java
javac -classpath `yarn classpath` -d . RemoveColumnsReducer.java
javac -classpath `yarn classpath`:. -d . RemoveColumns.java

# Create jar file
jar -cvf removeColumns.jar *.class

# Run the program
hadoop jar removeColumns.jar AcceptableRoads /user/"$USER"/infrastructure/transportation/removeColumns/latest_data.csv /user/"$USER"/infrastructure/transportation/removeColumns/output
hdfs dfs -getmerge /user/ma4759/infrastructure/transportation/addRoadColumn/output ../output/output.csv
