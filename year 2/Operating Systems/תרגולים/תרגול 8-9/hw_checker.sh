#!/bin/bash

declare -a seed=(6 6 7 9 12)
declare -a amount=(10000 10000000 10000000 10000000 10000000)
#declare -a amount=(10 100 1000 10000 100000)
declare -a good_results=(520964747626,496 513297223889453,490503 512007894110879,489247 512161926686405,489533 512659803488804,489822)
declare -a good_times=(1 4 6.14 6 6)

if [ -z "$1" ]; then 
	echo usage: $0 id_of_student
	exit
fi



#unzip archive
unzip -o -q $1.zip -d $1
echo -e "seed \t amount \t sum \t found \t time" > res_$1.txt
cd $1



STR="empty"

#clean and make executables
make clean 2&1>/dev/null
make

# measure the time, and exec solution
for i in `seq 0 4`;
do
        start=`date +%s.%N`
	str=$(./solution ${seed[i]} ${amount[i]})
	end=`date +%s.%N`
	runtime=$( echo "$end - $start" | bc -l )
	quality="OK"

	if [[ "$str" != "${good_results[i]}" ]]; then
    		echo "BAD results."
		quality="BAD"
	fi

	delta_time=$( echo "$runtime - ${good_times[i]}" | bc -l )
	is_delta_ok=$( echo "$delta_time < 2" | bc -l )
	echo $delta_time
	echo $is_delta_ok
	if [ $is_delta_ok -eq 1 ]; then
    		echo "Time is Ok."
	else
		echo "Time over !!"
	fi

	#save the results into a file
	echo -e $quality'\t' ${seed[i]}'\t'${amount[i]}'\t'$str'\t'$runtime '\t' $is_delta_ok >> ../res_$1.txt
	echo "--------------"
done  



