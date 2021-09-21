# Analysis of U.S infrastructure at the county level
A repo for analysis of United States infrastructure at the county level

Make sure the zip file is loaded onto dumbo.

Each group member is responsible for each dataset.

1. Justin Chen - Water Quality
2. Mert Alev - Transportation
3. Anand Tyagi - Tax

Afterwards, these datasets are combined in hive under one table. See [here](./hive/combine.md)

Then, we analyze tables again in hive. See [here](./hive/analytic.md)

We then export those tables. See [here](./hive/export.md)

Look at the following sections for further instructions.
The first three sections water quality, tax, and transportation has to do with cleaning and doing some minor analytics to the dataset. The hive section is doing further analytics

**Note** Make sure to you have access to /user/ma4759/infrastructure/. If not contact ma4759@nyu.edu to request.

## Hadoop MapReduce Pipeline

Run the clean and normalize code for water_quality, tax, and transportation. This pipeline is done in hadoop mapreduce

First make sure you are in the "scripts" folder. Then run:

bash main.sh

## Hive

Aggregate the datasets (tax, water, and transportation) and do analytics on combined dataset in hive

In hive/input data directory, it should contain three datasets tax, transportation, water. Each of those three datasets should be generated from the previous portion.

Each entry of those datasets represents a county in the United States.

We combined the datasets, then added new columns to derive new insights of the data.

We applied analytics such as finding the mean and normalizing the columns.

To find out more about the code steps in hive. Read [combine](./hive/combine.md), [analytic](./hive/analytic.md), and [export](./hive/export.md) in the hive directory for steps to combine, analyze, and export the datasets.

## Graphs

To generate the graphs that are used in the analytic, return back to the "scripts" folder and run:

bash graphing.sh

Your machine will need to have the numpy and pandas installed. The graphing script is written to run on NYU's Dumbo Cluster and has the necessary commands to install those libraries for you.

The graphs should open while the code is running, showing you all of the results.
