cd ../src
test_output_file=/tmp/test.out  
filename=${test_output_file}
if [ -f $filename ]
then
	rm $filename
fi

for i in sample1 sample2 sample3 sample4
do
	filename=/tmp/$i.diff
	if [ -f $filename ]
	then
		rm $filename
	fi
done

make clean 1>>${test_output_file} 2>>${test_output_file}
make 1>>${test_output_file} 2>>${test_output_file}

for i in sample1 sample2 sample3 sample4
do
	make $i 1>>${test_output_file} 2>>${test_output_file}
	diff SnowProgramImp.java ../test/sample-compiled/$i/SnowProgramImp.java >> /tmp/$i.diff
	if [ $? == 0 ]
	then
		echo "Test Status: SUCCESS - Program : $i.snow"
	else
		echo "Test Status: FAILURE - Program : $i.snow"
		echo "Diff File : /tmp/$i.diff"
	fi
done
cd ../test
