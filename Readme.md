
Use below command to pass parameter from command line if you are using cucumber
version 6. Here i am passing tag value which need to be run and it overrirrde tags present in runner class
mvn verify -Dcucumber.filter.tags="@tagname"



Use below command to pass parameter from command line if you are using cucumber
version below 6. Here i am passing tag value which need to be run and it overrirrde tags present in runner class
mvn verify -Dcucumber.options="--tags @tagname"

Note : if you run a invalid command like if i try to use version 6 command in version below to 6 then it will run all scenario
it will by pass tag 

if you want to pass some parameter value in cucumber run through command line then make sure runner class name is TestRunner
if not then it will not work