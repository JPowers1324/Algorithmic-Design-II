package Lab05;
//Jake Powers
public class ProcessScheduler {
	LLQueue<Process> proceses = new LLQueue<Process>(); //Initialize LL queue of Process
	Process currProcess;
	
	public Process getCurrentProcess() { //return current process
		return currProcess;
	}
	public void addProcess(Process xProcess) { //Add new process to queue
		if (currProcess == null) {
			currProcess = xProcess;
			return;
		}
		proceses.enqueue(xProcess);
	}
	public void runNextProcess() { //go to next process
		currProcess = proceses.dequeue();
	}
	public void cancelCurrentProcess() { //cancel current process
		currProcess = proceses.dequeue();
	}
	public void printProcessQueue() { //Print out the queue
		proceses.print();
	}
}
