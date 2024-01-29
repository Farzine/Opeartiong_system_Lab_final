							Lab Final Exam: OS (2020-21)
Time: 1 hour					Total Mark: 50 (Partial Mark will be given based on your implementation)

Marks: 40 (Without bonus)
Scenario: You are tasked with building a program that simulates a bakery producing bread and a shop selling it.

There is a single bakery thread that produces bread at a fixed rate (say, 1 bread every 3 seconds).
There are multiple shop threads (3-5 is a good range) that try to buy bread from the bakery.	
A mutex lock should be used to ensure critical section access when adding/removing bread from the bakery's inventory.
The bakery should only sell bread if it is available (not negative).
Shop threads should wait if no bread is available and be notified when new bread is produced.
Requirements:
Implement the bakery and shop threads using Java. 
Use a Mutex object to control access to the bakery's inventory.
Use wait() and notify() methods for thread synchronization between the bakery and shop threads.
Each shop thread should randomly wait for a certain time (between 1-5 seconds) before trying to buy bread again if unavailable.
Print messages to the console to track the production and selling of bread, including any waiting or notifying events.
Ensure your program handles potential race conditions and deadlocks.
Bonus points:
Implement a counter to track the total number of bread produced and sold.
Add exception handling for potential errors.
Enhance the program with functionalities like displaying the current inventory level.


  2.  Marks: 10
Scenario:
There are 3 philosophers, numbered 0, 1, and 2, sitting around a circular table.
Each philosopher has a plate of spaghetti (represented by their number).
There are 3 forks, numbered 0, 1, and 2, placed between each pair of philosophers.
Lists:
philosophers: A list containing the numbers 0, 1, and 2, representing the philosophers.
forks: A list containing the numbers 0, 1, and 2, representing the forks.



Rules:
A philosopher can only pick up the fork to their left or right (based on their index in the philosophers list).
To eat, a philosopher must have both forks corresponding to their numbers.
Only one philosopher can hold a fork at a time.
Requirements:
Implement a program that simulates the philosophers' actions using lists and threads.
Use appropriate synchronization mechanisms (mutexes, semaphores) to control access to the forks.
Print messages indicating each philosopher's state (thinking, eating, waiting for forks).
Ensure your solution avoids deadlock.
Example Initial State:
philosophers = [0, 1, 2]
forks = [0, 1, 2]
Example Output:
Philosopher 0 is thinking.
Philosopher 1 is thinking.
Philosopher 2 picks up fork 2.
Philosopher 2 picks up fork 0.
Philosopher 2 is eating.

Hint: This can be the main class in your code. Now you have to design the Fork and Philosopher class only.
                    
![Screenshot_8](https://github.com/Farzine/Opeartiong_system_Lab_final/assets/107579600/e8ff9390-05d8-4117-a2e2-831aa53e63d5)
