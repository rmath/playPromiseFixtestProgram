playPromiseFixtestProgram
=========================

A test program for problem of timeout with play

Launch the program with play run
Start the test with curl http://127.0.0.1:9000/
In the log, you will see the 2 jobs writing a trace and the parent awaiting the end of the jobs.
Without my fix of play, the parent wait until the end of the 2 jobs : the timeout is ignored.
With my fix, the parent exit with a TimeoutException.
