# Build the jar file and run

# Remove class and jar files
rm *.class
rm *.jar

# Compile
javac -classpath `yarn classpath` -d . LandAreaMapper1.java
javac -classpath `yarn classpath` -d . LandAreaMapper2.java
javac -classpath `yarn classpath` -d . LandAreaReducer.java
javac -classpath `yarn classpath`:. -d . LandArea.java

# Create jar file
jar -cvf landArea.jar *.class

# Run the program
hadoop jar landArea.jar LandArea /user/ma4759/infrastructure/transportation/addLandColumn/acceptableRoads.csv /user/ma4759/infrastructure/transportation/addLandColumn/land_data.csv /user/ma4759/infrastructure/transportation/addLandColumn/output
hdfs dfs -getmerge /user/ma4759/infrastructure/transportation/addLandColumn/output ../output/output.csv
cp ../output/output.csv ../../../../hive/input/transportation