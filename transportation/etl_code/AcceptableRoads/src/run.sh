# Build the jar file and run

# Remove class and jar files
rm *.class
rm *.jar

# Compile
javac -classpath `yarn classpath` -d . AcceptableRoadsMapper1.java
javac -classpath `yarn classpath` -d . AcceptableRoadsMapper2.java
javac -classpath `yarn classpath` -d . AcceptableRoadsReducer.java
javac -classpath `yarn classpath`:. -d . AcceptableRoads.java

# Create jar file
jar -cvf acceptableRoads.jar *.class

# Run the program
hadoop jar acceptableRoads.jar AcceptableRoads /user/ma4759/infrastructure/transportation/addRoadColumn/cleanedData.csv /user/ma4759/infrastructure/transportation/addRoadColumn/road_condition.csv /user/ma4759/infrastructure/transportation/addRoadColumn/output
hdfs dfs -getmerge /user/ma4759/infrastructure/transportation/addRoadColumn/output ../output/output.csv
