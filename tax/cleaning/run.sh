# Build the jar file and run

# Remove class and jar files
rm *.class
rm *.jar

# Compile
javac -classpath `yarn classpath` -d . CleanMapper.java
javac -classpath `yarn classpath` -d . CleanReducer.java
javac -classpath `yarn classpath`:. -d . Clean.java

# Create jar file
jar -cvf clean.jar *.class

# Run the program
hadoop jar clean.jar Clean /user/ma4759/infrastructure/tax/tax_data/original/18incyallnoagi.csv /user/ma4759/infrastructure/tax/tax_data/cleaned	



