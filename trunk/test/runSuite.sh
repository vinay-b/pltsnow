cd ../src
test_output_file=/tmp/test.out  
filename=${test_output_file}
if [ -f $filename ]
then
	rm $filename
fi

for i in sample1 sample2 sample3 sample4 tc_1 tc_2 tc_3 tc_4 tc_5 tc_6 tc_7 tc_8
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

unit_test_dir=../test/unit 

for i in tc_1 tc_2 tc_3 tc_4 tc_5 tc_6 tc_7 tc_8
do
	java com/google/code/pltsnow/gen/Parser ${unit_test_dir}/$i/$i.snow > SnowProgramImp.java
	diff SnowProgramImp.java ${unit_test_dir}/$i/SnowProgramImp.java >> /tmp/$i.diff
	if [ $? == 0 ]
	then
		echo "Test Status: SUCCESS - Program : $i.snow"
	else
		echo "Test Status: FAILURE - Program : $i.snow"
		echo "Diff File : /tmp/$i.diff"
	fi
done
cd ../test
