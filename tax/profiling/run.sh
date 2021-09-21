# Build the jar file and run

# Remove class and jar files
rm *.class
rm *.jar

# Compile
javac -classpath `yarn classpath` -d . CountRecsMapper.java
javac -classpath `yarn classpath` -d . CountRecsReducer.java
javac -classpath `yarn classpath`:. -d . CountRecs.java

# Create jar file
jar -cvf countRecs.jar *.class

# Run the program
hadoop jar countRecs.jar CountRecs /user/ma4759/infrastructure/tax/tax_data/original/18incyallnoagi.csv /user/ma4759/infrastructure/tax/tax_data/original_count/
hadoop jar countRecs.jar CountRecs /user/ma4759/infrastructure/tax/tax_data/cleaned/part-r-00000 /user/ma4759/infrastructure/tax/tax_data/cleaned_count/


