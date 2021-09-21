module load anaconda3/2019.10
yes | conda install numpy
module load pandas/0.18.1

cd ..
cd graph
bash run.sh
cd ..