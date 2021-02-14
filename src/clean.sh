rm -rf sources.txt
find * -name "*.class" > sources.txt
while read LINE
    do rm -rf $LINE
done < sources.txt
rm -rf sources.txt
rm -rf simulation.txt