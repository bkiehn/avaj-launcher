sh clean.sh
find * -name "*.java" > sources.txt
javac -sourcepath . @sources.txt
java shool21.Main scenario.txt
cat simulation.txt